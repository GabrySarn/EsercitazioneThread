import java.awt.*;
import javax.swing.*;

public class Police extends Thread {

    private boolean online = true;
    private PoliceGui pg;

    public Police(PoliceGui pg) {
        this.pg = pg;
    }

    public void run() {
        synchronized (pg) {
            while (getOnline()) {
                try {
                    pg.getLblred().setBackground(Color.RED);
                    pg.getLblblue().setBackground(null);

                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {

                    pg.getLblred().setBackground(null);
                    pg.getLblblue().setBackground(Color.BLUE);

                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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