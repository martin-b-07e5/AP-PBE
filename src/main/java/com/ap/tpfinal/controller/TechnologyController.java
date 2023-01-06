package com.ap.tpfinal.controller;

import com.ap.tpfinal.repository.TechnologyRepository;
import com.ap.tpfinal.service.TechnologyService;
import com.ap.tpfinal.entity.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/technology")  //https://www.baeldung.com/spring-requestmapping
@CrossOrigin(origins = "http://localhost:4200")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private TechnologyRepository technologyRepository; // for /findAll()

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the TechnologyController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the TechnologyController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Technology createTechnology(@RequestBody Technology technology) {
        return technologyService.add(technology);
    }

    @PutMapping("/update")
    public Technology updateTechnology(@RequestBody Technology technology) {
        return technologyService.update(technology);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTechnology(@PathVariable Long id) {
        return technologyService.deleteById(id);
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Technology> findTechnology() {
        return technologyRepository.findAll();
    }

    //    below, call function defined in ExperienceService.
    @GetMapping("/getAll")
    public List<Technology> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Technology getById(@PathVariable Long id) {
        return technologyService.getById(id);
    }

    //    ------------------------
    // it must be @RequestParam
    @GetMapping("/findByNameContaining")
    public List<Technology> findByNameContaining(@RequestParam String name) {
        return technologyService.findByNameContaining(name);
    }

}
