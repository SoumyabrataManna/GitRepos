drop table student;
drop table subject;


CREATE TABLE subject (id INT AUTO_INCREMENT PRIMARY KEY, name varchar(255) NOT NULL);
CREATE TABLE student (id INT AUTO_INCREMENT PRIMARY KEY, student_name varchar(255) NOT NULL, score FLOAT, subject_id INT REFERENCES subject(id));


