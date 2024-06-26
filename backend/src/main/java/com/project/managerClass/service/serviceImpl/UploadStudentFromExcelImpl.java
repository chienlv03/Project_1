package com.project.managerClass.service.serviceImpl;

import com.project.managerClass.Entity.Student;
import com.project.managerClass.Entity.StudentClassroom;
import com.project.managerClass.Repository.StudentClassroomRepository;
import com.project.managerClass.Repository.StudentRepository;
import com.project.managerClass.Repository.ClassRoomRepository;
import com.project.managerClass.service.UploadStudentFromExcel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UploadStudentFromExcelImpl implements UploadStudentFromExcel {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentClassroomRepository studentClassroomRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public void saveStudentsFromExcel(MultipartFile file, Long classroomId) throws IOException {
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row currentRow : sheet) {
                if (currentRow.getRowNum() == 0) { // skip header row
                    continue;
                }

                Student student = new Student();
                student.setStudentCode(currentRow.getCell(0).getStringCellValue());
                student.setStudentName(currentRow.getCell(1).getStringCellValue());
                student.setDob(currentRow.getCell(2).getStringCellValue());
                student.setGender(currentRow.getCell(3).getStringCellValue());
                student.setEmail(currentRow.getCell(4).getStringCellValue());

                Student savedStudent = studentRepository.save(student);

                StudentClassroom studentClassroom = new StudentClassroom();
                studentClassroom.setStudent(savedStudent);
                studentClassroom.setClassroom(classRoomRepository.findById(classroomId).orElseThrow(() -> new RuntimeException("Classroom not found")));
                studentClassroomRepository.save(studentClassroom);
            }
        }
    }
}
