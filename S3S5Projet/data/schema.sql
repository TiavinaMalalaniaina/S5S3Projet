CREATE TABLE model(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    dtn DATE NOT NULL,
    salaire DOUBLE PRECISION NOT NULL,
    heure TIME,
    timestamp 
)