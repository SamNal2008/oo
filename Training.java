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
    private Time time;
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
        date =  new Date(2019,6,5);
        maxPartCount = cmaxPartCount;
        time = new Time(0,0,0);
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
        
        Date date = new Date(year,month,day);
        Date date2 = new Date(2019,6,4);
        
        // tests if date 2 is before date and print
        boolean before = date2.before(date);
        System.out.println("Date 2 is before date: " + before);
        
        // tests if date is before date 2 and print
        before = date.before(date2);
        System.out.println("Date is before date 2: " + before);

        
        System.out.println(date2);
        if(date.after(date2))
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
        
        Time time = new Time(hours,minute,0);
        if(hours!=0)
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
