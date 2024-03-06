import java.io.Serializable;
public class Toiduaine implements Serializable {
    String nimetus;
    int valgud;
    int rasvad;
    int susivesikud;

    Toiduaine(String nimetus, int valgud, int rasvad, int susivesikud) {
        this.nimetus = nimetus;
        this.valgud = valgud;
        this.rasvad = rasvad;
        this.susivesikud = susivesikud;
    }
}
