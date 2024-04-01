package ee.tlu.Kodutoo4.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbriController {
    List<String> numbrid = new ArrayList<>();

    // kuva numbrite listi brauseris
    // locahost:8080/numbrid
    @GetMapping("numbrid")
    public List<String> naitaNumbreid() {
        return numbrid;
    }

    // lisa numbreid listi juurde
    @PostMapping("numbrid/{number}")
    public List<String> lisaNumbreid(@PathVariable String number) {
        numbrid.add(number);
        return numbrid;
    }

    // kustuta üks number listist
    @DeleteMapping("numbrid/{number}")
    public List<String> kustutaNumber(@PathVariable String number) {
        numbrid.remove(number);
        return numbrid;
    }


    // arvuta mitu numbrit on listis
    @GetMapping("numbrite-koguarv")
    public int mituNumbrit() {
        return numbrid.size();
    }

    // arvuta listis olevate numbrite kogusumma
    @GetMapping("kogusumma")
    public double numbriteSumma() {
        double summa = 0;
        for (String number : numbrid) {
            summa += Double.parseDouble(number);
        }
        return summa;
    }

    // arvuta listis olevate numbrite keskmine
    @GetMapping("keskmine")
    public double numbriteKeskmine() {
        double summa = 0;
        for (String s : numbrid) {
            summa += Double.parseDouble(s);
        }

        return summa / numbrid.size();
    }
}