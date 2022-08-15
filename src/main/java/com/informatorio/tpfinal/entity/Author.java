package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")  // table name
public class Author {

    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @OneToMany(mappedBy = "author")
    Set<Article> articles;  // don't delete this line
    //    ----------------------------------------------------------------
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    @Column(name = "id_author") // DB column name
    private Long id_author;

    @NotBlank(message = "firstName is mandatory")
    @Column(name = "first_name") // DB column name
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @Column(name = "last_name") // DB column name
    private String lastName;

    @Column(name = "full_name") // DB column name
    private String fullName;

    @PastOrPresent
    @Column(name = "created_at") // DB column name
    private LocalDate createdAt = LocalDate.now();


    // constructors
    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // getter and setter
    public Long getId_author() {
        return id_author;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName(firstName, lastName);  // without this doesn't work.
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId_author().equals(author.getId_author()) && getFirstName().equals(author.getFirstName()) && getLastName().equals(author.getLastName()) && getFullName().equals(author.getFullName()) && getCreatedAt().equals(author.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_author(), getFirstName(), getLastName(), getFullName(), getCreatedAt());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + id_author +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
