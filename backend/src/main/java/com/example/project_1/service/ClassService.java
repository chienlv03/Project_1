package com.example.project_1.service;

import com.example.project_1.entity.ClassEntity;

import java.util.List;

public interface ClassService {
    ClassEntity createClass(ClassEntity classEntity);

    List<ClassEntity> getAllClasses();

    ClassEntity updateClass(Long classId, ClassEntity updateClass);

    void deleteClass(Long classId);
}
