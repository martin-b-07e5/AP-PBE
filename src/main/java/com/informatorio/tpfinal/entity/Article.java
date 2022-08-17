package com.informatorio.tpfinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "articles")  // table name
public class Article {
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_article") // DB column name
    private Long idArticle;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;
    private String content;
    private String url;
    @Column(name = "url_to_image") // DB column name
    private String urlToImage;
    @PastOrPresent
    @Column(name = "published_at") // DB column name
    private LocalDate publishedAt = LocalDate.now();

    //    ----------------------------------------------------------------
    /* https://www.baeldung.com/jpa-many-to-many
     The joinColumn attribute will connect to the owner side of the relationship,
       and the inverseJoinColumn to the other side.*/
    /*@ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "id_source")
    )
    Set<Source> sources;*/
    //    ----------------------------------------------------------------
    // https://www.baeldung.com/hibernate-one-to-many
    @ManyToOne
//    @JoinColumn(name = "id_author")
    Author author;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    private Author author;
    //    ----------------------------------------------------------------

    // constructors
    public Article() {
    }

    public Article(Long idArticle, String title, String description, String content, String url, String urlToImage, LocalDate publishedAt, Author author) {
        this.idArticle = idArticle;
        this.title = title;
        this.description = description;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.author = author;
    }


    // getters and setters
    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        author.setArticles(author.getArticles());
        this.author = author;
    }

    /*
    * public void agregarArticle(Article article) {
        articles.add(article);
//        article.getAuthor().add(this);
        article.setAuthor(this);
    }*/

    public void agregarAuthor(Author author) {
        author.setArticles(author.getArticles());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getIdArticle().equals(article.getIdArticle()) && Objects.equals(getTitle(), article.getTitle()) && Objects.equals(getDescription(), article.getDescription()) && Objects.equals(getContent(), article.getContent()) && Objects.equals(getUrl(), article.getUrl()) && Objects.equals(getUrlToImage(), article.getUrlToImage()) && Objects.equals(getPublishedAt(), article.getPublishedAt()) && Objects.equals(getAuthor(), article.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdArticle(), getTitle(), getDescription(), getContent(), getUrl(), getUrlToImage(), getPublishedAt(), getAuthor());
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt +
                ", author=" + author +
                '}';
    }

}
