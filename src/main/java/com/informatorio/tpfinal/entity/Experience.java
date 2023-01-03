package com.informatorio.tpfinal.entity;

import lombok.AccessLevel;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Table(name = "Experience")
public class Experience {

    // ------------------------------------------------------------
    // https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "experienceSet")
    Set<Person> personSet;
    // ------------------------------------------------------------

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    @Column(name = "id_experience")
    private Long idExperience;

    @NotEmpty(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 1, max = 150)
    private String description;

    @Getter(AccessLevel.NONE)
    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();


    // constructors
    public Experience() {
    }

    public Experience(Long idExperience, String name, String description, LocalDate createdAt) {
        this.idExperience = idExperience;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }


    // getter and setter
    public Long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Long idExperience) {
        this.idExperience = idExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
