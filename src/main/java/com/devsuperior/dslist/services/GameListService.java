package com.devsuperior.dslist.services;

import com.devsuperior.dslist.Repositories.GameListRepository;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return result.stream().map(x -> new GameListDTO(x)).toList();
        //return dto;
    }


}


