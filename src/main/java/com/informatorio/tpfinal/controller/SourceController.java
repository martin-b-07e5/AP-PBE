package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import com.informatorio.tpfinal.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/source")  //https://www.baeldung.com/spring-requestmapping
public class SourceController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    //    ------------------------
    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private SourceService sourceService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the SourceController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the SourceController/";
    }

    //    ------------------------
    @RequestMapping(value = "/findAllSources", method = RequestMethod.GET)
    public @ResponseBody Iterable<Source> findSources() {
        return sourceRepository.findAll();
    }

    //    ------------------------
    //    call function defined in SourceService
    @GetMapping("/getAllSources")
    public List<Source> getAllSources() {
        return sourceService.getAllSources();
    }

    //        ------------------------
    //     localhost:8083/source/getById/1
    @GetMapping("/getById/{idSource}")
    public Source getById(@PathVariable Long idSource) {
        return sourceService.getById(idSource);
    }

    //    ------------------------
    //     Create a new source
    @PostMapping("/create")
    public Source createSource(@RequestBody Source source) {
        return sourceService.createSource(source);
    }

    //    ------------------------
    //     Update a source
    @PutMapping("/update")
    public Source updateSource(@RequestBody Source source) {
        return sourceService.updateSource(source);
    }

    //    ------------------------
    //    Delete a source
    @DeleteMapping("/delete/{idSource}")
    public String deleteSource(@PathVariable Long idSource) {
        return sourceService.deleteSource(idSource);
    }

//    ------------------------
}
