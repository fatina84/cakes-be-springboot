package com.psw.servizi.controller;

import com.psw.servizi.model.Cake;
import com.psw.servizi.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class CakeController {

    @Autowired
    CakeRepository cakeRepository;

    @RequestMapping(value = "/cakes",
            method = RequestMethod.GET,
            produces = "application/json")
    public List<Cake> getCakes() {
        return cakeRepository.findAll();
    }



    @RequestMapping(value = "/cakes/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteCake(@PathVariable("id") Long id ) {
        cakeRepository.deleteById(id);
    }

    @RequestMapping(value = "/cakes", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus( HttpStatus.CREATED )
    public Cake addCake(@RequestBody Cake cake) {
        return cakeRepository.save(cake);
    }


}
