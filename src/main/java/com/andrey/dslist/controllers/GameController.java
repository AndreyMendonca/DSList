package com.andrey.dslist.controllers;

import com.andrey.dslist.dtos.GameMinDTO;
import com.andrey.dslist.entities.Game;
import com.andrey.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return service.findAll();
    }
}
