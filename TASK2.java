import java.util.*;

public class StudentGrade{

    public static void calculate(){

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the marks obtained in each subjects out of 100.");

    double maths;
    System.out.println("Enter marks obtained in MATHS :");
    maths = sc.nextDouble();

    double phy;    
    System.out.println("Enter marks obtained in PHYSICS :");
    phy = sc.nextDouble();

    double chemi;    
    System.out.println("Enter marks obtained in CHEMISTRY :");
    chemi = sc.nextDouble();

    double bio;    
    System.out.println("Enter marks obtained in BIOLOGY :");
    bio = sc.nextDouble();

    double eng;
    System.out.println("Enter marks obtained in ENGLISH :");
    eng = sc.nextDouble();

    double total = maths + phy + chemi + bio + eng;

    double per;

    per = total/5;

    String grade = null; 
  
    
    if (per >= 90) { 
        grade = "A"; 
    } else if ((per >= 85) && (per < 90)) { 
        grade = "B"; 
    } else if ((per >= 80) && (per < 85)) { 
        grade = "C"; 
    } else if ((per >= 70) && (per < 80)) { 
        grade = "D"; 
    } else if ((per >= 60) && (per < 70)) { 
        grade = "E"; 
    } else if ((per >= 50) && (per < 60)) { 
        grade = "Poor"; 
    } 

    System.out.println("Total marks obtained in each subjects is " + total);

    System.out.println("Average percentage is " + per);

    System.out.println("Grade is " + grade);

    sc.close();

    }
    
    public static void main(String args[]){
        calculate();
        
    }
    
}
