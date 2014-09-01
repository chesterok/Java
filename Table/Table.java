import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;

import java.util.HashSet;
 
public class Table extends JPanel {
    private String firstName; 
    private String secondName; 
    private int age;
    private boolean married; 
    private FavoriteColor favoriteColor;
    private Url homepage;
    private Url profileUrl;
    private static HashSet<Table> counter = new HashSet<Table>();

    public static HashSet<Table> getCounter() {
        return counter;
    }

    public String getProfileUrl() {
        return profileUrl.getUrl();
    }

    public String getFirstName() {
        return firstName;
    } 

    public String getSecondName() {
        return secondName;
    } 

    public int getAge() {
        return age;
    }

    public boolean getMarried() {
        return married;
    } 

    public FavoriteColor getFavoriteColor() {
        return favoriteColor;
    }

    public Url getHomepage() {
        return homepage;
    }

    public Table(String firstName, String secondName, 
        int age, boolean married, FavoriteColor favoriteColor, Url homepage, Url profileUrl) { 

        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.married = married;
        this.favoriteColor = favoriteColor;
        this.homepage = homepage;
        this.profileUrl = profileUrl;

        JTable table = new JTable(new MyTableModel(firstName, secondName, age, married, favoriteColor, homepage, profileUrl));

        table.setPreferredScrollableViewportSize(new Dimension(1000, 150));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
 
        table.setDefaultRenderer(Color.class, new ColorRenderer());
        add(scrollPane);
        counter.add(this);
    }

    public void createAndShowUI() {
        JFrame frame = new JFrame("User Data: ");
        Table newContentPane = new Table(firstName, secondName, age, married, favoriteColor, homepage, profileUrl);

        newContentPane.setOpaque(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
