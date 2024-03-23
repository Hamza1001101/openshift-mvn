package org.farah.openshiftmvn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Document("students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
  //  @Id
    String id;
    String firstName;
    String lastName;
}