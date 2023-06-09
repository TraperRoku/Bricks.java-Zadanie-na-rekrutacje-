import java.util.*;

public class CheckKlocek {
    public boolean checkString(String string, String string2) {
        String[] parts = string.split(":");
        String frag = parts[0];
        for (int i = 0; i < frag.length(); i++) {
            if (Character.isLetter(frag.charAt(i))) {
                return false;
            }
        }

        if (string.length() > 6) {
            for (int i = 1; i < parts.length; i++) {
                String afterColon = parts[i].trim();
                int Count = afterColon.length();
                if (Count != 4) {
                    return false;
                }
            }
        }

        if (string.length() < 5) {
            return false;
        }

        for (char znak : string2.toCharArray()) {
            if (znak < 'A' || znak > 'O') {
                return false;
            }
        }

        if (string2.length() > 4) {
            return false;
        }

        return string.contains(":");
    }

    public boolean checkPusta(String string) {
        if (string.length() != 4) {
            return false;
        }

        for (char znak : string.toCharArray()) {
            if (znak < 'A' || znak > 'N') {
                return false;
            }
        }

        return true;
    }

    public void czyInstrukcjaZrealizowanaEtap1(List<String> etap, List<String> pudelko, WynikBudowy wynikBudowy, int theBiggestNumber, boolean etapModulo) {
        List<String> etapWithoutPrefix = new ArrayList<>();

        for (int j = 1; j <= theBiggestNumber; j++) {
            List<String> zmiennaEtap = new ArrayList<>();

            for (String element : etap) {
                if (element.startsWith(j + ":")) {
                    zmiennaEtap.add(element);
                }
            }

            if (zmiennaEtap.size() == 0) {
                continue;
            }

            String liczbaString = String.valueOf(j);
            int liczba = liczbaString.length() + 1;

            for (String element : zmiennaEtap) {
                etapWithoutPrefix.add(element.substring(liczba));
            }

            boolean containsAllElements = true;
            for (String element : etapWithoutPrefix) {
                if (Collections.frequency(pudelko, element) < Collections.frequency(etapWithoutPrefix, element)) {
                    containsAllElements = false;
                    break;
                }
            }

            if (containsAllElements) {
                wynikBudowy.dodajZrealizowanaBudowe();
                if (etapModulo) {
                    wynikBudowy.dodajKlockiDoEtapu1(etapWithoutPrefix.size());
                } else {
                    wynikBudowy.dodajKlockiDoEtapu2(etapWithoutPrefix.size());
                }

                for (int i = etapWithoutPrefix.size() - 1; i >= 0; i--) {
                    String element = etapWithoutPrefix.get(i);
                    pudelko.remove(element);
                }

                etapWithoutPrefix.clear();
            } else {
                for (int i = pudelko.size() - 1; i >= 0; i--) {
                    String element = pudelko.get(i);
                    etapWithoutPrefix.remove(element);
                }

                wynikBudowy.dodajLiczbeKlockowBrakujacych(etapWithoutPrefix.size());
                wynikBudowy.dodajNiezrealizowanaBudowe();
                etapWithoutPrefix.clear();
            }
        }
    }
}
