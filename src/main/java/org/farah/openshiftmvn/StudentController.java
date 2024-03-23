package org.farah.openshiftmvn;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }


    /*@PostMapping
    private ResponseEntity<Void> save(@RequestBody Student student) {
        Student saved = studentRepository.save(student);
        var location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }*/

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
