CREATE TABLE pessoafisica (
    id int, 
    cpf bigint not null, 
    nascto date, 
    constraint pk_pessoafisica primary key(id))

alter table pessoafisica add constraint fk_pessoafisica_pessoas foreign key (id) references pessoas (id);

CREATE TABLE pessoajuridica (
    id int,  
    cnpj bigint not null,
    nome_fantasica varchar(255), 
    constraint pk_pessoajuridica primary key(id),
    foreign key (id) references pessoas (id)
    )
    
SELECT * from pessoas;
SELECT * from pessoafisica;
SELECT * from pessoajuridica;

/*Limpando a tabela (Utilizado durante o teste do código)*/
TRUNCATE pessoas RESTART IDENTITY CASCADE;


/*Criando tabelas ContaComum, ContaEspecial, ContaPoupanca, Movimento*/
