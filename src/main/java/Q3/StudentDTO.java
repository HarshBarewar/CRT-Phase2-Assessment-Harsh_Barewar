package Q3;

//DTO
import jakarta.validation.constraints.*;

public class StudentDTO {
 @NotBlank(message = "Name must not be blank")
 private String name;

 @Min(value = 18, message = "Age must be 18 or above")
 private int age;

 // Getters & Setters
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public int getAge() { return age; }
 public void setAge(int age) { this.age = age; }
}

//Controller
@RestController
@RequestMapping("/api/students")
public class StudentController {

 @PostMapping
 public ResponseEntity addStudent(
         @Valid @RequestBody StudentDTO dto,
         BindingResult result) {

     if (result.hasErrors()) {
         String errorMsg = result.getFieldErrors().stream()
             .map(e -> e.getField() + ": " + e.getDefaultMessage())
             .collect(Collectors.joining(", "));
         return ResponseEntity.badRequest().body(errorMsg);
     }
     // Save logic here...
     return ResponseEntity.status(HttpStatus.CREATED).body("Student created");
 }
}