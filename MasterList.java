import java.util.*;
import java.sql.Time;
/**
 * Décrivez votre classe MasterList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MasterList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList<Training> trainList;

    /**
     * Constructeur d'objets de classe MasterList
     */
    public MasterList()
    {
        // initialisation des variables d'instance
        trainList = new ArrayList<Training>();
    }

  
    public boolean addTraining()
    {
        Training training = new Training();
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
        Training training = new Training();
        int i=0;
        while(i<this.trainList.size())
        {
            if(training.getTName()==trainList.get(i).getTName())
            {
                if(trainList.get(i).getNumberOfPart()==0)
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
            if(today.after(this.trainList.get(i).getDate()))
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
            if(today.before(this.trainList.get(i).getDate()))
            {
                pastList.add(this.trainList.get(i));
            }
        }
        return pastList;
    }
    
    public Training searchTraining()
    {
        Training training = new Training();
        int i =0;
        while(i<this.trainList.size())
        {
            if(training==this.trainList.get(i))
            {
                return this.trainList.get(i);
            }
            i++;
        }
        System.out.println("Sorry this training doesn't exist");
        return null;
    }
}
