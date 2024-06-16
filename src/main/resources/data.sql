INSERT INTO Custom_User (login, name, surname, private_email, summary, birth_date, password)
VALUES ('marks1', 'Marks', 'Engel', 'email@gmail.com', 'summary', '2000-01-01', 'password'),
       ('jp2omg', 'Jean', 'Pavlo', 'email1@gmail.com', 'summary1', '2000-01-01', 'password1'),
       ('lecturer', 'name', 'surname', 'email2@gmail.com', 'summary', '2000-01-01', 'password');

INSERT INTO USER_ROLES (custom_user_login, roles)
VALUES ('marks1', 'STUDENT'),
       ('jp2omg', 'STUDENT'),
       ('lecturer', 'LECTURER');

INSERT INTO Course (id, name, description, created_at, updated_at, lecturer_login)
VALUES (10001, 'Java 101', 'Learn Java from zero to hero', '2024-01-01', '2024-04-16', 'lecturer'),
       (10002, 'Python 101', 'Learn Python from zero to true master', '2023-11-12', '2024-02-22', 'lecturer'),
       (10003, 'Python master course', 'Python for experienced users', '2023-10-11', '2024-01-22', 'lecturer');

INSERT INTO TASK (id, content, status, title)
VALUES (10001, 'example content', 1, 'for loops'),
       (10002, 'content1', 2, 'for loops - before while'),
       (10003, 'content2', 0, 'while loops');

INSERT INTO COURSE_TASK (task_id, course_id)
VALUES (10001, 10001),
       (10002, 10001),
       (10003, 10001);

INSERT INTO Access (id, purchase_date, course_id, student_login)
VALUES (10001, '2024-01-01', 10001, 'marks1'),
       (10002, '2024-01-01', 10001, 'jp2omg');

INSERT INTO OPINION (id, comment, score, course_id, student_id)
VALUES (10001, 'Excellent course!', 5, 10001, 'marks1'),
       (10002, 'Informative but misleading in places', 4, 10001, 'jp2omg');

INSERT INTO TUTORIAL (id, difficulty)
VALUES (10001, 1),
       (10002, 2),
       (10003, 3),
       (10004, 4);

INSERT INTO TEXT_TUTORIAL (text, id)
VALUES ('In this tutorial we will cover some of the most important', 10001),
       ('Hopefully you get the grasp of OOP now. Let’s move on', 10002);

INSERT INTO VIDEO_TUTORIAL (extension, video_url, id)
VALUES ('mp4', 'https://edukaczka.com/video/123', 10003),
       ('mp4', 'https://edukaczka.com/video/123', 10004);

INSERT INTO VIDEO_EXPLAINED_TUTORIAL(TEXT, ID)
VALUES ('Here are some key moments that will help you understand the topic better', 10004);

INSERT INTO COURSE_TUTORIAL (tutorial_id, course_id)
VALUES (10001, 10001),
       (10002, 10001),
       (10003, 10001),
       (10004, 10001);
