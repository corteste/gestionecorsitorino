--docente
INSERT INTO docente VALUES('00001', 'Luke', 'Skywalker', 'INFORMATICA;CHIMICA;ANALISI');
INSERT INTO docente VALUES('00002', 'Jon', 'Snow', 'INFORMATICA;ANALISI');
INSERT INTO docente VALUES('00003', 'Francesco', 'Totti', 'STATISTICA;FISICA;CHIMICA;DIRITTO');

--admin
INSERT INTO ADMIN VALUES('Mario','00001','Rossi','prova');

--corsi
INSERT INTO CORSO VALUES('1','INFORMATICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A1','00001');
INSERT INTO CORSO VALUES('2','ANALISI','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A2','00002');
INSERT INTO CORSO VALUES('3','CHIMICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES('4','FISICA','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');
INSERT INTO CORSO VALUES('3','DIRITTO','20-SET-2021','20-GEN-2021',1000,'A;B;C;','A3','00003');
