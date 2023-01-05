package com.ap.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {

    // ------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @OneToMany(mappedBy = "project")
    Set<Person> personSet;
    // ------------------------------------------------------------

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_project")
    private Long idProject;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 50)
    private String description;

    // https://www.baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();


    //     constructors
    public Project() {
    }

    public Project(Long idProject, String name, String description, LocalDate createdAt) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }


    //     getters and setters
    public Long getIdProject() {
        return idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        setDescription(this.name);  // necessary
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name.toLowerCase().replace(" ", "-");
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
