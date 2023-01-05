package com.ap.tpfinal.service;

import com.ap.tpfinal.entity.Person;
import com.ap.tpfinal.repository.PersonRepository;
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
class PersonServiceTest {

    @Mock
    Person person;
    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setIdPerson(1L);
        person.setFirstName("Homer");
        person.setEmail("eating");
    }

    @Test
    void add() {
        when(personRepository.save(person)).thenReturn(person);
//        when(articleRepository.save(any(Article.class))).thenReturn(article);
        assertNotNull(personService.add(person));
//        assertNotNull(articleService.add(new Article()));
    }

    @Test
    void addOld() {
        boolean error = false;
        try {
            personService.add(person);
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
            personService.update(person);
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
            personService.deleteById(1L);
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
            when(personRepository.findAll()).thenReturn(Collections.singletonList(person));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personRepository.findAll());
        assertFalse(error, "Error finding All Articles");
    }

    @Test
    void findById() {
        boolean error = false;
        try {
            when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));
            System.out.println("Article found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personService.findById(1L));
    }

    @Test
    void findByTitleContainingOrDescriptionContaining() {
        boolean error = false;
        try {
//            when(articleRepository.findByTitleContainingOrDescriptionContaining("Homer", "eating")).thenReturn(Arrays.asList(article));
            when(personRepository.findByFirstNameContainingOrLastNameContaining("Homer", "eating")).thenReturn(Collections.singletonList(person));
            System.out.println("Articles found successfully \uD83C\uDF89");
        } catch (EntityNotFoundException e) {
            error = true;
        }
        assertNotNull(personService.findByFirstNameContainingOrLastNameContaining("Homer", "simp"));
    }

}