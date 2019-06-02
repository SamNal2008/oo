import java.util.*;
import java.sql.Time;
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

    /**
     * Constructeur d'objets de classe Training
     */
    public Training()
    {
        // initialisation des variables d'instance
        tName = null;
        date =  new Date(2019,6,2);
        maxPartCount = 0;
        time = new Time(0,0,0);
        venue = null;
        part = new ArrayList<Employee>();
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
            Employee employee = new Employee();
            this.part.add(employee);
            return true;
        }
        else
        {
            System.out.println("Sorry but you reached the limit of participants");
            return false;
        }
    }
    
    
    
    
    //get Part
    public String getTName()
    {
        return this.tName;
    }
    public Date getDate()
    {
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
    
    
    
    
    
    
    
    
    
    
}
