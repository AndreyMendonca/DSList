package com.andrey.dslist.services;

import com.andrey.dslist.dtos.GameDTO;
import com.andrey.dslist.dtos.GameListDTO;
import com.andrey.dslist.dtos.GameMinDTO;
import com.andrey.dslist.entities.Game;
import com.andrey.dslist.entities.GameList;
import com.andrey.dslist.repositories.GameListRepository;
import com.andrey.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = repository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        List<GameListDTO> dtos = result.stream().map(x->new GameListDTO(x)).toList();
        return dtos;
    }
}
