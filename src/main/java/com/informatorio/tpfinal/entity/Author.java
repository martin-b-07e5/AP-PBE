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
    //    @OneToMany(mappedBy = "author", cascade = CascadeType.REFRESH, orphanRemoval = true)
    @OneToMany(mappedBy = "author")
    Set<Article> articles;
//    Set<Article> articles = new HashSet<Article>();
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

//    public void setCreatedAt(LocalDate createdAt) {
//        this.createdAt = createdAt;
//    }


//    public Set<Article> getArticles() {
//        return articles;
//    }

//    public void setArticles(Set<Article> articles) {
//        this.articles = articles;
//    }


    // sin usar, ver video 12.3.4-Relaciones_-_ManyToMany.mkv
    /*public void agregarArticle(Article article) {
        articles.add(article);
        article.setAuthor(this);
    }*/

}
