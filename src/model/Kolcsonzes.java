package model;

public class Kolcsonzes {

    private String nev;
    private Konyv[] konyvek;
    private int konyvDb;

    public enum KonyvKolcsonozhetoseg {
        KOLCSONOZHET, NEM_FELHASZNALO, ELTILTOTT
    };
    private KonyvKolcsonozhetoseg jogosultsag;

    public Kolcsonzes(String nev) {
        this(nev, 5);
    }

    public Kolcsonzes(String nev, int db) {
        this(nev, db, "felhasznalo");
    }

    public Kolcsonzes(String nev, int db, String felhasznaloAllapot) {
        this.nev = nev;
        konyvDb = 0;
        konyvek = new Konyv[db];
        jogosultsag = KonyvKolcsonozhetoseg.KOLCSONOZHET;
        setJogosultsag(felhasznaloAllapot);
    }

    public void eltiltott() {
        jogosultsag = KonyvKolcsonozhetoseg.ELTILTOTT;
    }

    public void felhasznaloBealit() {
        jogosultsag = KonyvKolcsonozhetoseg.KOLCSONOZHET;
    }

    private void setJogosultsag(String felhasznaloAllapot) {
        switch (felhasznaloAllapot) {
            case "felhasznalo":
                this.jogosultsag = KonyvKolcsonozhetoseg.KOLCSONOZHET;
                break;
            case "nem_felhasznalo":
                this.jogosultsag = KonyvKolcsonozhetoseg.NEM_FELHASZNALO;
                break;
            case "eltiltott":
                this.jogosultsag = KonyvKolcsonozhetoseg.ELTILTOTT;
                break;
            default:
                this.jogosultsag = KonyvKolcsonozhetoseg.NEM_FELHASZNALO;
        }
    }

    public KonyvKolcsonozhetoseg getJogosultsag() {
        return jogosultsag;
    }

    public boolean kolcsonozhet() {
        return jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET;
    }

    public void kolcsonzesBevesz(Konyv konyv) {
        konyv.setKolcsonzesiAllapott(true);
        System.out.println(konyvek.length);
        if (jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET) {
            if (konyvDb < konyvek.length) {
                konyvek[konyvDb++] = konyv;
            } else {
                System.out.println("Nem kölcsönözhet több könyvet!");
            }
        } else {
            nemKolcsonozhet();
        }

    }

    public void altalanosAllapotRomlas() {
        if (jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET) {
            for (Konyv konyv : konyvek) {
                if (konyv != null) {
                    konyv.setKolcsonzesiAllapott(true);
                    konyv.altalanosAllapotRomlas();
                }
            }
        } else {
            nemKolcsonozhet();
        }
    }

    public void kimeloAllapotRomlas() {
        if (jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET) {
            for (Konyv konyv : konyvek) {
                if (konyv != null) {
                    konyv.kimeloMobbAllapotRomlas();
                }
            }
        } else {
            nemKolcsonozhet();
        }
    }

    public Konyv konyvLeadasa(String cim) {
        Konyv konyvVisszaAd = new VisszaAdottKonyv();
        if (jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET) {
            int i = 0;
            while (konyvek[i] == null || i < konyvDb && !(konyvek[i].getCime().equals(cim))) {
                i++;
            }
            if (i < konyvDb) {
                konyvek[i].setKolcsonzesiAllapott(false);
                String tipus = konyvek[i] instanceof Konyv ? "Könyve" : "Fantasy";
                System.out.println("Kiadva %s %s!".formatted(cim, tipus));
                konyvVisszaAd = konyvek[i];
                konyvek[i] = null;
            } else {
                System.out.println("Nincs ilyen kölcsönzött könyve " + nev + ".");
            }
        } else {
            nemKolcsonozhet();
        }
        return konyvVisszaAd;
    }

    public Konyv[] getKonyvek() {
        if (jogosultsag == KonyvKolcsonozhetoseg.KOLCSONOZHET) {
            Konyv[] kolcsonzottKonyvek = new Konyv[konyvDb];
            for (int i = 0; i < konyvDb; i++) {
                Konyv akt_Konyv = konyvek[i];
                if (akt_Konyv != null) {
                    kolcsonzottKonyvek[i] = akt_Konyv;
                }
            }
            return kolcsonzottKonyvek;
        } else {
            nemKolcsonozhet();
            return new Konyv[0];
        }

    }

    private void nemKolcsonozhet() {
        if (jogosultsag == KonyvKolcsonozhetoseg.NEM_FELHASZNALO) {
            System.out.println("Nincs be regisztrálva a könyvtár rendszerében, mint felhasználó");
        } else if (jogosultsag == KonyvKolcsonozhetoseg.ELTILTOTT) {
            System.out.println("El van tiltva a könyv kölcsönzéstől.");
        }
    }

}
