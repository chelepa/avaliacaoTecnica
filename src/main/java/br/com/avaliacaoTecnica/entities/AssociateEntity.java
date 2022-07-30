package br.com.avaliacaoTecnica.entities;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_associate")
public class AssociateEntity implements Serializable {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name")
    private String name;
}
