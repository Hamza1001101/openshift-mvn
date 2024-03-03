package org.farah.openshiftmvn;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {

    static List<Student> studentList = new ArrayList<>();

    static {

        studentList.add(new Student("32", "John", "Doe"));
        studentList.add(new Student(null, "Alice", "Smith"));
        studentList.add(new Student("34", "Bob", "Johnson"));
        studentList.add(new Student(null, "Emily", "Brown"));
        studentList.add(new Student(null, "Michael", "Davis"));
    }

    public List<Student> findAll() {
        return studentList;
    }

    public Optional<Student> findByName(String name) {
        return studentList.stream()
                .filter(student -> student.getFirstName().equals(name))
                .findFirst();
    }


}
