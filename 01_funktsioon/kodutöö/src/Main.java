//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double kogumaksumus1 = arvutaTooteMaksumus(0.2F);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTooteMaksumus(0.22F);
        System.out.println(kogumaksumus2);
        String hinnang1 = NiiskuseHinnang(74);
        System.out.println(hinnang1);
        String hinnang2 = NiiskuseHinnang(35);
        System.out.println(hinnang2);
        printIndexAndCharacter("Koolis on huvitav ");
        printIndexAndCharacter("aga vahel igav.");
    }

    private static double arvutaTooteMaksumus(float kaibemaks) {
        return 15 + 5*kaibemaks;
    }
    //arvutab toote maksumuse endise KM ja uue KM %- ga

    private static String NiiskuseHinnang(double niisk) {
        if (niisk < 40) {
            return "Liiga kuiv";
        } else if  (niisk < 60){
            return "Liiga niiske";
        } else {
            return "Mugavus tsoon";
        }
    }
    //arvutab niiskustaseme tsooni

    private static void printIndexAndCharacter(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            System.out.println("Index: " + i + ", Character: " + currentChar);
        }
    }
    //väljastab tähe väärtuse ja tähe ise
}