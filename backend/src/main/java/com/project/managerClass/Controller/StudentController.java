package com.project.managerClass.Controller;

import com.project.managerClass.Entity.Student;
import com.project.managerClass.request.StudentInforRequest;
import com.project.managerClass.request.StudentRequest;
import com.project.managerClass.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create/{classroomId}")
    public Student createStudent(@RequestBody Student student, @PathVariable Long classroomId) {
        return studentService.createStudent(student, classroomId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(id, studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{studentId}/{classroomId}")
    public ResponseEntity<?> deleteStudentFromClassroom(@PathVariable Long studentId, @PathVariable Long classroomId) {
        studentService.deleteStudentFromClassroom(studentId, classroomId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/classroom/{classroomId}")
    public List<StudentRequest> getStudentsByClassroom(@PathVariable Long classroomId) {
        return studentService.getStudentsByClassroom(classroomId);
    }

    @GetMapping("information/classroom/{classroomId}")
    public List<StudentInforRequest> getStudentsInfoByClassroom(@PathVariable Long classroomId) {
        return studentService.getStudentInforByClassroom(classroomId);
    }
}
