package Modell;

public class Konyvtar {

    private Konyv[] konyvek;
    private int konyvDb;

    private enum UzemelesiAllapot {
        UZEMEL, NEM_UZEMEL, LEEGETT
    };
    private UzemelesiAllapot allapot;

    public Konyvtar() {
        this(5);

    }

    public Konyvtar(int db) {
        konyvDb = 0;
        konyvek = new Konyv[db];
        allapot = UzemelesiAllapot.UZEMEL;
    }

    public void leeg() {
        allapot = UzemelesiAllapot.LEEGETT;
    }

    public UzemelesiAllapot getUzemel() {
        return allapot;
    }

    public boolean isUzemel() {
        return allapot == UzemelesiAllapot.UZEMEL;
    }

    public void kolcsonzottKonyvek(Konyv konyv) {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            if (konyvDb < konyvek.length) {
                konyvek[konyvDb++] = konyv;
            } else {
                System.out.println("Nem kölcsönözhet több könyvet!");
            }
        } else {
            nemUzemel();
        }

    }

    public void kiadas() {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            for (Konyv konyv : konyvek) {
                if (konyv != null) {
                    konyv.setKiadva(true);
                    konyv.kolcsonzesHatasa();
                }
            }
        } else {
            nemUzemel();
        }
    }

    public Konyv konyvLeadasa(String cim) {
        Konyv konyvVisszaAd = new VisszaHozottKonyv();
        if (allapot == UzemelesiAllapot.UZEMEL) {
            int i = 0;
            while (konyvek[i] == null || i < konyvDb && !(konyvek[i].getCim().equals(cim))) {
                i++;
            }
            if (i < konyvDb) {
                konyvek[i].setKiadva(false);
                String tipus = konyvek[i] instanceof Konyv ? "Papír" : "Elektronikus";
                System.out.println("Kiadva %s %s!".formatted(cim, tipus));
                konyvVisszaAd = konyvek[i];
                konyvek[i] = null;
            } else {
                System.out.println("Nincs ilyen kölcsönzött könyve " + konyvek[i].getKolcsonzo() + ".");
            }
        } else {
            nemUzemel();
        }
        return konyvVisszaAd;
    }

    public Konyv[] getKonyvek() {
        if (allapot == UzemelesiAllapot.UZEMEL) {
            Konyv[] kolcsonzottKonyvek = new Konyv[konyvDb];
            for (int i = 0; i < konyvDb; i++) {
                Konyv aktKonyv = konyvek[i];
                if (aktKonyv != null) {
                    kolcsonzottKonyvek[i] = aktKonyv;
                }
            }
            return kolcsonzottKonyvek;
        } else {
            nemUzemel();
            return new Konyv[0];
        }

    }

    private void nemUzemel() {
        if (allapot == UzemelesiAllapot.NEM_UZEMEL) {
            System.out.println("A könyvtár nem üzemel!");
        } else if (allapot == UzemelesiAllapot.LEEGETT) {
            System.out.println("A könyvtár leégett!");
        }
    }

}
