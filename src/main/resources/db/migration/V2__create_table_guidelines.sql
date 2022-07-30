CREATE TABLE IF NOT EXISTS tb_guidelines (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(100) NOT NULL,
  status VARCHAR(45) NOT NULL,
  date_creation DATETIME NOT NULL,
  date_expiration DATETIME NOT NULL,
  approved TINYINT NULL,
  amount_vote_yes INT NULL,
  amount_vote_not INT NULL,
  PRIMARY KEY (id)
);