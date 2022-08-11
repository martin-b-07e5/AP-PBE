package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import com.informatorio.tpfinal.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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

    // call function defined in SourceService
    @GetMapping("/getAllSources")
    public List<Source> getAllSources() {
        return sourceService.getAllSources();
    }

    // localhost:8083/source/getById/1
    @GetMapping("/getById/{idSource}")
    public Source getById(@PathVariable Long idSource) {
        return sourceService.getById(idSource);
    }

//    https://www.arquitecturajava.com/java-lombok-clases-y-productividad/
    @RequestMapping(value = "/buscarTodas")
    List<Source> buscarTodas() {
        List<Source> sourceList = new ArrayList<>();
        sourceList.add(new Source(5L, "diarioTag", 3L, LocalDate.now()));
        sourceList.add(new Source(6L, "dataTag", 3L, LocalDate.now()));
        return sourceList;
    }
    @RequestMapping(value = "/buscarTodas2", method = RequestMethod.GET)
    public @ResponseBody Iterable<Source> buscarTodas2() {
        return sourceRepository.findAll();
    }

}
