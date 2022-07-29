package br.com.avaliacaoTecnica.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Associate")
public class AssociateEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_Associate")
    private Integer id;

    @Column(name = "Cpf_Associate")
    private Integer cpf;

    @Column(name = "Nm_Associate")
    private String name;
}
