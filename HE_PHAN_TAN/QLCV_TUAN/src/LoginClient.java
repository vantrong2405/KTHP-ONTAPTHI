import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginClient extends JFrame {

    private JTextField txtUsernameLogin, txtUsernameRegister;
    private JPasswordField txtPasswordLogin, txtPasswordRegister;
    private JButton btnLogin, btnRegisterLogin, btnRegisterRegister;
    private JLabel lblUsernameLogin, lblPasswordLogin, lblUsernameRegister, lblPasswordRegister, lblTitle;

    // Cấu hình kết nối cơ sở dữ liệu
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db"; // URL cơ sở dữ liệu
    private static final String DB_USER = "root";  // Tên đăng nhập DB
    private static final String DB_PASSWORD = "Admin123@"; // Mật khẩu DB

    public LoginClient() {
        setTitle("Đăng nhập / Đăng ký");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo tabbed pane để chuyển đổi giữa Login và Register
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel đăng nhập
        JPanel loginPanel = createLoginPanel();
        tabbedPane.addTab("Đăng nhập", loginPanel);

        // Panel đăng ký
        JPanel registerPanel = createRegisterPanel();
        tabbedPane.addTab("Đăng ký", registerPanel);

        // Thiết lập nội dung cho cửa sổ
        setContentPane(tabbedPane);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Tiêu đề
        lblTitle = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        // Tên đăng nhập
        lblUsernameLogin = new JLabel("Tên đăng nhập:");
        lblUsernameLogin.setFont(new Font("Arial", Font.PLAIN, 16));
        lblUsernameLogin.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsernameLogin, gbc);

        txtUsernameLogin = new JTextField();
        txtUsernameLogin.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsernameLogin.setBackground(new Color(255, 255, 255));
        txtUsernameLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtUsernameLogin, gbc);

        // Mật khẩu
        lblPasswordLogin = new JLabel("Mật khẩu:");
        lblPasswordLogin.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPasswordLogin.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lblPasswordLogin, gbc);
        txtPasswordLogin = new JPasswordField();
        txtPasswordLogin.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPasswordLogin.setBackground(new Color(255, 255, 255));
        txtPasswordLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtPasswordLogin, gbc);

        // Nút đăng nhập
        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Tiêu đề
        lblTitle = new JLabel("ĐĂNG KÝ", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        // Tên đăng nhập
        lblUsernameRegister = new JLabel("Tên đăng nhập:");
        lblUsernameRegister.setFont(new Font("Arial", Font.PLAIN, 16));
        lblUsernameRegister.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsernameRegister, gbc);

        txtUsernameRegister = new JTextField();
        txtUsernameRegister.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsernameRegister.setBackground(new Color(255, 255, 255));
        txtUsernameRegister.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtUsernameRegister, gbc);

        // Mật khẩu
        lblPasswordRegister = new JLabel("Mật khẩu:");
        lblPasswordRegister.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPasswordRegister.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lblPasswordRegister, gbc);

        txtPasswordRegister = new JPasswordField();
        txtPasswordRegister.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPasswordRegister.setBackground(new Color(255, 255, 255));
        txtPasswordRegister.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 2;   gbc.gridwidth = 1;
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtPasswordRegister, gbc);

        // Nút đăng ký
        btnRegisterRegister = new JButton("Đăng ký");
        btnRegisterRegister.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegisterRegister.setBackground(new Color(0, 102, 204));
        btnRegisterRegister.setForeground(Color.WHITE);
        btnRegisterRegister.setFocusPainted(false);
        btnRegisterRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnRegisterRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnRegisterRegister, gbc);

        return panel;
    }

    // Kiểm tra đăng nhập
    private void login() {
        String username = txtUsernameLogin.getText();
        String password = new String(txtPasswordLogin.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập và mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL truy vấn kiểm tra tên đăng nhập và mật khẩu
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Nếu đăng nhập thành công, mở TaskClient
                openTaskClient();
                dispose(); // Đóng cửa sổ đăng nhập
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Đăng ký người dùng mới
    private void register() {
        String username = txtUsernameRegister.getText();
        String password = new String(txtPasswordRegister.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập và mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Kiểm tra nếu tên đăng nhập đã tồn tại
            String checkSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet checkRs = checkStmt.executeQuery();

            if (checkRs.next()) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                // Thêm người dùng mới
                String insertSql = "INSERT INTO users (username, password, full_name, email) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.setString(3, "Full Name"); // Giả định là tên đầy đủ chưa nhập
                insertStmt.setString(4, "email@example.com"); // Giả định email chưa nhập

                int rowsAffected = insertStmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng ký không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mở cửa sổ TaskClient khi đăng nhập thành công
    private void openTaskClient() {
        // Mở cửa sổ TaskClient
        new Task_Client(txtUsernameLogin.getText()).setVisible(true);
    }

    // Phương thức main để chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginClient().setVisible(true);
            }
        });
    }
}
