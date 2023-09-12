CREATE TABLE cliente (
	id bigint not null primary key auto_increment,
	nome VARCHAR(200),
	endereco VARCHAR(2000),
	email VARCHAR(2000),
	dt_nascimento DATE,
	cpf VARCHAR(20)
)