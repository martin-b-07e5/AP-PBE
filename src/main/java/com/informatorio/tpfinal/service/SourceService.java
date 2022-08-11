package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    private SourceRepository sourceRepository;

    // this function is called from the controller
    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }

    // this function is called from the controller
    public Source getById(Long idSource){
        return sourceRepository.findById(idSource).get();
    }
}
