package ee.tlu.Kodutoo4.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumberController {
    List<String> numbers = new ArrayList<>();

    @GetMapping("numbers")
    public List<String> showNumbers() {
        return numbers;
    }

    @PostMapping("numbers/{number}")
    public List<String> addNumbers(@PathVariable String number) {
        numbers.add(number);
        return numbers;
    }

    @DeleteMapping("numbers/{number}")
    public List<String> deleteNumber(@PathVariable String number) {
        numbers.remove(number);
        return numbers;
    }

    @GetMapping("total")
    public int getTotalNumbers() {
        return numbers.size();
    }

    @GetMapping("sum")
    public double getSumOfNumbers() {
        double sum = 0;
        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }
        return sum;
    }

    @GetMapping("average")
    public double getAverageOfNumbers() {
        double sum = 0;
        for (String s : numbers) {
            sum += Double.parseDouble(s);
        }
        return sum / numbers.size();
    }
}