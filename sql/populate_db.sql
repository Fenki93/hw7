INSERT INTO WORKER (NAME, BIRTHDATE, LEVEL, SALARY)
VALUES ('King', '2010-09-03', 'Junior', 700),
       ('Santa', '2005-05-01', 'Middle', 1400),
       ('Claus', '2000-06-02', 'Senior', 2800),
       ('Bruce', '2013-02-02', 'Trainee', 500),
       ('Willis', '2011-04-04', 'Junior', 750),
       ('Alise', '2014-05-05', 'Middle', 5000),
       ('Vik', '1973-04-08', 'Senior', 9000),
       ('Tor', '1973-04-08', 'Middle', 9000),
       ('Ajax', '1983-01-18', 'Senior', 8500),
       ('Bill', '1993-01-18', 'Junior', 550);

INSERT INTO CLIENT (NAME)
VALUES ('Nasa'),
       ('Nato'),
       ('Microsoft'),
       ('IBM'),
       ('Apple');

INSERT INTO PROJECT (CLIENT_ID, NAME, START_DATE, FINISH_DATE)
VALUES (1, 'Project A', NOW(), DATEADD(MONTH, +10, NOW())),
       (2, 'Project B', NOW(), DATEADD(MONTH, +7, NOW())),
       (1, 'Project C', NOW(), DATEADD(MONTH, +17, NOW())),
       (4, 'Project D', NOW(), DATEADD(MONTH, +21, NOW())),
       (5, 'Project E', NOW(), DATEADD(MONTH, +3, NOW())),
       (1, 'Project F', NOW(), DATEADD(MONTH, +12, NOW())),
       (2, 'Project J', NOW(), DATEADD(MONTH, +26, NOW())),
       (3, 'Project K', NOW(), DATEADD(MONTH, +26, NOW())),
       (5, 'Project L', NOW(), DATEADD(MONTH, +8, NOW())),
       (5, 'Project M', NOW(), DATEADD(MONTH, +6, NOW()));

INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 10),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4),
       (5, 10),
       (5, 9),
       (6, 8),
       (6, 7),
       (8, 1),
       (9, 2),
       (9, 3),
       (10, 4),
       (10, 10);