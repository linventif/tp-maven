CREATE TABLE AUTEUR (ID  SERIAL NOT NULL, EMAIL VARCHAR(255), NOM VARCHAR(255), PRENOM VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE LIVRE (LNO  SERIAL NOT NULL, CATEGORIE VARCHAR(255), TITRE VARCHAR(255), ano BIGINT, PRIMARY KEY (LNO))
ALTER TABLE LIVRE ADD CONSTRAINT FK_LIVRE_ano FOREIGN KEY (ano) REFERENCES AUTEUR (ID)
