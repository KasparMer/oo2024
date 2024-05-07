package ee.tlu.MatkajaInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatkajaRepository extends JpaRepository<Matkaja, Long> {
    List<Matkaja> findByMatkaklubiId(Long matkaklubiId);
    Double sumKilomeetraazByMatkaklubiIdAndStaatus(Long matkaklubiId, String staatus);
}
