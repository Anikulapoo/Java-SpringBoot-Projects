package com.example.demo.service;

import com.example.demo.entity.Games;
import com.example.demo.error.GamesNotFoundException;
import com.example.demo.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Implements built in methods created in the controller class
@Service
public class GamesServiceImpl implements GamesService {
    @Autowired
    private GamesRepository gamesRepository;

    @Override
    public Games addGame(Games games) {
        return gamesRepository.save(games);
    }

    @Override
    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }

    @Override
    public Games findGameById(Integer id) throws GamesNotFoundException {
         Optional<Games> gamesOptional = gamesRepository.findById(id);
         if (!gamesOptional.isPresent()){
             throw new GamesNotFoundException("Id not found");
         }
         return gamesOptional.get();
    }

    @Override
    public Games deleteGame(Integer id) throws GamesNotFoundException {
        Optional<Games> deleteGameOptional = gamesRepository.findById(id);
        if (!deleteGameOptional.isPresent()){
            throw new GamesNotFoundException("Id not found");
        }
        Games deletedGame = deleteGameOptional.get();
        gamesRepository.delete(deletedGame);
        return deletedGame;
    }

    @Override
    public Games updateGame(Integer id, Games games) throws GamesNotFoundException {
        Optional<Games> updateGameoptional = gamesRepository.findById(id);
        if (!updateGameoptional.isPresent()){
            throw new GamesNotFoundException("Id not found");
        }
        Games gamesToUpdate = updateGameoptional.get();
        if (games.getCompany() != null){
            gamesToUpdate.setCompany(games.getCompany());
        }
        if(games.getName() != null){
            gamesToUpdate.setName(games.getName());
        }
        return gamesRepository.save(gamesToUpdate);
    }

    @Override
    public List<Games> findByCompany(String company) {
        return gamesRepository.findByCompanyIgnoreCase(company);
    }

    @Override
    public Games findByName(String name) {
        return gamesRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Games> findByNameAndCompany(String name, String company) {
        return gamesRepository.findByNameAndCompanyIgnoreCase(name,company);
    }

    @Override
    public List<Games> start(String company) {
        return gamesRepository.startStartingWith(company);
    }

//    @Override
//    public List<Games> gamesOrderBy(String company, String name) {
//        return gamesRepository.findByCompanyOrderByNameDesc(company,name);
//    }
}
