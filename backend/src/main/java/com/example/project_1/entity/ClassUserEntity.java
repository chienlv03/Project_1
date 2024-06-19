package com.example.project_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ClassUser")
public class ClassUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "classId")
    private ClassEntity classId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "attendanceId")
    private AttendanceEntity attendanceId;

    @ManyToOne
    @JoinColumn(name = "applicationId")
    private LeaveApplicationsEntity applicationId;
}
