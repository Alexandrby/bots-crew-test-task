--  TABLE Degree
INSERT INTO public.degree (id, title)
VALUES (1, 'ASSISTANT');
INSERT INTO public.degree (id, title)
VALUES (2, 'ASSOCIATE_PROFESSOR');
INSERT INTO public.degree (id, title)
VALUES (3, 'PROFESSOR');

--  TABLE Department
INSERT INTO public.department (id, name)
VALUES (1, 'TO');
INSERT INTO public.department (id, name)
VALUES (2, 'MO');
INSERT INTO public.department (id, name)
VALUES (3, 'EKO');
INSERT INTO public.department (id, name)
VALUES (4, 'MFU');

--  TABLE Lectors
INSERT INTO public.lector (id, name, salary)
VALUES (1, 'Иванов Иван Иваныч', 435);
INSERT INTO public.lector (id, name, salary)
VALUES (2, 'Олегов Олег Олегович', 215);
INSERT INTO public.lector (id, name, salary)
VALUES (3, 'Карпин Валейри Яковлевич', 195);
INSERT INTO public.lector (id, name, salary)
VALUES (4, 'Петров Петр Петрович', 564);
INSERT INTO public.lector (id, name, salary)
VALUES (5, 'Сидоров Василий Иванович', 789);
INSERT INTO public.lector (id, name, salary)
VALUES (6, 'Андреев Андрей Андреевич', 564);
INSERT INTO public.lector (id, name, salary)
VALUES (7, 'Колин Николай Николаевич', 235);

--  TABLE Lector-Department
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (1,1);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (2,1);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (3,2);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (4,2);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (5,3);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (6,3);
INSERT INTO public.lector_departments (lector_id, department_id)
VALUES (7,4);

--  TABLE Degree-Lectors
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (1,1);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (1,2);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (1,3);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (2,4);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (2,5);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (3,6);
INSERT INTO public.degree_lectors (degree_id, lector_id)
VALUES (3,7);




