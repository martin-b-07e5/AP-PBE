package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Author;
import com.informatorio.tpfinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private AuthorRepository authorRepository;

    // this function is called from the controller
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // this function is called from the controller
    public Author getById(Long idSource){
        return authorRepository.findById(idSource).get();
    }
}
