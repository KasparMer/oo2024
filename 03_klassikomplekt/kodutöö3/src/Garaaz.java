import java.util.ArrayList;
import java.util.List;

public class Garaaz {
    private List<Auto> autod;

    public Garaaz() {
        this.autod = new ArrayList<>();
    }

    public void addAuto(Auto auto) {
        autod.add(auto);
    }

    public List<Auto> getAutodBrandid(String brand) {
        List<Auto> result = new ArrayList<>();
        for (Auto auto : autod) {
            if (auto.getBrand().equals(brand)) {
                result.add(auto);
            }
        }
        return result;
    }

    public List<Auto> getKoikAutod() {
        return autod;
    }
}
