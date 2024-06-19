package com.project.managerClass.request;

import com.project.managerClass.Entity.Enum.AttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequest {
    private String attendanceTime;
    private AttendanceStatus status;
}
