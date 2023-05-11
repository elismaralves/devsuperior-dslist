package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.dto.GameDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.Repositories.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        //Criar aqui futuramente, um tratamento de excessões de ERRO...
        //GameDTO dto = new GameDTO(result);
        return new GameDTO(result);
        //return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
        //return dto;
    }


}


