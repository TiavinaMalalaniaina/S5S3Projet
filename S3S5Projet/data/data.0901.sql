CREATE SCHEMA IF NOT EXISTS "public";

CREATE SEQUENCE "public".categorie_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".meuble_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".meuble_materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".style_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".style_materiel_id_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".categorie ( 
	id                   integer DEFAULT nextval('categorie_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_categorie PRIMARY KEY ( id )
 );

CREATE  TABLE "public".materiel ( 
	id                   integer DEFAULT nextval('materiel_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_materiel PRIMARY KEY ( id )
 );

CREATE  TABLE "public"."style" ( 
	id                   integer DEFAULT nextval('style_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_tbl PRIMARY KEY ( id )
 );

CREATE  TABLE "public".style_materiel ( 
	id                   integer DEFAULT nextval('style_materiel_id_seq'::regclass) NOT NULL  ,
	style_id             integer  NOT NULL  ,
	materiel_id          integer  NOT NULL  ,
	CONSTRAINT pk_style_materiel PRIMARY KEY ( id ),
	CONSTRAINT fk_style_materiel_materiel FOREIGN KEY ( materiel_id ) REFERENCES "public".materiel( id )   ,
	CONSTRAINT fk_style_materiel_style FOREIGN KEY ( style_id ) REFERENCES "public"."style"( id )   
 );

CREATE  TABLE "public".meuble ( 
	id                   integer DEFAULT nextval('meuble_id_seq'::regclass) NOT NULL  ,
	categorie_id         integer  NOT NULL  ,
	style_id             integer  NOT NULL  ,
	CONSTRAINT pk_meuble PRIMARY KEY ( id ),
	CONSTRAINT fk_meuble_categorie FOREIGN KEY ( categorie_id ) REFERENCES "public".categorie( id )   ,
	CONSTRAINT fk_meuble_style FOREIGN KEY ( style_id ) REFERENCES "public"."style"( id )   
 );

CREATE  TABLE "public".meuble_materiel ( 
	id                   integer DEFAULT nextval('meuble_materiel_id_seq'::regclass) NOT NULL  ,
	meuble_id            integer    ,
	materiel_id          integer    ,
	petit                double precision  NOT NULL  ,
	grand                double precision  NOT NULL  ,
	CONSTRAINT pk_meuble_materiel PRIMARY KEY ( id ),
	CONSTRAINT fk_meuble_materiel_materiel FOREIGN KEY ( materiel_id ) REFERENCES "public".materiel( id )   ,
	CONSTRAINT fk_meuble_materiel_meuble FOREIGN KEY ( meuble_id ) REFERENCES "public".meuble( id )   
 );

CREATE VIEW "public".v_meuble AS  SELECT m.id,
    m.categorie_id,
    m.style_id,
    s.nom AS style_nom,
    c.nom AS categorie_nom
   FROM ((meuble m
     JOIN style s ON ((m.style_id = s.id)))
     JOIN categorie c ON ((m.categorie_id = c.id)));

CREATE VIEW "public".v_meuble_materiel AS  SELECT mm.id,
    mm.meuble_id,
    mm.materiel_id,
    mm.petit,
    mm.grand,
    vm.categorie_id,
    vm.style_id,
    vm.style_nom,
    vm.categorie_nom
   FROM (meuble_materiel mm
     JOIN v_meuble vm ON ((mm.meuble_id = vm.id)));

CREATE VIEW "public".v_style_materiel AS  SELECT sm.id,
    sm.style_id,
    sm.materiel_id,
    s.nom AS style_nom,
    m.nom AS materiel_nom
   FROM ((style_materiel sm
     JOIN style s ON ((sm.style_id = s.id)))
     JOIN materiel m ON ((sm.materiel_id = m.id)));

INSERT INTO "public".categorie( id, nom ) VALUES ( 1, 'chaise');
INSERT INTO "public".categorie( id, nom ) VALUES ( 2, 'table');
INSERT INTO "public".categorie( id, nom ) VALUES ( 3, 'lit');
INSERT INTO "public".categorie( id, nom ) VALUES ( 4, 'armoire');
INSERT INTO "public".materiel( id, nom ) VALUES ( 1, 'Bois');
INSERT INTO "public".materiel( id, nom ) VALUES ( 2, 'Contre-plaquÃ©');
INSERT INTO "public".materiel( id, nom ) VALUES ( 4, 'Plastique');
INSERT INTO "public".materiel( id, nom ) VALUES ( 5, 'Inox');
INSERT INTO "public".materiel( id, nom ) VALUES ( 6, 'Or');
INSERT INTO "public".materiel( id, nom ) VALUES ( 7, 'qsdf');
INSERT INTO "public".materiel( id, nom ) VALUES ( 8, 'qsdf');
INSERT INTO "public".materiel( id, nom ) VALUES ( 9, 'qsdfqs');
INSERT INTO "public"."style"( id, nom ) VALUES ( 1, 'Royale');
INSERT INTO "public"."style"( id, nom ) VALUES ( 2, 'Contemporain');
INSERT INTO "public"."style"( id, nom ) VALUES ( 3, 'BohÃ¨me');
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 1, 1, 2);
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 2, 1, 6);
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 3, 2, 2);
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 4, 2, 4);
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 5, 3, 2);
INSERT INTO "public".style_materiel( id, style_id, materiel_id ) VALUES ( 6, 3, 6);
INSERT INTO "public".meuble( id, categorie_id, style_id ) VALUES ( 1, 1, 1);
INSERT INTO "public".meuble_materiel( id, meuble_id, materiel_id, petit, grand ) VALUES ( 3, 1, 2, 10.0, 20.0);
INSERT INTO "public".meuble_materiel( id, meuble_id, materiel_id, petit, grand ) VALUES ( 4, 1, 6, 2.0, 4.0);
