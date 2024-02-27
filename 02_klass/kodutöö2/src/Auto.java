public class Auto {
    private String brand;
    private String mudel;
    private int aasta;
    private String varv;
    private int kiirus;

    public Auto(String brand, String mudel, int aasta, String varv) {
        this.brand = brand;
        this.mudel = mudel;
        this.aasta = aasta;
        this.varv = varv;
        this.kiirus = 0;
    }

    // Auto kiiruse suurendamine
    public void kiirendus(int increment) {
        this.kiirus += increment;
        System.out.println(this.brand + " " + this.mudel + " kiirendab " + increment + " km/h");
    }

    // Auto kiiruse peatamine
    public void pidur(int decrement) {
        this.kiirus -= decrement;
        if (this.kiirus < 0) {
            this.kiirus = 0;
        }
        System.out.println(this.brand + " " + this.mudel + " pidurdab " + decrement+ " km/h");
    }

    // Hetkkiiurs leidmine
    public int getKiirus() {
        return this.kiirus;
    }

    // Mida display kuvab
    public void display() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Mudel: " + this.mudel);
        System.out.println("Aasta: " + this.aasta);
        System.out.println("Värv: " + this.varv);
    }
}