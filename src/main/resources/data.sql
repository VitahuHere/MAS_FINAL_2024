INSERT INTO Custom_User (login, name, surname, private_email, summary, birth_date, password)
VALUES ('student', 'name', 'surname', 'email@gmail.com', 'summary', '2000-01-01', 'password'),
       ('student1', 'name1', 'surname1', 'email1@gmail.com', 'summary1', '2000-01-01', 'password1'),
       ('lecturer', 'name', 'surname', 'email2@gmail.com', 'summary', '2000-01-01', 'password'),
       ('lecturer1', 'name1', 'surname1', 'email3@gmail.com', 'summary1', '2000-01-01', 'password1');

INSERT INTO user_roles (custom_user_login, roles)
VALUES ('student', 'STUDENT'),
       ('student1', 'STUDENT'),
       ('lecturer', 'LECTURER'),
       ('lecturer1', 'LECTURER');

INSERT INTO Course (id, name, description, created_at, updated_at, lecturer_login)
VALUES (10001, 'name', 'description', '2024-01-01', '2024-01-01', 'lecturer'),
       (10002, 'name1', 'description1', '2024-01-01', '2024-01-01', 'lecturer1');

INSERT INTO Access (id, purchase_date, course_id, student_login)
VALUES (10001, '2024-01-01', 10001, 'student'),
       (10002, '2024-01-01', 10002, 'student1');
