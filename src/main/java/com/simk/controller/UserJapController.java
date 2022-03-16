package com.simk.controller;

import com.simk.entities.UserJpa;
import com.simk.mapper.UserJapRepository;
import com.simk.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserJapController {
@Autowired
    UserJpaService userJpaService;
    @GetMapping("/userFindAllById/{id}")
    public UserJpa userFindAllById(@PathVariable("id") Integer id){
        UserJpa userJpa = userJpaService.findAllById(id);
        return userJpa;
    }
}
