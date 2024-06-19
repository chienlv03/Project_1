package com.project.managerClass.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentAbsenceDTO {
    private Long studentId;
    private int unexcusedAbsenceCount;
    private int excusedAbsenceCount;
}
