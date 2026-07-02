package net.javatuts.student_management_system.service;

import jakarta.validation.Valid;
import net.javatuts.student_management_system.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long studentId);
}
