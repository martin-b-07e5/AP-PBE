package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity  // this is a tab
@Table(name = "articles")  // table name
public class Article {
    @Id // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    private Long id_article;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;
    private Long id_author; // FK_id_author
    private Long id_source; // FK_id_source

    // constructor
    public Article() {
    }

    // constructor
    public Article(Long id_article, String title, String description, String url, String urlToImage, LocalDate publishedAt, String content, Long id_author, Long id_source) {
        this.id_article = id_article;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.id_author = id_author;
        this.id_source = id_source;
    }

    // getters and setters
    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
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

    public Long getId_author() {
        return id_author;
    }

    public void setId_author(Long id_author) {
        this.id_author = id_author;
    }

    public Long getId_source() {
        return id_source;
    }

    public void setId_source(Long id_source) {
        this.id_source = id_source;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId_article().equals(article.getId_article()) && getTitle().equals(article.getTitle()) && getDescription().equals(article.getDescription()) && getUrl().equals(article.getUrl()) && getUrlToImage().equals(article.getUrlToImage()) && getPublishedAt().equals(article.getPublishedAt()) && getContent().equals(article.getContent()) && getId_author().equals(article.getId_author()) && getId_source().equals(article.getId_source());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getId_article(), getTitle(), getDescription(), getUrl(), getUrlToImage(), getPublishedAt(), getContent(), getId_author(), getId_source());
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
                ", id_author=" + id_author +
                ", id_source=" + id_source +
                '}';
    }
}
