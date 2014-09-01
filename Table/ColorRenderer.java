import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;
 
public class ColorRenderer extends JLabel
                           implements TableCellRenderer {
 
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) 
    {
        setOpaque(true);
        setBackground((Color)color);

        return this;
    }
}
