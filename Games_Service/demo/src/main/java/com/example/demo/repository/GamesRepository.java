package com.example.demo.repository;

import com.example.demo.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Handles custom made methods using existing jpa methods
public interface GamesRepository extends JpaRepository<Games, Integer> {

    public List<Games> findByCompanyIgnoreCase(String company);

    public Games findByNameIgnoreCase(String name);

    public List<Games> findByNameAndCompanyIgnoreCase(String name, String company);

//    public List<Games> findByCompanyOrderByNameDesc(String company, String name);

    public List<Games> startStartingWith (String company);
}
