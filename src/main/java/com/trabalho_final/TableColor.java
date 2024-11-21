package com.trabalho_final;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableColor extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (row % 2 == 0) {
            cell.setBackground(Color.decode("#b4d9a5")); 
        } else {
            cell.setBackground(Color.decode("#c0d9b5")); 
        }
        
        return cell;
    }
}
