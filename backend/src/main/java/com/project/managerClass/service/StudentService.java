package com.project.managerClass.service;

import com.project.managerClass.Entity.Student;
import com.project.managerClass.request.StudentInforRequest;
import com.project.managerClass.request.StudentRequest;

import java.util.List;


public interface StudentService {
    Student createStudent(Student student, Long classroomId);

//    List<Student> getAllStudents();

//    Optional<Student> getStudentById(Long id);

    Student updateStudent(Long id, Student studentDetails);

    List<StudentRequest> getStudentsByClassroom(Long classroomId);

    List<StudentInforRequest> getStudentInforByClassroom(Long classroomId);

    void deleteStudentFromClassroom(Long studentId, Long classroomId);
}
