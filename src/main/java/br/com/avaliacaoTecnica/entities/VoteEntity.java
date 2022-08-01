package br.com.avaliacaoTecnica.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_voting")
public class VoteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    private AssociateEntity cpfAssociate;

    @ManyToOne
    private GuidelinesEntity idGuidelines;

    @Column(name = "vote")
    private String vote;
}
