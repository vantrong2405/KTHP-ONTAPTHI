import Model.Phong;
import database.JDBCUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private JFrame frame;
    private JTextField txtMaSV, txtQueQuan, txtHoTen, txtSDT, txtNgaySinh, txtGmail;
    private JTable table;
    private DefaultTableModel tableModel;

    public Main() {
        initializeUI();
        setupEventListeners();
        connectToDatabase();
    }

    private void initializeUI() {
        frame = new JFrame("Quản Lý Phòng Trọ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = createTitlePanel();

        // Center Panel with Form and Table
        JPanel centerPanel = createCenterPanel();

        // Menu Panel
        JPanel menuPanel = createMenuPanel();

        // Button Panel
        JPanel buttonPanel = createButtonPanel();

        // Main Panel Assembly
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Danh sách các phòng trọ", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20),
            BorderFactory.createTitledBorder("Thông Tin Khách trọ:")
        ));

        formPanel.add(new JLabel("Mã Khách:"));
        txtMaSV = new JTextField();
        formPanel.add(txtMaSV);

        formPanel.add(new JLabel("Quê Quán:"));
        txtQueQuan = new JTextField();
        formPanel.add(txtQueQuan);

        formPanel.add(new JLabel("Họ Tên:"));
        txtHoTen = new JTextField();
        formPanel.add(txtHoTen);

        formPanel.add(new JLabel("Số điện thoại:"));
        txtSDT = new JTextField();
        formPanel.add(txtSDT);

        formPanel.add(new JLabel("Ngày Sinh:"));
        txtNgaySinh = new JTextField();
        formPanel.add(txtNgaySinh);

        formPanel.add(new JLabel("Gmail:"));
        txtGmail = new JTextField();
        formPanel.add(txtGmail);

        centerPanel.add(formPanel, BorderLayout.NORTH);

        // Table Panel
        String[] columnNames = {"Mã Khách", "Họ Tên", "Ngày Sinh", "Giới Tính", "Quê Quán", "Số điện thoại", "Gmail", "Mã Lớp", "Cộng nợ"};
        Object[][] data = {
            {"11", "Trần Trung Hiếu", "2001-01-01", "Nam", "Hà Nam", "12345578", "hieu@gmail.com", "1", "0"},
            {"12", "Đoàn Nam Hùng", "2001-01-01", "Nam", "Thái Bình", "086243620", "hung@gmail.com", "2", "1"},
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        return centerPanel;
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] menuItems = {
            "Danh sách Khách trọ", 
            "Nhập trọ", 
            "Đóng tiền", 
            "Thông báo Nộp Tiền", 
            "Xuất Báo Cáo"
        };

        for (String item : menuItems) {
            JButton btn = new JButton(item);
            btn.setBackground(new Color(240, 240, 240));
            menuPanel.add(btn);
        }

        return menuPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        String[] buttonLabels = {"Tìm Kiếm", "Cập Nhật", "Xóa", "Hiển Thị"};

        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            buttonPanel.add(btn);
        }

        return buttonPanel;
    }

    private void setupEventListeners() {
        // TODO: Implement event handling for buttons
    }

    private void connectToDatabase() {
        try {
            Connection connection = JDBCUtil.getConnection();
            if (connection != null) {
                System.out.println("Database connection successful!");
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, 
                "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage(), 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> new Main());
    }
}