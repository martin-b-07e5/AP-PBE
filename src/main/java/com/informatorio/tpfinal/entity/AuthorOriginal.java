package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "authors")
public class AuthorOriginal {

    // https://www.baeldung.com/hibernate-one-to-many
    @OneToMany(mappedBy = "author")
    Set<Persona> personas;

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    @Column(name = "id_author")
    private Long idAuthor;

    @NotBlank(message = "firstName is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    @PastOrPresent
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();


    // constructors
    public AuthorOriginal() {
    }

    public AuthorOriginal(Long idAuthor, String firstName, String lastName, String fullName, LocalDate createdAt) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    // getter and setter
    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName(firstName, lastName);  // without this doesn't work.
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
