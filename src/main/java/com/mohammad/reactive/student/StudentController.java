package com.mohammad.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public Flux<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getById(id);
    }
}
