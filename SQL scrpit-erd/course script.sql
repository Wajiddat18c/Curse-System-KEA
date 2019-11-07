-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teacher` (
  `Email` VARCHAR(100) NOT NULL,
  `First_name` VARCHAR(45) NOT NULL,
  `Last_name` VARCHAR(45) NOT NULL,
  `Course_infomation_Id_Coruse` INT NOT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course_infomation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course_infomation` (
  `Id_Coruse` INT NOT NULL AUTO_INCREMENT,
  `Course` VARCHAR(200) NOT NULL,
  `Semester` INT NOT NULL,
  `ECTS` INT NOT NULL,
  `Course_Language` VARCHAR(100) NOT NULL,
  `Minimu_num _of_students` INT NOT NULL,
  `Maximumnum_of_students` INT NOT NULL,
  `Prerequisites` VARCHAR(250) NOT NULL,
  `Learning_outcome` VARCHAR(250) NOT NULL,
  `Content` VARCHAR(250) NOT NULL,
  `Learning_activities` VARCHAR(250) NOT NULL,
  `Exam_form` VARCHAR(250) NOT NULL,
  `Teacher_Email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Id_Coruse`),
  INDEX `fk_Course_infomation_Teacher_idx` (`Teacher_Email` ASC) VISIBLE,
  CONSTRAINT `fk_Course_infomation_Teacher`
    FOREIGN KEY (`Teacher_Email`)
    REFERENCES `mydb`.`Teacher` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course_Application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course_Application` (
  `Application_Id` INT NOT NULL AUTO_INCREMENT,
  `First_name` VARCHAR(50) NOT NULL,
  `Last_name` VARCHAR(50) NOT NULL,
  `birth` DATE NOT NULL,
  `Current_class` VARCHAR(45) NOT NULL,
  `EMail` VARCHAR(70) NOT NULL,
  `Phone` INT NOT NULL,
  `Course_infomation_Id_Coruse` INT NOT NULL,
  PRIMARY KEY (`Application_Id`),
  INDEX `fk_Course_Application_Course_infomation1_idx` (`Course_infomation_Id_Coruse` ASC) VISIBLE,
  CONSTRAINT `fk_Course_Application_Course_infomation1`
    FOREIGN KEY (`Course_infomation_Id_Coruse`)
    REFERENCES `mydb`.`Course_infomation` (`Id_Coruse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
