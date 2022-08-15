package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Author;
import com.informatorio.tpfinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    //  Below functions are called from the controller
    //    ------------------------
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(Long id) {
        return authorRepository.findById(id).get();
    }

    //    ------------------------
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Author author) {
        return authorRepository.save(author);
    }

    public String deleteById(Long id) {
        authorRepository.deleteById(id);
        return "author " + id + " deleted";
    }

    //    ------------------------
    public List<Author> findByFullNameContaining(String fullName) {
        return authorRepository.findByFullNameContaining(fullName);
    }

    public List<Author> findByCreatedAtGreaterThanEqual(LocalDate createdAt) {
        return authorRepository.findByCreatedAtGreaterThanEqual(createdAt);
    }


}
