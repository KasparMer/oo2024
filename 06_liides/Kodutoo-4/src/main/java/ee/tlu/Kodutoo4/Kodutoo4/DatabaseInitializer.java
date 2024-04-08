package ee.tlu.Kodutoo4.Kodutoo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final NumberRepository numberRepository;

    @Autowired
    public DatabaseInitializer(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public void run(String... args) {
        // Add new NumberEntity objects here
        NumberEntity numberEntity1 = new NumberEntity("first", 1, 2); // Example values, replace with your own
        numberRepository.save(numberEntity1);

        NumberEntity numberEntity2 = new NumberEntity("second", 3, 4); // Example values, replace with your own
        numberRepository.save(numberEntity2);

        // Add more entities if needed
    }
}
