package mintic.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mintic.controller.ControllerReto5;
import mintic.model.vo.LeadersByName;
import mintic.model.vo.LeadersBySalary;
import mintic.model.vo.ProjectsByCity;

public class ViewQueries extends JFrame {
    // public static final ViewQueries view = new ViewQueries();
    private Container _container;
    private ControllerReto5 _controller;
    private JTable contentTable;
    private String columns[];

    public ViewQueries() {
        _controller = new ControllerReto5();
        _container = getContentPane();
        CreateWindow();
    }

    private void CreateWindow() {
        setTitle("Reto 5: SENTENCIAS SQL CON JAVA SWING");

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 800;
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
        headerPanel.setBackground(Color.darkGray);
        Font myFont = new Font("Verdana", Font.BOLD, 12);
        Color myColor = new Color(0, 150, 120, 255);

        JButton button1 = new JButton("LIDERES POR SALARIO");
        button1.setBackground(myColor);
        button1.setFont(myFont);
        button1.setForeground(Color.white);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetLeadersBySalary();
            }
        });

        JButton button2 = new JButton("PROYECTOS POR CIUDAD");
        button2.setBackground(myColor);
        button2.setFont(myFont);
        button2.setForeground(Color.white);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetProjectsByCity();
            }
        });

        JButton button3 = new JButton("LIDERES POR NOMBRE");
        button3.setBackground(myColor);
        button3.setFont(myFont);
        button3.setForeground(Color.white);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetLeadersByName();
            }
        });

        JButton button4 = new JButton("LIMPIAR DATOS");
        button4.setBackground(new Color(0, 150, 230, 255));
        button4.setFont(myFont);
        button4.setForeground(Color.white);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _container.getComponent(1).setVisible(false);
            }
        });

        headerPanel.add(button1);
        headerPanel.add(button2);
        headerPanel.add(button3);
        headerPanel.add(button4);
        return headerPanel;
    }

    private JPanel CreateCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setName("Content");
        centerPanel.setPreferredSize(new Dimension(600, 400));
        Object data[][] = new Object[0][0];
        columns = new String[] { "", "", "", "" };

        contentTable = new JTable(data, columns);
        contentTable.setGridColor(Color.GRAY);
        contentTable.setAutoResizeMode(4);
        contentTable.setEnabled(false);

        JTableHeader header = contentTable.getTableHeader();
        header.setFont(new Font("Verdana", Font.BOLD, 12));
        header.setForeground(Color.white);
        header.setBackground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(contentTable);
        scrollPane.setPreferredSize(new Dimension(600, 480));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.setVisible(false);
        return centerPanel;
    }

    private JPanel CreateFooterPanel() {
        JPanel footerPanel = new JPanel(new FlowLayout());
        footerPanel.setName("Footer");
        footerPanel.setBackground(Color.DARK_GRAY);
        JLabel author = new JLabel("Autor: Holman Leonardo Alvarez Morales");
        author.setFont(new Font("Verdana", Font.BOLD, 14));
        author.setForeground(Color.white);
        footerPanel.add(author);
        return footerPanel;
    }

    private void GetLeadersBySalary() {
        try {
            ArrayList<LeadersBySalary> leaders = new ArrayList<LeadersBySalary>();
            leaders = _controller.GetLeadersBySalary();
            DefaultTableModel model = new DefaultTableModel();
            Object rowData[] = new Object[4];
            columns = new String[] { "NOMBRE", "APELLIDO", "ID", "SALARIO" };
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
            ArrayList<ProjectsByCity> projects = new ArrayList<ProjectsByCity>();
            projects = _controller.GetProjectsByCity();
            DefaultTableModel model = new DefaultTableModel();
            Object rowData[] = new Object[4];
            columns = new String[] { "ID", "CONSTRUCTORA", "CIUDAD", "ESTRATO" };
            model.setColumnIdentifiers(columns);

            for (int i = 0; i < projects.size(); i++) {
                rowData[0] = projects.get(i).getIdProject();
                rowData[1] = projects.get(i).getBuilder();
                rowData[2] = projects.get(i).getCity();
                rowData[3] = projects.get(i).getStratum();
                model.addRow(rowData);
            }

            contentTable.setModel(model);
            _container.getComponent(1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Error llamando a la consulta proyectos por ciudad" + e.getMessage());
        }
    }

    private void GetLeadersByName() {
        try {
            ArrayList<LeadersByName> leaders = new ArrayList<LeadersByName>();
            leaders = _controller.GetLeadersByName();
            DefaultTableModel model = new DefaultTableModel();
            Object rowData[] = new Object[4];
            columns = new String[] { "ID", "NOMBRE", "APELLIDO" };
            model.setColumnIdentifiers(columns);

            for (int i = 0; i < leaders.size(); i++) {
                rowData[0] = leaders.get(i).getIdLeader();
                rowData[1] = leaders.get(i).getName();
                rowData[2] = leaders.get(i).getFirstName();
                model.addRow(rowData);
            }

            contentTable.setModel(model);
            _container.getComponent(1).setVisible(true);
        } catch (Exception e) {
            System.err.println("Error llamando a la consulta lideres por nombre" + e.getMessage());
        }
    }
}