import java.util.*;
import java.sql.Time;
/**
 * Décrivez votre classe UI ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UI
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    
    private static Scanner action = new Scanner(System.in);
    /**
     * Constructeur d'objets de classe UI
     */
    public static void myProgram()
    {
        // initialisation des variables d'instance
        System.out.println("Hello and welcome in our TAS program ");
        System.out.println("-------------------------------------");
        nextAction();
    }
    public static void printMenu()
    {
        System.out.println("What would you like to do ?");
        System.out.println("1.	Add a training program to the list ");
        System.out.println("2.	Delete a training program from the list (only if no registered participants) ");
        System.out.println("3.	Register participants for a training program ");
        System.out.println("4.	Remove participants from a training program ");
        System.out.println("5.	Search for a training program ");
        System.out.println("6.	List upcoming training programs (include participant information if any) ");
        System.out.println("7.	List past training programs (include participant information if any) ");
        System.out.println("8.	Exit ");
    }
    public static void nextAction()
    {
        printMenu();
        int choice = action.nextInt();
        MasterList trainList = new MasterList();
        while(choice != 8)
        {
            if(choice==1)
            {
                if(trainList.addTraining())
                {
                    System.out.println("Your training has been added successfully !");
                }
                else
                {
                    System.out.println("Sorry your training could not been add in the training list");
                }
            }
            if(choice==2)
            {
                if(trainList.removeTraining())
                {
                    System.out.println("Your training has been removed successfully !");
                }
                else
                {
                    System.out.println("Sorry your training could not been removed in this training list");
                }
            }
            if(choice==3)
            {   
                if(trainList.searchTraining().addPartToTraining())
                {
                    System.out.println("The employee has been added to the training !");
                }
                else
                {
                    System.out.println("Sorry your employee could not been added in this training");
                }
            }
            if(choice==4)
            {
                /*if(trainList.searchTraining())
                {
                    System.out.println("Your training has been added successfully !");
                }
                else
                {*/
                    System.out.println("Sorry your training could not been add in the training list");
                
            }
            if(choice==5)
            {
                if(trainList.addTraining())
                {
                    System.out.println("Your training has been added successfully !");
                }
                else
                {
                    System.out.println("Sorry your training could not been add in the training list");
                }
            }
            if(choice==6)
            {
                trainList.print_training(trainList.upcomingList());
            }
            if(choice==7)
            {
                trainList.print_training(trainList.pastList());
            }
                
            printMenu();
            choice = action.nextInt();
        }
        System.out.println("Thank you for using our program see you soon !");

    }
        

    
}


