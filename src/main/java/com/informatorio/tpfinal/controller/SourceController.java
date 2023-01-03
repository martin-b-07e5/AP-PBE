package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Education;
import com.informatorio.tpfinal.repository.SourceRepository;
import com.informatorio.tpfinal.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping(value = "/education")
@RequestMapping(value = "/api/v1/education")  //https://www.baeldung.com/spring-requestmapping
public class SourceController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private SourceService sourceService;

    @Autowired
    private SourceRepository sourceRepository;

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
    @PostMapping("/add")
    public Education createSource(@RequestBody Education education) {
        return sourceService.add(education);
    }

    @PutMapping("/update")
    public Education updateSource(@RequestBody Education education) {
        return sourceService.update(education);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSource(@PathVariable Long id) {
        return sourceService.deleteById(id);
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Education> findSources() {
        return sourceRepository.findAll();
    }

    //    below, call function defined in SourceService.
    @GetMapping("/getAll")
    public List<Education> getAll() {
        return sourceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Education getById(@PathVariable Long id) {
        return sourceService.getById(id);
    }

    //    ------------------------
//    @GetMapping("/findByFullNameContaining")
//    //    it must be @RequestParam
//    public List<Source> findByFullNameContaining(@RequestParam String name) {
//        return sourceService.findByFullNameContaining(name);
//    }

    @GetMapping("/findByNameContaining")
    public List<Education> findByNameContaining(@RequestParam String name) {
        return sourceService.findByNameContaining(name);
    }

}
