CREATE TABLE IMAGE (
                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                       TITRE VARCHAR(255),
                       URL VARCHAR(255)
);

INSERT INTO IMAGE (TITRE, URL) VALUES ('Poker Table', 'poker1.jpg');
INSERT INTO IMAGE (TITRE, URL) VALUES ('Blackjack Night', 'blackjack.jpg');
INSERT INTO IMAGE (TITRE, URL) VALUES ('Roulette Wheel', 'roulette.jpg');
INSERT INTO IMAGE (TITRE, URL) VALUES ('VIP Lounge', 'vip-lounge.jpg');
INSERT INTO IMAGE (TITRE, URL) VALUES ('Casino Entrance', 'casino-entrance.jpg');