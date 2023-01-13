package com.ap.tpfinal.controller;

import com.ap.tpfinal.repository.ProjectRepository;
import com.ap.tpfinal.entity.Project;
import com.ap.tpfinal.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController  //https://www.baeldung.com/spring-controller-vs-restcontroller
@RequestMapping(value = "/api/v1/project")  //https://www.baeldung.com/spring-requestmapping
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://ap-front--2023-01-12--firebase.web.app")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository; // for /findAll()

    //    ------------------------
    @GetMapping("")
    public String helloE() {
        return "HELLO from the ProjectController";
    }

    @GetMapping("/")
    public String helloR() {
        return "HELLO from the ProjectController/";
    }

    //    ------------------------
    @PostMapping("/add")
    public Project createProject(@RequestBody Project project) {
        return projectService.add(project);
    }

    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project) {
        return projectService.update(project);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        return projectService.deleteById(id);
    }

    //    ------------------------
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Iterable<Project> findProject() {
        return projectRepository.findAll();
    }

    //    below, call function defined in ExperienceService.
    @GetMapping("/getAll")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Project getById(@PathVariable Long id) {
        return projectService.getById(id);
    }

    //    ------------------------
    // it must be @RequestParam
    @GetMapping("/findByNameContaining")
    public List<Project> findByNameContaining(@RequestParam String name) {
        return projectService.findByNameContaining(name);
    }

    @GetMapping("/findByCreatedAtGreaterThanEqual")
    // 💡 String type comes from postman.
    public List<Project> findByCreatedAtGreaterThanEqual(@RequestParam String createdAt) {
        // LocalDate date = LocalDate.parse(createdAt);
        return projectService.findByCreatedAtGreaterThanEqual(LocalDate.parse(createdAt));
    }

}
