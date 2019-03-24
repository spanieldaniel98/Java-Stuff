public class Student {
	
    private String firstName, lastName;
    private double gpa, semgpa;
    private long factor;

    public Student(String firstName, String lastName) {
           this.firstName = firstName;
           this.lastName = lastName;

           semesterGPA();
   }
    
    public void semesterGPA() {
         factor = (long) Math.pow(10, 2);
         semgpa = Math.round(Math.random()*4.0*factor);
         gpa = (double) semgpa/factor;
    }

   public String getInfo() {
        return "Name = " +this.firstName+" "+this.lastName+" "+this.gpa;
   }
   
   public double getGPA() {
        return gpa;
   }

   public String getFirstName() {
        return firstName;
   }
}