CREATE TABLE IF NOT EXISTS tb_voting (
  id INT NOT NULL AUTO_INCREMENT,
  cpf_associate_cpf CHAR(11) NULL DEFAULT NULL,
  id_guidelines_id INT NULL DEFAULT NULL,
  vote CHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX Idx_cpfAssociate(cpf_associate_cpf ASC) VISIBLE,
  INDEX Idx_idGuidelines(id_guidelines_id ASC) VISIBLE,
  CONSTRAINT fk_tb_vote_tb_associate FOREIGN KEY (cpf_associate_cpf) REFERENCES tb_associate(cpf),
  CONSTRAINT fk_tb_vote_tb_guidelines1 FOREIGN KEY (id_guidelines_id) REFERENCES tb_guidelines(id)
);