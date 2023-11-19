package view;

import model.Fantasy;
import model.Kolcsonzes;
import model.Konyv;

public class KikolcsonzoProgram {

    private Kolcsonzes kolcsonzesek;
   

    public KikolcsonzoProgram() {
        Konyv konyv = new Fantasy("Sok Kaland");
        System.out.println(konyv.toString());
        kolcsonzesek = new Kolcsonzes("Péter", 4, "fdfdf");
        kolcsonzesek.felhasznaloBealit();
        kolcsonzesek.kolcsonzesBevesz(new Fantasy("Harry Potter"));
        kolcsonzesek.kolcsonzesBevesz(new Fantasy("Gyürűk Úra"));
        kolcsonzesek.kolcsonzesBevesz(konyv);
        Konyv[] konyvek = kolcsonzesek.getKonyvek();
        for (int i = 0; i < konyvek.length; i++) {
              System.out.println(konyvek[i].toString());
        }
        Konyv leadott = kolcsonzesek.konyvLeadasa("Harry Potter");
        leadott.kimeloMobbAllapotRomlas();
        System.out.println(leadott.toString());
        leadott = kolcsonzesek.konyvLeadasa("Gyürűk Úra");
        leadott.altalanosAllapotRomlas();
        System.out.println(leadott.toString());
   

    }

}
