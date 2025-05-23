package com.andrey.dslist.services;

import com.andrey.dslist.dtos.GameDTO;
import com.andrey.dslist.dtos.GameMinDTO;
import com.andrey.dslist.entities.Game;
import com.andrey.dslist.projections.GameMinProjection;
import com.andrey.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x->new GameMinDTO(x)).toList();
        return dtos;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = repository.searchByList(listId);
        List<GameMinDTO> dtos = result.stream().map(x->new GameMinDTO(x)).toList();
        return dtos;
    }
}
