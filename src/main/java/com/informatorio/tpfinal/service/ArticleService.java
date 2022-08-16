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
    public Article add(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAll() {return articleRepository.findAll();}

}
