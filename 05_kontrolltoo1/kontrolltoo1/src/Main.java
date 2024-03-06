//* Koosta klass toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent ehk int tüüpi muutuja).
//Loo "main funktsioonis" mõni toiduaine (nt. kartul, hapukoor, vorst). Koosta uus klass toidukomponendi tarbeks (kogus, viit toiduainele).
//Loo mõned toidukomponendid (nt. 100 g kartuleid, 30 g hapukoort, 50 g vorsti). Lisa toidukomponendile käsklus selle sees leiduva rasvakoguse arvutamiseks.
//* Koosta klass toidu jaoks (nimetus, viit toidukomponendile).
//Lisa toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust.
//Loo "main funktsioonis" toit (nt. kartulisalat), küsi salatis leiduvate toitainete kogused.
//* Võimalda toidu andmeid kirjutada tekstifaili(desse) ja lugeda tagasi.
//Võib eeldada, et toiduaine, toidukomponendi ning toidu nimetus on unikaalne, et ei tekiks failide juures üle kirjutamist.

public class Main {
    public static void main(String[] args) {
        // Loome mõned toiduained
        Toiduaine kartul = new Toiduaine("kartul", 2, 0, 20);
        Toiduaine hapukoor = new Toiduaine("hapukoor", 2, 20, 3);
        Toiduaine kurk = new Toiduaine("kurk", 1, 0, 3);

        // Loome mõned toidukomponendid
        Toidukomponent kartuliKomponent = new Toidukomponent(200, kartul);
        Toidukomponent hapukooreKomponent = new Toidukomponent(50, hapukoor);
        Toidukomponent kurgiKomponent = new Toidukomponent(100, kurk);

        // Koostame kartulisalati
        Toit kartulisalat = new Toit("kartulisalat", new Toidukomponent[]{kartuliKomponent, hapukooreKomponent, kurgiKomponent});

        // Salvestame toidu andmed faili
        ToiduFailiUtil.salvestaToiduAndmed(kartulisalat, "kartulisalat.txt");

        // Loeme toidu andmed tagasi failist
        Toit loetudToiduAndmed = ToiduFailiUtil.loeToiduAndmed("kartulisalat.txt");

        // Küsime ja väljastame toiduainete kogused
        if (loetudToiduAndmed != null) {
            int valgud = loetudToiduAndmed.kusiValgud();
            int rasvad = loetudToiduAndmed.kusiRasvad();
            int susivesikud = loetudToiduAndmed.kusiSusivesikud();

            // Väljastame tulemused
            System.out.println("Kartulisalatis leiduvad toitained (100g kohta):");
            System.out.println("Valgud: " + valgud + "g");
            System.out.println("Rasvad: " + rasvad + "g");
            System.out.println("Süsivesikud: " + susivesikud + "g");
        }
    }
}