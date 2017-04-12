DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

ALTER SEQUENCE meals_id_seq RESTART WITH 1;

INSERT INTO meals (user_id, description, calories, datetime) VALUES
  ('100000', 'Breakfast', 500, '2017-04-11 10:00'),
  ('100000',  'Lunch', 1000, '2017-04-11 14:00'),
  ('100000',  'Dinner', 500, '2017-04-11 20:34'),
  ('100000',  'Breakfast', 500, '2017-04-12 10:00'),
  ('100000',  'Lunch', 1000, '2017-04-12 14:00'),
  ('100000',  'Dinner', 510, '2017-04-13 20:34'),
  ('100001',  'Lunch', 1000, '2017-04-13 14:00'),
  ('100001',  'Dinner', 510, '2017-04-13 20:34');
