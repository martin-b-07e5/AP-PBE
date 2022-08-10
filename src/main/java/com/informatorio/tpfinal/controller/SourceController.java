package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/source")
public class SourceController {

    @Autowired
    private SourceRepository repository;

//    @GetMapping("/getAllSources")
//    public List<Source> getAllSources() {
//        return sourceService.getAllSources();
//    }

    @RequestMapping(value = "/source", method = RequestMethod.GET)
    public @ResponseBody Iterable<Source> findSources() {
        return repository.findAll();
    }

}
