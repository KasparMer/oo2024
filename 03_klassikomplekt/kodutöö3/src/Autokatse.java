import java.util.List;

public class Autokatse {
    public static void main(String[] args) {
        // Tekitame garaazi
        Garaaz garaaz = new Garaaz();

        // Paigutame autod garaazi
        garaaz.addAuto(new Auto("Toyota", "Camry", 2022, "Punane"));
        garaaz.addAuto(new Auto("Honda", "Civic", 2023, "Sinine"));
        garaaz.addAuto(new Auto("Toyota", "Corolla", 2021, "Valge"));
        garaaz.addAuto(new Auto("VolksWagen", "Golf", 2020, "Hall"));
        garaaz.addAuto(new Auto("Mazda", "Mazda3", 2017, "Lilla"));
        garaaz.addAuto(new Auto("Toyota", "Hilux", 2019, "Kollane"));


        // Kuvab kõik autod, mis asuvad garaazis
        System.out.println("Kõik autod:");
        List<Auto> koikAutod = garaaz.getKoikAutod();
        for (Auto auto : koikAutod) {
            auto.display();
            System.out.println();
        }

        // Väljastab kõik autod vastavalt brändile
        System.out.println("Kuva kõik Toyota autod:");
        List<Auto> toyotaAutod = garaaz.getAutodBrandid("Toyota");
        for (Auto auto : toyotaAutod) {
            auto.display();
            System.out.println();
        }
    }
}
