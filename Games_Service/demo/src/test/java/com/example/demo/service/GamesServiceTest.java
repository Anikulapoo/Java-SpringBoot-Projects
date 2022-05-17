package com.example.demo.service;

import com.example.demo.entity.Games;
import com.example.demo.error.GamesNotFoundException;
import com.example.demo.repository.GamesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GamesServiceTest {

    @Autowired
    private GamesService gamesService;

    @MockBean
    private GamesRepository gamesRepository;

    @BeforeEach
    void setUp() {
        Games games = Games.builder()
                .name("FIFA")
                .company("EA Sports")
                .id(1).build();

        Mockito.when(gamesService.findByName("FIFA"))
                .thenReturn(games);
    }

    @Test
    public void whenValidGameName_thenGameShouldFound() {
        String name = "FIFA";
        Games found = gamesService.findByName(name);

        assertEquals(name, found.getName());
    }
}