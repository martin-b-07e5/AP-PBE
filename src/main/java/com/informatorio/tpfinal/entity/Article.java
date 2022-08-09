package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity  // this is a tab
@Table(name = "articles")  // table name
public class Article {
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_article") // DB column name
    private Long idArticle;
    private String title;
    private String description;
    private String url;
    @Column(name = "url_to_image") // DB column name
    private String urlToImage;
    @Column(name = "published_at") // DB column name
    private LocalDate publishedAt;
    private String content;
    @Column(name = "id_author") // DB column name
    private Long idAuthor; // FK_id_author
    @Column(name = "id_source") // DB column name
    private Long idSource; // FK_id_source

    // constructor
    public Article() {
    }

    // constructor
    public Article(Long idArticle, String title, String description, String url, String urlToImage, LocalDate publishedAt, String content, Long idAuthor, Long idSource) {
        this.idArticle = idArticle;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.idAuthor = idAuthor;
        this.idSource = idSource;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getIdArticle().equals(article.getIdArticle()) && getTitle().equals(article.getTitle()) && getDescription().equals(article.getDescription()) && getUrl().equals(article.getUrl()) && getUrlToImage().equals(article.getUrlToImage()) && getPublishedAt().equals(article.getPublishedAt()) && getContent().equals(article.getContent()) && getIdAuthor().equals(article.getIdAuthor()) && getIdSource().equals(article.getIdSource());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getIdArticle(), getTitle(), getDescription(), getUrl(), getUrlToImage(), getPublishedAt(), getContent(), getIdAuthor(), getIdSource());
    }

    @Override
    public String toString() {
        return "Article{" +
                "id_article=" + idArticle +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                ", id_author=" + idAuthor +
                ", id_source=" + idSource +
                '}';
    }
}
