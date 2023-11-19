
package Modell;

public class PapirKonyv extends Konyv {
    private double allapot;
    
    public PapirKonyv(String kolcsonzo) {
        super(kolcsonzo);
        this.allapot = 100;
    }

    public double getAllapot() {
        return allapot;
    }

    public void setAllapot(double allapot) {
        this.allapot = allapot;
    }

    
   @Override
    public String toString() {
        String szoveg = super.toString();
        szoveg += "{ allapot=" + allapot + '}';
        return szoveg;
    }
    
    
    public void kolcsonzesHatasa() {
        allapot *= .97;
    }
}
