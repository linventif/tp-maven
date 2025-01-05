-- data.sql
INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$oe4lY6mKDCx/.QJLl79kzefrRJY//N0yRuruwaTqkWzfCjn2cvBg6', true);
INSERT INTO users (username, password, enabled)
VALUES ('paul', '{MD5}6c63212ab48e8401eaf6b59b95d816a9', true);
INSERT INTO users (username, password, enabled)
VALUES ('pierre', '{noop}pierre', true);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
VALUES ('paul', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('pierre', 'ROLE_USER');