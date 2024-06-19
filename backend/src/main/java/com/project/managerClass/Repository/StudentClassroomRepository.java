package com.project.managerClass.Repository;

import com.project.managerClass.Entity.StudentClassroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentClassroomRepository extends JpaRepository<StudentClassroom, Long> {
    List<StudentClassroom> findByClassroomId(Long classroomId);
    List<StudentClassroom> findByStudentId(Long studentId);

    Optional<StudentClassroom> findByStudentIdAndClassroomId(Long studentId, Long classroomId);

    void deleteByClassroomId(Long id);
}
