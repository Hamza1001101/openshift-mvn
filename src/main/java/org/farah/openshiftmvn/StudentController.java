package org.farah.openshiftmvn;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
