//Gabriele Sarnelli 4G 

import javax.swing.*;
import java.awt.*;

public class CronoGui extends JFrame {
    private JLabel lblSec;
    private JButton btnStart, btnStop, btnReset;
    private JPanel pnlNord, pnlSud;
    private Cronometro t;

    public CronoGui() {
        super("Cronometro");
        setLayout(new GridLayout(2, 3));
        lblSec = new JLabel("0");
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnReset = new JButton("Reset");

        pnlNord = new JPanel();
        pnlSud = new JPanel();

        t = new Cronometro(lblSec);

        btnStart.addActionListener(e -> {
            if (!t.isAlive())
                t.start();
        });

        btnStop.addActionListener(e -> {
            t.setOnline(false);
            t = new Cronometro(lblSec);
        });

        btnReset.addActionListener(e -> {
            lblSec.setText("0");
        });

        pnlNord.add(lblSec);
        pnlSud.add(btnStart);
        pnlSud.add(btnStop);
        pnlSud.add(btnReset);

        add(pnlNord);
        add(pnlSud);

        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new CronoGui();
    }

}
