INSERT INTO tb_papel (nome, descricao) VALUES
   ('ADIMINISTRATOR', 'Papel com permissões de administrador'),
   ('DEV', 'Papel com permissões de development'),
   ('USER', 'Papel padrão para usuários');
INSERT INTO tb_usuario (nome, email, senha, ativo)
VALUES
('João', 'joao@teste.com', 'senha123', true),
('Maria', 'maria@teste.com', 'senha456', true),
('Pedro', 'pedro@teste.com', 'senha789', false);

INSERT INTO usuario_papel (usuario_id, papel_id)
VALUES
(1, 1),(2, 2),(3, 3);

INSERT INTO tb_recurso (nome, url) VALUES
('Página Inicial', '/'),
('Perfil do Usuário', '/perfil'),
('Configurações de Conta', '/conta/configuracoes');

--INSERT INTO condicao (campo, operador, valor) VALUES ('funcao', '=', 'administrador');
--INSERT INTO condicao (campo, operador, valor) VALUES ('nome', 'LIKE', 'J%');
--INSERT INTO condicao (campo, operador, valor) VALUES ('idade', '>', '18');
--INSERT INTO condicao (campo, operador, valor) VALUES ('funcao', '!=', 'convidado');
--INSERT INTO condicao (campo, operador, valor) VALUES ('departamento', 'IN', ('TI', 'RH'));
--INSERT INTO condicao (campo, operador, valor) VALUES ('papel', 'IN', ('editor', 'revisor'));
--INSERT INTO condicao (campo, operador, valor) VALUES ('data_cadastro', '<', '2022-01-01');
--INSERT INTO condicao (campo, operador, valor) VALUES ('funcao', '=', 'gerente');
--INSERT INTO condicao (campo, operador, valor) VALUES ('cargo', 'LIKE', '%senior%');
--INSERT INTO condicao (campo, operador, valor) VALUES ('acesso', '=', 'true');

--INSERT INTO tb_politica (nome, descricao, papel_id, permissao_id, condicoes)
--VALUES ('Política de Leitura', 'Permite apenas a leitura de informações do sistema', 1, 1, NULL);
--
--INSERT INTO tb_politica (nome, descricao, papel_id, permissao_id, condicoes)
--VALUES ('Política de Escrita', 'Permite a escrita de informações do sistema apenas para usuários administradores', 2, 2, 'isAdmin=1');
--
--INSERT INTO tb_politica (nome, descricao, papel_id, permissao_id, condicoes)
--VALUES ('Política de Execução', 'Permite a execução de comandos específicos do sistema apenas para usuários autorizados', 3, 3, 'isAuthorized=1');

