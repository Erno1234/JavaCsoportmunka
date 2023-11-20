package Modell;

public class EKonyv extends Konyv {

    private double nepszeruseg;

    public EKonyv(String kolcsonzo, String cim) {
        super(kolcsonzo, cim);
        this.nepszeruseg = 1;
    }

    public double getAllapot() {
        return nepszeruseg;
    }

    public void setAllapot(double nepszeruseg) {
        this.nepszeruseg = nepszeruseg;
    }

    @Override
    public String toString() {
        String szoveg = super.toString();
        szoveg += "{ nepszeruseg=" + nepszeruseg + '}';
        return szoveg;
    }

    @Override
    public void kolcsonzesHatasa() {
        nepszeruseg += 0.2;
    }
}
