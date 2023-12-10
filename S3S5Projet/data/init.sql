CREATE DATABASE projet_s3s5;

-- Utiliser la base de données
\c projet_s3s5;

-- Créer l'utilisateur avec mot de passe
CREATE USER s3s5 WITH PASSWORD 's3s5';

-- Donner tous les privilèges à l'utilisateur sur la base de données
GRANT ALL PRIVILEGES ON DATABASE projet_s3s5 TO s3s5;
