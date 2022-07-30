package br.com.avaliacaoTecnica.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_guidelines")
public class GuidelinesEntity implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "date_creation")
    private LocalDate date_creation;

    @Column(name = "date_expiration")
    private LocalDate date_expiration;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "amount_vote_yes")
    private Integer amount_vote_yes;

    @Column(name = "amount_vote_not")
    private Integer amount_vote_not;
}
