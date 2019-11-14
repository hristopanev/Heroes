package com.panev.heroes.data.repositrories;

import com.panev.heroes.data.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroesRepository extends JpaRepository<Hero, String> {
    Optional<Hero> getByNameIgnoreCase(String name);
}
