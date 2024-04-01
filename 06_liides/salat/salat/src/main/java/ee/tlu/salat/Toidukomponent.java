package ee.tlu.salat;

// Mis koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> Kartul+omadused ja mitu grammi

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Toidukomponent {
    ToiduaineEntity toiduaine;
    int kogus;
}