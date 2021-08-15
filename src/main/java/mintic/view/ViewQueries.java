package mintic.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mintic.controller.ControllerReto5;
import mintic.model.vo.LeadersBySalary;

public class ViewQueries extends JFrame {
    // public static final ViewQueries view = new ViewQueries();
    private Container _container;
    private ControllerReto5 _controller;
    private JTable contentTable;
    private Object data[][];
    private String columns[];

    public ViewQueries() {
        _controller = new ControllerReto5();
        _container = getContentPane();
        CreateWindow();
    }

    private void CreateWindow() {

        setTitle("Reto 5: SENTENCIAS SQL CON JAVA SWING");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 600;
        int height = 600;
        int xPos = (int) size.getWidth() / 2 - width / 2;
        int yPos = (int) size.getHeight() / 2 - height / 2;
        setBounds(xPos, yPos, width, height);

        _container.add(CreateHeaderPanel(), BorderLayout.NORTH);
        _container.add(CreateCenterPanel(), BorderLayout.CENTER);
        _container.add(CreateFooterPanel(), BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel CreateHeaderPanel() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setName("Header");
        headerPanel.setBackground(Color.gray);

        JButton button1 = new JButton("Lideres por Salario");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetLeadersBySalary();
            }
        });

        JButton button2 = new JButton("Proyectos por Ciudad");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetProjectsByCity();
            }
        });

        JButton button3 = new JButton("Lideres por Nombre");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetLeadersByName();
            }
        });

        headerPanel.add(button1);
        headerPanel.add(button2);
        headerPanel.add(button3);
        return headerPanel;
    }

    private JPanel CreateCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setName("Content");
        data = new Object[0][0];
        columns = new String[] { "Nombre", "Apellido", "ID", "Salario" };
        contentTable = new JTable(data, columns);
        centerPanel.add(new JScrollPane(contentTable), BorderLayout.CENTER);
        centerPanel.setVisible(false);
        return centerPanel;
    }

    private JPanel CreateFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout());
        footerPanel.setName("Footer");
        footerPanel.setBackground(Color.gray);
        JLabel author = new JLabel("Autor: Holman Leonardo Alvarez Morales");
        Font font = new Font("Verdana", Font.BOLD, 14);
        author.setFont(font);
        author.setForeground(Color.white);
        footerPanel.add(author);
        return footerPanel;
    }

    private void GetLeadersBySalary() {
        try {
            ArrayList<LeadersBySalary> leaders = _controller.GetLeadersBySalary();
            DefaultTableModel model = new DefaultTableModel();
            Object rowData[] = new Object[4];
            model.setColumnIdentifiers(columns);

            for (int i = 0; i < leaders.size(); i++) {
                rowData[0] = leaders.get(i).getName();
                rowData[1] = leaders.get(i).getFirstName();
                rowData[2] = leaders.get(i).getIdLeader();
                rowData[3] = leaders.get(i).getSalary();
                model.addRow(rowData);
            }

            contentTable.setModel(model);
            _container.getComponent(1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Error llamando a la consulta lideres por Salario" + e.getMessage());
        }
    }

    private void GetProjectsByCity() {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void GetLeadersByName() {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}