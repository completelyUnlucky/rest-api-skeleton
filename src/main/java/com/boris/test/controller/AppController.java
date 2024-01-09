package com.boris.test.controller;

import com.boris.test.entity.Cat;
import com.boris.test.repositories.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class AppController {

    @Autowired
    private CatRepo catRepo;

    @Operation(summary = "Add a cat to the db")
    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row: " + catRepo.save(cat));
    }

    @Operation(summary = "Get a list of all cats in db")
    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> allCats() {
        return catRepo.findAll();
    }

    @Operation(summary = "Get a cat by id")
    @GetMapping("/api/id")
    public Optional<Cat> findCat(@RequestParam Long id) {
        return catRepo.findById(id);
    }

    @Operation(summary = "Delete a cat by id")
    @DeleteMapping("/api/del")
    public void deleteCat(@RequestParam Long id) {
        log.info("Delete row: " + catRepo.findById(id));
        catRepo.deleteById(id);
    }

}
