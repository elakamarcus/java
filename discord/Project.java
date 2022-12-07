/**
* Class: Student
* Attributes: Name, GPA
* Class: Project
* Attributes: Question, grade
*/

public class Project {
   public String question;
   public int grade; /* 0-100 */
   
   
   Project(String question, int grade){
      this.question = question;
      this.grade = grade;
   }
}