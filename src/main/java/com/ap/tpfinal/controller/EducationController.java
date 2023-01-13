package com.ap.tpfinal.controller;

import com.ap.tpfinal.repository.EducationRepository;
import com.ap.tpfinal.entity.Education;
import com.ap.tpfinal.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/education")  //https://www.baeldung.com/spring-requestmapping
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://ap-front--2023-01-12--firebase.web.app")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @Autowired
    private EducationRepository educationRepository; // for /findAll()

    // ----------------------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the EducationController empty";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the EducationController root /";
    }

    // CREATE ----------------------------------------
    @PostMapping("/add")
    public Education create(@RequestBody Education education) {
        return educationService.save(education);
    }

    // UPDATE ----------------------------------------
    @PutMapping("/updateOld")
    public Education updateOld(@RequestBody Education education) {
        return educationService.save(education);
    }

    //    https://www.baeldung.com/spring-boot-react-crud
    @PutMapping("/update/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody Education education) {
        Education educationUpdate = educationRepository.findById(id).orElseThrow(RuntimeException::new);
        educationUpdate.setName(education.getName());
        educationUpdate.setDescription(education.getDescription());
        educationUpdate = educationRepository.save(education);
        return ResponseEntity.ok(educationUpdate);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity detail(
            @PathVariable Long id) {
        Education educationDetail = educationService.getById(id);
        return ResponseEntity.ok(educationDetail);
    }

    // DELETE ----------------------------------------
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

    @GetMapping("/findByNameContaining")
    // it must be @RequestParam
    public List<Education> findByNameContaining(@RequestParam String name) {
        return educationService.findByNameContaining(name);
    }

}
