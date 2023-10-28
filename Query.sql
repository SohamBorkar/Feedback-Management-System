TRUNCATE TABLE multiuserlogin;
TRUNCATE TABLE feedbacks;

-- ---------------------------Drop all feedbacks tabels---------------------------------------------
DELIMITER //
CREATE PROCEDURE DropTables()
BEGIN
  DECLARE done INT DEFAULT 0;
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