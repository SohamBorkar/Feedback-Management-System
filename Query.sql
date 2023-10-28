TRUNCATE TABLE multiuserlogin;
TRUNCATE TABLE feedbacks;

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

CREATE TABLE options (
    ops_type VARCHAR(255),
    ops1 VARCHAR(255),
    ops2 VARCHAR(255),
    ops3 VARCHAR(255),
    ops4 VARCHAR(255),
    ops5 VARCHAR(255)
);

