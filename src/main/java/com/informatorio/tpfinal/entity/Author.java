package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    private Long id_author;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date createdAt;

    // constructor
    public Author() {
    }

    // constructor
    public Author(Long id_author, String firstName, String lastName, String fullName, Date createdAt) {
        this.id_author = id_author;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    // getter and setter
    public Long getId_author() {
        return id_author;
    }

    public void setId_author(Long id_author) {
        this.id_author = id_author;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId_author().equals(author.getId_author()) && getFirstName().equals(author.getFirstName()) && getLastName().equals(author.getLastName()) && getFullName().equals(author.getFullName()) && getCreatedAt().equals(author.getCreatedAt());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getId_author(), getFirstName(), getLastName(), getFullName(), getCreatedAt());
    }

    // toString
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
