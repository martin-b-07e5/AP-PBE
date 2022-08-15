package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity  // this is a tab
@Table(name = "articles")  // table name
public class Article {
    //    ----------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.*/
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "id_source")
    )
    Set<Source> sources;  // don't delete this line.
    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    Author author;  // don't delete this line.
    //    ----------------------------------------------------------------
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_article") // DB column name
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "A short description is mandatory")
    private String description;

    @NotBlank(message = "A full content description is mandatory")
    private String content;

    private String url;

    @Column(name = "url_to_image") // DB column name
    private String urlToImage;

    @PastOrPresent
    @NotBlank(message = "PublishedAt is mandatory")
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
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId().equals(article.getId()) &&
                getTitle().equals(article.getTitle()) &&
                getDescription().equals(article.getDescription()) &&
                getUrl().equals(article.getUrl()) &&
                getUrlToImage().equals(article.getUrlToImage()) &&
                getPublishedAt().equals(article.getPublishedAt()) &&
                getContent().equals(article.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getUrl(), getUrlToImage(), getPublishedAt(), getContent());
    }

    @Override
    public String toString() {
        return "Article{" +
                "id_article=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
