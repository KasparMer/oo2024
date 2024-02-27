public class Autokatse {
    public static void main(String[] args) {
        // Creating an instance of Car
        Auto auto1 = new Auto("Toyota", "Camry", 2022, "Punane");
        Auto auto2 = new Auto("Honda", "Civic", 2023, "Sinine");

        // Autode andmed
        System.out.println("Esimese auto andmed:");
        auto1.display();
        System.out.println(" ");

        System.out.println("Teise auto andmed:");
        auto2.display();
        System.out.println(" ");


        // Accelerate and display car details
        auto1.kiirendus(30);
        System.out.println("Auto uus kiirus on: " + auto1.getKiirus() + " km/h");
        System.out.println(" ");


        auto2.kiirendus(20);
        System.out.println("Auto uus kiirus on: " + auto2.getKiirus() + " km/h");
        System.out.println(" ");

        // Pidurdamine ja andmete kuvamine
        auto1.pidur(10);
        System.out.println("Auto uus kiirus on: " + auto1.getKiirus() + " km/h");
        System.out.println(" ");


        auto2.pidur(15);
        System.out.println("Auto uus kiirus on: " + auto2.getKiirus() + " km/h");
        System.out.println(" ");
    }
}