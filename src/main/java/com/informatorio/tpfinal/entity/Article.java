package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity  // this is a tab
@Table(name = "articles")  // table name
public class Article {

    //    ----------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_source")
    Author source;  // don't delete this line.
    //    ----------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.*/
//    @ManyToMany
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "id_article"),
//            inverseJoinColumns = @JoinColumn(name = "id_source")
//    )
//    private Set<Source> sources;  // don't delete this line.
    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @ManyToOne
    @JoinColumn(name = "id_author")
    Author author;  // don't delete this line.
    //    ----------------------------------------------------------------
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_article") // DB column name
    private Long id_article;

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


    public Article(Set<Source> sources, Author author, String title, String description, String content, String url, String urlToImage, LocalDate publishedAt) {
        this.sources = sources;
        this.author = author;
        this.title = title;
        this.description = description;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    // getters and setters
    public Long getId_article() {
        return id_article;
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

    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId_article().equals(article.getId_article()) &&
                getTitle().equals(article.getTitle()) &&
                getDescription().equals(article.getDescription()) &&
                getUrl().equals(article.getUrl()) &&
                getUrlToImage().equals(article.getUrlToImage()) &&
                getPublishedAt().equals(article.getPublishedAt()) &&
                getContent().equals(article.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_article(), getTitle(), getDescription(), getUrl(), getUrlToImage(), getPublishedAt(), getContent());
    }

    @Override
    public String toString() {
        return "Article{" +
                "id_article=" + id_article +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
