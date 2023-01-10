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
    public Experience create(@RequestBody Experience experience) {
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
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody ExperienceDto experienceDto) {

        //Validamos si existe el ID
        if (!experienceService.existById(id)) {
            return new ResponseEntity(
                    new MessageValidations("El ID no existe"),
                    HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de experiencias
        /*if(sExperiencia.existsByNombreE(dtoexp.getNombreE()) &&
                sExperiencia
                        .getByNombreE(dtoexp.getNombreE())
                        .get()
                        .getId() != id) {
            return new ResponseEntity(
                    new Mensaje("Esa experiencia ya existe"),
                    HttpStatus.BAD_REQUEST);
        }*/

        //No puede estar vacio
        /*if(StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje(
                    "El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }*/

        Experience experiencia = experienceService.getOne(id).get();

        experiencia.setName(experienceDto.getName());
        experiencia.setDescription((experienceDto.getDescription()));

        experienceService.save(experiencia);

        return new ResponseEntity(
                new MessageValidations("Experiencia actualizada"),
                HttpStatus.OK);
    }



    /*@PutMapping("/update")
    public Experience updateOld(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }*/

    //    https://www.baeldung.com/spring-boot-react-crud
    /*@PutMapping("/update/`{id}`")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Experience experience) {
        Experience currentExperience = experienceRepository.findById(id).orElseThrow(RuntimeException::new);
        currentExperience.setName(experience.getName());
        currentExperience.setDescription(experience.getDescription());
        currentExperience = experienceRepository.save(experience);

        return ResponseEntity.ok(currentExperience);
    }*/


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
    public Experience getById(@PathVariable Long id) {
        return experienceService.getById(id);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> detail(
            @PathVariable("id") Long id) {
        // validation
        if (!experienceService.existById(id)) {
            return new ResponseEntity(new MessageValidations("no existe"), HttpStatus.NOT_FOUND);
        }

        // Experience experienceN = experienceService.getById(id);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @GetMapping("/findByNameContaining")
    // it must be @RequestParam
    public List<Experience> findByNameContaining(@RequestParam String name) {
        return experienceService.findByNameContaining(name);
    }

}
