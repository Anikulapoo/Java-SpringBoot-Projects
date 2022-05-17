package com.example.demo.service;

import com.example.demo.entity.Games;
import com.example.demo.error.GamesNotFoundException;

import java.util.List;

// Handles custom made methods
public interface GamesService  {

    public Games addGame(Games games);

    public List<Games> getAllGames();

    public Games findGameById(Integer id) throws GamesNotFoundException;

    Games deleteGame(Integer id) throws GamesNotFoundException;

    Games updateGame(Integer id, Games games) throws GamesNotFoundException;

    List<Games> findByCompany(String company);

    Games findByName(String name);

    List<Games> findByNameAndCompany(String name, String company);

//    List<Games> gamesOrderBy(String company, String name);

    List<Games> start(String company);
}
