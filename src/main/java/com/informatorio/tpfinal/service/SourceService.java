package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Source;
import com.informatorio.tpfinal.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    //    private HelloService helloService = new HelloService();
    /*  Aplico el concepto de INYECCIÓN DE DEPENDENCIA,
      no lo instancio, lo delego.
      Ya no tengo el control, invierto el control (con @Autowired)
      y el que tiene el control es SPRING */
    @Autowired
    private SourceRepository sourceRepository;

    //  Below functions are called from the controller
    //    ------------------------
    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }

    //    ------------------------
    public Source getById(Long idSource) {
        return sourceRepository.findById(idSource).get();
    }

    //        ------------------------
    public Source createSource(Source source) {
        return sourceRepository.save(source);
    }

    //    ------------------------
    public Source updateSource(Source source) {
        return sourceRepository.save(source);
    }

    //    ------------------------

    public String deleteSource(Long idSource) {
        sourceRepository.deleteById(idSource);
        return "source " + idSource + " deleted";
    }

}