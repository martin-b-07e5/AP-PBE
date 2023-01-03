package com.informatorio.tpfinal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "personas")  // table name
@Getter
@Setter
public class Persona {

    // ------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.
     */
    @ManyToMany
    @JoinTable(
            name = "persona_education",
            joinColumns = @JoinColumn(name = "id_persona"),
            inverseJoinColumns = @JoinColumn(name = "id_education")
    )
    Set<Education> education;

    // https://www.baeldung.com/hibernate-one-to-many
    @ManyToOne
    @JoinColumn(name = "id_author")
    Author author;
    // ------------------------------------------------------------

    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_persona") // DB column name
    private Long idPersona;

    @NotEmpty(message = "fn is mandatory")
    @Column(name = "first_name") // DB column name
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank(message = "ln is mandatory")
    @Column(name = "last_name")
    @Size(min = 1, max = 50)
    private String lastName;

    @NotEmpty
    @Size(min = 1, max = 100, message = "First name is mandatory")
    private String email;

//    private String content;
//    private String url;

//    @Column(name = "url_to_image") // DB column name
//    private String urlToImage;

    // baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "published_at") // DB column name
    private LocalDate publishedAt = LocalDate.now();

    // constructors
    public Persona() {
    }

    public Persona(String firstName, String lastName, String email, LocalDate publishedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.publishedAt = publishedAt;
    }

    // getters and setters
    /*public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDate getPublishedAt() {
//        return publishedAt;
//    }

    public Author getAuthor() {
        return author;
    }

    public Set<Education> getSourceSet() {
        return educationSet;
    }*/

}
