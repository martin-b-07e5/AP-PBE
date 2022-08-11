package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import com.informatorio.tpfinal.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/source")
public class SourceController {

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private SourceService sourceService;

    @GetMapping("")
    public String helloE() {
        return "HELLO from the SourceController";
    }
    @GetMapping("/")
    public String helloR() {
        return "HELLO from the SourceController/";
    }


    @RequestMapping(value = "/getAllSources2", method = RequestMethod.GET)
    public @ResponseBody Iterable<Source> findSources() {
        return sourceRepository.findAll();
    }

    // call the method in the service
    @GetMapping("/getAllSources")
    public List<Source> getAllSources() {
        return sourceService.getAllSources();
    }

}
