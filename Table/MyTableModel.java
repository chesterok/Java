import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    private Object[][] data;
    private String[] columnNames = { 
         "First Name",
         "Second Name",
         "Age",
         "Married",
         "Favorite Color",
         "Home Page",
         "Profile Url"
                                   };

    MyTableModel(String firstName, String secondName, 
        int age, boolean married, FavoriteColor favoriteColor, Url homepage, Url profileUrl) {                           
        Object[][] construct = { { firstName, 
                               secondName, 
                               age,
                               married,
                               favoriteColor.getColor(),
                               homepage.getUrl(),
                               profileUrl.getUrl() 
                           } };
        data = construct;
    }

    public Object[][] getData() {
        return data;
    }

    public String[] columnNames() {
        return columnNames;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
