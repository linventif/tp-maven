CREATE TABLE utilisateurs
(
    login VARCHAR(50) NOT NULL,
    mdp   VARCHAR(50) NOT NULL,
    dat   DATE        NOT NULL,
    ip    VARCHAR(15) NOT NULL,
    PRIMARY KEY (login)
);

INSERT INTO utilisateurs (login, mdp, dat, ip)
VALUES ('admin', 'admin', '2020-01-01', '127.0.0.1'),
       ('user', 'user', '2020-01-01', '127.0.0.1'),
       ('test', 'test', '2020-01-01', '127.0.0.1');
