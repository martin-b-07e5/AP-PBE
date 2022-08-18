package com.informatorio.tpfinal.repository;

import com.informatorio.tpfinal.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// using this repository and the entity Article, we can perform CRUD operations
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleContainingAndDescriptionContaining(String title, String description);
}
