
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(45) NOT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) 

INSERT INTO `user` VALUES (1,'Lilan','Colazoneloniñao','dlan@gmail.com','odioaOzzy'),(2,'nombre','apellido','correo','perrofeo'),(4,'nombre','apellido','correo','perrofeo'),(5,'nombre','apellido','correo','perrofeo');
