package com.ap.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
//@Table(name = "Experience")
public class Experience {

    // https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "technologySet")
    Set<Person> personSet;
    // ------------------------------------------------------------

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_experience")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 1, max = 50)
    private String description;

    // https://www.baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();


    //     constructors
    public Experience() {
    }

    public Experience(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Experience(Long id, String name, String description, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }


    //     getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
