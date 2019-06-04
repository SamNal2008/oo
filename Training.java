import java.util.*;
import java.text.*;
import java.sql.Time;
import java.text.*;
/**
 * Décrivez votre classe Training ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Training
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String tName;
    private Date date;
    private int maxPartCount;
    private String time;
    private String venue;
    public ArrayList<Employee> part;
    private Scanner scan = new Scanner(System.in);
    private String trainerDetail;

    /**
     * Constructeur d'objets de classe Training
     */
    public Training(String cTname,int cmaxPartCount, String cvenue,String ctrainerDetail)
    {
        tName = cTname;
        date =  null;
        maxPartCount = cmaxPartCount;
        venue = cvenue;
        part = new ArrayList<Employee>();
        trainerDetail = ctrainerDetail;
        setDate();
        setTime();
    }
    
    
    //SetPart
    public boolean setTName(String tName)
    {
        if(tName.length()>1)
        {
            this.tName = tName;
            return true;
        }
        else
        {
            System.out.println("Your training name is not valid");
            return false;
        }
    }
    public boolean setDate()
    {
        System.out.println("Which year your training will take place ?");
        int year = scan.nextInt();

        System.out.println("Which month your training will take place ?");
        int month = scan.nextInt();

        
        System.out.println("Which day your training will take place ?");
        int day = scan.nextInt();
        scan.nextLine();

        Date date = new Date(year-1900,month-1,day);

        if(date.after(Calendar.getInstance().getTime()))

        {
            this.date = date;
            return true;
        }
        else
        {
            System.out.println("The date you entered is already past");
            this.date= date;
            return false;
        }
    }
    public boolean setMaxPartCount(int maxPartCount)
    {
        if(maxPartCount>0)
        {
            this.maxPartCount = maxPartCount;
            return true;
        }
        else
        {
            System.out.println("The maximum of the participant should be higher than 0");
            return false;
        }
    }
    public boolean setTime()
    {
        System.out.println("How many days your training will take ?");
        String days = scan.nextLine();
        
        System.out.println("How many hours your training will take ?");
        String hours = scan.nextLine();
        
        
        String time = days + " day(s) " + hours + " hour(s)" ;

        if(hours!=null)

        {
            this.time = time;
            return true;
        }
        else
        {
            System.out.println("Your training time should be more than one hour");
            return setTime();
        }
    }
    public boolean setVenue(String venue)
    {
        if(venue.length()>1)
        {
            this.venue = venue;
            return true;
        }
        else
        {
            System.out.println("Your training venue is not valid");
            return false;
        }
    }
    public boolean addPartToTraining()
    {
        if(this.part.size()<this.maxPartCount)
        {
            System.out.println("What is the name of the employee that you want to add ?");
            String cename = scan.nextLine();
            System.out.println("What is the departement of your employee ?");
            String cdepartement = scan.nextLine();
            Employee employee = new Employee(cename,cdepartement);
            this.part.add(employee);
            return true;
        }
        else
        {
            System.out.println("Sorry but you reached the limit of participants");
            return false;
        }
    }
    
    public boolean removePart()
    {
        System.out.println("Enter the name of the employee that you want to remove : ");
        String participant = scan.nextLine();
        int i = 0;
        /*Date today = new Date();
        today = Calendar.getInstance().getTime();
        if(this.date)*/
        while(i<this.getNumberOfPart())
        {
            if(participant.equals(this.part.get(i).getEName()))
            {
                this.part.remove(this.part.get(i));
                System.out.println("The Employee has been deleted");
                return true;
            }
            i++;
            
        }
        System.out.println("Sorry the employee has not been found");
        return false;
    }
    
    public boolean setTrainerDetail(String trainerDetail)
    {
        if(trainerDetail.length()>3)
        {
            this.trainerDetail = trainerDetail;
            return true;
        }
        else
        {
            System.out.println("Your trainer details are not correct");
            return false;
        }
    }
    
    public boolean removePartFromTraining()
    {
        System.out.println("What is the employee number that you want to remove from this training ?");
        String employeeToRemove = scan.nextLine();
        int i=0;
        if(this.part.size()==0)
        {
            System.out.println("There is no participant in this training");
            return false;
        }
        
        while(i<this.part.size())
        {
            if(!(employeeToRemove==this.part.get(i).getEmployeeNumber()))
            {
                this.part.remove(this.part.get(i));
                System.out.println(employeeToRemove + "has been removed from the training");
                return true;
            }
                i++;
         }
          System.out.println("Sorry we did not find this employee in the training");
          return false;
    }
    
    //get Part
    public String getTName()
    {
        return this.tName;
    }
    public Date getDate()
    {

        SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd ");
        //System.out.println(ft.format(this.date));

        return this.date;

    }
    public int getMaxPartCount()
    {
        return this.maxPartCount;
    }
    public String getTime()
    {
        return this.time;
    }
    public String getVenue()
    {
        return this.venue;
    }
    public ArrayList<Employee> getPartOfTraining()
    {
        return this.part;
    }
    public int getNumberOfPart()
    {
        return this.part.size();
    }
    public String getTrainerDetail()
    {
        return this.trainerDetail;
    }
    
    
    
    
    
    
    
    
    
    
}
