package ee.tlu.MatkajaInfo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Matkaklubi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimetus;

    @OneToMany(mappedBy = "matkaklubi")
    private List<Matkaja> matkajad;
}
