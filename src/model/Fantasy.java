package model;

import model.Konyv;

public class Fantasy extends Konyv {

    private double allapot;

    public Fantasy(String cim) {
        super(cim);
        allapot = 100;
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

    public void altalanosAllapotRomlas() {
        allapot *= .97;
    }

    public void kimeloMobbAllapotRomlas() {
        allapot *= .985;
    }

}
