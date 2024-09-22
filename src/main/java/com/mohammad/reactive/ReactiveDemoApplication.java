package com.mohammad.reactive;

import com.mohammad.reactive.student.Student;
import com.mohammad.reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentService studentService
	) {
		return args -> {
			for(int i =0; i < 100; i++) {
				studentService.save(
						Student.builder()
								.firstName("Mohammad" + i)
								.lastname("Alabed" + i)
								.age(i)
						.build()
				);
			}
		};
	}
}
