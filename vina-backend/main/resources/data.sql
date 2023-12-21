INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');


  
INSERT INTO tip (id,ime)VALUES (1,'Suvo belo');
INSERT INTO tip (id,ime)VALUES (2,'Sardone');
INSERT INTO tip (id,ime)VALUES (3,'Vocno vino');

INSERT INTO vinarija(id,ime,godina_osnivanja) VALUES (3,'Ivanovic',2000);
INSERT INTO vinarija(id,ime,godina_osnivanja) VALUES (2,'Sibinovici',2009);
INSERT INTO vinarija(id,ime,godina_osnivanja) VALUES (1,'Bonko Zvogdan',2010);

INSERT INTO vino(id,ime,opis,godina_proizvodnje,cena_flase,broj_dostupnih_flasa,tip_id,vinarija_id) VALUES (1,'Jacobs Creek','Skupo vino iz Australije',1999,3000,400,1,2);
INSERT INTO vino(id,ime,opis,godina_proizvodnje,cena_flase,broj_dostupnih_flasa,tip_id,vinarija_id) VALUES (2,'Bantaski rizling','Jeftino vino iz Vojvodine',2019,300,4000,1,1);
INSERT INTO vino(id,ime,opis,godina_proizvodnje,cena_flase,broj_dostupnih_flasa,tip_id,vinarija_id) VALUES (3,'Medvedja krv','Mega sirotinja',2022,250,6000,2,3);
INSERT INTO vino(id,ime,opis,godina_proizvodnje,cena_flase,broj_dostupnih_flasa,tip_id,vinarija_id) VALUES (4,'Vranac','Isto',2022,250,400,3,1);