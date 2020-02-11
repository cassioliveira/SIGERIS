-- Cadastro de usuários
INSERT INTO grupo VALUES (1,'ADMINISTRADORES'),(2,'SECRETARIAS'),(3,'COORDENADORES'),(4,'BIBLIOTECA'),(5,'DIRECAO');
INSERT INTO usuario  VALUES (1,'Cássio','123','01404526480');
INSERT INTO usuario  VALUES (2,'Vania','123','31958889806');
INSERT INTO usuario  VALUES (3,'Ghost','123','11111111111');
INSERT INTO usuario  VALUES (4,'Dino','123','22222222222');
INSERT INTO usuario  VALUES (5,'Sauro','123','33333333333');
INSERT INTO usuario_grupo VALUES (1,1)
INSERT INTO usuario_grupo VALUES (2,5)
INSERT INTO usuario_grupo VALUES (3,5)
INSERT INTO usuario_grupo VALUES (4,4)
INSERT INTO usuario_grupo VALUES (5,1)
-- select setval('', 1);

-- Cadastro de setores
--INSERT INTO setor(id,nome,categoria) VALUES (1,'BIBLIOTECA','SERVIDORES');
--INSERT INTO setor(id,nome,categoria) VALUES (2,'CPD','SERVIDORES');
--INSERT INTO setor(id,nome,categoria) VALUES (3,'LIMPEZA','TERCEIRIZADOS');
--INSERT INTO setor(id,nome,categoria) VALUES (4,'ELETRICIDADE','TERCEIRIZADOS');
--INSERT INTO setor(id,nome,categoria) VALUES (5,'DIREÇÃO','SERVIDORES');

-- Cadastro de servidores
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (1,'Gilmara Meira','PROFESSOR','31958889806');
--INSERT INTO professor(id,dedicacao_exclusiva) VALUES (1,true);
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (2,'Martins Paulino','TECNICO','01404526480');
--INSERT INTO tecnico(id) VALUES (2);
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (3,'Joelda Vieira','TERCEIRIZADO','01404526480');
--INSERT INTO terceirizado(id) VALUES (3);
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (4,'Roger Ruanca','PROFESSOR','31958889806');
--INSERT INTO professor(id,dedicacao_exclusiva) VALUES (4,false);
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (5,'Alana Campos','TECNICO','01404526480');
--INSERT INTO tecnico(id) VALUES (5);
--INSERT INTO pessoa(id,nome,categoria,usuario) VALUES (6,'Gabriel Lima','TERCEIRIZADO','01404526480');
--INSERT INTO terceirizado(id) VALUES (6);