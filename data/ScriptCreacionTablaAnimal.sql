CREATE TABLE `test`.`animal` (
  `idAnimal` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `animal` ENUM ("perro","gato") NOT NULL,
  `genero` ENUM('M', 'F') NOT NULL,
  `fechaIngreso` DATE NOT NULL,
  `adoptable` BIT NOT NULL,
  `fechaSalida` DATE NULL,
  `estadoIngreso` ENUM("Muy mal", "Mal", "Bueno", "Muy Bueno") NOT NULL,
  PRIMARY KEY (`idAnimal`));

