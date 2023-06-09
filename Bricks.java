import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bricks {
    public static void main(String[] args) {
        List<String> pudelko = new ArrayList<>();
        List<String> pudelkoZNiechcianymi = new ArrayList<>();
        List<String> etap1 = new ArrayList<>();
        List<String> etap2 = new ArrayList<>();
        int theBiggestNumber = 0;

        WynikBudowy wynikBudowy = new WynikBudowy();
        boolean etapModulo3 = true;

        CheckKlocek checkKlocek = new CheckKlocek();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            while (scanner.hasNextLine()) {
                String string = scanner.next();
                int dlugoscString = string.length() - 4;
                int liczbaDoOdjecia;
                int number = 0;

                if (string.equals("0")) {
                    break;
                }

                if (string.length() < 6) {
                    if (!checkKlocek.checkPusta(string)) {
                        System.out.println("klops");
                        continue;
                    } else {
                        continue; // PRZYPADEK PUSTYCH INSTRUKCJI nie błąd ale pomijamy
                    }
                }

                if (string.charAt(0) == '-') {
                    System.out.println("klops");
                    continue;
                } else if (!checkKlocek.checkString(string, string.substring(dlugoscString))) {
                    System.out.println("klops");
                    continue;
                }

                if (string.contains("O")) {
                    pudelkoZNiechcianymi.add(string);
                    continue;
                }

                liczbaDoOdjecia = string.length() - 5;
                number = Integer.parseInt(string.substring(0, liczbaDoOdjecia));

                if (number == 0) {
                    pudelko.add(string.substring(dlugoscString));
                } else if (number % 3 == 0) {
                    etap1.add(string);
                } else {
                    etap2.add(string);
                }

                if (number > theBiggestNumber) {
                    theBiggestNumber = number;
                }
            }

            if (!etap1.isEmpty()) {
                checkKlocek.czyInstrukcjaZrealizowanaEtap1(etap1, pudelko, wynikBudowy, theBiggestNumber, etapModulo3);
            }

            if (!etap2.isEmpty()) {
                etapModulo3 = false;
                checkKlocek.czyInstrukcjaZrealizowanaEtap1(etap2, pudelko, wynikBudowy, theBiggestNumber, etapModulo3);
            }

            int suma = pudelko.size() + pudelkoZNiechcianymi.size();
            System.out.println(wynikBudowy.getLiczbaKlockowEtap1());
            System.out.println(wynikBudowy.getLiczbaKlockowEtap2());
            System.out.println(suma);
            System.out.println(wynikBudowy.getLiczbaKlockowBrakujacych());
            System.out.println(wynikBudowy.getLiczbaZrealizowanychBudowli());
            System.out.println(wynikBudowy.getLiczbaNiezrealizowanychBudowli());
            break;
        }
    }
}
