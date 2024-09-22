package com.mohammad.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// flux mean list of object
// mono mean single object

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> getAll() {
        return studentRepository.findAll();
    }

    public Mono<Student> getById(int id) {
        return studentRepository.findById(id);
    }
}
