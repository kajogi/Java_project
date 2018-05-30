package currencyconverter;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    queryExecution("SELECT id,value FROM currencies WHERE code LIKE " + "'%"
                            + JT_FromTo_Code.getText().toUpperCase() + "%'", "Search via Code");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btn_insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    queryExecution("INSERT INTO currencies (id, code, value) VALUES (" + JT_id.getText().toString() +
                            ", '" + JT_FromTo_Code.getText().toUpperCase() + "', '" + JT_Value.getText().toString() +
                            "')", "Insert via ID");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btn_update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (JT_id != null && JT_FromTo_Code != null && JT_Value != null) {
                        queryExecution("UPDATE currencies SET code = '" + JT_FromTo_Code.getText().toUpperCase()
                                + "', value = '" + JT_Value.getText().toString() + "' WHERE id = "
                                + JT_id.getText().toString(), "Update via ID");
                    } else {
                        JOptionPane.showMessageDialog(null, "One or more parameters missing!");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    queryExecution("DELETE FROM currencies WHERE id = " + JT_id.getText().toString(),
                            "Delete via ID");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }



    public void queryExecution(String sql, String id) {
        Connection connection = null;
        Statement stmt = null;
        DataSource dataSource = DBConnection.connectToDB();
        try {
            connection = dataSource.getConnection();
            stmt = connection.createStatement();
            if (id == "Search via Code") {
                ResultSet execute = stmt.executeQuery(sql);
                while (execute.next()) {
                    int value_id = execute.getInt("id");
                    float value = execute.getFloat("value");
                    String value_to_return = String.valueOf(value);
                    String id_to_return = String.valueOf(value_id);
                    JT_Value.setText(value_to_return);
                    JT_id.setText(id_to_return);
                }
            }
            if (id == "Insert via ID") {
                int row = stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Insertion successful!");
            }
            if (id == "Update via ID") {
                int row = stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Update successful!");
            }
            if (id == "Delete via ID") {
                int row = stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Delete successful!");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main() {
        new DatabaseGUI();
    }
}
