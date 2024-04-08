package ee.tlu.Kodutoo4.Kodutoo4;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "custom_numbers")
@Entity
@NoArgsConstructor
public class NumberEntity {
    @Id
    String name;
    int second;
    int third;

}
