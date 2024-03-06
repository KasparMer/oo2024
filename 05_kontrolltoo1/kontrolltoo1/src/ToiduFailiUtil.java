import java.io.*;

public class ToiduFailiUtil {
    // Salvestab nii binaarsed andmed kui ka inimesele loetava teksti
    public static void salvestaToiduAndmed(Toit toit, String failinimi) {
        try (ObjectOutputStream väljund = new ObjectOutputStream(new FileOutputStream(failinimi));
             BufferedWriter writer = new BufferedWriter(new FileWriter(failinimi + "_tekst.txt"))) {

            // Salvesta binaarsed andmed
            väljund.writeObject(toit);

            // Salvesta inimesele loetav tekst
            writer.write("Kartulisalatis leiduvad toitained (100g kohta):\n");
            writer.write("Valgud: " + toit.kusiValgud() + "g\n");
            writer.write("Rasvad: " + toit.kusiRasvad() + "g\n");
            writer.write("Süsivesikud: " + toit.kusiSusivesikud() + "g\n");
            System.out.println("Toidu andmed on salvestatud faili " + failinimi + "_tekst.txt");
        } catch (IOException e) {
            System.out.println("Viga toidu andmete salvestamisel: " + e.getMessage());
        }
    }

    // Meetod loeb toiduandmed failist tagasi
    public static Toit loeToiduAndmed(String failinimi) {
        try (ObjectInputStream sisend = new ObjectInputStream(new FileInputStream(failinimi))) {
            Toit toit = (Toit) sisend.readObject();
            System.out.println("Toidu andmed on loetud failist " + failinimi);
            return toit;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Viga toidu andmete lugemisel: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Loome mõned toiduained ja toidukomponendid
        Toiduaine kartul = new Toiduaine("kartul", 2, 0, 20);
        Toiduaine hapukoor = new Toiduaine("hapukoor", 2, 20, 3);
        Toiduaine kurk = new Toiduaine("kurk", 1, 0, 3);
        Toidukomponent kartuliKomponent = new Toidukomponent(200, kartul);
        Toidukomponent hapukooreKomponent = new Toidukomponent(50, hapukoor);
        Toidukomponent kurgiKomponent = new Toidukomponent(100, kurk);
        Toit kartulisalat = new Toit("kartulisalat", new Toidukomponent[]{kartuliKomponent, hapukooreKomponent, kurgiKomponent});

        // Salvestame nii binaarsed andmed kui ka inimesele loetava teksti
        salvestaToiduAndmed(kartulisalat, "kartulisalat");
    }
}
