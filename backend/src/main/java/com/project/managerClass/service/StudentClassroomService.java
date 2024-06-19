package com.project.managerClass.service;

import com.project.managerClass.request.StudentAbsenceDTO;

import java.util.List;

public interface StudentClassroomService {
//    StudentClassroom enrollStudentInClassroom(Long studentId, Long classroomId);

//    List<ClassRoom> getClassroomsForStudent(Long studentId);

//    List<Student> getStudentsInClassroom(Long classroomId);

    // Lấy ra số ần vắng của mỗi học sinh trong 1 lớp
    List<StudentAbsenceDTO> getAbsencesForClassroom(Long classroomId);

    // Xóa học sinh khỏi lớp
//    void removeStudentFromClassroom(Long studentId, Long classroomId);
}
