package com.example.vitrinesitepoker.service;

import com.example.vitrinesitepoker.model.Image;
import java.util.List;
import java.util.Optional;

public interface ImageService {
    List<Image> getAllImages();
    Optional<Image> getImage(int id);

    void save(Image image);
}

