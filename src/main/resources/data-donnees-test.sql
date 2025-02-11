INSERT INTO etat (designation)
VALUES ('statisfaisant'),
       ('neuf'),
       ('mauvais');

INSERT INTO produit (prix, code, description, nom, etat_id)
VALUES ('1499.99', 'bagueor', 'une bague en or', 'bague', 2),
       ('500', 'boshperc', 'une perceuse bosh', 'perceuse', 3);

INSERT INTO etiquette (designation)
VALUES ('st valentin'),
       ('homme'),
       ('femme'),
       ('promo');


INSERT INTO etiquette_produit (produit_id, etiquette_id)
VALUES (1, 3),
       (1, 1),
       (2, 1),
       (2, 2),
       (2, 4);

