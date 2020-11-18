create schema project2;

CREATE TABLE `User_Table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `PersonID` int DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Role_Table` (
  `ID` int NOT NULL,
  `RoleName` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `LastModidicationUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `UserRole_Table` (
  `ID` int NOT NULL,
  `UserID` int DEFAULT NULL,
  `RoleID` int DEFAULT NULL,
  `ActiveFlag` varchar(45) DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `LastModificationUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `UserRole_UserID_FK_idx` (`UserID`),
  KEY `UserRole_RoleID_FK_idx` (`RoleID`),
  CONSTRAINT `UserRole_RoleID_FK` FOREIGN KEY (`RoleID`) REFERENCES `Role_Table` (`ID`),
  CONSTRAINT `UserRole_UserID_FK` FOREIGN KEY (`UserID`) REFERENCES `User_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Permission_Table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PermissionName` varchar(45) DEFAULT NULL,
  `PermissionDescription` varchar(45) DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `LastModificationUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `RolePermission_Table` (
  `ID` int NOT NULL,
  `RoleID` int DEFAULT NULL,
  `PermissionID` int DEFAULT NULL,
  `RolePermission_Tablecol` varchar(45) DEFAULT NULL,
  `ActiveFlag` varchar(45) DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `LastModificationUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RolePermission_RoleID_FK_idx` (`RoleID`),
  KEY `RolePermission_Permission_ID_FK_idx` (`PermissionID`),
  CONSTRAINT `RolePermission_Permission_ID_FK` FOREIGN KEY (`PermissionID`) REFERENCES `Permission_Table` (`ID`),
  CONSTRAINT `RolePermission_RoleID_FK` FOREIGN KEY (`RoleID`) REFERENCES `Role_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `RegistrationToken_Table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Token` varchar(45) DEFAULT NULL,
  `ValidDuration` int DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `CreatedBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Person_Table` (
  `ID` int NOT NULL,
  `Firstname` varchar(45) DEFAULT NULL,
  `Lastname` varchar(45) DEFAULT NULL,
  `Middlename` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `CellPhone` varchar(45) DEFAULT NULL,
  `AlternatePhone` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `SSN` int DEFAULT NULL,
  `DOB` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Employee_Table` (
  `ID` int NOT NULL,
  `PersonID` int DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `ManagerID` varchar(45) DEFAULT NULL,
  `StartDate` varchar(45) DEFAULT NULL,
  `EndDate` varchar(45) DEFAULT NULL,
  `Avartar` varchar(45) DEFAULT NULL,
  `Car` varchar(45) DEFAULT NULL,
  `VisaStatusID` int DEFAULT NULL,
  `VisaStartDate` varchar(45) DEFAULT NULL,
  `VisaEndDate` varchar(45) DEFAULT NULL,
  `DriverLisence` varchar(45) DEFAULT NULL,
  `DriverLisence_ExpirationDate` varchar(45) DEFAULT NULL,
  `HouseID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Employee_PersonID_FK_idx` (`PersonID`),
  CONSTRAINT `Employee_PersonID_FK` FOREIGN KEY (`PersonID`) REFERENCES `Person_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Contact_Table` (
  `ID` int NOT NULL,
  `PersonID` int DEFAULT NULL,
  `Relationship` varchar(45) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `isRewference` varchar(45) DEFAULT NULL,
  `isEmergency` varchar(45) DEFAULT NULL,
  `isLandlord` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Contact_PersonID_FK_idx` (`PersonID`),
  CONSTRAINT `Contact_PersonID_FK` FOREIGN KEY (`PersonID`) REFERENCES `Person_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Address_Table` (
  `ID` int NOT NULL,
  `AddressLine1` varchar(45) DEFAULT NULL,
  `AddressLine2` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Zipcode` int DEFAULT NULL,
  `StateName` varchar(45) DEFAULT NULL,
  `StateAbbr` varchar(45) DEFAULT NULL,
  `PersonID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Address_PersonID_FK_idx` (`PersonID`),
  CONSTRAINT `Address_PersonID_FK` FOREIGN KEY (`PersonID`) REFERENCES `Person_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `VisaStatus_Table` (
  `ID` int NOT NULL,
  `VisaType` varchar(45) DEFAULT NULL,
  `Active` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `CreateUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `PersonalDocument_Table` (
  `ID` int NOT NULL,
  `EmployeeID` int DEFAULT NULL,
  `Path` varchar(45) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `Comment` varchar(45) DEFAULT NULL,
  `CteatedDate` varchar(45) DEFAULT NULL,
  `CreateBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonalDocument_EmployeeID_FK_idx` (`EmployeeID`),
  CONSTRAINT `PersonalDocument_EmployeeID_FK` FOREIGN KEY (`EmployeeID`) REFERENCES `Employee_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `DigitalDocument_Table` (
  `ID` int NOT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Required` varchar(45) DEFAULT NULL,
  `TemplateLocation` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ApplicationWorkFlow_Table` (
  `ID` int NOT NULL,
  `EmployeeID` int DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `ModificationDate` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Comments` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ApplicationWorkFlow_EmployeeID_FK_idx` (`EmployeeID`),
  CONSTRAINT `ApplicationWorkFlow_EmployeeID_FK` FOREIGN KEY (`EmployeeID`) REFERENCES `Employee_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `House_Table` (
  `ID` int NOT NULL,
  `ContactID` int DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `NumberofPerson` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `House_ContactID_FK_idx` (`ContactID`),
  CONSTRAINT `House_ContactID_FK` FOREIGN KEY (`ContactID`) REFERENCES `Contact_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Facility_Table` (
  `ID` int NOT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `HouseID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Facility_HouseID_FK_idx` (`HouseID`),
  CONSTRAINT `Facility_HouseID_FK` FOREIGN KEY (`HouseID`) REFERENCES `House_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FacilityReport_Table` (
  `ID` int NOT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `EmployeeID` int DEFAULT NULL,
  `ReportDate` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FacilityReport_EmployeeID_FK_idx` (`EmployeeID`),
  CONSTRAINT `FacilityReport_EmployeeID_FK` FOREIGN KEY (`EmployeeID`) REFERENCES `Employee_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FacilityReportDetail_Table` (
  `ID` int NOT NULL,
  `ReportID` int DEFAULT NULL,
  `EmployeeID` int DEFAULT NULL,
  `Comments` varchar(45) DEFAULT NULL,
  `CreateDate` varchar(45) DEFAULT NULL,
  `LastModicationDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FacilityReportDetail_EmployeeID_FK_idx` (`EmployeeID`),
  CONSTRAINT `FacilityReportDetail_EmployeeID_FK` FOREIGN KEY (`EmployeeID`) REFERENCES `Employee_Table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `Testing_Table` (
  `ID` int NOT NULL,
  `nameTable` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `project2`.`Testing_Table` (`ID`, `nameTable`) VALUES ('1', 'test1');



