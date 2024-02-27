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


    // aauto kiirendamine
    public void kiirendab(int increment) {
        this.kiirus += increment;
        System.out.println(this.brand + " " + this.mudel + " kiirendab " + this.kiirus + " km/h");
    }

    // auto pidurdamine
    public void pidurdab(int decrement) {
        this.kiirus -= decrement;
        if (this.kiirus < 0) {
            this.kiirus = 0; // Speed cannot be negative
        }
        System.out.println(this.brand + " " + this.mudel + " pidurdab " + this.kiirus + " km/h");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Autoandmed
    public void display() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Mudel: " + this.mudel);
        System.out.println("Aasta: " + this.aasta);
        System.out.println("Varv: " + this.varv);
        //System.out.println("Hetkkiirus: " + this.kiirus + " km/h");
    }
}
