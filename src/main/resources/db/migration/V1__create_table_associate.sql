CREATE TABLE IF NOT EXISTS Associate (
  id_Associate INT NOT NULL AUTO_INCREMENT,
  Cpf_Associate INT NOT NULL,
  Nm_Associate VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_Associate, Cpf_Associate)
)