package com.advance.springwebflux.controller;


import com.advance.springwebflux.dto.StudentDto;
import com.advance.springwebflux.mapper.StudentMapper;
import com.advance.springwebflux.model.Student;
import com.advance.springwebflux.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private  final StudentMapper mapper;
    private final StudentService studentService;


    @GetMapping
    public Flux<Student> findAll(){

        return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable String id){
        return studentService.getById(id);
    }
    @PostMapping
    public Mono<Student> addStudent(@RequestBody StudentDto studentDto){
        Student student = mapper.toModel(studentDto);

        return studentService.save(student);
    }
    @PutMapping("/{id}")
    public Mono<Student> update(@PathVariable String id,StudentDto studentDto){
        Student student = mapper.toModel(studentDto);
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return studentService.delete(id);
    }

}
