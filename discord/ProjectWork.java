/**
* Class: Student
* Attributes: Name, GPA
* Class: Project
* Attributes: Question, grade

Create 5 students and 10 projects for each student
* Assign grades for all projects on 100 points basis
* Convert the average grade a student into a GPA update.  GPA can be from 0 to 4 only.
* Display all students with their individual grades, their averages and their final GPA
*/

import java.util.Random; /* for the project grading */

public class ProjectWork {
   public static void main(String[] args){
   final int NUM_STUDENTS = 5;
   final int NUM_PROJECTS = 10;
   final String[] studentNames = new String[] {"One", "Two", "Three", "Four", "Five"};
   final String[] studentProjectQuestions= new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
   /* code goes here */
   
   Student[] studentArr = new Student[NUM_STUDENTS];
   Project[] projectArr = new Project[NUM_PROJECTS];
   for(int h=0; h<NUM_STUDENTS; h++){
   /* create a bunch of projects for the student */
      for(int i=0; i<NUM_PROJECTS; i++){
         Random tempGrade = new Random();
         int projectGrade = tempGrade.nextInt(100) + 1;
         projectArr[i] = new Project(studentProjectQuestions[i], projectGrade);
      }
      /* setting a bogus GPA first... since GPA will be calculated in the student class constructor */
      studentArr[h] = new Student(studentNames[h], 0.0, projectArr);
      }
   }

}