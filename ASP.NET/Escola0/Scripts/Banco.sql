
CREATE TABLE ASP_Disciplina (
	dis_cod varchar(6) PRIMARY KEY,
	dis_ementa varchar(400) not null,
	dis_nome varchar(200) not null
)

CREATE TABLE ASP_Usuario (
	usu_cod varchar(12) PRIMARY KEY,
	usu_end varchar(400) not null,
	usu_tel varchar(10),
	usu_email varchar (200) not null,
	usu_login varchar(12) not null,
	usu_senha varchar(8) not null,
	usu_tipo int not null
)

CREATE TABLE ASP_Aluno (
	al_cod varchar(12) PRIMARY KEY,
	al_ano_ingresso varchar(4) not null,
	al_nome varchar(400) not null,
	usu_cod varchar(12) not null,
	FOREIGN KEY(usu_cod) REFERENCES ASP_Usuario (usu_cod)
)

CREATE TABLE ASP_Professor (
	prof_cod varchar(12) PRIMARY KEY,
	prof_nome varchar(400) not null,
	prof_formacao varchar(100) not null,
	usu_cod varchar(12)not null,
	FOREIGN KEY(usu_cod) REFERENCES ASP_Usuario (usu_cod)
)

CREATE TABLE ASP_Adm (
	adm_cod varchar(12) PRIMARY KEY,
	adm_nome varchar(400),
	usu_cod varchar(12),
	FOREIGN KEY(usu_cod) REFERENCES ASP_Usuario (usu_cod)
)

CREATE TABLE ASP_AlunoCurso (
	cur_cod int,
	al_cod varchar(12),
	FOREIGN KEY(cur_cod) REFERENCES ASP_Curso (cur_cod),
	FOREIGN KEY(al_cod) REFERENCES ASP_Aluno (al_cod)
)

CREATE TABLE ASP_Curso (
	cur_cod int PRIMARY KEY,
	cur_nome varchar(200),
	cur_periodo int,
	cur_ano varchar(4)
)

CREATE TABLE ASP_CursoDisciplina (
	cur_cod int,
	dis_cod varchar(6),
	FOREIGN KEY(cur_cod) REFERENCES ASP_Curso (cur_cod),
	FOREIGN KEY(dis_cod) REFERENCES ASP_Disciplina (dis_cod)
)

CREATE TABLE ASP_Leciona (
	lec_periodo int,
	lec_semestre int,
	lec_ano varchar(4),
	lec_cod varchar(12) PRIMARY KEY,
	prof_cod varchar(12),
	dis_cod varchar(6),
	FOREIGN KEY(prof_cod) REFERENCES ASP_Professor (prof_cod),
	FOREIGN KEY(dis_cod) REFERENCES ASP_Disciplina (dis_cod)
)

CREATE TABLE ASP_Historico (
	his_nota int,
	his_frequencia int,
	his_aprovado int,
	lec_cod varchar(12),
	dis_cod varchar(6),
	al_cod varchar(12),
	FOREIGN KEY(dis_cod) REFERENCES ASP_Disciplina (dis_cod),
	FOREIGN KEY(al_cod) REFERENCES ASP_Aluno (al_cod),
)
