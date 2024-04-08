package ee.tlu.Kodutoo4.Kodutoo4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumberEntityController {
    NumberRepository numberRepository;
    public NumberEntityController (NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @GetMapping("custom-numbers")
    public List<NumberEntity> showCustomNumbers() {
        return numberRepository.findAll();
    }

    @PostMapping("custom-numbers/{name}/{second}/{third}")
    public List<NumberEntity> addCustomNumbers(
            @PathVariable String name,
            @PathVariable int second,
            @PathVariable int third
    ) {
        NumberEntity input = new NumberEntity(name, second, third);
        numberRepository.save(input);
        return numberRepository.findAll();
    }

    @DeleteMapping("custom-numbers/{name}")
    public List<NumberEntity> deleteCustomNumber(@PathVariable String name) {
        numberRepository.deleteById(name);
        return numberRepository.findAll();
    }

    @PutMapping("custom-numbers")
    public List<NumberEntity> updateInput(
            @RequestParam String name,
            @RequestParam int second,
            @RequestParam int third
    ) {
        NumberEntity input = new NumberEntity(name, second, third);
        numberRepository.save(input);
        return numberRepository.findAll();
    }

    @GetMapping("custom-numbers-sum")
    public int getTotalSumOfNumbers() {
        int sum = 0;
        List<NumberEntity> numbers = numberRepository.findAll();
        for (NumberEntity input : numbers) {
            sum += input.second + input.third;
        }
        return sum;
    }
}