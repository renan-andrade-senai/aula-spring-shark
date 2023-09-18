CREATE TABLE contato (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	numero VARCHAR(30),
	tipo VARCHAR(10)
);

CREATE TABLE produto (
	id int primary key auto_increment,
	titulo VARCHAR(100),
	descricao VARCHAR(1000),
	preco REAL,
	prazo_entrega DATE
);

CREATE TABLE jogo (
	id int primary key auto_increment,
	titulo VARCHAR(100),
	descricao VARCHAR(1000),
	preco REAL,
	dt_lancamento DATE,
	nome_desenvolvedora VARCHAR(500),
	nome_publisher VARCHAR(500)
);