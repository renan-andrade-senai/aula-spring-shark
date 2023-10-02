CREATE TABLE departamento (
	id int primary key auto_increment,
	nome VARCHAR(1000)
);

CREATE TABLE medico (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	crm VARCHAR(50),
	cpf VARCHAR(20),
	departamento_id int,
	foreign key (departamento_id) references departamento(id)
);