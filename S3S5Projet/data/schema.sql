CREATE SCHEMA IF NOT EXISTS "public";

CREATE  TABLE "public".materiel ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_materiaux PRIMARY KEY ( id )
 );

CREATE  TABLE "public".meuble_type ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_meuble_type PRIMARY KEY ( id )
 );

CREATE  TABLE "public".materiel_type ( 
	id                   serial  NOT NULL  ,
	materiel_id          integer  NOT NULL  ,
	meuble_type_id       integer  NOT NULL  ,
	CONSTRAINT pk_materiel_type PRIMARY KEY ( id ),
	CONSTRAINT fk_materiel_type_materiel FOREIGN KEY ( materiel_id ) REFERENCES "public".materiel( id )   ,
	CONSTRAINT fk_materiel_type_meuble_type FOREIGN KEY ( meuble_type_id ) REFERENCES "public".meuble_type( id )   
 );

CREATE OR REPLACE VIEW "public".v_meuble_materiaux AS 
SELECT m.*, ma.nom nom_materiel, mt.nom nom_meuble_type
FROM materiel_type m
JOIN materiel ma ON m.materiel_id=ma.id 
JOIN meuble_type mt ON m.meuble_type_id=mt.id;

