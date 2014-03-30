CREATE TABLE Asp_Adm (
adm_cod varchar(12) PRIMARY KEY,
adm_nome varchar(400),
usu_cod varchar(12)
)

CREATE TABLE Asp_Usuario (
usu_cod varchar(12) PRIMARY KEY,
usu_end varchar(400),
usu_tel varchar(10),
usu_email varchar(200),
usu_login varchar(12),
usu_senha varchar(8),
usu_tipo int
)

CREATE TABLE Asp_Professor (
prof_cod varchar(12) PRIMARY KEY,
prof_nome varchar(400),
prof_formacao varchar(100),
usu_cod varchar(12),
FOREIGN KEY(usu_cod) REFERENCES Asp_Usuario (usu_cod)
)

CREATE TABLE Asp_Aluno (
al_cod varchar(12) PRIMARY KEY,
al_ano_ingresso varchar(4),
al_nome varchar(400),
usu_cod varchar(12),
cur_cod int,
FOREIGN KEY(usu_cod) REFERENCES Asp_Usuario (usu_cod)
)

CREATE TABLE Asp_Curso (
cur_cod int PRIMARY KEY,
cur_nome varchar(200),
cur_periodo int
)

CREATE TABLE Asp_Disciplina (
dis_cod varchar(6) PRIMARY KEY,
dis_nome varchar(200),
dis_ementa varchar(400)
)

CREATE TABLE Asp_Leciona (
lec_cod int PRIMARY KEY,
lec_periodo int,
lec_semestre int,
lec_ano varchar(4),
dis_cod varchar(6),
prof_cod varchar(12),
FOREIGN KEY(dis_cod) REFERENCES Asp_Disciplina (dis_cod),
FOREIGN KEY(prof_cod) REFERENCES Asp_Professor (prof_cod)
)

CREATE TABLE Asp_Historico (
his_cod int PRIMARY KEY,
his_frequencia float,
his_nota float,
his_aprovado bit
)

CREATE TABLE Asp_Catalogo (
cur_ano varchar(4),
dis_cod varchar(6),
cur_cod int,
FOREIGN KEY(dis_cod) REFERENCES Asp_Disciplina (dis_cod),
FOREIGN KEY(cur_cod) REFERENCES Asp_Curso (cur_cod)
)

CREATE TABLE Asp_Matricula (
mat_cod int,
al_cod varchar(12),
lec_cod int,
his_cod int,
PRIMARY KEY(mat_cod,al_cod,lec_cod,his_cod)
)

ALTER TABLE Asp_Adm ADD FOREIGN KEY(usu_cod) REFERENCES Asp_Usuario (usu_cod)
ALTER TABLE Asp_Aluno ADD FOREIGN KEY(cur_cod) REFERENCES Asp_Curso (cur_cod)
