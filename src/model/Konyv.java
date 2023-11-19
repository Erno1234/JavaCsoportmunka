package model;

public abstract class Konyv {

    private String cim;
    private boolean kolcsonzott;

    public Konyv(String cim) {
        this.cim = cim;
        kolcsonzott = false;
    }

    public String getCime() {
        return cim;
    }

    public void setCime(String kolcsonzoNeve) {
        this.cim = kolcsonzoNeve;
    }

    public boolean isKolcsonzott() {
        return kolcsonzott;
    }
    
 public boolean getKolncsonzesiAllapot() {
        return kolcsonzott;
    }
 
    public void setKolcsonzesiAllapott(boolean kolcsonzott) {
        this.kolcsonzott = kolcsonzott;
    }

    @Override
    public String toString() {
        return "Könyv{" + "kölcsönzött könyv neve=" + cim + ", kölcsönzési állapota=" + kolcsonzott + '}';
    }

    public abstract void altalanosAllapotRomlas();
    public abstract void kimeloMobbAllapotRomlas();

}
