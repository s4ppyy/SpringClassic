package ru.itmo.razrab.persistence.services;

import ru.itmo.razrab.persistence.model.ColorCat;
import java.util.Optional;

public interface ColorCatService {

    ColorCat findByNaim(String naim);
    Optional<ColorCat> findById(Long id);

}
