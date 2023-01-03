package com.informatorio.tpfinal.service;

import com.informatorio.tpfinal.entity.Persona;
import com.informatorio.tpfinal.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @Mock
    Persona persona;
    @Mock
    PersonaRepository personaRepository;

    @InjectMocks
    PersonaService personaService;

    @BeforeEach
    void setUp() {
        persona = new Persona();
        persona.setIdPersona(1L);
        persona.setFirstName("Homer");
        persona.setEmail("eating");
    }

    @Test
    void add() {
        when(personaRepository.save(persona)).thenReturn(persona);
//        when(articleRepository.save(any(Article.class))).thenReturn(article);
        assertNotNull(personaService.add(persona));
//        assertNotNull(articleService.add(new Article()));
    }

    @Test
    void addOld() {
        boolean error = false;
        try {
            personaService.add(persona);
            System.out.println("Article added successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertFalse(error, "Error adding article ❗❗❗");
    }

    @Test
    void update() {
        boolean error = false;
        try {
            personaService.update(persona);
            System.out.println("Article update successfully \uD83C\uDF89");
        } catch (Exception e) {
            error = true;
        }
        assertFalse(error, "\uD83D\uDC4E Error updating article ❗❗❗");
    }

    @Test
    void deleteById() {
        boolean error = false;
        try {
            personaService.deleteById(1L);
            System.out.println("Article deleted successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertFalse(error, "Error deleting article ❗❗❗");
    }

    @Test
    void findAll() {
        boolean error = false;
        try {
//            when(articleRepository.findAll()).thenReturn(Arrays.asList(article));
            when(personaRepository.findAll()).thenReturn(Collections.singletonList(persona));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personaRepository.findAll());
        assertFalse(error, "Error finding All Articles");
    }

    @Test
    void findById() {
        boolean error = false;
        try {
            when(personaRepository.findById(1L)).thenReturn(Optional.ofNullable(persona));
            System.out.println("Article found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personaService.findById(1L));
    }

    @Test
    void findByTitleContainingOrDescriptionContaining() {
        boolean error = false;
        try {
//            when(articleRepository.findByTitleContainingOrDescriptionContaining("Homer", "eating")).thenReturn(Arrays.asList(article));
            when(personaRepository.findByFirstNameContainingOrLastNameContaining("Homer", "eating")).thenReturn(Collections.singletonList(persona));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personaService.findByFirstNameContainingOrLastNameContaining("Homer", "simp"));
    }

}