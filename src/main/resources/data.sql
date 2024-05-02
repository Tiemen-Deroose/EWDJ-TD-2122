DELETE FROM wedstrijdticket;
DELETE FROM stadium;
DELETE FROM wedstrijd;
DELETE FROM users;
DELETE FROM authorities;

INSERT INTO stadium (id, naam) VALUES (1, "Al Bayt Stadium");
INSERT INTO stadium (id, naam) VALUES (2, "Al Thumama Stadium");
INSERT INTO stadium (id, naam) VALUES (3, "Khalifa International Stadium");
INSERT INTO stadium (id, naam) VALUES (4, "Ahmad Bin Ali Stadium");
													/* YYYYMMDD HH:MM:SS */
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('1', '2022-11-25 21:00:00', 'België', 'Canada');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('2', '2022-11-26 18:00:00', 'Brazilië', 'Zwitserland');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('3', '2022-11-27 15:00:00', 'Marroko', 'Kroatië');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('4', '2022-11-27 18:00:00', 'Spanje', 'Duitsland');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('5', '2022-11-29 15:00:00', 'Frankrijk', 'Denemarken');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('6', '2022-11-29 18:00:00', 'Argentinië', 'Mexico');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('7', '2022-11-30 18:00:00', 'Engeland', 'USA');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('8', '2022-11-30 21:00:00', 'Nederland', 'Qatar');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('9', '2022-11-21 18:00:00', 'Engeland', 'Iran');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('10', '2022-11-23 15:00:00', 'Duitsland', 'Japan');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('11', '2022-11-25 21:00:00', 'Nederland', 'Ecuador');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('12', '2022-12-01 15:00:00', 'Japan', 'Spanje');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('13', '2022-11-22 21:00:00', 'USA', 'Qatar');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('14', '2022-11-24 18:00:00', 'Tunesië', 'Polen');
INSERT INTO wedstrijd (id, datum, landA, landB) VALUES ('15', '2022-12-02 21:00:00', 'Senegal', 'Servië');

INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('1', '35', '1', '1');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('2', '21', '1', '2');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('3', '5', '1', '3');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('4', '95', '2', '4');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('5', '45', '2', '5');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('6', '10', '1', '6');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('7', '22', '1', '7');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('8', '16', '2', '8');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('9', '28', '3', '9');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('10', '3', '3', '10');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('11', '71', '3', '11');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('12', '43', '3', '12');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('13', '14', '4', '13');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('14', '120', '4', '14');
INSERT INTO wedstrijdticket (id, tickets, stadium_id, wedstrijd_id) VALUES ('15', '0', '4', '15');

INSERT INTO users(username,password,enabled)
VALUES('user', '$2a$10$RWl3N4kOp2S4mwFKA0GZQuDu8UnmW8eNteQs9MRaO3KgqbSMYTGzK', '1'),('admin', '$2a$10$RWl3N4kOp2S4mwFKA0GZQuDu8UnmW8eNteQs9MRaO3KgqbSMYTGzK', '1');

INSERT INTO authorities(username,authority) 
VALUES ('user', 'ROLE_USER'),('admin', 'ROLE_ADMIN'),('admin', 'ROLE_USER');