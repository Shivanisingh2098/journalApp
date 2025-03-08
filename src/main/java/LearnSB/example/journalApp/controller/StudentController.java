package LearnSB.example.journalApp.controller;

import LearnSB.example.journalApp.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

  private List<Student> students = new ArrayList<>(
          List.of(
          new Student(1, "Navin", 60),
                    new Student(2, "Kiran", 65)
            ));


  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("/csrf-token")
  public CsrfToken getCsrfToken(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");

  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student) {
    students.add(student);
    return student;
  }

//  private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//  @GetMapping
//  public List<JournalEntry> getAll(){
//      return new ArrayList<>(journalEntries.values());
//  }
//
//  @PostMapping
//  public boolean createEntry(@RequestBody JournalEntry myEntry){
//      journalEntries.put(myEntry.getId(), myEntry);
//      return true;
//  }
//
//  @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//      return journalEntries.get(myId);
//  }
//
//  @DeleteMapping("id/{myId}")
//    public JournalEntry deleteById(@PathVariable Long myId){
//      return journalEntries.remove(myId);
//  }
//
//  @PutMapping("id/{myId}")
//  public JournalEntry updateEntry(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
//      return journalEntries.put(myId, myEntry);
//  }

}
