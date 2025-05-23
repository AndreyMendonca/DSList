package com.andrey.dslist.services;

import com.andrey.dslist.dtos.GameMinDTO;
import com.andrey.dslist.entities.Game;
import com.andrey.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x->new GameMinDTO(x)).toList();
        return dtos;
    }
}
