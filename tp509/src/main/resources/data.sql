INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$oe4lY6mKDCx/' ||
                 '.QJLl79kzefrRJY//N0yRuruwaTqkWzfCjn2cvBg6', true);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');