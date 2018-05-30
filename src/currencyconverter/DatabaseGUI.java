package currencyconverter;

import javax.swing.*;

public class DatabaseGUI extends JFrame {
    JLabel JL_FromTo_Code, JL_Value, JL_id;
    JTextField JT_FromTo_Code, JT_Value, JT_id;
    JButton btn_insert, btn_update, btn_delete, btn_search;

    public DatabaseGUI() {
        super("Database Controller");
        JL_id = new JLabel("ID:");
        JL_FromTo_Code = new JLabel("From-To Code");
        JL_Value = new JLabel("Value");
        JL_id.setBounds(20, 20, 100, 20);
        JL_FromTo_Code.setBounds(20, 50, 100, 20);
        JL_Value.setBounds(20, 80, 100, 20);
        JT_id = new JTextField(20);
        JT_FromTo_Code = new JTextField(10);
        JT_Value = new JTextField(10);
        JT_id.setBounds(130, 20, 150, 20);
        JT_FromTo_Code.setBounds(130, 50, 150, 20);
        JT_Value.setBounds(130, 80, 150, 20);
        btn_insert = new JButton("Insert");
        btn_update = new JButton("Update");
        btn_delete = new JButton("Delete");
        btn_search = new JButton("Search");
        btn_insert.setBounds(300, 20, 80, 20);
        btn_update.setBounds(300, 50, 80, 20);
        btn_delete.setBounds(300, 80, 80, 20);
        btn_search.setBounds(300, 110, 80, 20);

        setLayout(null);
        add(JL_id);
        add(JL_FromTo_Code);
        add(JL_Value);
        add(JT_id);
        add(JT_FromTo_Code);
        add(JT_Value);
        add(btn_insert);
        add(btn_update);
        add(btn_delete);
        add(btn_search);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500, 200);
    }
}