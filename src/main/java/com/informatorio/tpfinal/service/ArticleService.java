package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Article;
import com.informatorio.tpfinal.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private ArticleRepository articleRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).get();
    }

    //    ------------------------
    public Article add(Article article) {
        return articleRepository.save(article);
    }

    public Article update(Article article) {
        return articleRepository.save(article);
    }

    public String deleteById(Long id) {
        articleRepository.deleteById(id);
        return "article" + id + " deleted";
    }

    //    ------------------------
    public List<Article> findByTitleContainingAndDescriptionContaining(String title, String description) {
        int query = title.length() + description.length();
        if (query >= 3) {
            return articleRepository.findByTitleContainingAndDescriptionContaining(title, description);
        }
        else throw new IllegalArgumentException("La palabra a buscar debe ser mayor a 3 caracteres: " + "title = " + title + ", " + " description = " + description);
    }

}
