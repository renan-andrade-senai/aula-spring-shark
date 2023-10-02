CREATE TABLE quarto (
	id int primary key auto_increment,
	numero int,
	andar int
);

CREATE TABLE paciente (
	id int primary key auto_increment,
	nome VARCHAR(1000),
	cpf VARCHAR(20),
	quarto_id int,
	foreign key (quarto_id) references quarto(id)
)