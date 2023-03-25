//Gabriele Sarnelli 4G 

import java.awt.*;
import javax.swing.*;

public class PoliceGui extends JFrame {
    private JLabel lblred, lblblue;
    private JButton btnOn, btnOff;
    private Police p;

    public PoliceGui() {
        super("Police");
        setLayout(new GridLayout(2, 2));
        lblblue = new JLabel("BLUE");
        lblblue.setOpaque(true);
        lblblue.setHorizontalAlignment(JLabel.CENTER);
        lblred = new JLabel("RED");
        lblred.setOpaque(true);
        lblred.setHorizontalAlignment(JLabel.CENTER);

        p = new Police(this);

        btnOn = new JButton("ON");
        btnOn.addActionListener(e -> {
            if (!p.isAlive()){
            p.start();
            }
        });

        btnOff = new JButton("OFF");
        btnOff.addActionListener(e -> {
            p.setOnline(false);
            p = new Police(this);
            lblred.setBackground(null);
            lblblue.setBackground(null);
        });

        add(lblblue);
        add(lblred);
        add(btnOn);
        add(btnOff);

        setSize(300, 80);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JLabel getLblred() {
        return lblred;
    }

    public void setLblred(JLabel lblred) {
        this.lblred = lblred;
    }

    public JLabel getLblblue() {
        return lblblue;
    }

    public void setLblblue(JLabel lblblue) {
        this.lblblue = lblblue;
    }

    public static void main(String[] args) {
        new PoliceGui();
    }
}
