import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager=new StudentManager();
        Scanner input=new Scanner(System.in);

        int choice;

        do { 
            System.out.println("\n1. Add Student");
            System.out.println("2.Display All Students");
            System.out.println("3.Search Student by ID");
            System.out.println("4. Save and Exit");
            System.out.println("Enter Choice");     

        try{
            choice=input.nextInt();
            switch (choice) {
                case 1:
                manager.addStudent();
                    break;
                case 2:
                manager.displayAllStudents();
                    break;
                case 3:
                manager.searchStudent();
                    break;
                case 4:
                manager.saveToFile();
                System.out.println("Exiting....");
                break;
                default:
                    System.err.println("Invalid choice");
            }
        }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid number");

                input.nextLine();
                choice=0;

            }
        }    
            while(choice!=4);

        }
    } 
