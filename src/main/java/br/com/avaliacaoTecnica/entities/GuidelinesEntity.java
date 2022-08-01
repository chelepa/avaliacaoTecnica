package br.com.avaliacaoTecnica.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_guidelines")
public class GuidelinesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "date_creation")
    private LocalDateTime creationDate;

    @Column(name = "date_expiration")
    private LocalDateTime expirationDate;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "amount_vote_yes")
    private Integer amount_vote_yes;

    @Column(name = "amount_vote_not")
    private Integer amount_vote_not;

    @OneToMany(mappedBy = "idGuidelines", fetch=FetchType.EAGER)
    private List<VoteEntity> vote;


}
