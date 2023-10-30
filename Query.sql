TRUNCATE TABLE multiuserlogin;
TRUNCATE TABLE feedbacks;
DELETE FROM feedbacks;questions

-- ---------------------------Drop all feedbacks tabels---------------------------------------------
DELIMITER //
CREATE PROCEDURE DropTables()
BEGIN
  DECLARE done INT DEFAULT 0;feedbacksfeedbacks
  DECLARE tableName VARCHAR(255);

  -- Declare a cursor to select table names
  DECLARE cur CURSOR FOR
    SELECT table_name
    FROM information_schema.tables
    WHERE table_name LIKE 'feedback\_%' ESCAPE '\\';

  -- Declare continue handler to exit the loop
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  OPEN cur;

  read_loop: LOOP
    FETCH cur INTO tableName;

    IF done THEN
      LEAVE read_loop;
    END IF;

    SET @dropTableSQL = CONCAT('DROP TABLE ', tableName);
    PREPARE stmt FROM @dropTableSQL;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
  END LOOP;

  CLOSE cur;
END;
//
DELIMITER ;

CALL DropTables();

DROP PROCEDURE IF EXISTS DropTables;
-- ---------------------------------------------------------------


ALTER TABLE multiuserlogin
ADD PRIMARY KEY (id);

INSERT INTO multiuserlogin VALUES(100,'amey123','Student');
INSERT INTO multiuserlogin VALUES(101,'soham123','Student');
INSERT INTO multiuserlogin VALUES(102,'pratik123','Student');

INSERT INTO multiuserlogin VALUES(1,'fac1','Faculty');
INSERT INTO multiuserlogin VALUES(2,'fac2','Faculty');
INSERT INTO multiuserlogin VALUES(3,'fac3','Faculty');
INSERT INTO multiuserlogin VALUES(4,'fac4','Faculty');

INSERT INTO multiuserlogin VALUES(1001,'admin1','Admin');
INSERT INTO multiuserlogin VALUES(1002,'admin2','Admin');

CREATE TABLE feedbacks (
    feed_id INT PRIMARY KEY AUTO_INCREMENT,
    feed_name VARCHAR(255),
    feed_time TIMESTAMP
);
ALTER TABLE feedbacks
ADD COLUMN by_faculty_id INT;

ALTER TABLE feedbacks
ADD COLUMN no_que INT(11) NULL DEFAULT NULL;


ALTER TABLE feedbacks
ADD CONSTRAINT fk_by_faculty
FOREIGN KEY (by_faculty_id) REFERENCES faculty(faculty_id)
ON UPDATE CASCADE
ON DELETE CASCADE;


CREATE TABLE options (
    ops_type VARCHAR(255),
    ops1 VARCHAR(255),
    ops2 VARCHAR(255),
    ops3 VARCHAR(255),
    ops4 VARCHAR(255),
    ops5 VARCHAR(255)
);

SELECT * FROM feedbacks;
SELECT * FROM feedback_10;
SHOW TABLES;

DELIMITER //
CREATE PROCEDURE `GetStudentFeedbacks` (IN student_prn INT)
BEGIN
    SELECT
    	  f.feed_id,
        f.feed_name AS `Feedback Name`,
        CONCAT(fac.faculty_name, ' (ID: ', f.by_faculty_id, ')') AS `Created By`,
        f.no_que AS `No of Questions`,
        f.feed_time AS `Created On`,
        IFNULL(sf.is_completed, 'pending') AS `Status`
    FROM feedbacks f
    LEFT JOIN std_feedback sf ON f.feed_id = sf.feed_id AND sf.std_prn = student_prn
    LEFT JOIN faculty fac ON f.by_faculty_id = fac.faculty_id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `GetQuestionsByFeedId` (IN feedback_id INT)
BEGIN
    SELECT q.que_no, q.question, o.ops1, o.ops2, o.ops3, o.ops4, o.ops5
    FROM questions q
    INNER JOIN options o ON q.ops_type = o.ops_type
    WHERE q.feed_id = feedback_id;
END//
DELIMITER ;

CALL GetQuestionsByFeedId(feed_id);
CALL GetStudentFeedbacks(101);
feedbacks
ALTER TABLE student
MODIFY std_year VARCHAR(10);
student
SELECT * FROM student;
SELECT * FROM faculty;AddStudnet
INSERT INTO faculty (faculty_name, faculty_branch, faculty_id) VALUES (?, ?, ?)
GetStudentFeedbacks




DELIMITER //
CREATE PROCEDURE `GetQuestionsAndOptionsByFeedId` (IN feed_id INT)
BEGIN
    SELECT q.que_no, q.question, o.ops1, o.ops2, o.ops3, o.ops4, o.ops5
    FROM questions q
    INNER JOIN options o ON q.ops_type = o.ops_type
    WHERE q.feed_id = feed_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS GetQuestionsAndOptionsByFeedId;

CALL GetQuestionsAndOptionsByFeedId(4);

DELIMITER //
CREATE PROCEDURE `AddStudent`(
    IN `s_name` VARCHAR(255),
    IN `s_year` VARCHAR(10),
    IN `s_roll` INT,
    IN `s_branch` VARCHAR(255),
    IN `password` VARCHAR(16)
)
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
    -- Declare a variable for the new student ID and branch ID
    DECLARE new_std_id INT;
    DECLARE new_branch_id INT;

    -- Get the branch_id based on the branch_name
    SELECT branch_id INTO new_branch_id FROM branches WHERE branch_name = s_branch LIMIT 1;
	 SELECT new_branch_id;
    -- Insert a new row into the multiuserlogin table to generate a new student ID
    INSERT INTO multiuserlogin (Password, Role)
    VALUES (password, 'student');

    -- Get the auto-genAddStudenterated student ID
    SET new_std_id = LAST_INSERT_ID();

    -- Insert a new row into the student table with the generated student ID and the resolved branch ID
    INSERT INTO student (std_name, std_year, std_rollno, std_prn, branch_id)
    VALUES (s_name, s_year, s_roll, new_std_id, new_branch_id);

    -- Commit the transaction
    COMMIT;
END//
DELIMITER ;


SELECT * FROM Std_Feedback_Responses;
CALL GetStudentFeedbacks(10);

CREATE TABLE Std_Feedback_Responses (
    std_prn INT,
    feed_Id INT,
    que_no INT,
    ops_selected VARCHAR(255),
    FOREIGN KEY (std_prn) REFERENCES student (std_prn) ON DELETE CASCADE,
    FOREIGN KEY (que_no) REFERENCES questions (que_no) ON DELETE CASCADE,
    FOREIGN KEY (feed_Id) REFERENCES questions (feed_Id) ON DELETE CASCADE
);

ALTER TABLE Std_Feedback_ResponsesmultiuserloginAddStudnet ADD PRIMARY KEY (std_prn,que_no,feed_Id);

INSERT INTO Std_Feedback_Responses (std_prn, feed_Id, que_no, ops_selected) VALUES (101, 10, 1, 'ops3');
Std_Feedback_Responses
SELECT * FROM Std_Feedback_Responses;

ALTER TABLE Std_Feedback_Responses ADD is_given TINYINT(0);

TRUNCATE TABLE Std_Feedback_Responses;