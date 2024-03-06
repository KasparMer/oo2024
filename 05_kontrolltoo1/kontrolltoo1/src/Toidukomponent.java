import java.io.Serializable;
public class Toidukomponent implements Serializable {
    double kogus;
    Toiduaine toiduaine;

    Toidukomponent(double kogus, Toiduaine toiduaine) {
        this.kogus = kogus;
        this.toiduaine = toiduaine;
    }

    double arvutaRasvakogus() {
        return (toiduaine.rasvad * kogus) / 100.0;
    }
}
