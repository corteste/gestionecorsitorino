--OPERAZIONI_BASE CORSISTA
SELECT CORSISTA.COD_CORSISTA,CORSISTA.NOME_CORSISTA,CORSISTA.COGNOME_CORSITA,CORSISTA.PRECEDENTI_FORMATIVI 

FROM CORSISTA; -- PER INSERT E GET ALL

SELECT CORSISTA.*
FROM CORSISTA
WHERE COD_CORSISTA = ?

--END OPERAZIONE CORSISTA


--OPERAZIONI_BASE CORSO
SELECT CORSO.COD_CORSO,CORSO.NOME_CORSO,CORSO.DATA_INIZIO,CORSO.DATA_FINE,CORSO.COSTO_CORSO,CORSO.COMMENTI_CORSO,CORSO.AULA_CORSO,CORSO.COD_DOCENTE
FROM CORSO; --PER INSERT E GET ALL

SELECT CORSO.*
FROM CORSO
WHERE COD_CORSO = ? 

SELECT CORSO.*
FROM CORSO 
WHERE COD_DOCENTE = ?

SELECT CORSO.*
FROM CORSO,CORSO_CORSITA
WHERE CORSO.COD_CORSO = CORSO_CORSISTA.COD_CORSO
AND CORSO_CORSISTA.COD_CORSISTA = ?

DELETE FROM CORSO WHERE COD_CORSO = ? 
--END OPERAZIONE CORSO



--STATISTICHE
--1 CONTROLLATA
SELECT COUNT(*)
FROM CORSISTA
--END 1
--2 CONTROLLATA
CREATE OR REPLACE VIEW  CORSO_POPOLARE AS 


SELECT COD_CORSO,COUNT(COD_CORSISTA) AS PARTECIPANTI
FROM CORSO_CORSISTA
GROUP BY COD_CORSO
HAVING COUNT(COD_CORSISTA)  = (SELECT MAX(COUNT(COD_CORSISTA))
FROM CORSO_CORSISTA
GROUP BY COD_CORSO)


--END 2
--3 CONTROLLATA 
SELECT CORSO.*
FROM CORSO
WHERE DATA_INIZIO = (SELECT MAX(DATA_INIZIO)
                     FROM CORSO)
--END 3
--4
--SE CONTROLLIAMO CHE IL GIORNO SIA LAVORATIVO (SIA DI INIZIO CHE DI FINE)
SELECT  AVG((DATA_FINE-DATA_INIZIO) - (TO_NUMBER(TO_CHAR(DATA_FINE, 'IW'))-TO_NUMBER(TO_CHAR(DATA_INIZIO, 'IW')))*2 )
FROM CORSO
--IN PRATICA CONTO I GIORNI CHE CI SONO TRA DATA_FINE-DATA_INIZO
--POI CONTROLLO QUANTE SETTIMANE PASSANO E LEVO IL DOPPIO DELLE SETTIMANE
--FUNZIA SOLO SE IL GIORNO DI PARTENZA DEL CORSO /GIORNO DI FINE DEL CORSO SONO LAVORATIVI
--END 4

--5 CONTROLLATA OK 
CREATE OR REPLACE CORSO_COMMENTI AS 
SELECT DISTINCT COD_CORSO,regexp_substr(CORSO.commenti_corso, '[^;]+', 1, LEVEL) COMMENTI
FROM CORSO
CONNECT BY regexp_substr(CORSO.commenti_corso, '[^;]+', 1, LEVEL) IS NOT NULL;

CREATE OR REPLACE VIEW CORSO_N_COMMENTI AS
SELECT COD_CORSO, COUNT(COMMENTI) AS NUMERO_COMMENTI
FROM CORSO_COMMENTI
GROUP BY COD_CORSO
;

SELECT SUM(NUMERO_COMMENTI)
FROM CORSO_N_COMMENTI

--END 5

--6
--UGUALE AL GET ALL
--END 

--7 CONTROLLATA
CREATE OR REPLACE VIEW DOCENTE_CV AS 
SELECT DISTINCT COD_DOCENTE,regexp_substr(DOCENTE.CV_DOCENTE, '[^;]+', 1, LEVEL) MATERIE
FROM DOCENTE
CONNECT BY regexp_substr(DOCENTE.CV_DOCENTE, '[^;]+', 1, LEVEL) IS NOT NULL;

SELECT COD_DOCENTE, COUNT(MATERIE) 
FROM DOCENTE_CV
GROUP BY COD_DOCENTE
HAVING COUNT(MATERIE) = (SELECT MAX(COUNT(MATERIE))
                        FROM DOCENTE_CV
                        GROUP BY COD_DOCENTE
                        );
--END 7

--8 CONTROLLATA

CREATE OR REPLACE VIEW  AS 

SELECT COD_CORSO,(12 - COUNT(COD_CORSISTA)) POSTI_DISPONIBILI
FROM CORSO_CORSISTA 
GROUP BY(COD_CORSO)
HAVING COUNT(COD_CORSISTA) >0 

--END 8
                     
---END STATISTICHE