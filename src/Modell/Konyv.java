
package Modell;

public abstract class Konyv {
    private String kolcsonzo;
    private String cim;
    private boolean kiadva;

    public Konyv(String kolcsonzo, String cim) {
        this.kolcsonzo = kolcsonzo;
        this.cim = cim;
        kiadva = false;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
    
    public String getKolcsonzo() {
        return kolcsonzo;
    }

    public void setKolcsonzo(String kolcsonzo) {
        this.kolcsonzo = kolcsonzo;
    }

    public boolean isKiadva() {
        return kiadva;
    }

    public void setKiadva(boolean kiadva) {
        this.kiadva = kiadva;
    }

    @Override
    public String toString() {
        return "Konyv{" + "kolcsonzo=" + kolcsonzo + ", kiadva=" + kiadva + '}';
    }
    
    public abstract void kolcsonzesHatasa();
}
