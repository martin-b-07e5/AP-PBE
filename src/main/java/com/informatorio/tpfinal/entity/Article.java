package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "articles")  // table name
public class Article {

    //    ----------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.*/
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_source"),
            inverseJoinColumns = @JoinColumn(name = "id_article")
    )
    Set<Source> sources;  // don't delete this line.
    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @ManyToOne  // 0k
    @JoinColumn(name = "id_author")
    Author author;  // don't delete this line.
    //    ----------------------------------------------------------------
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_article") // DB column name
    private Long idArticle;

    @NotBlank(message = "Title is mandatory")
    private String title;

    //    @NotBlank(message = "A short description is mandatory")
    private String description;

    //    @NotBlank(message = "A full content description is mandatory")

    private String content;

    private String url;

    @Column(name = "url_to_image") // DB column name
    private String urlToImage;

    @PastOrPresent
//    @NotBlank(message = "PublishedAt is mandatory")
    @Column(name = "published_at") // DB column name
    private LocalDate publishedAt = LocalDate.now();


    // constructors
    public Article() {
    }


    public Article(String title, String description, String content, String url, String urlToImage, LocalDate publishedAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    // getters and setters
    public Long getIdArticle() {
        return idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    /*public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }*/


}
