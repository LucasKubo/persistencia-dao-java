/*Criando relações que representam Objetos pessoas*/
CREATE TABLE pessoas (
    id serial,
    nome varchar(255) not null,
    endereco varchar(255),
    cep bigint,
    telefone varchar(19),
    renda float,
    situacao smallint,
    constraint pk_pessoas primary key(id)
)

CREATE TABLE pessoasfisicas (
    id int, 
    cpf bigint not null, 
    nascto date, 
    constraint pk_pessoasfisicas primary key(id)
)

ALTER TABLE pessoasfisicas add constraint fk_pessoasfisicas_pessoas foreign key (id) references pessoas (id);

CREATE TABLE pessoasjuridicas (
    id int,  
    cnpj bigint not null,
    nome_fantasica varchar(255), 
    constraint pk_pessoasjuridicas primary key(id),
    constraint fk_pessoasjuridicas_pessoas foreign key (id) references pessoas (id)
)
    
SELECT * from pessoas;
SELECT * from pessoasfisicas;
SELECT * from pessoasjuridicas;

/*Limpando a tabela (Utilizado durante o teste do código)*/
/*TRUNCATE pessoas RESTART IDENTITY CASCADE;*/

/*Criando tabelas ContaComum, ContaEspecial, ContaPoupanca, Movimento*/
create table contascomuns(
	numero bigint,
	abertura timestamp not null,
	fechamento timestamp,
	situacao smallint,
	senha int,
	saldo double precision,
	constraint pk_contascomuns primary key(numero)
);

create table pessoas_contascomuns (
	idpessoa int,
	idcontacomum bigint,
	constraint pk_pessoas_contascomuns primary key(idpessoa, idcontacomum)
);

alter table pessoas_contascomuns add constraint fk_pessoas_contascomuns_pessoas foreign key (idpessoa) references pessoas(id);

alter table pessoas_contascomuns add constraint fk_pessoas_contascomuns_contascomuns foreign key (idcontacomum) references contascomuns(numero);