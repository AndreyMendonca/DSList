package com.andrey.dslist.controllers;

import com.andrey.dslist.dtos.GameDTO;
import com.andrey.dslist.dtos.GameListDTO;
import com.andrey.dslist.dtos.GameMinDTO;
import com.andrey.dslist.services.GameListService;
import com.andrey.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService service;

    @GetMapping
    public List<GameListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GameListDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
}
