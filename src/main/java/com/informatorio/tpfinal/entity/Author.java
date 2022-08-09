package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "authors")  // table name
public class Author {
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    @Column(name = "id_author") // DB column name
    private Long idAuthor;
    @Column(name = "first_name") // DB column name
    private String firstName;
    @Column(name = "last_name") // DB column name
    private String lastName;
    @Column(name = "full_name") // DB column name
    private String fullName;
    @Column(name = "created_at") // DB column name
    private LocalDate createdAt;

    // constructor
    public Author() {
    }

    // constructor
    public Author(Long idAuthor, String firstName, String lastName, String fullName, LocalDate createdAt) {
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
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getIdAuthor().equals(author.getIdAuthor()) && getFirstName().equals(author.getFirstName()) && getLastName().equals(author.getLastName()) && getFullName().equals(author.getFullName()) && getCreatedAt().equals(author.getCreatedAt());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getIdAuthor(), getFirstName(), getLastName(), getFullName(), getCreatedAt());
    }

    // toString
    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + idAuthor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
