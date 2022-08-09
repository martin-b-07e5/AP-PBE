package com.informatorio.tpfinal.controller;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/source")
//@RequestMapping("/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping("/getAllSources")
    public List<Source> getAllSources() {
        return sourceService.getAllSources();
    }

}
