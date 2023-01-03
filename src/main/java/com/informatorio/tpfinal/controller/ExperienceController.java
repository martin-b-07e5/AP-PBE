package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Experience;
import com.informatorio.tpfinal.repository.ExperienceRepository;
import com.informatorio.tpfinal.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
//@RequestMapping("/experience")
@RequestMapping("/api/v1/experience")  //https://www.baeldung.com/spring-requestmapping
public class ExperienceController {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceService experienceService;

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the AuthorController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the AuthorController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Experience createAuthor(@RequestBody Experience experience) {
        return experienceService.add(experience);
    }

    @PutMapping("/update")
    public Experience update(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        return experienceService.deleteById(id);
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Experience> findAuthors() {
        return experienceRepository.findAll();
    }

    // call function defined in AuthorService
    @GetMapping("/getAll")
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Experience getById(@PathVariable Long id) {
        return experienceService.getById(id);
    }

    //    ------------------------
    @GetMapping("/findByNameContaining")
    //    it must be @RequestParam
    public List<Experience> findByNameContaining(@RequestParam String name) {
        return experienceService.findByNameContaining(name);
    }

    @GetMapping("/findByCreatedAtGreaterThanEqual")
    // 💡 String type comes from postman.
    public List<Experience> findByCreatedAtGreaterThanEqual(@RequestParam String createdAt) {
        // LocalDate date = LocalDate.parse(createdAt);
        return experienceService.findByCreatedAtGreaterThanEqual(LocalDate.parse(createdAt));
    }

}
