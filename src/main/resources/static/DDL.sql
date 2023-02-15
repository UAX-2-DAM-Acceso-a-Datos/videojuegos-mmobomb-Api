CREATE DATABASE videojuegos

CREATE TABLE users(
id_user INT AUTO_INCREMENT,
username VARCHAR(100) NOT NULL,
password VARCHAR(250) NOT NULL,
PRIMARY KEY(id_user)
)ENGINE=InnoDB;

CREATE TABLE favoritos(
id_videojuego INT,
id_user INT,
PRIMARY KEY (id_videojuego, id_user),
FOREIGN KEY (id_user) REFERENCES users (id_user) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


CREATE TABLE categorias(
id_categoria INT,
categoria VARCHAR(50),
PRIMARY KEY(id_categoria)
)ENGINE=InnoDB;