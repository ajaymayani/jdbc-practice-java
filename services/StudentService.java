package student_management.services;

import student_management.entities.Student;

import java.util.List;

public interface StudentService {

    //create
    Student insertStudent(Student student);

    //update
    Student updateStudent(Student student,int sId);

    //delete
    boolean deleteStudent(int sId);

    //get student by id;
    Student getStudent(int sId);

    //get all student
    List<Student> getStudent();
}
