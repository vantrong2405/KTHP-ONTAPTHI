import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginServer extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblUsername, lblPassword, lblTitle;

    // Cấu hình kết nối với cơ sở dữ liệu
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db"; // URL cơ sở dữ liệu
    private static final String DB_USER = "root";  // Tên đăng nhập DB
    private static final String DB_PASSWORD = "Admin123@"; // Mật khẩu DB

    public LoginServer() {
        setTitle("Đăng nhập");
        setSize(600, 350);  // Tăng kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Đặt cửa sổ vào giữa màn hình

        // Tạo panel chứa các thành phần giao diện
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để kiểm soát layout linh hoạt
        panel.setBackground(new Color(240, 240, 240)); // Màu nền sáng, nhẹ nhàng

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần
        gbc.anchor = GridBagConstraints.WEST;

        // Tiêu đề giao diện
        lblTitle = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(new Color(0, 102, 204)); // Màu xanh cho tiêu đề
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        // Tên đăng nhập
        lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        lblUsername.setForeground(new Color(0, 102, 204)); // Màu chữ đẹp
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsername, gbc);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsername.setBackground(new Color(255, 255, 255));
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Làm cho ô nhập liệu trải rộng hết chiều ngang
        gbc.weightx = 1.0;  // Cho phép ô nhập liệu chiếm hết không gian còn lại
        panel.add(txtUsername, gbc);

        // Mật khẩu
        lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPassword.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lblPassword, gbc);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPassword.setBackground(new Color(255, 255, 255));
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Làm cho ô nhập liệu trải rộng hết chiều ngang
        gbc.weightx = 1.0;  // Cho phép ô nhập liệu chiếm hết không gian còn lại
        panel.add(txtPassword, gbc);

        // Nút đăng nhập
        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect for button
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 84, 160));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 102, 204));
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        // Thêm sự kiện cho nút đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Thêm sự kiện khi nhấn phím Enter (tương tự nhấn nút đăng nhập)
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        // Thiết lập nội dung cho cửa sổ
        setContentPane(panel);
    }

    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        // Kiểm tra nếu tên đăng nhập và mật khẩu rỗng
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập và mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // So sánh với dữ liệu mặc định
        String defaultUsername = "admin";
        String defaultPassword = "Admin123@";

        if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // Nếu đăng nhập thành công, mở TaskClient
            openTaskClient();
            dispose(); // Đóng cửa sổ đăng nhập
        } else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mở TaskClient khi đăng nhập thành công
    private void openTaskClient() {
        // Mở cửa sổ TaskClient
        new Task_Server().setVisible(true);
    }

    // Phương thức main để chạy ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginServer().setVisible(true);
            }
        });
    }
}
