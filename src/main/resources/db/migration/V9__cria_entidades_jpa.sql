CREATE TABLE motorista (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	cnh VARCHAR(50),
	dt_nascimento DATE
);

CREATE TABLE veiculo (
	id int primary key auto_increment,
	marca VARCHAR(100),
	modelo VARCHAR(100),
	ano int,
	cor VARCHAR(50),
	motorista_id int,
	foreign key (motorista_id) references motorista(id)
);

CREATE TABLE vendedor (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	cpf VARCHAR(20),
	nome_loja VARCHAR(1000)
);

CREATE TABLE pedido (
	id int primary key auto_increment,
	valor REAL,
	dt_emissao DATE,
	qt_itens INT,
	vendedor_id int,
	foreign key (vendedor_id) references vendedor(id)
);