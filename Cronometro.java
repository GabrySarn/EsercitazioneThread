import javax.swing.*;

public class Cronometro extends Thread {

    private JLabel txt;
    private int i = 0;
    private boolean online = true;

    public Cronometro(JLabel txt) {
        this.txt = txt;
    }

    
    public void run() {
        while (getOnline()) {
            i = Integer.parseInt(txt.getText()) + 1;
            txt.setText("" + i);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    synchronized boolean getOnline() {
        return online;
    }

    synchronized void setOnline(boolean v) {
        online = v;
    }

}
