package ee.tlu.MatkajaInfo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Matkaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    private double kilomeetraaz;
    private int riikideArv;
    private String staatus;

    @ManyToOne
    @JoinColumn(name = "matkaklubi_id")
    private Matkaklubi matkaklubi;
}