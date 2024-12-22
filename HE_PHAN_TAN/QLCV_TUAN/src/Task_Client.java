import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class Task_Client extends JFrame {

    private JTextField txtEmail, txtUsername, txtSearch;
    private JPasswordField txtOldPassword, txtNewPassword, txtConfirmPassword;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private TaskService taskService;
    private UserService userService;
    private String currentUsername;

    // Màu sắc và font chữ mới cho giao diện
    private static final Color HEADER_COLOR = new Color(0, 102, 204);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(245, 245, 245);
    private static final Color BUTTON_COLOR = new Color(51, 153, 255);
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 26);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.PLAIN, 16);
    private static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);

    // Constructor nhận username
    public Task_Client(String username) {
        this.currentUsername = username;
        setTitle("Task Management Client");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            taskService = (TaskService) Naming.lookup("rmi://localhost/TaskService");
            userService = (UserService) Naming.lookup("rmi://localhost/UserService");
            System.out.println("RMI Server connected successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối với Server RMI.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        initUI();
        loadUserInfo();
        loadUserTasks();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(HEADER_COLOR);
        JLabel lblHeader = new JLabel("Task Management Client", JLabel.CENTER);
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(HEADER_FONT);
        headerPanel.add(lblHeader, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(PANEL_BACKGROUND_COLOR);

        // Personal Info Panel
        JPanel personalInfoPanel = new JPanel(new GridBagLayout());
        personalInfoPanel.setBackground(PANEL_BACKGROUND_COLOR);
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin cá nhân"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(LABEL_FONT);
        txtEmail = new JTextField(20);
        txtEmail.setEditable(false);

        JLabel lblOldPassword = new JLabel("Mật khẩu cũ:");
        lblOldPassword.setFont(LABEL_FONT);
        txtOldPassword = new JPasswordField(20);

        JLabel lblNewPassword = new JLabel("Mật khẩu mới:");
        lblNewPassword.setFont(LABEL_FONT);
        txtNewPassword = new JPasswordField(20);

        JLabel lblConfirmPassword = new JLabel("Xác nhận mật khẩu:");
        lblConfirmPassword.setFont(LABEL_FONT);
        txtConfirmPassword = new JPasswordField(20);

        JButton btnUpdateInfo = new JButton("Cập nhật thông tin");
        btnUpdateInfo.setFont(BUTTON_FONT);
        btnUpdateInfo.setBackground(BUTTON_COLOR);
        btnUpdateInfo.setForeground(Color.WHITE);
        btnUpdateInfo.addActionListener(e -> updatePersonalInfo());

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        personalInfoPanel.add(lblEmail, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        personalInfoPanel.add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        personalInfoPanel.add(lblOldPassword, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        personalInfoPanel.add(txtOldPassword, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        personalInfoPanel.add(lblNewPassword, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        personalInfoPanel.add(txtNewPassword, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        personalInfoPanel.add(lblConfirmPassword, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        personalInfoPanel.add(txtConfirmPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = GridBagConstraints.CENTER;
        personalInfoPanel.add(btnUpdateInfo, gbc);

        mainPanel.add(personalInfoPanel, BorderLayout.NORTH);

        // Task Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Danh sách công việc"));

        tableModel = new DefaultTableModel();
        taskTable = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên công việc");
        tableModel.addColumn("Mô tả");
        tableModel.addColumn("Ngày hết hạn");
        tableModel.addColumn("Tên người dùng");
        tableModel.addColumn("Danh mục");
        tableModel.addColumn("Trạng thái");

        JScrollPane scrollPane = new JScrollPane(taskTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(PANEL_BACKGROUND_COLOR);
        JLabel lblSearch = new JLabel("Tìm kiếm người khác (Email hoặc Username):");
        lblSearch.setFont(LABEL_FONT);
        txtSearch = new JTextField(20);

        JButton btnSearchUser = new JButton("Tìm kiếm");
        btnSearchUser.setFont(BUTTON_FONT);
        btnSearchUser.setBackground(BUTTON_COLOR);
        btnSearchUser.setForeground(Color.WHITE);
        btnSearchUser.addActionListener(e -> searchUserInfo());

        searchPanel.add(lblSearch);
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearchUser);

        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void loadUserInfo() {
        try {
            User currentUser = userService.getUserInfo(currentUsername);
            if (currentUser != null) {
                txtEmail.setText(currentUser.getEmail());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải thông tin người dùng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadUserTasks() {
        try {
            List<Task> tasks = taskService.getTasksByUser(currentUsername);
            tableModel.setRowCount(0);
            for (Task task : tasks) {
                tableModel.addRow(new Object[] {
                    task.getId(),
                    task.getName(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.getUserFullName(),
                    task.getCategoryName(),
                    task.getStatus()
                });
            }

            // Cập nhật cột "Trạng thái" với JComboBox để thay đổi trạng thái
            taskTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(createStatusComboBox()));
            taskTable.getColumnModel().getColumn(6).setCellRenderer(new StatusCellRenderer());
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải danh sách công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JComboBox<String> createStatusComboBox() {
        String[] statuses = {"Pending", "In Progress", "Completed"};
        JComboBox<String> comboBox = new JComboBox<>(statuses);
        comboBox.addActionListener(e -> updateTaskStatus(comboBox));
        return comboBox;
    }

    private void updateTaskStatus(JComboBox<String> comboBox) {
        int row = taskTable.getSelectedRow();
        if (row != -1) {
            String selectedStatus = (String) comboBox.getSelectedItem();
            int taskId = (int) taskTable.getValueAt(row, 0);

            try {
                boolean success = taskService.updateTaskStatus(taskId, selectedStatus);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái công việc thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái công việc thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Không thể cập nhật trạng thái công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class StatusCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value != null ? value.toString() : "");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
    }

    private void updatePersonalInfo() {
        String oldPassword = new String(txtOldPassword.getPassword());
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        // Kiểm tra xem tất cả các trường có được điền đầy đủ không
        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra mật khẩu cũ có đúng không (trực tiếp trong UserService)
        try {
            // Lấy thông tin người dùng từ DB (hoặc server)
            User user = userService.getUserInfo(currentUsername);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Người dùng không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra mật khẩu cũ
            if (!userService.checkPassword(currentUsername, oldPassword)) {  // Kiểm tra mật khẩu cũ từ DB
                JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra mật khẩu mới và xác nhận mật khẩu có khớp không
            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu mới và xác nhận không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cập nhật mật khẩu mới vào cơ sở dữ liệu
            boolean passwordUpdated = userService.updatePassword(currentUsername, newPassword);
            if (passwordUpdated) {
                JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật mật khẩu thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối với server.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }







    private void searchUserInfo() {
        String searchQuery = txtSearch.getText();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email hoặc username để tìm kiếm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            User user = userService.getUserInfoBySearch(searchQuery);
            if (user != null) {
                JOptionPane.showMessageDialog(this,
                        "Thông tin người dùng: \nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail(),
                        "Thông tin người dùng", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng với thông tin này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tìm kiếm thông tin người dùng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Task_Client("username123").setVisible(true));
    }
}
