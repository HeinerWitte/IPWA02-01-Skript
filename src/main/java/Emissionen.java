
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;



@Entity
@Inheritance
        (strategy = InheritanceType.JOINED)
public class Emissionen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nr;
    private String laendername;
    private String laendercode;
    private String indikatorname;
    private String indikatorcode;
    private int jahr;
    private double emissionen;


    public Emissionen()
    {
    }
  

    public Emissionen(int nr, String laendername, String laendercode, String indikatorname, String indikatorcode, int jahr, double emissionen)
    {
        this.nr = nr;
        this.laendername = laendername;
        this.laendercode = laendercode;
        this.indikatorname = indikatorname;
        this.indikatorcode = indikatorcode;
        this.jahr = jahr;
        this.emissionen = emissionen;
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    public String getLaendername()
    {
        return laendername;
    }

    public void setLaendername(String laendername)
    {
        this.laendername = laendername;
    }

    public String getLaendercode()
    {
        return laendercode;
    }

    public void setLaendercode(String laendercode)
    {
        this.laendercode = laendercode;
    }
    
    public String getIndikatorname()
    {
        return indikatorname;
    }

    public void setIndikatorname(String indikatorname)
    {
        this.indikatorname = indikatorname;    
    }
    
        public String getIndikatorcode()
    {
        return indikatorcode;
    }

    public void setIndikatorcode(String indikatorcode)
    {
        this.indikatorcode = indikatorcode;
    }
    
    
        public int getJahr()
    {
        return jahr;
    }

    public void setJahr(int jahr)
    {
        this.jahr = jahr;
    }
    
    
    public double getEmissionen()
    {
        return emissionen;
    }

    public void setEmissionen(double emissionen)
    {
        this.emissionen = emissionen;
    }
    
}
