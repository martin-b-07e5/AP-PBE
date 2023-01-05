package com.ap.tpfinal.controller;

import com.ap.tpfinal.repository.EducationRepository;
import com.ap.tpfinal.entity.Education;
import com.ap.tpfinal.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/education")  //https://www.baeldung.com/spring-requestmapping
public class EducationController {

    @Autowired
    private EducationService educationService;

    @Autowired
//    private SourceRepository sourceRepository; // for /findAll()
    private EducationRepository educationRepository; // for /findAll()

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the EducationController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the EducationController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Education createEducation(@RequestBody Education education) {
        return educationService.add(education);
    }

    @PutMapping("/update")
    public Education updateEducation(@RequestBody Education education) {
        return educationService.update(education);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEducation(@PathVariable Long id) {
        return educationService.deleteById(id);
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Education> findEducation() {
        return educationRepository.findAll();
    }

    //    below, call function defined in EducationService.
    @GetMapping("/getAll")
    public List<Education> getAll() {
        return educationService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Education getById(@PathVariable Long id) {
        return educationService.getById(id);
    }

    //    ------------------------
    // it must be @RequestParam
    @GetMapping("/findByNameContaining")
    public List<Education> findByNameContaining(@RequestParam String name) {
        return educationService.findByNameContaining(name);
    }

}
