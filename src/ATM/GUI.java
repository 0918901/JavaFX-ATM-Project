package ATM;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Applet implements ActionListener {
    int saldo = 2000;
    int pincode = 0000;
    int rekeningnummer = 1234;
    String rekeninghouder = "Joey";

    boolean start       = true;
    boolean account     = false;
    boolean keuzemenu   = false;
    boolean status      = false;
    boolean setting     = false;

    Label       LB_Welkom,LB_Login_account,LB_Login_pincode;
    Label       LB_Account_num,LB_Account_saldo,LB_Account_pincode,LB_Account_name;
    Label       LB_KM_V1,LB_KM_K1,LB_KM_K2,LB_KM_K3,LB_KM_K4,LB_KM_K5,LB_KM_K6;
    Label       LB_setName,LB_setPin,LB_setSaldo, LB_SL;
    Button      BT_Login,BT_Change,BT_Delete,BT_Input,BT_Pinnen,BT_Storten;
    TextField   TF_Acc_Num, KM_input, KM_Pinnen,KM_Storten;
    TextField   TF_Acc_Status,TF_Acc_saldo,TF_Acc_Name,TF_Acc_Pincode;
    TextField   TF_setName,TF_setPin,TF_setSaldo;
    Image       IM_Account;
    List        SB_Logboek = new List(500,true);
    MediaTracker mediaTracker;
    JPasswordField TF_Acc_Pin;

    Font Font_Titel     = new Font("TimesRoman",Font.BOLD,60);
    Font Font_Text      = new Font("TimesRoman",Font.BOLD,20);
    Font Font_Label     = new Font("TimesRoman",Font.BOLD,25);


    int SCSize_Width = 1200;
    int SCSize_Height = 800;

    int VC_SL1  =   50,     HZ_SL1   =   50;
    int VC_SL2  =   200,    HZ_SL3  =   400;
    int VC_SL3  =   300,    HZ_SL2  =   600;
    int VC_SL4  =   550,    HZ_SL4  =   850;

    int BT_VC       = 40,   BT_HZ       = 200;
    int BT_VC_SL    = 50,   BT_HZ_SL    = 300;
    int LB_VC_Intro = 100,  LB_HZ_Intro = 400;
    int LB_VC_Login = 50,  LB_HZ_Login  = 200;
    int LB_VC_KM    = 50,  LB_HZ_KM     = 200;

    public void init() {
        setLayout(null);
        setSize(SCSize_Width,SCSize_Height);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.RED);

        LB_Welkom = new Label("Welkom bij het HRO Geldautomaat");
        LB_Welkom.setFont(Font_Titel);
        LB_Welkom.setBounds(HZ_SL1,VC_SL1,SCSize_Width-100,100);
        LB_Welkom.setAlignment(1);
        LB_Welkom.setForeground(Color.GREEN);
        LB_Welkom.setBackground(Color.LIGHT_GRAY);


        LB_Login_account = new Label(" Accountnummer:");
        LB_Login_account.setFont(Font_Label);
        LB_Login_account.setBounds(HZ_SL1,VC_SL2,225,50);
        LB_Login_account.getForeground();
        LB_Login_account.setBackground(Color.LIGHT_GRAY);


        LB_Login_pincode = new Label(" Pincode:");
        LB_Login_pincode.setFont(Font_Label);
        LB_Login_pincode.setBounds(HZ_SL3,VC_SL2,125,50);
        LB_Login_pincode.getForeground();
        LB_Login_pincode.setBackground(Color.LIGHT_GRAY);

        //

        LB_Account_num = new Label(" Acc.Num:");
        LB_Account_num.setFont(Font_Label);
        LB_Account_num.setBounds(HZ_SL1,VC_SL3,125,50);
        LB_Account_num.getForeground();
        LB_Account_num.setBackground(Color.LIGHT_GRAY);

        LB_Account_name = new Label(" Naam:");
        LB_Account_name.setFont(Font_Label);
        LB_Account_name.setBounds(HZ_SL1,VC_SL3+50,125,50);
        LB_Account_name.getForeground();
        LB_Account_name.setBackground(Color.LIGHT_GRAY);

        LB_Account_saldo = new Label(" Saldo:");
        LB_Account_saldo.setFont(Font_Label);
        LB_Account_saldo.setBounds(HZ_SL1,VC_SL3+100,125,50);
        LB_Account_saldo.getForeground();
        LB_Account_saldo.setBackground(Color.LIGHT_GRAY);

        LB_Account_pincode = new Label(" Pincode:");
        LB_Account_pincode.setFont(Font_Label);
        LB_Account_pincode.setBounds(HZ_SL1,VC_SL3+150,125,50);
        LB_Account_pincode.getForeground();
        LB_Account_pincode.setBackground(Color.LIGHT_GRAY);

        LB_setName = new Label(" Naam:");
        LB_setName.setFont(Font_Label);
        LB_setName.setBounds(HZ_SL1,VC_SL4,125,50);
        LB_setName.getForeground();
        LB_setName.setBackground(Color.LIGHT_GRAY);

        LB_setSaldo = new Label(" Saldo:");
        LB_setSaldo.setFont(Font_Label);
        LB_setSaldo.setBounds(HZ_SL1,VC_SL4+50,125,50);
        LB_setSaldo.getForeground();
        LB_setSaldo.setBackground(Color.LIGHT_GRAY);

        LB_setPin = new Label(" Pincode:");
        LB_setPin.setFont(Font_Label);
        LB_setPin.setBounds(HZ_SL1,VC_SL4+100,125,50);
        LB_setPin.getForeground();
        LB_setPin.setBackground(Color.LIGHT_GRAY);

        LB_KM_V1 = new Label(" Keuzemenu");
        LB_KM_V1.setFont(Font_Label);
        LB_KM_V1.setBounds(HZ_SL3,VC_SL3,400,50);
        LB_KM_V1.setAlignment(1);
        LB_KM_V1.getForeground();
        LB_KM_V1.setBackground(Color.LIGHT_GRAY);

        LB_KM_K1 = new Label(" 1 = Ik wil pinnnen");
        LB_KM_K1.setFont(Font_Text);
        LB_KM_K1.setBounds(HZ_SL3,VC_SL3+50,400,50);
        LB_KM_K1.getForeground();
        LB_KM_K1.setBackground(Color.LIGHT_GRAY);

        LB_KM_K2 = new Label(" 2 = Ik wil storten");
        LB_KM_K2.setFont(Font_Text);
        LB_KM_K2.setBounds(HZ_SL3,VC_SL3+100,400,50);
        LB_KM_K2.getForeground();
        LB_KM_K2.setBackground(Color.LIGHT_GRAY);

        LB_KM_K3 = new Label(" 3 = Wat is mijn saldo?");
        LB_KM_K3.setFont(Font_Text);
        LB_KM_K3.setBounds(HZ_SL3,VC_SL3+150,400,50);
        LB_KM_K3.getForeground();
        LB_KM_K3.setBackground(Color.LIGHT_GRAY);

        LB_KM_K4 = new Label(" 4 = Wat is mijn kredietlimiet?");
        LB_KM_K4.setFont(Font_Text);
        LB_KM_K4.setBounds(HZ_SL3,VC_SL3+200,400,50);
        LB_KM_K4.getForeground();
        LB_KM_K4.setBackground(Color.LIGHT_GRAY);

        LB_KM_K5 = new Label(" 5 = Ik wil mijn gegevens weergeven");
        LB_KM_K5.setFont(Font_Text);
        LB_KM_K5.setBounds(HZ_SL3,VC_SL3+250,400,50);
        LB_KM_K5.getForeground();
        LB_KM_K5.setBackground(Color.LIGHT_GRAY);

        LB_KM_K6 = new Label(" 6 = Ik wil mijn gegevens wijzigen");
        LB_KM_K6.setFont(Font_Text);
        LB_KM_K6.setBounds(HZ_SL3,VC_SL3+300,400,50);
        LB_KM_K6.getForeground();
        LB_KM_K6.setBackground(Color.LIGHT_GRAY);

        LB_SL = new Label(" Banklogmenu");
        LB_SL.setFont(Font_Text);
        LB_SL.setAlignment(1);
        LB_SL.setBounds(HZ_SL4,VC_SL2,300,50);
        LB_SL.getForeground();
        LB_SL.setBackground(Color.LIGHT_GRAY);

        BT_Login = new Button("Login");
        BT_Login.setBounds(HZ_SL2+50,VC_SL2+5,BT_HZ-50,BT_VC);

        BT_Change = new Button("Bijwerken");
        BT_Change.setBounds(HZ_SL1+5,VC_SL4+155,BT_HZ+90,BT_VC);

        BT_Delete = new Button("Verwijderen");
        BT_Delete.setBounds(HZ_SL4,VC_SL4+150,BT_HZ_SL,BT_VC_SL);

        BT_Input = new Button("Volgende");
        BT_Input.setBounds(HZ_SL3+230,VC_SL4+155,BT_HZ-50,BT_VC);

        BT_Pinnen = new Button("Geld pinnen");
        BT_Pinnen.setBounds(HZ_SL3+230,VC_SL4+155,BT_HZ-50,BT_VC);

        BT_Storten = new Button("Geld storten");
        BT_Storten.setBounds(HZ_SL3+230,VC_SL4+155,BT_HZ-50,BT_VC);

        TF_Acc_Num = new TextField("");
        TF_Acc_Num.setFont(Font_Text);
        TF_Acc_Num.setBounds(HZ_SL1+230,VC_SL2+12,BT_HZ-100,BT_VC-10);

        TF_Acc_Pin = new JPasswordField();
        TF_Acc_Pin.setFont(Font_Text);
        TF_Acc_Pin.setBounds(HZ_SL3+130,VC_SL2+12,BT_HZ-100,BT_VC-10);

        TF_Acc_Status = new TextField("");
        TF_Acc_Status.setFont(Font_Label);
        TF_Acc_Status.setBounds(HZ_SL1+150,VC_SL3+5,125,40);
        TF_Acc_Status.disable();

        TF_Acc_Name = new TextField("");
        TF_Acc_Name.setFont(Font_Label);
        TF_Acc_Name.setBounds(HZ_SL1+150,VC_SL3+55,125,40);
        TF_Acc_Name.disable();

        TF_Acc_saldo = new TextField("");
        TF_Acc_saldo.setFont(Font_Label);
        TF_Acc_saldo.setBounds(HZ_SL1+150,VC_SL3+105,125,40);
        TF_Acc_saldo.disable();

        TF_Acc_Pincode = new TextField("");
        TF_Acc_Pincode.setFont(Font_Label);
        TF_Acc_Pincode.setBounds(HZ_SL1+150,VC_SL3+155,125,40);
        TF_Acc_Pincode.disable();

        TF_setName = new TextField("");
        TF_setName.setFont(Font_Label);
        TF_setName.setBounds(HZ_SL1+150,VC_SL4+5,125,40);
        TF_setName.enable(false);

        TF_setSaldo = new TextField("");
        TF_setSaldo.setFont(Font_Label);
        TF_setSaldo.setBounds(HZ_SL1+150,VC_SL4+55,125,40);
        TF_setSaldo.enable(false);

        TF_setPin = new TextField("");
        TF_setPin.setFont(Font_Label);
        TF_setPin.setBounds(HZ_SL1+150,VC_SL4+105,125,40);
        TF_setPin.enable(false);

        KM_input = new TextField("");
        KM_input.setFont(Font_Label);
        KM_input.setBounds(HZ_SL3+5,VC_SL4+155,125,40);

        KM_Storten = new TextField("");
        KM_Storten.setFont(Font_Label);
        KM_Storten.setBounds(HZ_SL3+5,VC_SL4+155,125,40);

        KM_Pinnen = new TextField("");
        KM_Pinnen.setFont(Font_Label);
        KM_Pinnen.setBounds(HZ_SL3+5,VC_SL4+155,125,40);

        SB_Logboek.setBounds(HZ_SL4,VC_SL2+50,300,450);
        SB_Logboek.setFont(Font_Label);

        BT_Login.addActionListener(this);
        BT_Change.addActionListener(this);
        BT_Delete.addActionListener(this);
        BT_Input.addActionListener(this);

        add(LB_Welkom);
        add(SB_Logboek);

        IM_Account = getImage(getCodeBase(), "profile.jpg");

        add(TF_Acc_Num);
        add(TF_Acc_Pin);

        add(BT_Login);
        add(BT_Change);
        add(BT_Delete);
        add(BT_Input);

        add(TF_Acc_Status);
        add(TF_Acc_Name);
        add(TF_Acc_saldo);
        add(TF_Acc_Pincode);

        add(TF_setName);
        add(TF_setSaldo);
        add(TF_setPin);

        add(LB_Login_account);
        add(LB_Login_pincode);

        add(LB_Account_name);
        add(LB_Account_num);
        add(LB_Account_saldo);
        add(LB_Account_pincode);

        add(LB_setName);
        add(LB_setSaldo);
        add(LB_setPin);

        add(LB_KM_V1);
        add(LB_KM_K1);
        add(LB_KM_K2);
        add(LB_KM_K3);
        add(LB_KM_K4);
        add(LB_KM_K5);
        add(LB_KM_K6);
        add(LB_SL);
    }

    public void paint(Graphics g){


        mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(IM_Account,1);
        g.drawImage(IM_Account,600,350,100,100,this);
        setForeground(Color.LIGHT_GRAY);
        g.fillRect(HZ_SL1,VC_SL1,1100,100);
        g.setColor(Color.RED);
        g.fillRect(HZ_SL1,VC_SL2,750,50);
        g.setColor(Color.BLUE);
        g.fillRect(HZ_SL1,VC_SL3,300,200);
        g.setColor(Color.GREEN);
        g.fillRect(HZ_SL1,VC_SL4,300,200);
        g.setColor(Color.CYAN);
        g.fillRect(HZ_SL3,VC_SL4+150,400,50);
        g.setColor(Color.YELLOW);
        g.fillRect(HZ_SL4,VC_SL2,300,550);

    }

    public void actionPerformed(ActionEvent e) {
        int Accountnummer = Integer.parseInt(TF_Acc_Num.getText());
        int Controlepincode = Integer.parseInt(String.valueOf(TF_Acc_Pin.getPassword()));
        if(e.getSource() == BT_Login) {
            if (Accountnummer == rekeningnummer && Controlepincode == pincode) {
                SB_Logboek.add("Acount 1234 ingelogd");
                TF_Acc_Num.disable();
                TF_Acc_Pin.disable();
                add(KM_input);
            }else {
                SB_Logboek.add("Onjuiste invoer");
            }
        }

        if(e.getSource() == BT_Delete){
            SB_Logboek.remove(SB_Logboek.getSelectedItem());
            SB_Logboek.deselect(SB_Logboek.getSelectedIndex());
        }
        int Keuze = Integer.parseInt(KM_input.getText());
        if(e.getSource() == BT_Input) {
            if (Keuze == 1) {
                KM_input.setText("");
                TF_Acc_saldo.setBackground(Color.WHITE);
                SB_Logboek.add("Pinnen");
                remove(BT_Input);
                remove(KM_input);
                add(KM_Pinnen);
                add(BT_Pinnen);
                int Pinnen = Integer.parseInt(KM_Pinnen.getText());
                if(e.getSource() == BT_Pinnen) {
                    if (Pinnen < saldo) {
                        KM_Pinnen.setText("");
                        saldo = Pinnen - saldo;
                        SB_Logboek.add("Nieuwe saldo: € " + saldo);
                        remove(KM_Pinnen);
                        remove(BT_Pinnen);
                        add(KM_input);
                        add(BT_Input);
                    } else {
                        KM_Pinnen.setText("");
                        SB_Logboek.add("Onvoldoende saldo");
                    }
                }
            }else if(Keuze == 2) {
                KM_input.setText("");
                TF_Acc_saldo.setBackground(Color.WHITE);
                SB_Logboek.add("Storten");
                remove(BT_Input);
                remove(KM_input);
                add(KM_Storten);
                add(BT_Storten);
                int Storten = Integer.parseInt(KM_Storten.getText());
                if(e.getSource() == BT_Storten) {
                    if (Storten > 0) {
                        KM_Storten.setText("");
                        saldo = Storten + saldo;
                        SB_Logboek.add("Nieuwe saldo: € " + saldo);
                        remove(KM_Storten);
                        remove(BT_Storten);
                        add(KM_input);
                        add(BT_Input);
                    } else {
                        KM_Storten.setText("");
                        SB_Logboek.add("Ongeldige invoer");
                    }
                }
            }else if(Keuze == 3){
                KM_input.setText("");
                account = true;
                TF_Acc_saldo.setBackground(Color.WHITE);
                TF_Acc_saldo.setText("€ "+saldo);
                SB_Logboek.add("Huidige saldo: € "+saldo);
                TF_Acc_saldo.setBackground(Color.GREEN);
            }else if(Keuze == 4){
                KM_input.setText("");
                keuzemenu = true;
                TF_Acc_saldo.setBackground(Color.WHITE);
                SB_Logboek.add("Geen Kreditlimiet");
            }else if(Keuze == 5){
                KM_input.setText("");
                status = true;
                TF_Acc_saldo.setBackground(Color.WHITE);
                SB_Logboek.add("Gegevens weergeven");
                TF_Acc_Status.setText(""+rekeningnummer);
                TF_Acc_Name.setText(rekeninghouder);
                TF_Acc_saldo.setText("€ "+saldo);
                TF_Acc_Pincode.setText(""+pincode);
            }else if(Keuze == 6){
                KM_input.setText("");
                setting = true;
                TF_Acc_saldo.setBackground(Color.WHITE);
                SB_Logboek.add("Gegevens wijzigen");
                TF_setName.enable(true);
                TF_setSaldo.enable(true);
                TF_setPin.enable(true);
            }else {
                SB_Logboek.add("Onjuiste invoer");
            }
        }
        String naam = TF_setName.getText().toString();
        int nieuwsaldo = Integer.parseInt(TF_setSaldo.getText());
        int nieuwpincode = Integer.parseInt(TF_setPin.getText());
        if(e.getSource() == BT_Change) {
            naam = rekeninghouder;
            nieuwsaldo = saldo;
            nieuwpincode = pincode;
            SB_Logboek.add("Gegevens aangepast");
        }
    }
}



