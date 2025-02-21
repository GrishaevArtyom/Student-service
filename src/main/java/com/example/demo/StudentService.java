package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    void save(Student student){studentRepository.save(student);}

    void delete(int id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid user Id: " + id));
        studentRepository.delete(student);
    }

    public Student getById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
    }

    public void update(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }
}
