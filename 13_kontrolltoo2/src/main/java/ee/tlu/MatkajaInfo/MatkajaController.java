package ee.tlu.MatkajaInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matkajad")
public class MatkajaController {

    private final MatkajaRepository matkajaRepository;

    @Autowired
    public MatkajaController(MatkajaRepository matkajaRepository) {
        this.matkajaRepository = matkajaRepository;
    }

    @GetMapping
    public List<Matkaja> kõikMatkajad() {
        return matkajaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Matkaja> lisaMatkaja(@RequestBody Matkaja matkaja) {
        Matkaja savedMatkaja = matkajaRepository.save(matkaja);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatkaja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> kustutaMatkaja(@PathVariable Long id) {
        matkajaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/suurenda-kilomeetraazi/{lisatudKilomeetraaz}")
    public ResponseEntity<Matkaja> suurendaKilomeetraazi(@PathVariable Long id, @PathVariable double lisatudKilomeetraaz) {
        Optional<Matkaja> matkajaOptional = matkajaRepository.findById(id);
        if (matkajaOptional.isPresent()) {
            Matkaja matkaja = matkajaOptional.get();
            double uusKilomeetraaz = matkaja.getKilomeetraaz() + lisatudKilomeetraaz;
            matkaja.setKilomeetraaz(uusKilomeetraaz);
            matkajaRepository.save(matkaja);
            return ResponseEntity.ok(matkaja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/suurima-kilomeetraaziga-matkaja")
    public ResponseEntity<Matkaja> suurimaKilomeetraazigaMatkaja() {
        List<Matkaja> matkajad = matkajaRepository.findAll();
        if (matkajad.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Matkaja suurimaKilomeetraazigaMatkaja = matkajad.stream()
                .max(Comparator.comparingDouble(Matkaja::getKilomeetraaz))
                .orElseThrow();
        return ResponseEntity.ok(suurimaKilomeetraazigaMatkaja);
    }

    @PutMapping("/{id}/lisa-kulastatud-riik")
    public ResponseEntity<Matkaja> lisaKulastatudRiik(@PathVariable String id, @RequestBody String uusRiik) {
        Optional<Matkaja> matkajaOptional = matkajaRepository.findById(Long.valueOf(id));
        if (matkajaOptional.isPresent()) {
            Matkaja matkaja = matkajaOptional.get();
            matkaja.setRiikideArv(matkaja.getRiikideArv() + 1);
            matkajaRepository.save(matkaja);
            return ResponseEntity.ok(matkaja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/kõik-riigid")
    public List<String> kysiKoikRiigid() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all?fields=name";
        String[] response = restTemplate.getForObject(url, String[].class);
        return Arrays.asList(response);
    }

    @GetMapping("/riigid-tähega")
    public List<String> kysiRiigidTähega(@RequestParam String täht) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all?fields=name";
        String[] response = restTemplate.getForObject(url, String[].class);
        return Arrays.stream(response)
                .filter(riik -> riik.startsWith(täht))
                .collect(Collectors.toList());
    }

    @GetMapping("/riigid-common")
    public List<String> kysiRiigidCommon() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/countries";
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {});
        List<String> commonKeys = new ArrayList<>();
        if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
            Map<String, Object> responseBody = response.getBody();
            for (Map.Entry<String, Object> entry : responseBody.entrySet()) {
                if (entry.getKey().equals("common")) {
                    commonKeys = (List<String>) entry.getValue();
                    break;
                }
            }
        }
        return commonKeys;
    }

    @GetMapping("/väiksema-populatsiooniga-riik")
    public ResponseEntity<String> väiksemaPopulatsioonigaRiik() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/countries";
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Map<String, Object>>>() {});
        if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
            List<Map<String, Object>> countries = response.getBody();
            Optional<Map<String, Object>> smallestPopulationCountry = countries.stream()
                    .min(Comparator.comparingLong(country -> (Long) country.get("population")));
            if (smallestPopulationCountry.isPresent()) {
                String countryName = (String) smallestPopulationCountry.get().get("name");
                return ResponseEntity.ok(countryName);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/suurema-pindalaga-riik")
    public ResponseEntity<String> suuremaPindalagaRiik() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/countries";
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Map<String, Object>>>() {});
        if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
            List<Map<String, Object>> countries = response.getBody();
            Optional<Map<String, Object>> largestAreaCountry = countries.stream()
                    .max(Comparator.comparingDouble(country -> (Double) country.get("area")));
            if (largestAreaCountry.isPresent()) {
                String countryName = (String) largestAreaCountry.get().get("name");
                return ResponseEntity.ok(countryName);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/riigid-tihedusega-vähem-kui")
    public ResponseEntity<List<String>> riigidTihedusegaVähemKui(@RequestParam double tihedus) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/countries";
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Map<String, Object>>>() {});
        List<String> countriesWithLowerDensity = new ArrayList<>();
        if (response.getStatusCode() == HttpStatus.OK && response.hasBody()) {
            List<Map<String, Object>> countries = response.getBody();
            for (Map<String, Object> country : countries) {
                double population = (Long) country.get("population");
                double area = (Double) country.get("area");
                double density = population / area;
                if (density < tihedus) {
                    String countryName = (String) country.get("name");
                    countriesWithLowerDensity.add(countryName);
                }
            }
        }
        return ResponseEntity.ok(countriesWithLowerDensity);
    }

    @GetMapping("/matkajad-klubis/{matkaklubiId}")
    public ResponseEntity<Integer> matkajadKlubis(@PathVariable Long matkaklubiId) {
        List<Matkaja> matkajad = matkajaRepository.findByMatkaklubiId(matkaklubiId);
        return ResponseEntity.ok(matkajad.size());
    }

    @GetMapping("/kilomeetraaz-klubis/{matkaklubiId}")
    public ResponseEntity<Double> kilomeetraazKlubis(@PathVariable Long matkaklubiId) {
        Double kilomeetraaz = matkajaRepository.sumKilomeetraazByMatkaklubiIdAndStaatus(matkaklubiId, "Kuld");
        return ResponseEntity.ok(kilomeetraaz != null ? kilomeetraaz : 0);
    }
}