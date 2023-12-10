package com.psw.servizi.controller;

import com.psw.servizi.entity.Cake;
import com.psw.servizi.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CakeController {

    @Autowired
    CakeRepository cakeRepository;

    @GetMapping(value = "/cakes")
    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    @GetMapping("/cakes/{id}")
    Cake getCakeById(@PathVariable Long id) {
        return cakeRepository.findById(id).get();
    }

    @PostMapping("/cakes")
    Cake addCake(@RequestBody Cake newCake) {
        return cakeRepository.save(newCake);
    }

    @PutMapping("/cakes/{id}")
    Cake updateCake(@RequestBody Cake updatedCake, @PathVariable Long id) {
        return cakeRepository.findById(id).map(cake -> {
            cake.setTitle(updatedCake.getTitle());
            cake.setOccasion(updatedCake.getOccasion());
            cake.setDescription(updatedCake.getDescription());
            return cakeRepository.save(cake);
        }).orElseGet(() -> {
            updatedCake.setId(id);
            return null;
        });
    }

    @DeleteMapping("/cakes/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    void deleteCake(@PathVariable Long id) {
        cakeRepository.deleteById(id);
    }

}
