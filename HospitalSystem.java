import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

class Patient {
    String firstName;
    String lastName;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Queue<Patient> patientQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Show All Patients");
            System.out.println("3. Quit");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the patient's first name: ");
                        String firstName = scanner.next();
                        System.out.print("Enter the patient's last name: ");
                        String lastName = scanner.next();
                        Patient patient = new Patient(firstName, lastName);
                        patientQueue.add(patient);
                        System.out.println("Patient added to the queue successfully.");
                        break;
                    case 2:
                        if (patientQueue.isEmpty()) {
                            System.out.println("No patients in the queue.");
                        } else {
                            ArrayList<Patient> sortedPatients = new ArrayList<>(patientQueue);
                            Collections.sort(sortedPatients, (p1, p2) -> p2.lastName.compareTo(p1.lastName));

                            System.out.println("Patients in Descending Order of Last Name:");
                            for (Patient p : sortedPatients) {
                                System.out.println(p);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Thank you for using the Hospital Management System. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option (1, 2, or 3).");
                scanner.nextLine();
            }
        }
    }
}