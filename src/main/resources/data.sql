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
VALUES (10001, '2024-01-01', 10001, 'student'),
       (10002, '2024-01-01', 10002, 'student1');
