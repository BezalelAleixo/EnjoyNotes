CREATE SCHEMA PROJETO;
USE PROJETO;

DROP TABLE USUARIO;
DROP TABLE NOTA;
DROP TABLE LISTA;
DROP TABLE QUADROS;
DROP TABLE CARTOES;
DROP TABLE CONTA;
DROP TABLE SESSAO;
DROP TABLE VIDEOS;

CREATE TABLE USUARIO(
	id_usuario INT  PRIMARY KEY AUTO_INCREMENT,
    nome_pessoal VARCHAR(100) NOT NULL,
    sexo VARCHAR (9) NOT NULL,
    data_nasc VARCHAR(30) NOT NULL,
    id_conta_CE INT,
    CONSTRAINT fk_conta FOREIGN KEY (id_conta_CE) REFERENCES CONTA (id_conta)
);

CREATE TABLE CONTA(
	id_conta INT PRIMARY KEY AUTO_INCREMENT,
    nome_perfil VARCHAR(100) NOT NULL,
    senha CHAR(8) NOT NULL,
    foto VARCHAR(200) NOT NULL
);
SELECT N.* FROM NOTA as N INNER JOIN CONTA as C ON N.id_conta = C.id_conta WHERE C.nome_perfil = '@beza';
DELETE FROM USUARIO;
DELETE U.id_usuario,U.nome_pessoal,U.sexo,U.data_nasc,U.id_conta_CE,C.id_conta,C.nome_perfil,C.senha,C.foto,C.id_nota, C.id_lista,C.id_quadro from usuario as U inner join conta as C on U.id_conta_CE = C.id_conta where U.id_usuario = 1;
select * from conta where nome_perfil = '@beza';

insert into USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) values ('bezalel', 'masculino', '2006/07/28', 1);
insert into CONTA (nome_perfil, senha, foto) values ('@beza', 'onepiece', 'D:\\projetoENjoyNotes\\teste1.png');
insert into CONTA (nome_perfil, senha, foto) values ('Gabriela', 'ana', 'D:\\projetoENjoyNotes\\logo01.png');
insert into USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) values ('Maria', 'feminino', '2004/02/12',2);
insert into CONTA (nome_perfil, senha, foto) values ('Sheila', 'aaaa', 'D:\\projetoENjoyNotes\\teste2.png');
insert into USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) values ('Sheila Cordeiro', 'feminino', '2002/05/06',3);

insert into USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) values ('Bruno Cordeiro', 'masculino', '2004/08/13',4);
insert into USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) values ('Lene Aleixo', 'feminino', '2000/03/18',5);

select conta.nome_perfil, usuario.sexo from conta inner join usuario where id_conta_CE = id_conta;
select * from usuario where id_conta_CE = 1;
CREATE TABLE NOTA(
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR (100) NOT NULL,
    conteudo TEXT NOT NULL,
    data_criac DATE NOT NULL,
    cor VARCHAR (200) NOT NULL,
    foto VARCHAR(200)
);
ALTER TABLE NOTA ADD COLUMN id_conta INT;

-- Defina a chave estrangeira (FOREIGN KEY) na coluna id_conta
ALTER TABLE NOTA ADD CONSTRAINT fk_conta_nota FOREIGN KEY (id_conta) REFERENCES CONTA(id_conta);

ALTER TABLE NOTA DROP FOREIGN KEY fk_conta_nota;
ALTER TABLE NOTA DROP COLUMN id_conta;
DELETE FROM NOTA WHERE id = 1;
insert into LISTA_DE_CARTOES (titulo_list,ordem_list,data_criac, id_conta) values 
('bezalel', 'masculino', '2006/07/28',1),
('sheila', 'feminino', '2002/05/06',1),
('lene', 'feminino', '2000/03/18',1),
('filipinho', 'masculino', '1998/04/20',1),
('bruno', 'masculino', '2004/08/13',1),
('raquel', 'feminino', '1996/07/01',1),
('arlene', 'feminino', '1972/01/28',1);
#('felipe', 'masculino', '1957/06/08',1),
#('izaque', 'masculino', '1995/11/21',1),
#('alexandro', 'masculino', '1997/10/17',1);

delete from LISTA where titulo_list = 'izaque';
insert into CONTA (nome_perfil, senha, foto, id_nota) values ('@beza', 'onepiece', 'D:\\projetoENjoyNotes\\teste1.png', 1);
update conta set id_nota = 1 where id_conta = 1;
SELECT N.id, N.titulo, N.conteudo, N.data_criac FROM NOTA as N INNER JOIN CONTA as C WHERE C.nome_perfil = '@beza';
insert into nota (titulo, conteudo, data_criac, id_conta, cor) values ('aula', 'no no no', now(),1, '0x2a4674');
INSERT INTO NOTA (titulo, conteudo, data_criac, id_conta) VALUES ('Nova Nota', 'Conteúdo da nova nota', NOW(), 1);

ALTER TABLE LISTA ADD COLUMN id_conta INT;

-- Defina a chave estrangeira (FOREIGN KEY) na coluna id_conta
ALTER TABLE LISTA ADD CONSTRAINT fk_conta_LISTA FOREIGN KEY (id_conta) REFERENCES CONTA(id_conta);

ALTER TABLE LISTA DROP FOREIGN KEY fk_conta_LISTA;
ALTER TABLE LISTA DROP COLUMN id_conta;

SELECT L.id, L.titulo_list, L.ordem_list, L.data_criac FROM LISTA as L INNER JOIN CONTA as C WHERE C.nome_perfil = '@beza';
CREATE TABLE QUADROS(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome_quad VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_criac DATE NOT NULL,
    id_conta INT,
    CONSTRAINT fk_conta_quadro FOREIGN KEY (id_conta) REFERENCES CONTA (id_conta)
);
insert into quadros (nome_quad, descricao, data_criac, id_conta)values ('beza', 'tipo assim', now(), 1);
CREATE TABLE LISTA_DE_CARTOES(
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo_list VARCHAR(100) NOT NULL,
    data_criac DATE NOT NULL,
    id_quadro INT,
    CONSTRAINT fk_quadro FOREIGN KEY (id_quadro) REFERENCES QUADROS (id)
);
select L.* from Lista_DE_CARTOES as L inner join QUADROS as Q on L.id = Q.id  order by id desc;
CREATE TABLE CARTOES(
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo_cart VARCHAR(100) NOT NULL,
    descricao_cart TEXT,
    data_criac DATE NOT NULL,
    id_list_cartao INT,
    CONSTRAINT fk_list_cartao FOREIGN KEY (id_list_cartao) REFERENCES LISTA_DE_CARTOES (id)
);
CREATE TABLE VIDEOS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_video TEXT NOT NULL,
    caminho_video VARCHAR(250) NOT NULL,
    id_conta INT,
    CONSTRAINT fk_conta_video FOREIGN KEY (id_conta) REFERENCES CONTA (id_conta)
);
SELECT l.* FROM LISTA_DE_CARTOES as l inner join Quadros as q on l.id=q.id WHERE l.id < 2 ORDER BY l.id DESC LIMIT 1;
SELECT l.* FROM LISTA_DE_CARTOES as l inner join Quadros as q on l.id=q.id WHERE l.id > 1 ORDER BY l.id ASC LIMIT 1;
insert into CArtoes (titulo_cart, descricao_cart, data_criac, id_list_cartao) values ('oi', 'nossa', now(), 1);
SELECT * FROM LISTA WHERE TITULO LIKE 'A%';
SELECT * FROM NOTA WHERE TITULO LIKE 'O%';

TRUNCATE NOTA;
TRUNCATE LISTA;
TRUNCATE USUARIO;
DELETE FROM NOTA WHERE id = 1;
CREATE DATABASE TESTE;
USE TESTE;
CREATE TABLE LIVROS(
	id int(10) unsigned not null primary key auto_increment,
    titulo varchar(45) not null,
    autor varchar(45) not null,
    preco double not null
);
DROP TABLE SESSAO;
CREATE TABLE SESSAO(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    acesso VARCHAR(2) NOT NULL,
    id_conta_acesso INT,
    CONSTRAINT fk_conta_acesso FOREIGN KEY (id_conta_acesso) REFERENCES CONTA (id_conta)
);

insert into SESSAO (acesso, id_conta_acesso) values ('L', 1);
insert into SESSAO (acesso, id_conta_acesso) values ('L', 2);
insert into SESSAO (acesso, id_conta_acesso) values ('L', 3);



SELECT S.id, S.acesso, S.id_conta_acesso, C.id_conta ,C.nome_perfil, C.foto FROM SESSAO as S INNER JOIN CONTA as C ON S.id_conta_acesso = C.id_conta WHERE acesso = 'L';
insert into LIVROS (titulo, autor, preco) values('oi maicon', 'bezalel', 1200);

select nota.titulo as NT, lista.titulo as LT
from nota, lista;

select * from lista where titulo = 'one';
select * from nota where titulo like 'A%';
select * from lista where titulo like 'one%';