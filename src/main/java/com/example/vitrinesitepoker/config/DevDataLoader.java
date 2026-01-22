package com.example.vitrinesitepoker.config;

import com.example.vitrinesitepoker.model.Image;
import com.example.vitrinesitepoker.service.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")  // ne s'exécute que sur le profil dev
public class DevDataLoader implements CommandLineRunner {

    private final ImageService imageService;

    public DevDataLoader(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.save(new Image("Poker Table", "poker1.jpg"));
        imageService.save(new Image("VIP Lounge", "vip-lounge.jpg"));
        imageService.save(new Image("Roulette Wheel", "roulette.jpg"));
        imageService.save(new Image("Blackjack Table", "blackjack.jpg"));
        imageService.save(new Image("Casino Entrance", "casino-entrance.jpg"));
    }
}
