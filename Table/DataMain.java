import java.awt.Color;

import javax.swing.JFrame;

public class DataMain {
    public static void main(String[] args) {
        Table a = new Table("Yuriy", "Avilov", 10, false, new FavoriteColor(Color.red), 
            new Url("https://translate.google.com"), new Url("https://translate.google1.com"));
        Table b = new Table("Evgen", "Mikicey", 22, true, new FavoriteColor(Color.green), 
            new Url("https://translate.google2.com"), new Url("https://translate.google3.com"));
        Table c = new Table("Irina", "Mickitchik", 25, true, new FavoriteColor(Color.blue), 
            new Url("https://translate.google4.com"), new Url("https://translate.google5.com"));

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                Frame frame = new Frame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
