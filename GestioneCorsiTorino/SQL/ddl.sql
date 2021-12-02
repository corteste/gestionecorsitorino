--MAX 12 CORSISTI
CREATE TABLE corso( 
cod_corso int,
nome_corso varchar2(30) NOT NULL,
data_inizio date NOT NULL,
data_fine date NOT NULL,
costo_corso number(7,2),
commenti_corso varchar2(200),
aula_corso varchar2(30),
cod_docente char(5),
CONSTRAINT p_cod_corso PRIMARY KEY (cod_corso),
CONSTRAINT f_cod_docente FOREIGN KEY (cod_docente) REFERENCES docente(cod_docente)
);

CREATE TABLE admin(
username_admin varchar2(15) UNIQUE NOT NULL,
cod_admin char(5),
nome_admin varchar2(30) NOT NULL,
cognome_admin varchar2(30) NOT NULL,
CONSTRAINT p_cod_admin PRIMARY KEY (cod_admin)
);

CREATE TABLE corsista(
cod_corsista int,
nome_corsista varchar2(30) NOT NULL,
cognome_corsista varchar2(30) NOT NULL,
precedenti_formativi char(1),
CONSTRAINT p_cod_corsista PRIMARY KEY (cod_corsista)
);

CREATE TABLE docente(
cod_docente char(5),
nome_docente varchar2(30) NOT NULL,
cognome_docente varchar2(30) NOT NULL,
cv_docente varchar2(100) NOT NULL,
CONSTRAINT p_cod_docente PRIMARY KEY (cod_docente)
);

CREATE TABLE corso_corsista(
cod_corso int,
cod_corsista int,
CONSTRAINT f_cod_corsista FOREIGN KEY (cod_corsista) REFERENCES corsista(cod_corsista),
CONSTRAINT f_cod_corso FOREIGN KEY (cod_corso) REFERENCES corso(cod_corso),
CONSTRAINT p_corso_corsista PRIMARY KEY (cod_corso, cod_corsista)
);

CREATE sequence corso_seq;
CREATE sequence corsista_seq;

-- VIEW (da inserire su cmd)

CREATE OR REPLACE VIEW DOCENTE_CV AS 
SELECT DISTINCT COD_DOCENTE,regexp_substr(DOCENTE.CV_DOCENTE, '[^;]+', 1, LEVEL) MATERIE
FROM DOCENTE
CONNECT BY regexp_substr(DOCENTE.CV_DOCENTE, '[^;]+', 1, LEVEL) IS NOT NULL;
