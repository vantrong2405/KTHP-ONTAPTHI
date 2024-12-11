
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskServiceImpl extends UnicastRemoteObject implements TaskService {

    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin123@";
 private Connection connection; // Khai báo biến connection
    public TaskServiceImpl() throws RemoteException {
        super();
    }

    @Override
public void addTask(String name, String description, String dueDate, int userId, int categoryId , String status) throws RemoteException {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
        // Chuyển đổi dueDate thành java.sql.Date
        java.sql.Date sqlDueDate = null;
        if (dueDate != null && !dueDate.isEmpty()) {
            // Giả sử định dạng ngày là "yyyy-MM-dd" (có thể thay đổi tùy theo yêu cầu của bạn)
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(dueDate);
            sqlDueDate = new java.sql.Date(utilDate.getTime());
        }

        // SQL câu lệnh chèn vào database
        String sql = "INSERT INTO tasks (name, description, due_date, user_id, category_id, status) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.setDate(3, sqlDueDate);  // Đảm bảo rằng kiểu dữ liệu là java.sql.Date
        stmt.setInt(4, userId);
        stmt.setInt(5, categoryId);
        stmt.setString(6, status);
        
        // Thực thi câu lệnh SQL
        stmt.executeUpdate();
    } catch (SQLException | java.text.ParseException e) {
        e.printStackTrace();
    }
}


    @Override
    public void updateTask(int id, String name, String description, String dueDate, int userId, int categoryId, String status) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE tasks SET name = ?, description = ?, due_date = ?, user_id = ?, category_id = ?, status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, dueDate);
            stmt.setInt(4, userId);
            stmt.setInt(5, categoryId);
            stmt.setString(6, status);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> searchTasks(String keyword) throws RemoteException {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT t.id, t.name, t.description, t.due_date, u.full_name AS user_full_name, c.name AS category_name, t.status "
                    + "FROM tasks t "
                    + "JOIN users u ON t.user_id = u.id "
                    + "JOIN categories c ON t.category_id = c.id "
                    + "WHERE t.name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getString("user_full_name"),
                        rs.getString("category_name"),
                        rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasks() throws RemoteException {
        List<Task> tasks = new ArrayList<>();
        try {
            // Đảm bảo driver MySQL được đăng ký
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT t.id, t.name, t.description, t.due_date, u.full_name AS user_full_name, c.name AS category_name, t.status "
                    + "FROM tasks t "
                    + "JOIN users u ON t.user_id = u.id "
                    + "JOIN categories c ON t.category_id = c.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getString("user_full_name"),
                        rs.getString("category_name"),
                        rs.getString("status")
                );
                tasks.add(task);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }
    
      @Override
    public List<Task> getTasksByStatus(String status) throws RemoteException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks WHERE status = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDate("due_date"),
                            rs.getString("user_full_name"),
                            rs.getString("category_name"),
                            rs.getString("status")
                    );
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Không thể lấy công việc theo trạng thái.");
        }
        return tasks;
    }
    
}
