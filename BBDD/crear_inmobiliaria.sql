--
-- Creacion de la Base de Datos 'inmobiliaria'
--
--


-- ATENCION: Debemos ejecutar este script desde 
-- MySQL Query Browse habiendo entrado como root


-- Crea la BD si no existe
CREATE DATABASE IF NOT EXISTS inmobiliaria;

-- La activa
use inmobiliaria;

-- Crea el usuario 'usuario1'
-- Este usuario se podr connectar desde cualquier host.
-- Esto se consiguie mediante el smbolo '%'
-- Si quisiramos que slo pudiera conectarse en local
-- sustituiramos '%' por 'localhost'
-- create user 'usuario1'@'%' identified by 'usuario1';


-- Conceder al usuario slo permisos especficos sobre la BD
-- GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON inmobiliaria.* TO 'usuario1'@'%';

-- Si quisieramos conceder al usuario permisos totales sobre la BD:
-- GRANT ALL ON inmobiliaria.* TO 'usuario1'@'%';

--
-- Si la BD ya exista debemos eliminar las tablas
-- Hay que eliminar antes las tablas hijas que las padres
--
drop table if exists CAJA;
drop table if exists PEDIDO;
drop table if exists PISO;
drop table if exists PROP;
drop table if exists CLI;


--
-- Creacin de las tablas
--


--
-- Creacin de la tabla de pisos
--

create table piso(
	n_piso serial primary key,
	dir varchar(50) not null,
	loc varchar(50) not null,
	piscina boolean not null,
	nif_prop varchar(10) not null,
	precio decimal(6,2) not null,
	comision decimal(5,2) not null
);

-- Carga de los datos
LOAD DATA LOCAL INFILE '~/Dropbox/Documents/ap-java-sep10/teoria/bd-sql/practica2/cargasSQL/PISO.txt' INTO TABLE piso LINES TERMINATED BY '\r\n';



--
-- Creacion de la tabla de propietarios
--

create table prop(
	nif_prop varchar(10) primary key not null,
	nombre varchar(50) not null,
	apel varchar(100) not null,
	dir varchar(50) not null,
	loc varchar(50) not null
);

-- Carga de los datos
LOAD DATA LOCAL INFILE '~/Dropbox/Documents/ap-java-sep10/teoria/bd-sql/practica2/cargasSQL/PROP.txt' INTO TABLE prop LINES TERMINATED BY '\r\n';


--
-- Creacin de la tabla clientes
--

create table cli(
	nif_cli varchar(10) primary key not null,
	nombre varchar(50) not null,
	apel varchar(100) not null
);

-- Carga de los datos
LOAD DATA LOCAL INFILE '~/Dropbox/Documents/ap-java-sep10/teoria/bd-sql/practica2/cargasSQL/CLI.txt' INTO TABLE cli LINES TERMINATED BY '\r\n';


--
-- Creacin de la tabla de pedidos
--

create table pedido(
	n_pedido serial primary key,
	nif_cli varchar(10) not null,
	n_piso bigint unsigned not null,
	llegada date not null,
	partida date not null,
	pagado boolean not null,
	cancelado boolean not null
);

-- Carga de los datos
LOAD DATA LOCAL INFILE '~/Dropbox/Documents/ap-java-sep10/teoria/bd-sql/practica2/cargasSQL/PEDIDO.txt' INTO TABLE pedido LINES TERMINATED BY '\r\n';


--
-- Creacin de la tabla caja
--

create table caja(
	n_factura serial primary key,
	operacion char(1) not null,
	n_pedido bigint unsigned null,
	importe decimal(10,2) not null,
	pagado boolean null,
	dia date not null
);

-- Carga de los datos
LOAD DATA LOCAL INFILE '~/Dropbox/Documents/ap-java-sep10/teoria/bd-sql/practica2/cargasSQL/CAJA.txt' INTO TABLE caja LINES TERMINATED BY '\r\n';

--
-- Definicion de claves externas
--

-- Si se modifica la clave primaria de la tabla padre 
-- se actualiza el valor de la clave externa.
--
-- El intento de eliminar un registro de la clave primaria 
-- de la tabla padre ser prohibido si existen registros 
-- para esa clave en la tabla hija.

ALTER TABLE piso ADD FOREIGN KEY fk_nif_prop(nif_prop) REFERENCES prop(nif_prop) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE pedido ADD FOREIGN KEY fk_nif_cli(nif_cli) REFERENCES cli(nif_cli) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE pedido ADD FOREIGN KEY fk_n_piso(n_piso) REFERENCES piso(n_piso) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE caja ADD FOREIGN KEY fk_n_pedido(n_pedido) REFERENCES pedido(n_pedido) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Creamos otro usuario que solo puede hacer operaciones simples sobre la BD.
-- Este usuario es el que podriamos utilizar desde un programa Java
-- create user 'usuario2'@'%' identified by 'usuario2';
--GRANT SELECT,INSERT,UPDATE,DELETE ON inmobiliaria.* TO 'usuario2'@'%';