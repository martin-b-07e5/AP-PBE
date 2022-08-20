package com.informatorio.tpfinal.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.informatorio.tpfinal.entity.Article;
import com.informatorio.tpfinal.repository.ArticleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    Article article;
    @Mock
    ArticleRepository articleRepository;

    @InjectMocks
    ArticleService articleService;

    @BeforeEach
    void setUp() {
        article = new Article();
        article.setIdArticle(1L);
        article.setTitle("Homer");
        article.setDescription("eating");
    }

    @Test
    void add() {
        when(articleRepository.save(article)).thenReturn(article);
//        when(articleRepository.save(any(Article.class))).thenReturn(article);
        assertNotNull(articleService.add(article));
//        assertNotNull(articleService.add(new Article()));
    }

    @Test
    void addOld() {
        boolean error = false;
        try {
            articleService.add(article);
            System.out.println("Article added successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertFalse(error, "Error adding article ❗❗❗");
    }

    @Test
    void update() {
        boolean error = false;
        try {
            articleService.update(article);
            System.out.println("Article update successfully \uD83C\uDF89");
        } catch (Exception e) {
            error = true;
        }
        assertFalse(error, "\uD83D\uDC4E Error updating article ❗❗❗");
    }

    @Test
    void deleteById() {
        boolean error = false;
        try {
            articleService.deleteById(1L);
            System.out.println("Article deleted successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertFalse(error, "Error deleting article ❗❗❗");
    }

    @Test
    void findAll() {
        boolean error = false;
        try {
//            when(articleRepository.findAll()).thenReturn(Arrays.asList(article));
            when(articleRepository.findAll()).thenReturn(Collections.singletonList(article));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(articleRepository.findAll());
        assertFalse(error, "Error finding All Articles");
    }

    @Test
    void findById() {
        boolean error = false;
        try {
            when(articleRepository.findById(1L)).thenReturn(Optional.ofNullable(article));
            System.out.println("Article found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(articleService.findById(1L));
    }

    @Test
    void findByTitleContainingOrDescriptionContaining() {
        boolean error = false;
        try {
//            when(articleRepository.findByTitleContainingOrDescriptionContaining("Homer", "eating")).thenReturn(Arrays.asList(article));
            when(articleRepository.findByTitleContainingOrDescriptionContaining("Homer", "eating")).thenReturn(Collections.singletonList(article));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(articleService.findByTitleContainingOrDescriptionContaining("Homer", "eating"));
    }

}