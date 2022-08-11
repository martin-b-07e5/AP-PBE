package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Author;
import com.informatorio.tpfinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

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
