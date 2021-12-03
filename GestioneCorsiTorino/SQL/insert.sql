--docente
INSERT INTO docente VALUES('00001', 'Luke', 'Skywalker', 'INFORMATICA;CHIMICA;ANALISI');
INSERT INTO docente VALUES('00002', 'Jon', 'Snow', 'INFORMATICA;ANALISI');
INSERT INTO docente VALUES('00003', 'Francesco', 'Totti', 'STATISTICA;FISICA;CHIMICA;DIRITTO');

--admin
INSERT INTO ADMIN VALUES('Mario','00001','Rossi','prova');

--corsi
INSERT INTO CORSO VALUES(corso_seq.nextval,'INFORMATICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A1','00001');
INSERT INTO CORSO VALUES(corso_seq.nextval,'ANALISI','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A2','00002');
INSERT INTO CORSO VALUES(corso_seq.nextval,'CHIMICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES(corso_seq.nextval,'FISICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES(corso_seq.nextval,'DIRITTO','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');

--corsista
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Pippo','Pluto','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Pipqqq','EERRR','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'QWERTY','AMD','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'MAX','NUTS','S');
INSERT INTO CORSISTA VALUES(corsista_seq.nextval,'Sono','un corsista','S');