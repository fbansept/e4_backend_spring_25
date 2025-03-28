INSERT INTO etat (designation)
VALUES ('statisfaisant'),
       ('neuf'),
       ('mauvais');

INSERT INTO produit (prix, code, description, nom, etat_id, disponible)
VALUES ('1499.99', 'bagueor', 'une bague en or', 'bague', 2, 1),
       ('500', 'boshperc', 'une perceuse bosh', 'perceuse', 3, 1),
       ('1', 'VS42', 'un produit sans etiquette', 'vis', 1, 1);

INSERT INTO etiquette (designation, couleur)
VALUES ('st valentin', 'red'),
       ('homme', 'blue'),
       ('femme', 'pink'),
       ('promo', '#e98f9d');


INSERT INTO etiquette_produit (produit_id, etiquette_id)
VALUES (1, 3),
       (1, 1),
       (2, 1),
       (2, 2),
       (2, 4);

INSERT INTO utilisateur (email, password, administrateur, actif)
VALUES ("a@a", "$2a$10$vplRMIHJw4/ZPhFqBBYfiOzIkM7dLmdU4EOvRSWWW23VaRiowCpcO", 1, 1),
       ("b@b", "$2a$10$vplRMIHJw4/ZPhFqBBYfiOzIkM7dLmdU4EOvRSWWW23VaRiowCpcO", 0, 1),
       ("c@c", "$2a$10$vplRMIHJw4/ZPhFqBBYfiOzIkM7dLmdU4EOvRSWWW23VaRiowCpcO", 0, 0);

INSERT INTO commande (date, utilisateur_id, status)
VALUES ("2025-02-12 13:10:04.000000", 2, 'ENVOYEE'),
       ("2025-02-1 10:10:04.000000", 2, 'PANIER');

INSERT INTO ligne_commande (quantite, prix_de_vente, produit_id, commande_id)
VALUES (1, 1399.99, 1, 1),
       (1, 1499.99, 1, 2),
       (2, 500, 2, 2);


alter table etiquette_produit
    drop foreign key FK_produit_etiquette;

alter table etiquette_produit
    drop foreign key FK_etiquette_produit;

DROP INDEX FK_produit_etiquette ON etiquette_produit;
DROP INDEX FK_etiquette_produit ON etiquette_produit;

alter table etiquette_produit
    add constraint FK_produit_etiquette
        foreign key (produit_id) references produit (id)
            on update cascade on delete cascade;

alter table etiquette_produit
    add constraint FK_etiquette_produit
        foreign key (etiquette_id) references etiquette (id)
            on update cascade on delete cascade;

