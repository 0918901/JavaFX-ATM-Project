package ATM;

import java.util.Scanner;

class Betaalsysteem extends Account{

    private int opnamelimiet = 5000;
    private String pashouderinvoer_string;
    private Scanner user_input = new Scanner(System.in);

    public Betaalsysteem(){

    }

    public Betaalsysteem(int opnamelimiet){
        this.opnamelimiet = opnamelimiet;
    }


    public void Welkom(){
        System.out.println("Welkom bij HRO geldautomaat");
        System.out.println("----------------------------------------------------------------");
    }
    public void startKeuzeMenu(){
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil een testaccount gebruiken");
        System.out.println("2 = Nieuwe account maken");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");

    }

    public void startKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer == 1){
            bestaandAccount();
        }else{
            nieuwAccount();
        }
    }

    public void geldKeuzeMenu(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil pinnnen");
        System.out.println("2 = Ik wil storten");
        System.out.println("3 = Wat is mijn saldo?");
        System.out.println("4 = Wat is mijn kredietlimiet?");
        System.out.println("5 = Ik wil mijn gegevens weergeven");
        System.out.println("6 = Ik wil mijn gegevens wijzigen");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");
    }

    public void geldKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer > 6 || pashouderinvoer < 0) {
            System.out.println("onjuiste invoer");
            geldKeuzeMenu();
            pashouderinvoer = user_input.nextInt();
        }
        if (pashouderinvoer == 1) {
            System.out.println("Hoeveel wilt u pinnen?:");
            pashouderinvoer = user_input.nextInt();
            geldPinnen(pashouderinvoer);
            getSaldo();
        }
        if (pashouderinvoer == 2) {
            System.out.println("Hoeveel wilt u storten?:");            pashouderinvoer = user_input.nextInt();
            geldStoren(pashouderinvoer);
            System.out.println("Storten is gelukt");
            getSaldo();
        }
        if (pashouderinvoer == 3) {
            getSaldo();
        }
        if (pashouderinvoer == 4) {
            getKredietlimiet();
        }
        if (pashouderinvoer == 5) {
            controleAccount();
        }
    }

    public void accountKeuzeMenu(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Kies een nummer");
        System.out.println("1 = Ik wil mijn naam wijzigen");
        System.out.println("2 = Ik wil mijn saldo wijzigen");
        System.out.println("3 = Ik wil mijn kredit wijzigen");
        System.out.println("4 = Ik wil mijn opnamelimiet wijzigen");
        System.out.println("5 = Ik wil mijn pincode wijzigen");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Wat is uw keuze: ");
    }



    public void accountKeuzeMenuANS(int pashouderinvoer){
        if (pashouderinvoer == 1){
            getNaampashouder();
            System.out.println("Wijzig uw naam in:");
            pashouderinvoer_string = user_input.nextLine();
            setNaampashouder(pashouderinvoer_string);
            getNaampashouder();
        }
        if (pashouderinvoer == 2){
            getSaldo();
            System.out.println("Wijzig uw saldo in:");
            pashouderinvoer = user_input.nextInt();
            setSaldo(pashouderinvoer);
            getSaldo();
        }
        if (pashouderinvoer == 3){
            getKredietlimiet();
            System.out.println("Wijzig uw kreditlimiet in:");
            pashouderinvoer = user_input.nextInt();
            if (pashouderinvoer < 0){
                setKredietlimiet(pashouderinvoer);
            }else {
                setKredietlimiet(-pashouderinvoer);
            }
            getKredietlimiet();
        }
        if (pashouderinvoer == 4){
            getOpnamelimiet();
            System.out.println("Wijzig de opnamelimiet in:");
            pashouderinvoer = user_input.nextInt();
            setOpnamelimiet(pashouderinvoer);
            getOpnamelimiet();
        }
        if (pashouderinvoer == 5){
            getPincode();
            System.out.println("Wijzig uw pincode in:");
            pashouderinvoer = user_input.nextInt();
            setPincode(pashouderinvoer);
            getPincode();
        }
    }

    private void bestaandAccount(){
        System.out.println("----------------------------------------------------------------");
        getNaampashouder();
        getNummerpashouder();
        getPincode();
        getSaldo();
        getKredietlimiet();
        getOpnamelimiet();
    }

    private void nieuwAccount(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Vul een naam in:");
        pashouderinvoer_string = user_input.nextLine();
        setNaampashouder(pashouderinvoer_string);

        System.out.println("Wat wordt uw nieuwe pincode? (Max.4 getallen):");
        int pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 9999){
            setPincode(pashouderinvoer_int);
        }else {
            System.out.println("[FOUT] Probeer opnieuw (Max. 4 getallen)!!");
            pashouderinvoer_int = user_input.nextInt();
            setPincode(pashouderinvoer_int);
        }

        System.out.println("Wat is uw pasnummer? (Max. 3 getallen):");
        pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 999) {
            setNummerpashouder(pashouderinvoer_int);
        }else{
            System.out.println("[FOUT] Probeer opnieuw (Max. 3 getallen)!!");
            pashouderinvoer_int = user_input.nextInt();
            setNummerpashouder(pashouderinvoer_int);
        }

        System.out.println("Stel uw nieuwe saldo in:");
        pashouderinvoer_int = user_input.nextInt();
        setSaldo(Math.abs(pashouderinvoer_int));

        System.out.println("Stel uw nieuwe kreditlimiet in:");
        pashouderinvoer_int = user_input.nextInt();
        if (pashouderinvoer_int < 0){
            setKredietlimiet(pashouderinvoer_int);
        }else {
            setKredietlimiet(-pashouderinvoer_int);
        }

        System.out.println("Stel geldautomaat limiet in:");
        pashouderinvoer_int = user_input.nextInt();
        setOpnamelimiet(Math.abs(pashouderinvoer_int));

        System.out.println("----------------------------------------------------------------");
        System.out.println("Nieuwe Opdracht2.Account succesvol aangemaakt");
        controleAccount();
    }

    private void controleAccount(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Acountgegevens");
        getNaampashouder();
        getNummerpashouder();
        getPincode();
        getSaldo();
        getKredietlimiet();
        getOpnamelimiet();
    }

    private int geldStoren(int storten){
        saldo = saldo+storten;
        return saldo;
    }

    private int geldPinnen(int pinnen){
        if (pinnen < opnamelimiet){
            if (saldo >= kredietlimiet){
                saldo = saldo - pinnen;
                System.out.println("Geld opname succesvol uitgevoerd");
            }
            if (saldo < kredietlimiet){
                saldo = saldo + pinnen;
                System.out.println("onvoldoende saldo");
            }
        }else{
            System.out.println("De geldautomaat heeft \n" +
                    "onvoldoende biljetten beschibaar");
        }
        return saldo;
    }

    private int getOpnamelimiet() {
        System.out.println("Opnamelimiet:\t€ "+opnamelimiet+",-");
        return opnamelimiet;
    }

    private void setOpnamelimiet(int opnamelimiet) {

        this.opnamelimiet = opnamelimiet;
    }
}