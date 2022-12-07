/**
* Class: Student
* Attributes: Name, GPA
* Class: Project
* Attributes: Question, grade
*/

public class Student {
   final int NUM_PROJECTS = 10;
   private String name;
   private double GPA; /* 0-4, needs to be converted from project score 0-100 to 0-4, e.g., sum(projectScore)/10/25 */
   Project[] projectArr = new Project[NUM_PROJECTS];
   
   Student(String name, double GPA, Project[] projectArr){
      this.name = name;
      this.GPA = GPA;
      this.projectArr = projectArr;
      calculateGPA();
   }
   
   public void setGPA(double gpa){
      GPA = gpa;
   }
      
   public double getGPA(){
      return GPA;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public String getName(){
      return name;
   }
   
   public void calculateGPA() {
      int sum = 0;
      for(int i=0; i<NUM_PROJECTS; i++){
         sum += this.projectArr[i].grade;   
      }
      this.GPA = (sum/10.0)/25.0;
      
      System.out.println("Student: " + this.name + ", GPA: " + String.format("%.2f", this.GPA));
      System.out.print("Project scores: ");
      for(int i=0;i<NUM_PROJECTS;i++){
         System.out.print(this.projectArr[i].grade + " ");
      }
      System.out.println("");
   }
}