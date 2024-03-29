import java.util.*;
import java.sql.Time;
import java.io.*;
/**
 * Décrivez votre classe MasterList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MasterList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public ArrayList<Training> trainList;
    private Scanner scan = new Scanner(System.in);
    /**
     * Constructeur d'objets de classe MasterList
     */
    public MasterList()
    {
        trainList = new ArrayList<Training>();
    }

    public boolean addTraining()
    {
        System.out.println("Please enter the name of the training that you want to add");
        String cname = scan.nextLine();
        System.out.println("Please enter the maximum number of participants");
        int cmaxPartCount = scan.nextInt();
        System.out.println("Please enter the venue of the training");
        scan.nextLine();
        String cvenue = scan.nextLine();
        System.out.println("Please enter the trainer details");
        String cTrainerDetail = scan.nextLine();
        Training training = new Training(cname,cmaxPartCount,cvenue,cTrainerDetail);
        if(!(training.getTName()==null))//retournera null de toutes facons vu qu'on ne l'initialise pas
        {
            this.trainList.add(training);
            return true;
        }
        else
        {
            System.out.println("Your training does not have a name !");
            return false;
        }
    }
    
    public boolean removeTraining()
    {
        System.out.println("What is the name of the training that you want to remove");
        String nameToRemove = scan.nextLine();
        int i=0;
        while(i<this.trainList.size())
        {
            if(nameToRemove.equals(this.trainList.get(i).getTName()))
            {
                if(this.trainList.get(i).getNumberOfPart()==0)
                {
                    this.trainList.remove(this.trainList.get(i));
                    return true;
                }
                else
                {
                    System.out.println("Sorry but you can not delete a training which has participants");
                    return false;
                }
            }
            i++;
        }
        System.out.println("Sorry we did not find your training in the traininig list maybe it does not exist");
        return false;
    }
    
    public ArrayList<Training> upcomingList()
    {
        ArrayList<Training> upcomingList = new ArrayList<Training>();
        Date today = new Date();
        today = Calendar.getInstance().getTime();
        for(int i = 0;i<this.trainList.size();i++)
        {
            if(today.before(this.trainList.get(i).getDate()))
            {
                upcomingList.add(this.trainList.get(i));
            }
        }
        return upcomingList;
    }
    
    public ArrayList<Training> pastList()
    {
        ArrayList<Training> pastList = new ArrayList<Training>();
        Date today = new Date();
        today = Calendar.getInstance().getTime();
        for(int i = 0;i<this.trainList.size();i++)
        {
            if(today.after(this.trainList.get(i).getDate()))
            {
                pastList.add(this.trainList.get(i));
            }
        }
        return pastList;
    }
    
    public Training searchTraining()
    {
        System.out.println("What is the name of the training that you are looking for");
        String nameToSearch = scan.nextLine();
        int i =0;
        while(i<this.trainList.size())
        {
            if(nameToSearch.equals(this.trainList.get(i).getTName()))
            {
                return this.trainList.get(i);
            }
            i++;
        }
        System.out.println("Sorry this training doesn't exist");
        return null;
    }
    
    private String clac_string(String ok)
    {
        String ret = ok;
        while(ret.length() < 28)
        {
            ret = ret + " ";
        }
        return ret;
    }
    
    public void print_training(ArrayList<Training> List,boolean upcoming)
    {
        String last = "";
        if(upcoming)
        {
            last = "registrations";
            
        }
        else
        {
            last = "Total participants";
        }
        System.out.println("Name                        |Date                        |Venue                       |Trainer Details             |Max participants            |Duration                    |"+clac_string(last)+"|");
        System.out.println("----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|");
        for(int i = 0; i < List.size(); i++)
        {

            System.out.print(clac_string(List.get(i).getTName()));
            System.out.print("|"+List.get(i).getDate());
            System.out.print("|"+clac_string(List.get(i).getVenue()));
            System.out.print("|"+clac_string(List.get(i).getTrainerDetail()));
            System.out.print("|"+clac_string(Integer.toString(List.get(i).getMaxPartCount())));
            System.out.print("|"+clac_string(List.get(i).getTime()));
            if(upcoming)
            {
                if(List.get(i).getNumberOfPart()!= 0)
                {
                    for(int j = 0; j < List.get(i).getNumberOfPart(); j++)
                    {
                        if(j==0)
                        {
                            String employ1 = List.get(i).getPartOfTraining().get(j).getEName() +"/"+List.get(i).getPartOfTraining().get(j).getDepartement();
                            System.out.println("|"+clac_string(employ1)+"|");
                        }
                        else
                        {
                            String employx = List.get(i).getPartOfTraining().get(j).getEName() +"/"+List.get(i).getPartOfTraining().get(j).getDepartement();
                            System.out.print("                            |                            |                            |                            |                            |                            ");
                            System.out.println("|"+clac_string(employx)+"|");
                        }
                    }
                }
                else
                {
                    System.out.println("|                            |");
                }
            }
            else
            {
                System.out.println("|"+clac_string(Integer.toString(List.get(i).getNumberOfPart())));
            }
            System.out.println("----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|----------------------------|");
        }
    }
}
