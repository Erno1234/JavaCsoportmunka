package View;

import Modell.EKonyv;
import Modell.Konyv;
import Modell.Konyvtar;
import Modell.PapirKonyv;

public class Kolcsonzes {

    private final Konyvtar konyvtar;

    public Kolcsonzes() {
        konyvtar = new Konyvtar(4);
        konyvtar.kolcsonzottKonyvek(new PapirKonyv("János", "Könyv1"));
        konyvtar.kolcsonzottKonyvek(new EKonyv("Petra", "Könyv2"));

        System.out.println("--- Könyvek kiadás előtt:");
        konyvtarKonyvei();

        System.out.println("--- Könyvek kiadás után:");
        konyvtar.kiadas();
        konyvtarKonyvei();
        
        System.out.println("--- Könyv leadása");
        konyvtar.konyvLeadasa("Könyv2");
        
        System.out.println("--- Könyvtárban maradt könyvek:");
        konyvtarKonyvei();

    }

    private void konyvtarKonyvei() {
        for (Konyv konyv : konyvtar.getKonyvek()) {
            if (konyv != null) {
                System.out.println(konyv);
            }
        }
    }

}
