package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "authors")
public class Author {

    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @OneToMany(mappedBy = "author")
    Set<Article> articles;
//    List<Article> articles = new ArrayList<>();

    //    Set<Article> articles = new HashSet<Article>();

    //    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Article> articles;
    //    ----------------------------------------------------------------
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for AI
    @Column(name = "id_author") // DB column name
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
    public Author() {
    }

    public Author(Long idAuthor, String firstName, String lastName, String fullName, LocalDate createdAt, Set<Article> articles) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.articles = articles;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getIdAuthor(), getFirstName(), getLastName(), getFullName(), getCreatedAt(), getArticles());
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }


    public void agregarArticle(Article article) {
        articles.add(article);
//        article.getAuthor().add(this);
        article.setAuthor(this);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getIdAuthor().equals(author.getIdAuthor()) && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getFullName(), author.getFullName()) && Objects.equals(getCreatedAt(), author.getCreatedAt()) && Objects.equals(getArticles(), author.getArticles());
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                ", articles=" + articles +
                '}';
    }

}
