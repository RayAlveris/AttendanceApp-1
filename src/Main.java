import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHi, AttendanceApp!\n");

        //Customized welcome message
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + "!");

        // Create and output List of absences
        ArrayList<Integer> absences = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < name.length(); i++) {
            absences.add(rand.nextInt(11));


        }
        System.out.println("\nThe elements are: " + absences);

        //Number of students with perfect attendance
        int countPerfect = 0;
        for (int i = 0; i < name.length(); i++) {
            if (absences.get(i) == 0) ;
            {
                countPerfect++;

            }
            System.out.println(countPerfect + " students had perfect absences.");
        }

        // calculate average of absences
        double avg = average(absences);
        System.out.println("\nThe average number of absences is " + avg);

        // calculate the sum


        // Percentage of the number of fewer then 3 absences and perfect absences
        double checkAttendance = numOfAbsences(absences, 3);
        System.out.println("The number of absences fewer then 3: " + checkAttendance);

        //index(es) of the students who had a specified number of absences.
        System.out.println("Enter number of absences: ");
        int studAbsences = sc.nextInt();
        ArrayList<Integer> indexesOfStudents = indexOfStud(absences, studAbsences);
        System.out.println("The index: " + indexesOfStudents + " had number of: " + studAbsences + " absences");

        // students have FE'd the course
        ArrayList<Integer> FEStudents = numOfStudentsFE(absences, 3);
        System.out.println("The students who FE'd: " + FEStudents);

        //percentage of the students have FE'd the course
        double nonFED = avgFED(FEStudents, absences);
        System.out.printf("Formatted %d divided by %d is %.2f%%", FEStudents.size(), absences.size(), nonFED);


    }

    private static double avgFED(ArrayList<Integer>absences,ArrayList<Integer>FEStudents){
        double avg= (double)FEStudents.size()/(double)absences.size();
        return avg;
    }

    private static ArrayList<Integer> numOfStudentsFE(ArrayList<Integer> absences, int classMeet) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if(absences.get(i) >= classMeet );
                num.add(i);
        }
        return num;
    }

    private static ArrayList<Integer> indexOfStud (ArrayList<Integer> array, int studAbsences) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i)==(studAbsences)){
                indexes.add(i);
            }
        }
        return indexes;
    }

    private static double numOfAbsences(ArrayList<Integer> absences, int numOfElements) {
        int countAbsences = 0;
        int countPerfect = 0;

        for (int i = 0; i < absences.size(); i++) {
            if (numOfElements > absences.get(i)) {
                countAbsences++;
                if (absences.get(i) == 0) {
                    countPerfect++;
                }

            }


        }
        return (double) countPerfect / countAbsences;


    }


    private static double average(ArrayList<Integer> absences) {
        return (double) sum(absences) / absences.size();

    }

    private static int sum(ArrayList<Integer> absences) {
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = sum + absences.get(i);
        }
        return sum;
    }
}
