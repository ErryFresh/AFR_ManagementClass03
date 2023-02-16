drop database if exists afr_management;
create database afr_management;
use afr_management;

CREATE TABLE Reparto(
                        codiceRep INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(30) NOT NULL,
                        descrizione TEXT
);

CREATE TABLE Dipendente(
                           matricola CHAR(10) PRIMARY KEY,
                           password VARCHAR(40) NOT NULL,
                           cf CHAR(16) NOT NULL,
                           nome VARCHAR(30) NOT NULL,
                           cognome VARCHAR(30) NOT NULL,
                           recapito CHAR(10) NOT NULL,
                           eMail VARCHAR(30) NOT NULL,
                           posizione VARCHAR(20) NOT NULL,
                           codiceRep INT NOT NULL,
                           FOREIGN KEY(codiceRep) REFERENCES Reparto(codiceRep)
);

CREATE TABLE Prodotto(
                         codiceArt CHAR(8) primary key,
                         nome VARCHAR(30) UNIQUE,
                         descrizione TEXT NOT NULL,
                         prezzoAcquisto DOUBLE NOT NULL,
                         prezzoVendita DOUBLE NOT NULL,
                         tipologiaVendita VARCHAR(10) NOT NULL
);

CREATE TABLE ProdottoScaffale(
                                codProdScaf INT AUTO_INCREMENT PRIMARY KEY,
                                 codiceArt CHAR(8),
                                 codiceSc INT,
                                 quantita INT NOT NULL,
                                 lunghezza DOUBLE NOT NULL,
                                 larghezza DOUBLE NOT NULL,
                                 altezza DOUBLE NOT NULL
);

CREATE TABLE Magazzino(
                          codiceMag INT PRIMARY KEY,
                          indirizzo VARCHAR(255),
                          nScaffali INT NOT NULL
);

CREATE TABLE Scaffale(
                         codiceSc INT PRIMARY KEY,
                         nome VARCHAR(10) NOT NULL,
                         descrizione TEXT NOT NULL,
                         superficeOccupata DOUBLE NOT NULL,
                         superficeDisponibile DOUBLE NOT NULL,
                         codiceMag INT REFERENCES Magazzino(codiceMag)
);

CREATE TABLE ClienteFornitore(
                                 cf VARCHAR(17) PRIMARY KEY,
                                 nome VARCHAR(30) NOT NULL,
                                 cognome VARCHAR(50),
                                 recapito VARCHAR(50) UNIQUE,
                                 eMail VARCHAR(319) UNIQUE
);

CREATE TABLE Calendario(
                           codiceCal CHAR(5) PRIMARY KEY,
                           nome VARCHAR(15) NOT NULL,
                           codiceRep INT NOT NULL,
                           matricolaDip CHAR(10) NOT NULL,
                           FOREIGN KEY(codiceRep) REFERENCES Reparto(codiceRep),
                           FOREIGN KEY(matricolaDip) REFERENCES Dipendente(matricola)
);

CREATE TABLE Evento(
                       codiceEv CHAR(5) PRIMARY KEY,
                       nome VARCHAR(30) NOT NULL,
                       descrizione TEXT NOT NULL,
                       dataEv DATE NOT NULL,
                       matricolaDip CHAR(10) NOT NULL,
                       codiceCal CHAR(5) NOT NULL,
                       FOREIGN KEY(matricolaDip) REFERENCES Dipendente(matricola),
                       FOREIGN KEY(codiceCal) REFERENCES Calendario(codiceCal)
);

CREATE TABLE Pagamento(
                          nTransazione INT AUTO_INCREMENT PRIMARY KEY,
                          tipo VARCHAR(25) NOT NULL,
                          nAssegno CHAR(13) UNIQUE,
                          causale VARCHAR(255) NOT NULL,
                          importo DOUBLE NOT NULL,
                          saldato BOOLEAN NOT NULL DEFAULT 0,
                          dataEmissione DATE NOT NULL,
                          dataScadenza DATE NOT NULL,
                          beneficiario VARCHAR(17) REFERENCES ClienteFornitore(cf),
                          emittente VARCHAR(17) REFERENCES ClienteFornitore(cf)
);

CREATE TABLE Documento(
                          nDocumento CHAR(11) PRIMARY KEY,
                          tipo VARCHAR(50) NOT NULL,
                          dataEmissione DATE NOT NULL,
                          note VARCHAR(250) UNIQUE,
                          cf CHAR(17) NOT NULL,
                          matricola CHAR(10) NOT NULL,
                          FOREIGN KEY(cf) REFERENCES ClienteFornitore(cf),
                          FOREIGN KEY(matricola) REFERENCES Dipendente(matricola)
);

CREATE TABLE ProdottoDocumento(
                                  codProdDoc INT AUTO_INCREMENT PRIMARY KEY,
                                  codiceArt CHAR(8) NOT NULL,
                                  codiceDoc CHAR(11) NOT NULL,
                                  quantita INT NOT NULL,
                                  lunghezza DOUBLE NOT NULL,
                                  larghezza DOUBLE NOT NULL,
                                  altezza DOUBLE NOT NULL
);

insert into Reparto values(1,"amminsitrazione","prova");
insert into Dipendente values("0000000001","6279886fde090b3038f267098bcca771a6efa946","1234567890123456","Tizio","Brutto","1234567890","a@b.it","Capo dei Capi",1);
insert into Magazzino values(1,"Via non lo devi sapere 55",3);
insert into Scaffale values(1,"Prova","Su questo scaffale troveremo oggetti che vengono usati nell'ambito dell'informatica",5,50,1),
                           (2,"Plastica","Su questo scaffale saranno presenti tutti gli oggetti in plastica",0,100,1);
insert into ClienteFornitore values("AAAAAAAAAAAAAAAA","Gino","Pasticcio","3248545998","gino@gmail.com"),
                                   ("BBBBBBBBBBBBBBBB","Luko","ConLaK","3297845698","luko@gmail.com");
insert into Documento values("DA01","Documento d'acquisto","2023-02-11","Acquisto relativo al toner","AAAAAAAAAAAAAAAA","0000000001"),
                            ("DDT01","Documento di trasporto","2023-02-11","Documento che fa riferimento al trasporto di nuove apparecchiature","BBBBBBBBBBBBBBBB","0000000001");
insert into Prodotto values("PR000001","Porta Penne","portapenne in plastica",4,1,"nessuna");
insert into Prodotto values("PR000001","Porta Penne","portapenne in plastica",4,1,"nessuna");