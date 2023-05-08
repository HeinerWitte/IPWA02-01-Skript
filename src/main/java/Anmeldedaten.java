import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class Anmeldedaten implements Serializable {
    
    private String name;
    private String passwort;
    
    
    public String getName()
    {
        return name;
    }
    
     public String getPasswort()
    {
        return passwort;
    }
     
     public void setName(String name) {
                this.name = name;
        } 
     
     
    public void setPassword(String passwort) {
                this.passwort = passwort;
        } 
     
    
    private static final Anmeldedaten instance = new Anmeldedaten();

    private final List<Benutzer> benutzerliste = new ArrayList<>();

    public Anmeldedaten()
    {

        benutzerliste.add(new Benutzer("Heiner", "1234"));
        benutzerliste.add(new Benutzer("Max", "4321"));
        benutzerliste.add(new Benutzer("Uschi", "0000"));
    
    }

    public static Anmeldedaten getInstance()
    {
        return instance;
    }

    public List<Benutzer> getBenutzerliste()
    {
        return benutzerliste;
    }
    
    public Anmeldedaten(String name, String passwort)
    {
        this.name = name;
        this.passwort = passwort;
    }
    
    
     public void postValidateName(ComponentSystemEvent ev)
            throws AbortProcessingException {
        UIInput temp = (UIInput)ev.getComponent();
        this.name = (String)temp.getValue();
    }
    
public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    
    List<Benutzer> benutzerliste = Anmeldedaten.getInstance().getBenutzerliste();
    for (Benutzer b : benutzerliste) {
        Benutzer temp = new Benutzer(this.name, (String) value);
        if (b.equals(temp))
            return;
    }
    throw new ValidatorException (new FacesMessage("Login falsch!"));
}
        
}


