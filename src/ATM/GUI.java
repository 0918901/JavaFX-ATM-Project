package ATM;

import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Applet implements ActionListener{
    Account account;
    private Label Controle;
    private Label SK_Keuze;
    Label GKM_Account;
    Label accountpincode;
    private Label GKM_1;
    private Label GKM_2;
    private Label GKM_3;
    private Label GKM_4;
    private Label GKM_5;
    private Label GKM_6;
    Label naampashouder,nummerpashouder,pincode,saldo,kredietlimiet;
    private Button Next_Button;
    private Button BPincode;
    private Button Keuze_Button;
    private TextField SK_Keuzevak;
    TextField Pincode;

    private Font Font_Titel = new Font("TimesRoman",Font.BOLD,30);
    private Font Font_Text = new Font("TimesRoman",Font.PLAIN,20);
    Font Font_Label = new Font("TimesRoman",Font.PLAIN,25);

    public void init(){
        setLayout(null);
        setSize(800,800);
        setBackground(Color.LIGHT_GRAY);

        Label titel = new Label("Welkom bij HRO geldautomaat");
        titel.setFont(Font_Titel);
        int TL_Label = 800;
        int TH_Label = 40;
        titel.setBounds(180,20, TL_Label, TH_Label);

        Label k_Vraag = new Label("Kies een nummer:");
        k_Vraag.setFont(Font_Text);
        int h_lijn = 80;
        int v_lijn = 100;
        k_Vraag.setBounds(h_lijn, v_lijn, TL_Label, TH_Label);

        GKM_1 = new Label("1 = Ik wil een testaccount gebruiken");
        GKM_1.setFont(Font_Text);
        GKM_1.setBounds(h_lijn, v_lijn +40, TL_Label, TH_Label);

        GKM_2 = new Label("2 = Nieuwe account maken");
        GKM_2.setFont(Font_Text);
        GKM_2.setBounds(h_lijn, v_lijn +80, TL_Label, TH_Label);

        GKM_3 = new Label("");
        GKM_3.setFont(Font_Text);
        GKM_3.setBounds(h_lijn, v_lijn +125, TL_Label, TH_Label);

        GKM_4 = new Label("");
        GKM_4.setFont(Font_Text);
        GKM_4.setBounds(h_lijn, v_lijn +160, TL_Label, TH_Label);

        GKM_5 = new Label("");
        GKM_5.setFont(Font_Text);
        GKM_5.setBounds(h_lijn, v_lijn +200, TL_Label, TH_Label);

        GKM_6 = new Label("");
        GKM_6.setFont(Font_Text);
        GKM_6.setBounds(h_lijn, v_lijn +240, TL_Label, TH_Label);

        SK_Keuze = new Label("Wat is uw keuze: ");
        SK_Keuze.setFont(Font_Text);
        SK_Keuze.setBounds(h_lijn, v_lijn +300, TL_Label, TH_Label);

        Next_Button = new Button("Volgende");
        Next_Button.setFont(Font_Text);
        int TL_Button = 100;
        int TH_Button = 35;
        Next_Button.setBounds(h_lijn, v_lijn +350, TL_Button, TH_Button);

        BPincode = new Button("Check");
        BPincode.setFont(Font_Text);
        BPincode.setBounds(h_lijn, v_lijn +350, TL_Button, TH_Button);

        Keuze_Button = new Button("Volgende");
        Keuze_Button.setFont(Font_Text);
        Keuze_Button.setBounds(h_lijn, v_lijn +350, TL_Button, TH_Button);

        SK_Keuzevak = new TextField(40);
        SK_Keuzevak.setFont(Font_Text);
        SK_Keuzevak.setBounds(h_lijn +200, v_lijn +300, TL_Button, TH_Button);

        Controle = new Label("");
        Controle.setFont(Font_Text);
        Controle.setBounds(h_lijn +320, v_lijn +300,200, TH_Label);

        add(GKM_1);
        add(GKM_2);
        add(GKM_3);
        add(GKM_4);
        add(GKM_5);
        add(GKM_6);
        add(Controle);
        add(SK_Keuzevak);
        add(titel);
        add(k_Vraag);


        add(SK_Keuze);



        add(Next_Button);
        Next_Button.addActionListener(this);
        BPincode.addActionListener(this);
        Keuze_Button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Next_Button) {
            int MenuKeuze = Integer.parseInt(SK_Keuzevak.getText());
            if (MenuKeuze == 1) {
                SK_Keuzevak.setText("");
                remove(Next_Button);
                Controle.setText("");
                GKM_1.setText("");
                GKM_2.setText("");
                add(BPincode);
                SK_Keuze.setText("Vul pincode in:");
            }
            else if (MenuKeuze == 2) {
                Controle.setText("");
                SK_Keuzevak.setText("");
            }
            else{
                Controle.setText("onjuiste invoer");
                Controle.setBackground(Color.RED);
                SK_Keuzevak.setText("");
            }
        }
        if(e.getSource() == BPincode) {
            int PincodeControle = Integer.parseInt(SK_Keuzevak.getText());
            if (PincodeControle == 1234) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                remove(BPincode);
                add(Keuze_Button);
                SK_Keuze = new Label("Wat is uw keuze: ");
                GKM_1.setText("1 = Ik wil pinnnen");
                GKM_2.setText("2 = Ik wil storten");
                GKM_3.setText("3 = Wat is mijn saldo?");
                GKM_4.setText("4 = Wat is mijn kredietlimiet?");
                GKM_5.setText("5 = Ik wil mijn gegevens weergeven");
                GKM_6.setText("6 = Ik wil mijn gegevens wijzigen");
            }else{
                Controle.setText("onjuiste invoer");
                Controle.setBackground(Color.RED);
                SK_Keuzevak.setText("");
            }
        }
        if(e.getSource() == Keuze_Button) {
            int StartMenuKeuze = Integer.parseInt(SK_Keuzevak.getText());
            if (StartMenuKeuze == 1) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else if (StartMenuKeuze == 2) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else if (StartMenuKeuze == 3) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else if (StartMenuKeuze == 4) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else if (StartMenuKeuze == 5) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else if (StartMenuKeuze == 6) {
                SK_Keuzevak.setText("");
                Controle.setText("");
                SK_Keuze.setText("Hoeveel wilt u pinnen?:");
            } else {
                Controle.setText("onjuiste invoer");
                Controle.setBackground(Color.RED);
                SK_Keuzevak.setText("");
            }
        }
    }
}
