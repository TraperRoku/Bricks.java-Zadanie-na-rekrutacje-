public class WynikBudowy {
    private int liczbaKlockowEtap1;
    private int liczbaKlockowEtap2;

    private int liczbaKlockowBrakujacych;
    private int liczbaZrealizowanychBudowli;
    private int liczbaNiezrealizowanychBudowli;





    public void dodajLiczbeKlockowBrakujacych(int liczbaKlockow) {
        liczbaKlockowBrakujacych += liczbaKlockow;
    }
    public void dodajKlockiDoEtapu1(int liczbaKlockow) {
        liczbaKlockowEtap1 += liczbaKlockow;
    }

    public void dodajKlockiDoEtapu2(int liczbaKlockow) {
        liczbaKlockowEtap2 += liczbaKlockow;
    }

    public void dodajZrealizowanaBudowe() {
        liczbaZrealizowanychBudowli++;
    }

    public void dodajNiezrealizowanaBudowe() {
        liczbaNiezrealizowanychBudowli++;
    }



    public int getLiczbaKlockowEtap1() {
        return liczbaKlockowEtap1;
    }

    public int getLiczbaKlockowEtap2() {
        return liczbaKlockowEtap2;
    }



    public int getLiczbaKlockowBrakujacych() {
        return liczbaKlockowBrakujacych;
    }

    public int getLiczbaZrealizowanychBudowli() {
        return liczbaZrealizowanychBudowli;
    }

    public int getLiczbaNiezrealizowanychBudowli() {
        return liczbaNiezrealizowanychBudowli;
    }

}