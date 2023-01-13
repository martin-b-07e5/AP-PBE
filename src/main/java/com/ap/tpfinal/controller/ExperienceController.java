package com.ap.tpfinal.controller;

import com.ap.tpfinal.entity.Experience;
import com.ap.tpfinal.repository.ExperienceRepository;
import com.ap.tpfinal.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/experience")  //https://www.baeldung.com/spring-requestmapping
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://ap-front--2023-01-12--firebase.web.app")
//@CrossOrigin(origins = "https://ap-pbe-production.up.railway.app")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private ExperienceRepository experienceRepository; // for /findAll()

    // ----------------------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the ExperienceController empty";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the ExperienceController root /";
    }

    // CREATE ----------------------------------------
    @PostMapping("/add")
    public Experience create(@RequestBody Experience experience) {
        return experienceService.save(experience);
    }

    // UPDATE ----------------------------------------
    @PutMapping("/updateOld")
    public Experience updateOld(@RequestBody Experience experience) {
        return experienceService.save(experience);
    }

    //    https://www.baeldung.com/spring-boot-react-crud
    @PutMapping("/update/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody Experience experience) {
        Experience experienceUpdate = experienceRepository.findById(id).orElseThrow(RuntimeException::new);
        experienceUpdate.setName(experience.getName());
        experienceUpdate.setDescription(experience.getDescription());
        experienceUpdate = experienceRepository.save(experience);
        return ResponseEntity.ok(experienceUpdate);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity detail(
            @PathVariable Long id) {
        Experience experienceDetail = experienceService.getById(id);
        return ResponseEntity.ok(experienceDetail);
    }

    // DELETE ----------------------------------------
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return experienceService.deleteById(id);
    }

    // READ ----------------------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Experience> findExperience() {
        return experienceRepository.findAll();
    }

    @GetMapping("/getAll")
    public List<Experience> getAll() {
        return experienceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Experience getById(@PathVariable Long id) {
        return experienceService.getById(id);
    }

    @GetMapping("/findByNameContaining")
    // it must be @RequestParam
    public List<Experience> findByNameContaining(@RequestParam String name) {
        return experienceService.findByNameContaining(name);
    }

}
