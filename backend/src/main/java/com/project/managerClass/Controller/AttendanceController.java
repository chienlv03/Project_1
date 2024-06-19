package com.project.managerClass.Controller;

import com.project.managerClass.Entity.Attendance;
import com.project.managerClass.Entity.StudentClassroom;
import com.project.managerClass.Repository.StudentClassroomRepository;
import com.project.managerClass.payload.response.MessageResponse;
import com.project.managerClass.request.CreateAttendanceRequest;
import com.project.managerClass.request.UpdateAttendanceRequest;
import com.project.managerClass.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentClassroomRepository studentClassroomRepository;

    @PostMapping("/classroom/{classroomId}")
    public ResponseEntity<?> createAttendanceRecords(@PathVariable Long classroomId, @RequestBody CreateAttendanceRequest request) {
        List<StudentClassroom> studentClassrooms = studentClassroomRepository.findByClassroomId(classroomId);

        if (studentClassrooms.isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Lớp không có sinh viên"));
        }

        List<Attendance> attendances = attendanceService.createAttendanceRecords(classroomId, request.getAttendanceTime());
        return ResponseEntity.ok(attendances);
    }


    @PutMapping("/student/{studentId}/classroom/{classroomId}")
    public ResponseEntity<Attendance> updateAttendanceStatus(@PathVariable Long studentId,
                                                             @PathVariable Long classroomId,
                                                             @RequestBody UpdateAttendanceRequest updateAttendanceRequest) {
        Attendance attendance = attendanceService.updateAttendanceStatus(
                studentId,
                classroomId,
                updateAttendanceRequest.getAttendanceTime(),
                updateAttendanceRequest.getIsAbsent(),
                updateAttendanceRequest.getIsExcused()
        );
        return ResponseEntity.ok(attendance);
    }

    @GetMapping("/classroom/{classroomId}/times")
    public ResponseEntity<List<String>> getDistinctAttendanceTimesByClassroomId(@PathVariable Long classroomId) {
        List<String> attendanceTimes = attendanceService.getDistinctAttendanceTimesByClassroomId(classroomId);
        return ResponseEntity.ok(attendanceTimes);
    }

}
