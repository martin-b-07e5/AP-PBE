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
    // this method is called from the controller
    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }
}
