import java.util.*;

public class Employee
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String employeeNumber;
    private String eName;
    private String departement;
    
    /**
     * Constructeur d'objets de classe Employee
     */
    public Employee(String ceName,String cDepartement)
    {
       // initialisation des variables d'instance
       employeeNumber = UUID.randomUUID().toString();
       //System.out.println(this.employeeNumber);
       eName = ceName;
       departement = cDepartement;
    }
    
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
    
    public String getEmployeeNumber()
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
