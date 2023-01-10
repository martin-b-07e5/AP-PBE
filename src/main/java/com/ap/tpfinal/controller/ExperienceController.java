package com.ap.tpfinal.controller;

import com.ap.tpfinal.dto.ExperienceDto;
import com.ap.tpfinal.entity.Experience;
import com.ap.tpfinal.repository.ExperienceRepository;
import com.ap.tpfinal.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/experience")  //https://www.baeldung.com/spring-requestmapping
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private ExperienceRepository experienceRepository; // for /findAll()

    //    ------------------------
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
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceService.add(experience);
    }

    /*@PostMapping("/add")
    public ResponseEntity<?> createExperience(@RequestBody ExperienceDto experienceDto) {
        // validations
        if (experienceDto.getName().length() < 3) {
            return new ResponseEntity(new MessageValidations("NAME TO SHORT"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = new Experience(experienceDto.getName(), experienceDto.getDescription());
        experienceService.add(experience);
        return new ResponseEntity<>(new MessageValidations("ADDED EXPERIENCE"), HttpStatus.OK);
    }*/

    // UPDATE ----------------------------------------
    @PutMapping("/updateOld")
    public Experience updateOld(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody ExperienceDto experienceDto) {

//        Experience experienceN = experienceService.getById(id);
        Experience experience = experienceService.getOne(id).get();

        experience.setName(experienceDto.getName());
        experience.setDescription(experienceDto.getDescription());

        experienceService.save(experience);

        return new ResponseEntity(
                new MessageValidations("Experience updated"),
                HttpStatus.OK);
    }

    // DELETE ------------------------
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
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
    public Experience getByIdOld(@PathVariable Long id) {
        return experienceService.getById(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(
            @PathVariable("id") Long id) {

        if (!experienceService.existById(id)) {
            return new ResponseEntity(new MessageValidations("no existe"), HttpStatus.NOT_FOUND);
        }

        Experience experiencia = experienceService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @GetMapping("/findByNameContaining")
    // it must be @RequestParam
    public List<Experience> findByNameContaining(@RequestParam String name) {
        return experienceService.findByNameContaining(name);
    }

}
