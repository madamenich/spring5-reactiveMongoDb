package com.advance.springwebflux.service;

import com.advance.springwebflux.model.Student;
import com.advance.springwebflux.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;

    public Flux<Student> getAllStudent(){
        return studentRepository.findAll().switchIfEmpty(Flux.empty());
    }
    public Mono<Student> getById(final  String id){
        return studentRepository.findById(id);

    }
    public Mono updateStudent(final String id, final Student student){
        return studentRepository.findById(id)
                .map(student1 -> student)
                .flatMap(this::save);
    }
    public Mono save( final Student student){
        return studentRepository.save(student);

    }

    public Mono delete (final String id){
        return studentRepository.deleteById(id);
    }


}
