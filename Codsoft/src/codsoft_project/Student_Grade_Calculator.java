package codsoft_project;

import java.util.Scanner;

public class Student_Grade_Calculator {
	
	public static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }
	
	public static double Avg(int totalMarks, int sub) {
        return (double) totalMarks / (sub * 100) * 100;
    }
	
	public static String calculateGrade(double avg) {
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80 && avg<90) {
            return "A";
        } else if (avg >= 70 && avg<80) {
        	return "B";
        } else if (avg >= 60 && avg<70) {
        	return "C";
        } else if (avg >= 40 && avg<60) {
        	return "D";
        } else {
            return "F";
        }
    }
	
	public static void displayResults(int totalMarks, double avg, String grade) {
        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.printf("Percentage: %.2f%%\n", avg);
        System.out.println("Grade: " + grade);
        
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Number of Subjects: ");
		int sub =sc.nextInt();
		
		int marks[] = new int[sub];
		
		for(int i=0;i<sub;i++) {
			System.out.print("Enter marks obtained in subject "+(i+1)+": ");
			marks[i]=sc.nextInt();
		}
		
        int totalMarks = calculateTotalMarks(marks);
        double avg = Avg(totalMarks, sub);
        String grade = calculateGrade(avg);
        displayResults(totalMarks, avg, grade);
		
	}
	
}