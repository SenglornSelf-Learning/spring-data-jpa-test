CREATE TABLE student (
         id BIGINT AUTO_INCREMENT PRIMARY KEY,
         first_name TEXT NOT NULL,
         last_name TEXT NOT NULL,
         email VARCHAR(100) NOT NULL UNIQUE,
         age INT NOT NULL
);

CREATE TABLE student_id_card (
         id BIGINT AUTO_INCREMENT PRIMARY KEY,
         student_id BIGINT NOT NULL UNIQUE,
         card_number VARCHAR(20) NOT NULL UNIQUE,
         FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);

CREATE TABLE book (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          student_id BIGINT NOT NULL,
          book_name TEXT NOT NULL,
          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
          FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);

CREATE TABLE course (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name TEXT NOT NULL,
        department TEXT NOT NULL
);

CREATE TABLE enrollment (
        student_id BIGINT NOT NULL,
        course_id BIGINT NOT NULL,
        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (student_id, course_id),
        FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
        FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
);
