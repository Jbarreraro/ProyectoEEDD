CREATE TABLE `test`.`animal` (
  `idAnimal` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `animal` VARCHAR(45) NOT NULL,
  `genero` ENUM('M', 'F') NOT NULL,
  `fechaIngreso` DATE NOT NULL,
  `adoptable` BIT NOT NULL,
  `fechaSalida` DATE NULL,
  `estadoIngreso` VARCHAR(45) NULL,
  PRIMARY KEY (`idAnimal`));

