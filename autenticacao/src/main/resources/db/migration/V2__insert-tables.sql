INSERT INTO `tb_hierarquia_role`(`descricao`,`nome`,`role_hierarchy_pai_id`) VALUES
('Responsável pela gestão geral da empresa','Gerente Geral',null);
INSERT INTO `tb_hierarquia_role`(`nome`, `descricao`,`role_hierarchy_pai_id`) VALUES
('Gerente de Vendas', 'Responsável pela gestão da equipe de vendas', 1),
('Gerente de Produtos', 'Responsável pela gestão da equipe de produtos', 1),
('Gerente de TI', 'Responsável pela gestão da equipe da tecnologia da informação', 1);
INSERT INTO `tb_hierarquia_role`(`nome`,`descricao`,`role_hierarchy_pai_id`) VALUES
('Encarregado de Vendas', 'Responsável pela equipe de vendas e seu funcionamento', 2);
INSERT INTO `tb_papel`(`nome`,`descricao`,`role_hierarchy_id`) VALUES
('ADIMINISTRATOR', 'Papel com permissões de administrador',1);
INSERT INTO `tb_papel`(`nome`,`descricao`,`papel_pai_id`,`role_hierarchy_id`) VALUES
('DEV', 'Papel com permissões de development',1,1),
('USER', 'Papel padrão para usuários',1,1);
INSERT INTO `tb_papel`(`nome`,`descricao`,`role_hierarchy_id`) VALUES
('GERENTE_TI', 'Papel com permissões de administradorde TI',4);
INSERT INTO `tb_papel`(`nome`,`descricao`,`papel_pai_id`,`role_hierarchy_id`) VALUES
('DEV_TI', 'Papel com permissões de developmentde TI',4,4),
('USER_TI', 'Papel padrão para usuários de TI',4,4);
INSERT INTO `tb_recurso`(`nome`,`url`)VALUES
('Página Inicial', '/'),
('Perfil do Usuário', '/perfil'),
('Configurações de Conta', '/conta/configuracoes');
INSERT INTO `tb_permissao`(`campo`,`operador`,`valor`,`tipo`,`recurso_id`)VALUES
('papel_usuario', '=', 'DEV', ' ESCRITA', 1),
('usuario_id', '=', '2', 'ESCRITA', 1),
('departamento_id', '=', '1', 'LEITURA', 2),
('departamento_id', '=', '2', 'ESCRITA', 2);
INSERT INTO `papel_permissao`(`papel_id`,`permissao_id`)VALUES
(1,3), (1,4), (3,2);
INSERT INTO `tb_politica`(`descricao`,`nome`,`permissao_id`,`papel_id`)VALUES
('Permite todas as operações no sistema', 'Politica de Administrador', 1, 1),
('Permite operações limitadas no sistema', 'Politica de Gerente', 2, 2 );
INSERT INTO `tb_usuario`(`nome`,`email`,`senha`,`ativo`)VALUES
('João', 'joao@teste.com', 'senha123', true),
('Maria', 'maria@teste.com', 'senha456', true),
('Pedro', 'pedro@teste.com', 'senha789', false);
INSERT INTO `usuario_papel`(`usuario_id`,`papel_id`)VALUES
(1, 2),(2, 1),(3, 6);
