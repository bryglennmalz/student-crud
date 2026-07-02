package net.javatuts.student_management_system.mapper;

import net.javatuts.student_management_system.dto.StudentDto;
import net.javatuts.student_management_system.entity.Student;

public class StudentMapper {

    public static StudentDto maptoStudentDto(Student student){
        StudentDto studentDto = new StudentDto(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getEmail()
        );
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
        return student;
    }
}
