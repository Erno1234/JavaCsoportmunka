
package Modell;

public abstract class Konyv {
    private String kolcsonzo;
    private boolean kiadva;

    public Konyv(String kolcsonzo) {
        this.kolcsonzo = kolcsonzo;
        kiadva = false;
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
