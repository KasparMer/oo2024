package ee.tlu.salat;

// jpa moodulist pärinev. Hibernate.
// Kui räägite ChatGPT-ga
// import javax.persistence.Table
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "toiduaine") // vabatahtlik - nime vahetuseks
@Entity // andmebaasipanekuks
@NoArgsConstructor // andmebaasipanekuks
public class ToiduaineEntity {
    @Id // alati unikaalne - kustutamiseks, võtmiseks, muutmiseks
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;


    // parem klõps -> Generate -> Constructor -> valida kõik
//    public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
//        this.nimetus = nimetus;
//        this.valk = valk;
//        this.rasv = rasv;
//        this.sysivesik = sysivesik;
//    }
}