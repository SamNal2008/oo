import java.util.*;
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
    private Time time;
    private String venue;
    private ArrayList<Employee> part;
    private Scanner scan = new Scanner(System.in);
    private String trainerDetail;

    /**
     * Constructeur d'objets de classe Training
     */
    public Training(String cTname,int cmaxPartCount, String cvenue,String ctrainerDetail)
    {
        tName = cTname;
        date =  new Date(2019,6,5);
        maxPartCount = cmaxPartCount;
        time = new Time(0,0,0);
        venue = cvenue;
        part = new ArrayList<Employee>();
        trainerDetail = ctrainerDetail;
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
        Date date = new Date();
        System.out.println("Which year your training will take place ?");
        int year = scan.nextInt();
        date.setYear(year);
        
        System.out.println("Which month your training will take place ?");
        int month = scan.nextInt();
        date.setMonth(month);
        
        System.out.println("Which day your training will take place ?");
        int day = scan.nextInt();
        date.setDate(day);
        
        System.out.println(Calendar.getInstance().getTime());
        if(date.before(Calendar.getInstance().getTime()))
        {
            this.date = date;
            return true;
        }
        else
        {
            System.out.println("The date you entered is already past");
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
        System.out.println("How many hours your training will take ?");
        int hours = scan.nextInt();
        
        System.out.println("How many minutes your training will take ?");
        int minute = scan.nextInt();
        
        Time time = new Time(hours*3600000 + minute * 60);
        if(time.getHours()>0)
        {
            this.time = time;
            return true;
        }
        else
        {
            System.out.println("Your training time should be more than one hour");
            return false;
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
        System.out.println(ft.format(this.date));
        return this.date;
    }
    public int getMaxPartCount()
    {
        return this.maxPartCount;
    }
    public Time getTime()
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
