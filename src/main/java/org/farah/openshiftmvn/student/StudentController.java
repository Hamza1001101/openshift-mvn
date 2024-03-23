package org.farah.openshiftmvn.student;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final StudentService studentService;
    final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/mongo")
    private List<Student> findAllMongo() {
        return studentRepository.findAll();
    }

    @PostMapping
    private ResponseEntity<Void> save(@RequestBody Student student) {
        Student saved = studentRepository.save(student);
        var location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    private List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{name}")
    private ResponseEntity<Student> findByName(@PathVariable String name) {
        return studentService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
