package org.farah.openshiftmvn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    String id;
    String firstName;
    String lastName;
}