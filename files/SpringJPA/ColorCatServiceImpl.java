package ru.itmo.razrab.persistence.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.razrab.persistence.model.ColorCat;
import ru.itmo.razrab.persistence.repository.ColorCatRepository;
import ru.itmo.razrab.persistence.services.ColorCatService;

import java.util.Optional;

public class ColorCatServiceImpl implements ColorCatService {

    @Autowired
    public ColorCatRepository colorCatRepository;


    @Override
    public ColorCat findByNaim(String naim) {
        return colorCatRepository.findByNaim(naim);
    }

    @Override
    public Optional<ColorCat> findById(Long id) {
        return colorCatRepository.findById(id);
    }
}

