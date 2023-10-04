CREATE TABLE empregado (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	cpf VARCHAR(20),
	cargo VARCHAR(100),
	salario REAL
);

CREATE TABLE dependente (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	cpf VARCHAR(20),
	empregado_id int,
	foreign key (empregado_id) references empregado(id)
);
