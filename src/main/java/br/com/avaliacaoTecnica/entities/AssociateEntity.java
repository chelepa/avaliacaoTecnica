package br.com.avaliacaoTecnica.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tb_associate")
public class AssociateEntity implements Serializable {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cpfAssociate")
    private List<VoteEntity> vote;

}
