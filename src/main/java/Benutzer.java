import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Named
@ApplicationScoped
public class Benutzer implements Serializable
{
    private String name;
    private String passwort;
    
    private Object benutzer;
   
        
    public Benutzer()
    {
    }

    public Benutzer(String name, String passwort)
    {
        this.name = name;
        this.passwort = passwort;
    }

  
   
   @Override
    public boolean equals(Object obj) {
    if (obj instanceof Anmeldedaten) {
        Anmeldedaten b = (Anmeldedaten) obj;
        if (b.getName().equals(this.name) &&
                b.getPasswort().equals(this.passwort))
            return true;
    }
    return false;
}  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.passwort);
        return hash;
    }
  
   
    public String login() {
        List<Benutzer> benutzerliste = Anmeldedaten.getInstance().getBenutzerliste();
        for (Benutzer b : benutzerliste) {
            if (b.equals(this.benutzer))
                return "index.xhtml" ;
        }
        return "login.xhtml" ;
    }  
   
    
}
