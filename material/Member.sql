CREATE TABLE `KS_GATEWAY`.`Member` (
  `Id` INT NOT NULL,
  `Reference_Code` VARCHAR(12) NOT NULL,
  `User_Name` VARCHAR(10) NOT NULL,
  `Password` VARCHAR(10) NOT NULL,
  `First_Name` VARCHAR(30) NOT NULL,
  `Last_Name` VARCHAR(30) NOT NULL,
  `Age` INT NOT NULL,
  `Phone` VARCHAR(10) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Salary` VARCHAR(10) NOT NULL,
  `Address` VARCHAR(200) NULL,
  `Member_Type` VARCHAR(10) NOT NULL,
  `Create_Date` DATE NOT NULL,
  `Update_Date` DATE NOT NULL,
  PRIMARY KEY (`Id`));