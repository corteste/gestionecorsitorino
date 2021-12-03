--docente
INSERT INTO docente VALUES('00001', 'Luke', 'Skywalker', 'INFORMATICA;CHIMICA;ANALISI');
INSERT INTO docente VALUES('00002', 'Jon', 'Snow', 'INFORMATICA;ANALISI');
INSERT INTO docente VALUES('00003', 'Francesco', 'Totti', 'STATISTICA;FISICA;CHIMICA;DIRITTO');

--admin
INSERT INTO ADMIN VALUES('prova','00001','Mario','Rossi');

--corsi
INSERT INTO CORSO VALUES(corso_seq.nextval,'INFORMATICA','20-SET-2021','20-GEN-2022',1000,'A;B;C;','A1','00001');
INSERT INTO CORSO VALUES(corso_seq.nextval,'ANALISI','20-SET-2021','20-GEN-2022',1000,'A;B;C;','A2','00002');
INSERT INTO CORSO VALUES(corso_seq.nextval,'CHIMICA','20-SET-2021','20-GEN-2022',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES(corso_seq.nextval,'FISICA','20-SET-2021','20-GEN-2022',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES(corso_seq.nextval,'DIRITTO','20-SET-2021','20-GEN-2022',1000,'A;B;C;','A3','00003');

--corsista
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Mickey','Mouse','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Duffy','Duck','N');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Paperon','De Paperoni','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Pippo','Pluto','S');
