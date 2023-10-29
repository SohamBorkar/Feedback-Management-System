-- --------------------------------------------------------
-- Host:                         sql12.freesqldatabase.com
-- Server version:               5.5.62-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for procedure sql12656946.AddFeedbackForAllStudents
DELIMITER //
CREATE PROCEDURE `AddFeedbackForAllStudents`(IN feedback_id INT)
BEGIN
    -- Declare variables
    DECLARE done INT DEFAULT 0;
    DECLARE student_prn INT;

    -- Declare cursor for selecting all student PRNs
    DECLARE student_cursor CURSOR FOR
        SELECT std_prn FROM student;

    -- Continue handling until there are no more students
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    -- Start the transaction
    START TRANSACTION;

    OPEN student_cursor;

    student_loop: LOOP
        FETCH student_cursor INTO student_prn;

        IF done = 1 THEN
            LEAVE student_loop;
        END IF;

        -- Insert a new row into std_feedback for each student
        INSERT INTO std_feedback (std_prn, feed_id, is_completed)
        VALUES (student_prn, feedback_id, 'pending');
    END LOOP;

    CLOSE student_cursor;

    -- Commit the transaction
    COMMIT;
END//
DELIMITER ;

-- Dumping structure for table sql12656946.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_pass` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `faculty_name` varchar(255) DEFAULT NULL,
  `faculty_branch` varchar(100) DEFAULT NULL,
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.feedbacks
CREATE TABLE IF NOT EXISTS `feedbacks` (
  `feed_id` int(11) NOT NULL AUTO_INCREMENT,
  `feed_name` varchar(255) DEFAULT NULL,
  `feed_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `by_faculty_id` int(11) DEFAULT NULL,
  `no_que` int(11) DEFAULT NULL,
  PRIMARY KEY (`feed_id`),
  KEY `fk_by_faculty` (`by_faculty_id`),
  CONSTRAINT `fk_by_faculty` FOREIGN KEY (`by_faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.multiuserlogin
CREATE TABLE IF NOT EXISTS `multiuserlogin` (
  `ID` int(50) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Role` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.options
CREATE TABLE IF NOT EXISTS `options` (
  `ops_type` varchar(255) NOT NULL DEFAULT '',
  `ops1` varchar(255) DEFAULT NULL,
  `ops2` varchar(255) DEFAULT NULL,
  `ops3` varchar(255) DEFAULT NULL,
  `ops4` varchar(255) DEFAULT NULL,
  `ops5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ops_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.questions
CREATE TABLE IF NOT EXISTS `questions` (
  `que_no` int(11) NOT NULL DEFAULT '0',
  `feed_id` int(11) NOT NULL DEFAULT '0',
  `question` varchar(255) DEFAULT NULL,
  `ops_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`que_no`,`feed_id`),
  KEY `feed_id` (`feed_id`),
  KEY `ops_type` (`ops_type`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`feed_id`) REFERENCES `feedbacks` (`feed_id`) ON DELETE CASCADE,
  CONSTRAINT `questions_ibfk_2` FOREIGN KEY (`ops_type`) REFERENCES `options` (`ops_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.std_feedback
CREATE TABLE IF NOT EXISTS `std_feedback` (
  `std_prn` int(11) NOT NULL DEFAULT '0',
  `feed_id` int(11) NOT NULL DEFAULT '0',
  `is_completed` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`std_prn`,`feed_id`),
  KEY `feed_id` (`feed_id`),
  CONSTRAINT `std_feedback_ibfk_1` FOREIGN KEY (`std_prn`) REFERENCES `student` (`std_prn`) ON DELETE CASCADE,
  CONSTRAINT `std_feedback_ibfk_2` FOREIGN KEY (`feed_id`) REFERENCES `feedbacks` (`feed_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table sql12656946.student
CREATE TABLE IF NOT EXISTS `student` (
  `std_name` varchar(255) DEFAULT NULL,
  `std_year` smallint(6) DEFAULT NULL,
  `std_rollno` int(11) DEFAULT NULL,
  `std_prn` int(11) NOT NULL AUTO_INCREMENT,
  `std_branch` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`std_prn`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
