package ru.itmo.razrab.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.itmo.razrab.persistence.model.ColorCat;

import java.util.Optional;

@Repository
public interface ColorCatRepository extends JpaRepository<ColorCat, Long> {
    Optional<ColorCat> findById(Long id);

    ColorCat findByNaim(String naim);
}
