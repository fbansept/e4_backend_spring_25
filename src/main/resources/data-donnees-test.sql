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

INSERT INTO utilisateur (email, password, administrateur, actif)
VALUES ("a@a", "root", 1, 1),
       ("b@b", "root", 0, 1),
       ("c@c", "root", 0, 0);

INSERT INTO commande (date, utilisateur_id, status)
VALUES ("2025-02-12 13:10:04.000000", 2, 'ENVOYEE'),
       ("2025-02-1 10:10:04.000000", 2, 'PANIER');

INSERT INTO ligne_commande (quantite, prix_de_vente, produit_id, commande_id)
VALUES (1, 1399.99, 1, 1),
       (1, 1499.99, 1, 2),
       (2, 500, 2, 2);