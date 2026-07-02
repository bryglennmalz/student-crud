package net.javatuts.student_management_system.service.impl;

import net.javatuts.student_management_system.dto.StudentDto;
import net.javatuts.student_management_system.entity.Student;
import net.javatuts.student_management_system.mapper.StudentMapper;
import net.javatuts.student_management_system.repository.StudentRepository;
import net.javatuts.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream
                ().map(StudentMapper::maptoStudentDto).toList();
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student does not exist with given id: " + studentId));;
        StudentDto studentDto = StudentMapper.maptoStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }


}
