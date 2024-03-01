package org.farah.openshiftmvn;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static  List<Student> studentList = new ArrayList<>();
    static {

        studentList.add(new Student("John", "Doe", 20, "S001"));
        studentList.add(new Student("Alice", "Smith", 22, "S002"));
        studentList.add(new Student("Bob", "Johnson", 21, "S003"));
        studentList.add(new Student("Emily", "Brown", 19, "S004"));
        studentList.add(new Student("Michael", "Davis", 23, "S005"));
    }

    public List<Student> findAll() {
        return studentList;
    }

    public Optional<Student> findByName(String name) {
        return studentList.stream()
                .filter(student -> student.firstName().equals(name))
                .findFirst();
    }


}
