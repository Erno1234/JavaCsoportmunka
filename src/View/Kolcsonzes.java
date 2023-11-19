package View;

import Modell.EKonyv;
import Modell.Konyvtar;
import Modell.PapirKonyv;

public class Kolcsonzes {

    private final Konyvtar konyvtar;

    public Kolcsonzes() {
        konyvtar = new Konyvtar(4);
        konyvtar.kolcsonzottKonyvek(new PapirKonyv("János",""));
        konyvtar.kolcsonzottKonyvek(new EKonyv("Petra",""));
    }

}
