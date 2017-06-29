CREATE TABLE empleado (
    dni character varying(8) NOT NULL UNIQUE,
    nombre character varying(50) NOT NULL,
    telefono character varying(20) NOT NULL,
    domicilio character varying(60) NOT NULL,
    legajo SERIAL PRIMARY KEY
);

CREATE TABLE productor (
    dni character varying(8) NOT NULL,
    nombre character varying(50) NOT NULL,
    telefono character varying(12) NOT NULL,
    domicilio character varying(60),
    pcod SERIAL PRIMARY KEY 
);

CREATE TABLE establecimiento (
    nombre character varying(50) NOT NULL,
    ubicacion character varying(60) NOT NULL,
    pcod integer NOT NULL,
    ecod SERIAL PRIMARY KEY,
    legajo integer,

    FOREIGN KEY (legajo) REFERENCES empleado(legajo),
    FOREIGN KEY (pcod) REFERENCES productor(pcod)
);

CREATE TABLE animal (
    raza character varying(20) NOT NULL,
    fechanac date NOT NULL,
    peso real NOT NULL,
    acod SERIAL PRIMARY KEY,
    ecod integer NOT NULL,
    
    FOREIGN KEY (ecod) REFERENCES establecimiento(ecod)
);

CREATE TABLE produccion (
    fecha date NOT NULL,
    cantlts real NOT NULL,
    sng real NOT NULL,
    densidad real NOT NULL,
    nroReg SERIAL PRIMARY KEY,
    acod integer NOT NULL,

    FOREIGN KEY (acod) REFERENCES animal(acod)
);

-- ALTAS EMPLEADOS
INSERT INTO empleado ("dni", "nombre", "telefono", "domicilio")
VALUES ('15654789','juan perez','365241','lavalle 115');

INSERT INTO empleado ("dni", "nombre", "telefono", "domicilio")
VALUES ('33456786','empleado01','2664324362','chacabuco 345');

-- ALTAS PRODUCTORES
--1
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('10564789','Adolfo Rodrigez','2665847965','falucho 70');
--2
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('32589654','Jose Gutierrez','2664356985','Falucho 812');
--3
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('35789963','Luis Montenegro','266456123','Bolivar 51');
--4
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('30548478','Juan Perez','266789456','Illia 300');
--5
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('21753951','Jorge Gomez Gomez','2664963258','Lavalle 2687');
--6
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('25456789','Alberto Rodriguez','2664123123','Pringles 1142');
--7
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('30035472','Maria Rosa Zabala','3794854512','Belgrano 1258');
--8
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('29035472','Esteban Romero','2664721818','Junin 581');
--9
INSERT INTO productor ("dni","nombre","telefono","domicilio")
VALUES ('32546800','Josecito Moreno','266480','balcarce 563');

-- ALTAS ESTABLECIMIENTOS
INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('La Lechera','Santa Fe',1);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Sancor','Cordoba',2);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Lactosa','Cordoba',3);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Vaquitas','La Pampa',4);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Estancia Grande','Corrientes',5);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Don Jose','Cordoba',6);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Estancia Chica','Chaco',7);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Marolio','Santa Fe',8);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Milkaut','Santa Fe',9);

INSERT INTO establecimiento ("nombre","ubicacion","pcod")
VALUES ('Nutrilon','Santa Fe',1);

-- ALTA ANIMALES
INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v01','2017-06-20',410.0,1);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v02','2017-06-20',410.0,1);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v06','2017-06-20',410.0,1);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v07','2017-06-20',410.0,1);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v03','2017-06-20',410.0,1);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v04','2017-06-20',410.0,2);

INSERT INTO animal ("raza","fechanac","peso","ecod")
VALUES ('v05','2017-06-20',410.0,2);

-- ALTA PRODUCCION
INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-06-20',2.5,0.013,0.038,1);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-06-20',10.56,0.013,0.038,2);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-05-01',10.56,0.013,0.038,3);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-05-01',2.0,0.013,0.038,4);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-06-21',6.45,0.15,1.2,5);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-06-21',25.0,0.15,1.26,6);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-07-20',2.5,0.013,0.038,1);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-07-21',6.45,0.15,1.2,5);

INSERT INTO produccion ("fecha","cantlts","sng","densidad","acod")
VALUES ('2017-07-20',10.56,0.013,0.038,2);

