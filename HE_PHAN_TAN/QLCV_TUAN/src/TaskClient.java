
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class TaskClient extends JFrame {

    private JTextField txtTaskName, txtDescription, txtSearch;
    private JSpinner txtDueDate;
    private JComboBox<String> comboUser, comboCategory, comboStatus;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private TaskService taskService;
    private int currentTaskId = -1;  
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Admin123@";

    public TaskClient() {
        setTitle("Task Management");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            taskService = (TaskService) Naming.lookup("rmi://localhost/TaskService");
            System.out.println("RMI Server connected successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối với Server RMI.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        initUI();
        loadAllTasks();
    }

    private void initUI() {
        setTitle("Ứng dụng Quản Lý Công Việc");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Title Panel with JLabel (căn giữa và màu đỏ)
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Ứng dụng Quản Lý Công Việc", SwingConstants.CENTER);
        titleLabel.setForeground(Color.RED); // Màu đỏ cho chữ
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Font chữ và kích thước
        titlePanel.add(titleLabel); // Thêm JLabel vào titlePanel

        // Input Panel for form fields (using GridLayout)
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10)); // GridLayout with spacing between rows and columns

        inputPanel.add(new JLabel("Tên công việc"));
        txtTaskName = new JTextField();
        inputPanel.add(txtTaskName);

        inputPanel.add(new JLabel("Mô tả"));
        txtDescription = new JTextField();
        inputPanel.add(txtDescription);

        inputPanel.add(new JLabel("Ngày hết hạn"));
        // Tạo một JSpinner với SpinnerDateModel
        SpinnerDateModel model = new SpinnerDateModel();
        txtDueDate = new JSpinner(model);

        // Đặt định dạng cho ngày (dễ đọc cho người dùng)
        JSpinner.DateEditor editor = new JSpinner.DateEditor(txtDueDate, "yyyy-MM-dd");
        txtDueDate.setEditor(editor);

        // Thêm Spinner vào JPanel
        inputPanel.add(txtDueDate);

        // Hiển thị panel trong một JFrame ví dụ
        JFrame frame = new JFrame("Chọn ngày");

        inputPanel.add(new JLabel("Tên người dùng"));
        comboUser = new JComboBox<>();
        loadUsers();  // Load users into combo box
        inputPanel.add(comboUser);

        inputPanel.add(new JLabel("Danh mục"));
        comboCategory = new JComboBox<>();
        loadCategories();  // Load categories into combo box
        inputPanel.add(comboCategory);

        inputPanel.add(new JLabel("Trạng thái"));
        comboStatus = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed"});
        inputPanel.add(comboStatus);

        inputPanel.add(new JLabel("Tìm kiếm"));
        txtSearch = new JTextField();
        inputPanel.add(txtSearch);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm công việc");
        JButton btnUpdate = new JButton("Cập nhật công việc");
        JButton btnDelete = new JButton("Xóa công việc");
        JButton btnSearch = new JButton("Tìm kiếm");
        JButton btnLoadData = new JButton("Tải lại danh sách");
        JButton btnClearDataInput = new JButton("Làm mới nhập liệu");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnLoadData);
        buttonPanel.add(btnClearDataInput);
        // Table for displaying tasks
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
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        taskTable.getSelectionModel().addListSelectionListener(e -> onTableRowSelected());
        setContentPane(panel);
        // Add listeners
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        btnClearDataInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currentDate = new Date();
                txtDescription.setText("");
                txtSearch.setText("");
                txtTaskName.setText("");
                txtDueDate.setValue(currentDate);
                comboCategory.setSelectedIndex(0);
                comboStatus.setSelectedIndex(0);
                comboUser.setSelectedIndex(0);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTask();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTasks();
            }
        });

        btnLoadData.addActionListener(new ActionListener() {  // Nút tải lại dữ liệu
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAllTasks();
            }
        });
    }

    private void loadAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            tableModel.setRowCount(0); // Xóa dữ liệu hiện tại
            int i = 1;
            for (Task task : tasks) {
                tableModel.addRow(new Object[]{
                    task.getId(), task.getName(), task.getDescription(), task.getDueDate(), task.getUserFullName(), task.getCategoryName(), task.getStatus()
                });
                i++;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải danh sách công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadUsers() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT id, full_name FROM users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                comboUser.addItem(rs.getString("full_name"));  // Chỉ lấy tên người dùng để hiển thị
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải danh sách người dùng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategories() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT id, name FROM categories";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                comboCategory.addItem(rs.getString("name"));  // Chỉ lấy tên danh mục để hiển thị
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải danh sách danh mục.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String convertToDateFormat(String inputDate) {
        try {
            // Định dạng ban đầu mà bạn có
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            // Phân tích chuỗi ngày vào đối tượng Date
            Date date = inputFormat.parse(inputDate);

            // Định dạng ngày đầu ra là "YYYY-MM-DD"
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Chuyển đối tượng Date thành chuỗi theo định dạng yêu cầu
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Xử lý lỗi nếu không thể phân tích chuỗi ngày
            e.printStackTrace();
            return null;
        }
    }

    public static Date resetTime(Date date) {
        // Tạo đối tượng Calendar từ date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Đặt giờ, phút, giây về 00:00:00
        calendar.set(Calendar.HOUR_OF_DAY, 0);  // Đặt giờ = 0
        calendar.set(Calendar.MINUTE, 0);       // Đặt phút = 0
        calendar.set(Calendar.SECOND, 0);       // Đặt giây = 0
        calendar.set(Calendar.MILLISECOND, 0);  // Đặt mili giây = 0

        // Trả về đối tượng Date mới với thời gian đã reset
        return calendar.getTime();
    }

    private void addTask() {
        String name = txtTaskName.getText();
        String description = txtDescription.getText();

        Date dueDateValue = (Date) txtDueDate.getValue();  // Lấy giá trị từ JSpinner (là đối tượng Date)

        Date currentDate = new Date();  // Lấy ngày hiện tại
        currentDate = resetTime(currentDate);  // Đặt giờ, phút, giây của currentDate về 00:00:00
        dueDateValue = resetTime(dueDateValue);  // Đặt giờ, phút, giây của dueDateValue về 00:00:00

        if (dueDateValue.before(currentDate)) {
            JOptionPane.showMessageDialog(this, "Ngày hết hạn không thể nhỏ hơn ngày hiện tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;  // Dừng lại nếu ngày hết hạn không hợp lệ
        }

        // So sánh nếu ngày dueDate nhỏ hơn ngày hiện tại
        String utilDate = txtDueDate.getValue().toString();
        String dueDateString = convertToDateFormat(utilDate);

        String userFullName = (String) comboUser.getSelectedItem();  // Get selected user
        String category = (String) comboCategory.getSelectedItem();  // Get selected category
        String status = (String) comboStatus.getSelectedItem();  // Get selected status
        if (name.isEmpty() || description.isEmpty() || dueDateString.isEmpty() || userFullName.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Lấy ID người dùng và danh mục
            int userId = getUserId(userFullName);
            int categoryId = getCategoryId(category);
            taskService.addTask(name, description, dueDateString, userId, categoryId, status);
            JOptionPane.showMessageDialog(this, "Công việc đã được thêm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadAllTasks();
        } catch (RemoteException e) {
            int userId = getUserId(userFullName);
            int categoryId = getCategoryId(category);
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể thêm công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  
    private void onTableRowSelected() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy dữ liệu từ dòng đã chọn
            currentTaskId = (int) taskTable.getValueAt(selectedRow, 0); // Lấy ID công việc
            String name = (String) taskTable.getValueAt(selectedRow, 1); // Lấy tên công việc
            String description = (String) taskTable.getValueAt(selectedRow, 2); // Lấy mô tả
            Date dueDate = (Date) taskTable.getValueAt(selectedRow, 3); // Lấy ngày đến hạn
            String userFullName = (String) taskTable.getValueAt(selectedRow, 4); // Lấy người dùng
            String category = (String) taskTable.getValueAt(selectedRow, 5); // Lấy danh mục
            String status = (String) taskTable.getValueAt(selectedRow, 6); // Lấy trạng thái
            
            // Cập nhật các ô nhập liệu
            txtTaskName.setText(name);
            txtDescription.setText(description);
            txtDueDate.setValue(dueDate);
            // Cập nhật ComboBox
            comboUser.setSelectedItem(userFullName);
            comboCategory.setSelectedItem(category);
            comboStatus.setSelectedItem(status);
            
            
        }
    }
    
    
    private void updateTask() {
        if (currentTaskId == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công việc cần cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy giá trị từ các ô nhập liệu
        String name = txtTaskName.getText();
        String description = txtDescription.getText();
        String dueDate = txtDueDate.getValue() != null ? new SimpleDateFormat("yyyy-MM-dd").format(txtDueDate.getValue()) : "";
        String userFullName = (String) comboUser.getSelectedItem();
        String category = (String) comboCategory.getSelectedItem();
        String status = (String) comboStatus.getSelectedItem();

        // Kiểm tra tính hợp lệ của dữ liệu
        if (name.isEmpty() || description.isEmpty() || dueDate.isEmpty() || userFullName.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

//         Kiểm tra ngày dueDate không được là ngày quá khứ
        if (isDueDateInThePast(dueDate)) {
            JOptionPane.showMessageDialog(this, "Ngày đến hạn không được chọn là ngày quá khứ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Lấy ID người dùng và danh mục từ tên
            int userId = getUserId(userFullName);
            int categoryId = getCategoryId(category);

            // Gọi phương thức cập nhật công việc
            taskService.updateTask(currentTaskId, name, description, dueDate, userId, categoryId, status);

            JOptionPane.showMessageDialog(this, "Công việc đã được cập nhật.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
            // Làm mới bảng công việc
            loadAllTasks();
        } catch (RemoteException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể cập nhật công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    
  
    private boolean isDueDateInThePast(String dueDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = sdf.parse(dueDate);
            return parsedDate.before(new Date());  // Kiểm tra xem ngày đã qua chưa
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    private int getUserId(String userFullName) {
        int userId = -1;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT id FROM users WHERE full_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userFullName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("id");  // Trả về userId nếu tìm thấy người dùng
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng với tên: " + userFullName, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể kết nối cơ sở dữ liệu để lấy thông tin người dùng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return userId;
    }

    private int getCategoryId(String categoryName) {
        int categoryId = -1;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT id FROM categories WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                categoryId = rs.getInt("id");  // Trả về categoryId nếu tìm thấy danh mục
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy danh mục với tên: " + categoryName, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể kết nối cơ sở dữ liệu để lấy thông tin danh mục.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return categoryId;
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công việc để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int taskId = (int) taskTable.getValueAt(selectedRow, 0);
        try {
            taskService.deleteTask(taskId);
            JOptionPane.showMessageDialog(this, "Công việc đã được xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadAllTasks();
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể xóa công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchTasks() {
        String searchQuery = txtSearch.getText();
        if (searchQuery.isEmpty()) {
            loadAllTasks();
            return;
        }

        try {
            List<Task> tasks = taskService.searchTasks(searchQuery);
            tableModel.setRowCount(0);
            for (Task task : tasks) {
                tableModel.addRow(new Object[]{
                    task.getId(), task.getName(), task.getDescription(), task.getDueDate(), task.getUserFullName(), task.getCategoryName(), task.getStatus()
                });
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tìm kiếm công việc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskClient().setVisible(true);
            }
        });
    }
}
