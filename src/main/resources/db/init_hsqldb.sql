

INSERT INTO users (id, firstname, lastname, email, password, enabled) VALUES
  (1, 'alex', 'pol', 'alex@mail.by', '$2a$11$ggB8UibIY.jeD1r5DNgvrugANRRLxwVqHzDq7v2GRZiZG5wlTKiyq', TRUE),
   (2,'vasya','pupkin','vasya@yandex.by','$2a$11$aNUWEtr1Extaf2n0KhjcCe3n1ZZ.MqjnDf1LfPKavj.EuomYvxahG', TRUE);
INSERT INTO role (id, name) VALUES (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN');
INSERT INTO privilege (id, name) VALUES (1, 'READ'),
  (2, 'WRITE'), (3, 'UPDATE');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 1),
  (2, 1), (2, 2), (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2),
(2,1);



INSERT INTO train (id, type) VALUES
  (1, 'HIGH_SPEED'),
  (2, 'HIGH_SPEED'),
  (3, 'PASSENGER'),
  (4, 'PASSENGER'),
  (5, 'PASSENGER'),
  (6, 'PASSENGER'),
  (7, 'PASSENGER'),
  (8, 'PASSENGER'),
  (9, 'FAST'),
  (10, 'FAST');


INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (1, 1, 'Vitebsk', NULL, '06:31:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (2, 2, 'Minsk', '10:04:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (3, 1, 'Minsk', NULL, '16:43:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (4, 2, 'Vitebsk', '20:23:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (5, 1, 'Vitebsk', NULL, '08:15:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (6, 2, 'Mogilev', '11:41:00', '12:13:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (7, 3, 'Gomel', '15:58:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (8, 1, 'Gomel', NULL, '13:45:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (9, 2, 'Mogilev', '17:35:00', '18:22:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (10, 3, 'Vitebsk', '21:51:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (11, 1, 'Grodno', NULL, '19:57:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (12, 2, 'Brest', '08:40:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (13, 1, 'Brest', NULL, '17:15:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (14, 2, 'Grodno', '05:50:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (15, 1, 'Vitebsk', NULL, '15:53:00');
INSERT INTO station (id, position, name, time_arrival, time_departure)
VALUES (16, 2, 'Mogilev', '19:40:00', '20:02:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (17, 3, 'Gomel', '00:05:00', '00:42:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (18, 4, 'Brest', '08:40:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (19, 1, 'Brest', NULL, '17:02:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (20, 2, 'Gomel', '00:47:00', '01:20:00');
INSERT INTO station (id, position, name, time_arrival, time_departure)
VALUES (21, 3, 'Mogilev', '05:42:00', '06:17:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (22, 4, 'Vitebsk', '09:55:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (23, 1, 'Vitebsk', NULL, '23:18:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (24, 2, 'Minsk', '03:38:00', '03:53:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (25, 3, 'Brest', '08:18:00', NULL);
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (26, 1, 'Brest', NULL, '14:05:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (27, 2, 'Minsk', '18:27:00', '18:42:00');
INSERT INTO station (id, position, name, time_arrival, time_departure) VALUES (28, 3, 'Vitebsk', '23:13:00', NULL);


INSERT INTO train_station (station_id, train_id) VALUES (1, 1);
INSERT INTO train_station (station_id, train_id) VALUES (2, 1);
INSERT INTO train_station (station_id, train_id) VALUES (3, 2);
INSERT INTO train_station (station_id, train_id) VALUES (4, 2);
INSERT INTO train_station (station_id, train_id) VALUES (5, 3);
INSERT INTO train_station (station_id, train_id) VALUES (6, 3);
INSERT INTO train_station (station_id, train_id) VALUES (7, 3);
INSERT INTO train_station (station_id, train_id) VALUES (8, 4);
INSERT INTO train_station (station_id, train_id) VALUES (9, 4);
INSERT INTO train_station (station_id, train_id) VALUES (10, 4);
INSERT INTO train_station (station_id, train_id) VALUES (11, 5);
INSERT INTO train_station (station_id, train_id) VALUES (12, 5);
INSERT INTO train_station (station_id, train_id) VALUES (13, 6);
INSERT INTO train_station (station_id, train_id) VALUES (14, 6);
INSERT INTO train_station (station_id, train_id) VALUES (15, 7);
INSERT INTO train_station (station_id, train_id) VALUES (16, 7);
INSERT INTO train_station (station_id, train_id) VALUES (17, 7);
INSERT INTO train_station (station_id, train_id) VALUES (18, 7);
INSERT INTO train_station (station_id, train_id) VALUES (19, 8);
INSERT INTO train_station (station_id, train_id) VALUES (20, 8);
INSERT INTO train_station (station_id, train_id) VALUES (21, 8);
INSERT INTO train_station (station_id, train_id) VALUES (22, 8);
INSERT INTO train_station (station_id, train_id) VALUES (23, 9);
INSERT INTO train_station (station_id, train_id) VALUES (24, 9);
INSERT INTO train_station (station_id, train_id) VALUES (25, 9);
INSERT INTO train_station (station_id, train_id) VALUES (26, 10);
INSERT INTO train_station (station_id, train_id) VALUES (27, 10);
INSERT INTO train_station (station_id, train_id) VALUES (28, 10);


INSERT INTO days_of_week (scheduler_id, day_of_week, queue_position) VALUES
  (1, 'MONDAY', 1), (1, 'WEDNESDAY', 2), (1, 'FRIDAY', 3),
  (2, 'MONDAY', 1), (2, 'WEDNESDAY', 2), (2, 'FRIDAY', 3),
  (3, 'MONDAY', 1), (3, 'WEDNESDAY', 2), (3, 'FRIDAY', 3),
  (4, 'MONDAY', 1), (4, 'WEDNESDAY', 2), (4, 'FRIDAY', 3),
  (5, 'TUESDAY', 1), (5, 'SATURDAY', 2),
  (6, 'TUESDAY', 1), (6, 'SATURDAY', 2),
  (7, 'TUESDAY', 1), (7, 'SATURDAY', 2),
  (8, 'WEDNESDAY', 1), (8, 'SUNDAY', 2),
  (9, 'WEDNESDAY', 1), (9, 'SUNDAY', 2),
  (10, 'WEDNESDAY', 1), (10, 'SUNDAY', 2),
  (11, 'FRIDAY', 1), (12, 'SATURDAY', 1),
  (13, 'TUESDAY', 1), (14, 'WEDNESDAY', 1),
  (15, 'TUESDAY', 1), (15, 'THURSDAY', 2), (15, 'SUNDAY', 3),
  (16, 'TUESDAY', 1), (16, 'THURSDAY', 2), (16, 'SUNDAY', 3),
  (17, 'WEDNESDAY', 1), (17, 'FRIDAY', 2), (17, 'MONDAY', 3),
  (18, 'WEDNESDAY', 1), (18, 'FRIDAY', 2), (18, 'MONDAY', 3),
  (19, 'MONDAY', 1), (19, 'WEDNESDAY', 2), (19, 'FRIDAY', 3),
  (20, 'TUESDAY', 1), (20, 'THURSDAY', 2), (20, 'SATURDAY', 3),
  (21, 'TUESDAY', 1), (21, 'THURSDAY', 2), (21, 'SATURDAY', 3),
  (22, 'TUESDAY', 1), (22, 'THURSDAY', 2), (22, 'SATURDAY', 3),
  (23, 'WEDNESDAY', 1), (23, 'SUNDAY', 2),
  (24, 'THURSDAY', 1), (24, 'MONDAY', 2),
  (25, 'THURSDAY', 1), (25, 'MONDAY', 2),
  (26, 'THURSDAY', 1), (26, 'SUNDAY', 2),
  (27, 'THURSDAY', 1), (27, 'SUNDAY', 2),
  (28, 'THURSDAY', 1), (28, 'SUNDAY', 2);


