package com.ap.tpfinal.controller;

import com.ap.tpfinal.entity.Experience;
import com.ap.tpfinal.repository.ExperienceRepository;
import com.ap.tpfinal.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/experience")  //https://www.baeldung.com/spring-requestmapping
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @Autowired
//    private SourceRepository sourceRepository; // for /findAll()
    private ExperienceRepository experienceRepository; // for /findAll()

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the ExperienceController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the ExperienceController/";
    }

    // CREATE ------------------------
    @PostMapping("/add")
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.add(experience);
    }

    // UPDATE ------------------------
    @PutMapping("/update")
    public Experience updateExperience(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }

    // DELETE ------------------------
    @DeleteMapping("/delete/{id}")
    public String deleteExperience(@PathVariable Long id) {
        return experienceService.deleteById(id);
    }

    // READ ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Experience> findExperience() {
        return experienceRepository.findAll();
    }

    //    below, call function defined in ExperienceService.
    @GetMapping("/getAll")
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Experience getById(@PathVariable Long id) {
        return experienceService.getById(id);
    }

    //    ------------------------
    // it must be @RequestParam
    @GetMapping("/findByNameContaining")
    public List<Experience> findByNameContaining(@RequestParam String name) {
        return experienceService.findByNameContaining(name);
    }

}
