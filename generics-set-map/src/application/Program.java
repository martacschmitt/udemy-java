package application;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many students for course A? ");
		int countStudents = sc.nextInt();
		
		Set<Integer> setCourseA = new TreeSet<Integer>();
		while (countStudents > 0) {
			int studentId = sc.nextInt();
			setCourseA.add(studentId);
			sc.nextLine();
			countStudents--;
		}
		
		System.out.print("How many students for course B? ");
		countStudents = sc.nextInt();
		
		Set<Integer> setCourseB = new TreeSet<Integer>();
		while (countStudents > 0) {
			int studentId = sc.nextInt();
			setCourseB.add(studentId);
			sc.nextLine();
			countStudents--;
		}
		
		System.out.print("How many students for course C? ");
		countStudents = sc.nextInt();
		
		Set<Integer> setCourseC = new TreeSet<Integer>();
		while (countStudents > 0) {
			int studentId = sc.nextInt();
			setCourseC.add(studentId);
			sc.nextLine();
			countStudents--;
		}
		
		Set<Integer> allStudents = new TreeSet<Integer>(setCourseA);
		allStudents.addAll(setCourseB);
		allStudents.addAll(setCourseC);
		
		System.out.println("Total students: " + allStudents.size());
		
		sc.close();

	}

}
