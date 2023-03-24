CREATE TABLE IF NOT EXISTS `tb_hierarquia_role` (
  `role_hierarchy_id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `role_hierarchy_pai_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`role_hierarchy_id`),
  INDEX `FKnco75v9ojcife419ejnknw2j4` (`role_hierarchy_pai_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`tb_papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_papel` (
  `papel_id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `papel_pai_id` BIGINT NULL DEFAULT NULL,
  `role_hierarchy_id` BIGINT NOT NULL,
  PRIMARY KEY (`papel_id`, `role_hierarchy_id`),
  INDEX `FK1hjf8iexo0wblxnj08llucsa1` (`papel_pai_id` ASC) VISIBLE,
  INDEX `fk_tb_papel_tb_hierarquia_role1_idx` (`role_hierarchy_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`tb_recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_recurso` (
  `recurso_id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `url` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`recurso_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`tb_permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_permissao` (
  `permissao_id` BIGINT NOT NULL AUTO_INCREMENT,
  `campo` VARCHAR(255) NULL DEFAULT NULL,
  `operador` VARCHAR(255) NULL DEFAULT NULL,
  `valor` VARCHAR(255) NULL DEFAULT NULL,
  `tipo` VARCHAR(255) NULL DEFAULT NULL,
  `recurso_id` BIGINT NOT NULL,
  PRIMARY KEY (`permissao_id`, `recurso_id`),
  INDEX `fk_tb_permissao_tb_recurso1_idx` (`recurso_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`papel_permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `papel_permissao` (
  `papel_id` BIGINT NOT NULL,
  `permissao_id` BIGINT NOT NULL,
  PRIMARY KEY (`papel_id`, `permissao_id`),
  INDEX `fk_papel_permissao_tb_permissao1_idx` (`permissao_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`tb_politica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_politica` (
  `politica_id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `permissao_id` BIGINT NOT NULL,
  `papel_id` BIGINT NOT NULL,
  PRIMARY KEY (`politica_id`, `permissao_id`, `papel_id`),
  INDEX `fk_tb_politica_tb_permissao1_idx` (`permissao_id` ASC) VISIBLE,
  INDEX `fk_tb_politica_tb_papel1_idx` (`papel_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `usuario_id` BIGINT NOT NULL AUTO_INCREMENT,
  `ativo` BIT(1) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`usuario_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `controle_acesso`.`usuario_papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario_papel` (
  `usuario_id` BIGINT NOT NULL,
  `papel_id` BIGINT NOT NULL,
  PRIMARY KEY (`usuario_id`, `papel_id`),
  INDEX `fk_usuario_papel_tb_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_usuario_papel_tb_papel1_idx` (`papel_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;