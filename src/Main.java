import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHi, AttendanceApp!\n");

        //Customized welcome message
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name  = sc.nextLine();
        System.out.println("Welcome, " + name + "!");

        // Create and output List of absences
        ArrayList<Integer> absences = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < name.length() ; i++) {
            absences.add(rand.nextInt(11));


        }
        System.out.println("The elements are: " + absences);

        //Number of students with perfect attendance
        int countPerfect = 0;
        for (int i = 0; i < name.length(); i++) {
            if (absences.get(i)==0);{
                countPerfect++;

            }
            System.out.println(countPerfect + " students had perfect absences.");
        }

        // calculate average of absences
        double avg = average(absences);
        System.out.println("\nThe average number of absences is " + avg);

        // calculate the sum


        // Percentage of the number of fewer then 3 absences and perfect absences
        double checkAttendance = numOfAbsences(absences,3);
        System.out.println("The number of absences fewer then 3: " + checkAttendance);

    }

    private static double numOfAbsences(ArrayList<Integer> absences, int numOfElements ) {
        int countAbsences = 0;
        for (int i = 0; i < absences.size(); i++) {
            if(numOfElements < absences.get(i) ){
                countAbsences++;
            }
        }
        return countAbsences;



    }


    private static double average(ArrayList<Integer> absences) {
        return (double) sum(absences)/ absences.size();

    }

    private static int sum(ArrayList<Integer>absences){
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = sum + absences.get(i);
        }
        return sum;
    }
}
