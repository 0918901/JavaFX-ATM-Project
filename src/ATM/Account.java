package ATM;

class Account{
    private String naampashouder = "testaccount";
    private int nummerpashouder = 123;
    private int pincode = 1234;
    int saldo = 100;
    int kredietlimiet = -500;

    Account(){

    }

    public Account(String naampashouder, int nummerpashouder, int pincode, int saldo, int kredietlimiet) {
        this.naampashouder = naampashouder;
        this.nummerpashouder = nummerpashouder;
        this.pincode = pincode;
        this.saldo = saldo;
        this.kredietlimiet = kredietlimiet;
    }

    String getNaampashouder() {
        System.out.println("Naam:\t\t\t"+ naampashouder);
        return naampashouder;
    }

    void setNaampashouder(String naampashouder) {
        this.naampashouder = naampashouder;
    }

    int getNummerpashouder() {
        System.out.println("Pasnummer:\t\t"+nummerpashouder);
        return nummerpashouder;
    }

    void setNummerpashouder(int nummerpashouder) {
        this.nummerpashouder = nummerpashouder;
    }

    int getPincode() {
        System.out.println("Pincode:\t\t"+pincode);
        return pincode;
    }

    void setPincode(int pincode) {
        this.pincode = pincode;
    }

    int getSaldo() {
        System.out.println("Saldo:\t\t\t€ "+saldo+",-");
        return saldo;
    }

    void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    int getKredietlimiet() {
        System.out.println("Kreditlimiet:\t€ "+kredietlimiet+",-");
        return kredietlimiet;
    }

    void setKredietlimiet(int kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }
}