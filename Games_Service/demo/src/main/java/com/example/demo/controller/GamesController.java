package com.example.demo.controller;

import com.example.demo.entity.Games;
import com.example.demo.error.GamesNotFoundException;
import com.example.demo.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
// Handles endpoints, update/get/delete...
public class GamesController {
//    Creates a log file of all activities
    public final Logger LOGGER = Logger.getLogger(String.valueOf(GamesController.class));

    @Autowired
    private GamesService gamesService;

//    Request body changes the java data into json format
//    PostMapping is an annotation for adding data into a database
    @PostMapping("/add")
    public Games addGame(@RequestBody Games games){
        LOGGER.info("inside of addGame of GameController");
        return gamesService.addGame(games);
    }

    @GetMapping("/all")
    public List<Games> getAllGames(){
        LOGGER.info("inside of getAllGames of GameController");
        return gamesService.getAllGames();
    }

    @GetMapping("/find/{id}")
    public Games findGameById(@PathVariable("id") Integer id) throws GamesNotFoundException {
        LOGGER.info("inside of findGameById of GameController");
        return gamesService.findGameById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Games deleteGame(@PathVariable("id") Integer id) throws GamesNotFoundException {
        LOGGER.info("inside of deleteGame of GameController");
        return gamesService.deleteGame(id);
    }

    @PutMapping("/update/{id}")
    public Games updateGame(@PathVariable("id")Integer id, @RequestBody Games games) throws GamesNotFoundException {
        LOGGER.info("inside of updateGame of GameController");
        return gamesService.updateGame(id, games);
    }

    @GetMapping("company/{company}")
    public List<Games> findByCompany(@PathVariable ("company") String company){
        LOGGER.info("inside of findByCompany of GameController");
        return gamesService.findByCompany(company);
    }

    @GetMapping("name/{name}")
    public Games findByName(@PathVariable("name") String name){
        LOGGER.info("inside of findByName of GameController");
        return gamesService.findByName(name);
    }

    @GetMapping("name/{name}/company/{company}")
    public List<Games> findByNameAndCompany(@PathVariable("name") String name,@PathVariable("company") String company){
        LOGGER.info("inside of findByNameAndCompany of GameController");
        return gamesService.findByNameAndCompany(name,company);
    }

    @GetMapping("starting/company/{company}")
    public List<Games> start(@PathVariable("company") String company){
        LOGGER.info("inside of startingWith of GameController");
        return gamesService.start(company);
    }
//    }
//
//    @GetMapping("/get")
//    public Games getGame(@RequestBody Games games){
//
//    }
//
//    @DeleteMapping("/delete")
//    public Games deleteGame(@RequestBody Games games){
//
//    }
}
