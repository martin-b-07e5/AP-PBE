package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Article, we can perform CRUD operations
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContainingOrDescriptionContaining(String title, String description);
//        List<Article> findByTitleContainingAndDescriptionContainingAndAuthorFullNameContaining(String title, String description, String fullName);

    /*
    @Query(value = "SELECT articles.title as TITLE, articles.description AS DESCRIPTION, articles.content AS CONTENT, authors.full_name AS \"FULL NAME\"\n" +
            "FROM articles\n" +
            "INNER JOIN authors\n" +
            "on articles.id_author = authors.id_author;\n", nativeQuery = true)
    List<Article> getValues(String title, String description, String content, String fullName);
    */

    /* sql query
    SELECT articles.title AS TITLE, articles.description AS DESCRIPTION, articles.content AS CONTENT, authors.full_name AS "FULL NAME"
    FROM articles
    INNER JOIN authors
    on articles.id_author = authors.id_author
    WHERE full_name LIKE '%wang%';
    */

}
