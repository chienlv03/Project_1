package com.project.managerClass.service;

import com.project.managerClass.Entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    ClassRoom createClassroom(ClassRoom classroom, Long teacherId);
    List<ClassRoom> getClassroomsByTeacherId(Long teacherId);

//    List<ClassRoom> getAllClassrooms();
    ClassRoom updateClassRoom(Long id, ClassRoom classRoomDetails);
    void deleteClassRoom(Long id);
}
