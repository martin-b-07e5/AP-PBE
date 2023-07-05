package com.ap.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Education")
public class Education {

    // https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "educationSet")
    Set<Person> personSet;
    // -------------------------------------------------------

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_education")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 60)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 1, max = 160)
    private String description;

    // asked for --------------------------------------------------
    @PastOrPresent
    @Column(name = "started_at")
    private LocalDate startedAt;

    @PastOrPresent
    @Column(name = "finished_at")
    // private LocalDate finishedAt = LocalDate.now();
    private LocalDate finishedAt;
    // --------------------------------------------------

    // https://www.baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    //     constructors
    public Education() {
    }

    public Education(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Education(String name, String description, LocalDate startedAt, LocalDate finishedAt) {
        this.name = name;
        this.description = description;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
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

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
