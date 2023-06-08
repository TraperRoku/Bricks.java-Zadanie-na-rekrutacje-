import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
//Niektóre instrukcje mogły zaginąć – brakujące numery instrukcji mogą w takim przypadku nie być podane i to nie jest błąd
            String string = scanner.next();

            int liczbaCzegos = 0;
            int liczbaDoOdjecia;
            int number= 0;

            if(string.equals("0")){
                break;
            }
            if(string.length()<6){
                liczbaCzegos=0;

                if(!checkKlocek.checkPusta(string)){
                    System.out.println("klops");
                    continue;
                }else{
                    continue;//PRZYPADEK PUSTYCH INSTRUKCJI nie bład ale pomijamy
                }

            }else if(string.length()>5){
                liczbaCzegos = string.length() - 4;
                liczbaDoOdjecia = string.length()-5;
                number = Integer.parseInt(string.substring(0, liczbaDoOdjecia));
            }



            if(string.charAt(0)=='-'){
                String stringN = string.substring(0,2);
                int number1 = Integer.parseInt(stringN);
                if (!checkKlocek.checkString(string, number1, string.substring(liczbaCzegos))) {
                    System.out.println("klops");
                    continue;
                }
            }else if (!checkKlocek.checkString(string, number, string.substring(liczbaCzegos))) {
                System.out.println("klops");
                continue;
            }
            if (string.contains("O")) {
                pudelkoZNiechcianymi.add(string);
                continue;
            }

            if (number == 0) {
                pudelko.add(string.substring(liczbaCzegos));//tutaj

            } else if (number % 3 == 0) {

                etap1.add(string);
            }
            else{
                etap2.add(string);
            }
            if (number > theBiggestNumber) {
                theBiggestNumber = number;
            }

        }
        if(!etap1.isEmpty()) {


            checkKlocek.czyInstrukcjaZrealizowanaEtap1(etap1, pudelko, wynikBudowy, theBiggestNumber, etapModulo3);
        }

        if (!etap2.isEmpty()) {

            etapModulo3 = false;
            checkKlocek.czyInstrukcjaZrealizowanaEtap1(etap2, pudelko, wynikBudowy, theBiggestNumber, etapModulo3);
        }

        int suma = pudelko.size()+pudelkoZNiechcianymi.size();
        System.out.println(wynikBudowy.getLiczbaKlockowEtap1());
        System.out.println(wynikBudowy.getLiczbaKlockowEtap2());
        System.out.println(suma);
        System.out.println(wynikBudowy.getLiczbaKlockowBrakujacych());
        System.out.println(wynikBudowy.getLiczbaZrealizowanychBudowli());
        System.out.println(wynikBudowy.getLiczbaNiezrealizowanychBudowli());

    }


}