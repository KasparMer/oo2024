import java.io.Serializable;
class Toit implements Serializable {
    String nimetus;
    Toidukomponent[] komponendid;

    Toit(String nimetus, Toidukomponent[] komponendid) {
        this.nimetus = nimetus;
        this.komponendid = komponendid;
    }

    int kusiValgud() {
        int summa = 0;
        for (Toidukomponent komponent : komponendid) {
            summa += komponent.toiduaine.valgud;
        }
        return summa;
    }

    int kusiRasvad() {
        int summa = 0;
        for (Toidukomponent komponent : komponendid) {
            summa += komponent.toiduaine.rasvad;
        }
        return summa;
    }

    int kusiSusivesikud() {
        int summa = 0;
        for (Toidukomponent komponent : komponendid) {
            summa += komponent.toiduaine.susivesikud;
        }
        return summa;
    }
}