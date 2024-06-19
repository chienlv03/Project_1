package com.project.managerClass.Repository;

import com.project.managerClass.Entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    List<ClassRoom> findAllByTeacherId(Long teacherId);

    boolean existsByClassCode(String classCode);
}
