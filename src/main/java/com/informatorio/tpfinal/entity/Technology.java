package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Technology")
public class Technology {

    // ------------------------------------------------------------
    // https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "technologySet")
    Set<Person> personSet;
    // ------------------------------------------------------------

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_technology")
    private Long idTechnology;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 50)
    private String description;

    private int percentage;

    // https://www.baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();


    //     constructors
    public Technology() {
    }

    public Technology(Long idTechnology, String name, String description, LocalDate createdAt) {
        this.idTechnology = idTechnology;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }


    //     getters and setters
    public Long getIdTechnology() {
        return idTechnology;
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
