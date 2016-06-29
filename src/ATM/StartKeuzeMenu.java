package ATM;

public class StartKeuzeMenu {
    boolean Intro = true;
    boolean newAccount = false;
    boolean SKM_Vraag1 = false;
    boolean SKM_Vraag2 = false;
    boolean IntroVraag = false;

    public StartKeuzeMenu(boolean intro, boolean newAccount, boolean SKM_Vraag1, boolean SKM_Vraag2, boolean introVraag) {
        Intro = intro;
        this.newAccount = newAccount;
        this.SKM_Vraag1 = SKM_Vraag1;
        this.SKM_Vraag2 = SKM_Vraag2;
        IntroVraag = introVraag;
    }

    public void setIntro(boolean intro) {
        Intro = intro;
    }

    public void setNewAccount(boolean newAccount) {
        this.newAccount = newAccount;
    }

    public void setSKM_Vraag1(boolean SKM_Vraag1) {
        this.SKM_Vraag1 = SKM_Vraag1;
    }

    public void setSKM_Vraag2(boolean SKM_Vraag2) {
        this.SKM_Vraag2 = SKM_Vraag2;
    }

    public void setIntroVraag(boolean introVraag) {
        IntroVraag = introVraag;
    }

    public void Start(){
        String Vraag = "Kies een nummer";
        String Keuze1 = "Keuze 1 - Test Account gebruiken";
        String Keuze2 = "Keuze 2 - Nieuwe Account maken";
        String InvoerLabel = "Wat is uw Keuze:";
    }

}
