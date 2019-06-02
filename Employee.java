
/**
 * Décrivez votre classe Employee ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Employee
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int employeeNumber;
    private String eName;
    private String departement;
    
    /**
     * Constructeur d'objets de classe Employee
     */
    public Employee()
    {
       // initialisation des variables d'instance
       eName = null;
       employeeNumber = 0;
       departement = null;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    
    public boolean setEName(String eName)
    {
        if(eName.length()<15)
        {
          this.eName = eName;
          return true;  
        }
        else
        {
            return false;
        }
    }
    
    public boolean setEmployeeNumber(int employeeNumber)
    {
        if(employeeNumber>0)
        {
          this.employeeNumber = employeeNumber;
          return true;  
        }
        else
        {
            return false;
        }
    }
    
    public boolean setDepartement(String departement)
    {
        if(departement.length()>2)
        {
          this.departement = departement;
          return true;  
        }
        else
        {
            return false;
        }
    }
    
    public int getEmployeeNumber()
    {
        return this.employeeNumber;
    }
    
     public String getEName()
    {
        return this.eName;
    }
    
     public String getDepartement()
    {
        return this.departement;
    }
    
    
    
}
