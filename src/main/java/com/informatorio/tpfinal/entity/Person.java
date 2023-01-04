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
@Table(name = "Person")  // table name
@Getter
@Setter
public class Person {

    // ------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.
     */
    @ManyToMany
    @JoinTable(
            name = "person_education",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_education")
    )
    Set<Education> educationSet;
    // ----------------------------------------
    @ManyToMany
    @JoinTable(
            name = "person_experience",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_experience")
    )
    Set<Experience> experienceSet;
    // ----------------------------------------
    @ManyToMany
    @JoinTable(
            name = "person_technology",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_technology")
    )
    Set<Technology> technologySet;
    // ------------------------------------------------------------

    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_person") // DB column name
    private Long idPerson;

    @NotEmpty(message = "fn is mandatory")
    @Column(name = "first_name") // DB column name
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank(message = "ln is mandatory")
    @Column(name = "last_name")
    @Size(min = 1, max = 50)
    private String lastName;

    @NotEmpty
    @Size(min = 1, max = 100, message = "Email is mandatory")
    private String email;

    // http://www.baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "published_at") // DB column name
    private LocalDate publishedAt = LocalDate.now();

    // constructors
    public Person() {
    }

    public Person(String firstName, String lastName, String email, LocalDate publishedAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.publishedAt = publishedAt;
    }

}
