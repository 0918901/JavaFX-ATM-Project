package ATM;

import java.util.Scanner;

class Geldautomaat{

    public static void main (String []args) {
        int pashouderinvoer;
        Scanner user_input = new Scanner(System.in);
        Betaalsysteem HRO = new Betaalsysteem();

        HRO.Welkom();
        HRO.startKeuzeMenu();
        pashouderinvoer = user_input.nextInt();
        HRO.startKeuzeMenuANS(pashouderinvoer);

        for(int x = 0; x<100; x++) {
            HRO.geldKeuzeMenu();
            pashouderinvoer = user_input.nextInt();
            if (pashouderinvoer == 1 ||
                    pashouderinvoer == 2 ||
                    pashouderinvoer == 3 ||
                    pashouderinvoer == 4 ||
                    pashouderinvoer == 5){
                HRO.geldKeuzeMenuANS(pashouderinvoer);
            }
            if (pashouderinvoer == 6) {
                HRO.accountKeuzeMenu();
                pashouderinvoer = user_input.nextInt();
                HRO.accountKeuzeMenuANS(pashouderinvoer);
            }else {
                System.out.println("ongeldige invoer probeer opnieuw");
            }
        }
    }
}