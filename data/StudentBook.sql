--
-- Database: `StudentBook`
--

CREATE DATABASE StudentBook;

-- --------------------------------------------------------

--
-- Table structure for table `Grades`
--

CREATE TABLE `Grades` (
  `id_student` int(8) UNSIGNED NOT NULL,
  `id_subject` int(4) UNSIGNED NOT NULL,
  `grade` tinyint(1) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `Grades`
--

INSERT INTO `Grades` (`id_student`, `id_subject`, `grade`) VALUES
(2, 1, 3),
(2, 2, 2),
(3, 2, 3),
(3, 7, 5),
(4, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `Students`
--

CREATE TABLE `Students` (
  `id` int(8) UNSIGNED NOT NULL,
  `first_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `birth_date` date NOT NULL,
  `street_and_number` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `post_code` char(6) COLLATE utf8_polish_ci NOT NULL,
  `city` varchar(40) COLLATE utf8_polish_ci NOT NULL,
  `class_number` char(2) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `Students`
--

INSERT INTO `Students` (`id`, `first_name`, `last_name`, `birth_date`, `street_and_number`, `post_code`, `city`, `class_number`, `password`) VALUES
(1, 'asd', 'asd', '2010-03-19', 'asdfghj 90', '12345', 'qwerty', 'as', 'b270077d2830df2390122ad7fa62236e79227b99'),
(2, 'qwe', 'qwe', '2010-05-18', 'bbbbb 33', '222222', 'qwerty', 'as', '65ca8d70d793b3fdc1d9d74ae83da7cce7d4f96b'),
(3, 'iii', 'iii', '2010-05-29', 'hdfgh 54', '5345', 'dsggsdf', 'gd', '543b4dffc95fc563f3ac1d27c49e9e69ffb0a39c'),
(4, 'jjj', 'jjj', '2008-08-11', 'Street XX', '12-345', 'City', 'gf', '4298d0482f89f69bbf08b5e4553be61fe9996d8a');

-- --------------------------------------------------------

--
-- Table structure for table `Subjects`
--

CREATE TABLE `Subjects` (
  `id` int(4) UNSIGNED NOT NULL,
  `name` varchar(40) COLLATE utf8_polish_ci NOT NULL,
  `id_teacher` int(4) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `Subjects`
--

INSERT INTO `Subjects` (`id`, `name`, `id_teacher`) VALUES
(1, 'poiuyt', 1),
(2, 'drynn', 2),
(3, 'jhkhjk', 3),
(4, 'wtreteber', 1),
(5, 'trdfstgdf', 2),
(6, ';lk;nkl;kl', 2),
(7, 'gfrdsrv4e', 3),
(8, 'aetbe45wb5', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Teachers`
--

CREATE TABLE `Teachers` (
  `id` int(4) UNSIGNED NOT NULL,
  `first_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `birth_date` date NOT NULL,
  `street_and_number` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `post_code` char(6) COLLATE utf8_polish_ci NOT NULL,
  `city` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `Teachers`
--

INSERT INTO `Teachers` (`id`, `first_name`, `last_name`, `birth_date`, `street_and_number`, `post_code`, `city`, `password`) VALUES
(1, 'ccc', 'ccc', '1978-09-18', 'ddddd 55', '33333', 'vvvvv', '2ba44e72cedb30d4ea94a162b6ee8b896bd497c1'),
(2, 'fff', 'fff', '1990-12-11', 'adfsg 87', '123456', 'qwerty', 'ce9c1c2d9a100524b0779d20cf596f71558fd7e5'),
(3, 'hhh', 'hhh', '1987-01-05', 'Street XX', '12-345', 'City', '3bb4b7436bd1afbedc13a5b663a7f3d17e265746');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Grades`
--
ALTER TABLE `Grades`
  ADD UNIQUE KEY `multi_grade_id` (`id_student`,`id_subject`);

--
-- Indexes for table `Students`
--
ALTER TABLE `Students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_teacher` (`id_teacher`);

--
-- Indexes for table `Teachers`
--
ALTER TABLE `Teachers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Students`
--
ALTER TABLE `Students`
  MODIFY `id` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Subjects`
--
ALTER TABLE `Subjects`
  MODIFY `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `Teachers`
--
ALTER TABLE `Teachers`
  MODIFY `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Grades`
--
ALTER TABLE `Grades`
  ADD CONSTRAINT `Grades_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `Students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Grades_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `Subjects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD CONSTRAINT `Subjects_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `Teachers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--------------------------------------------------------------
DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudentGrade` (IN `myId` INT, IN `stId` INT, IN `suID` INT, IN `_grade` INT)  BEGIN
	DECLARE a INT DEFAULT 0;
	SET a = (SELECT COUNT(id) FROM `Subjects` WHERE id_teacher = myId AND id = suID);
	IF a > 0 THEN
		INSERT INTO `Grades` (id_student, id_subject, grade)
    	VALUES (stId, suId, _grade);
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `changeStudentAddress` (IN `myId` INT, IN `newCity` VARCHAR(40), IN `newStreet_and_number` VARCHAR(100), IN `newPost_code` VARCHAR(6))  BEGIN
	UPDATE `Students` 
    SET city = newCity, street_and_number = newStreet_and_number, post_code = newPost_code
    WHERE id = myId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `changeStudentGrade` (IN `myId` INT, IN `stId` INT, IN `suID` INT, IN `_grade` INT)  BEGIN
	DECLARE a INT DEFAULT 0;
	SET a = (SELECT COUNT(id) FROM `Subjects` WHERE id_teacher = myId);
	IF a > 0 THEN
		UPDATE `Grades`
    	SET grade = _grade
        WHERE id_student = stId AND id_subject = suId;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `changeTeacherAddress` (IN `myId` INT, IN `newCity` VARCHAR(40), IN `newStreet_and_number` VARCHAR(100), IN `newPost_code` VARCHAR(6))  BEGIN
	UPDATE `Teachers` 
    SET city = newCity, street_and_number = newStreet_and_number, post_code = newPost_code
    WHERE id = myId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteStudentGrade` (IN `myId` INT, IN `stId` INT, IN `suID` INT)  BEGIN
	DECLARE a INT DEFAULT 0;
	SET a = (SELECT COUNT(id) FROM `Subjects` WHERE id_teacher = myId AND id = suID);
	IF a > 0 THEN
		DELETE FROM `Grades`
        WHERE id_student = stId AND id_subject = suId;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllMyGrades` (IN `myId` INT)  BEGIN
	SELECT u.name, g.grade 
    FROM `Grades` AS g 
    JOIN `Subjects` AS u
    ON u.id = g.id_subject
    WHERE g.id_student = myId
    ORDER BY u.name;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getGradesFrom` (IN `myId` INT, IN `suId` INT)  BEGIN
	SELECT u.name, g.grade, s.id, s.first_name, s.last_name
    FROM `Grades` AS g 
    JOIN `Subjects` AS u
    ON u.id = g.id_subject
    JOIN `Students` AS s
    ON s.id = g.id_student
    WHERE g.id_subject = suId
    ORDER BY u.name, s.id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMyGradeFrom` (IN `myId` INT, IN `suId` INT)  BEGIN
	SELECT u.name, g.grade 
    FROM `Grades` AS g 
    JOIN `Subjects` AS u
    ON u.id = g.id_subject
    WHERE g.id_student = myId AND g.id_subject = suId
    ORDER BY u.name;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMyStudentsGrades` (IN `myId` INT)  BEGIN
	SELECT u.name, g.grade, s.id, s.first_name, s.last_name
    FROM `Grades` AS g 
    JOIN `Subjects` AS u
    ON u.id = g.id_subject
    JOIN `Students` AS s
    ON s.id = g.id_student
    WHERE u.id_teacher = myId
    ORDER BY u.name, s.id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentById` (IN `myId` INT)  BEGIN
	SELECT * FROM `Students` WHERE id = myId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getTeacherById` (IN `myId` INT)  BEGIN
	SELECT * FROM `Teachers` WHERE id = myId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginStudent` (IN `myId` INT, IN `pass` VARCHAR(40))  BEGIN
	SELECT count(id) FROM `Students` WHERE id = myId AND password = pass;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loginTeacher` (IN `myId` INT, IN `pass` VARCHAR(40))  BEGIN
	SELECT count(id) FROM `Teachers` WHERE id = myId AND password = pass;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePasswordSTU` (IN `myId` INT, IN `pass` VARCHAR(40))  BEGIN
	UPDATE `Students` 
    SET password = SHA1(CONCAT('&!N_@(C-&$-*(&-4vmN&#$_V&_m&%#V)MU4ly8mjyC$)V#', MD5(pass)))
    WHERE id = myId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTeacherSTU` (IN `myId` INT, IN `pass` VARCHAR(40))  BEGIN
	UPDATE `Teachers` 
    SET password = SHA1(CONCAT('&!N_@(C-&$-*(&-4vmN&#$_V&_m&%#V)MU4ly8mjyC$)V#', MD5(pass)))
    WHERE id = myId;
END$$

DELIMITER ;
