
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
	private Connection connection;

	public TaskServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public void addTask(String name, String description, String dueDate, int userId, int categoryId, String status)
			throws RemoteException {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			java.sql.Date sqlDueDate = null;
			if (dueDate != null && !dueDate.isEmpty()) {
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = sdf.parse(dueDate);
				sqlDueDate = new java.sql.Date(utilDate.getTime());
			}

			String sql = "INSERT INTO tasks (name, description, due_date, user_id, category_id, status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setDate(3, sqlDueDate);
			stmt.setInt(4, userId);
			stmt.setInt(5, categoryId);
			stmt.setString(6, status);
			stmt.executeUpdate();
		} catch (SQLException | java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTask(int id, String name, String description, String dueDate, int userId, int categoryId,
			String status) throws RemoteException {
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
					+ "FROM tasks t " + "JOIN users u ON t.user_id = u.id "
					+ "JOIN categories c ON t.category_id = c.id " + "WHERE t.name LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getDate("due_date"), rs.getString("user_full_name"), rs.getString("category_name"),
						rs.getString("status"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> getAllTasks() throws RemoteException {
		System.out.println("TÔi get đã chạy");
		List<Task> tasks = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT t.id, t.name, t.description, t.due_date, u.full_name AS user_full_name, c.name AS category_name, t.status "
					+ "FROM tasks t " + "JOIN users u ON t.user_id = u.id "
					+ "JOIN categories c ON t.category_id = c.id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getDate("due_date"), rs.getString("user_full_name"), rs.getString("category_name"),
						rs.getString("status"));
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
					Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
							rs.getDate("due_date"), rs.getString("user_full_name"), rs.getString("category_name"),
							rs.getString("status"));
					tasks.add(task);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Không thể lấy công việc theo trạng thái.");
		}
		return tasks;
	}
	
	@Override
    public List<Task> getTasksByUser(String username) throws RemoteException {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT t.id, t.name, t.description, t.due_date, u.full_name AS user_full_name, c.name AS category_name, t.status "
                     + "FROM tasks t "
                     + "JOIN users u ON t.user_id = u.id "
                     + "JOIN categories c ON t.category_id = c.id "
                     + "WHERE u.username = ?";  // Truy vấn công việc của người dùng theo username

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);  // Set username vào câu truy vấn
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
                        rs.getDate("due_date"), rs.getString("user_full_name"), rs.getString("category_name"),
                        rs.getString("status"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Không thể lấy công việc của người dùng.", e);
        }

        return tasks;
    }
	
	 @Override
	    public boolean updateTaskStatus(int taskId, String status) throws RemoteException {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            // Kết nối cơ sở dữ liệu
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            
	            // Cập nhật trạng thái công việc trong cơ sở dữ liệu
	            String sql = "UPDATE tasks SET status = ? WHERE id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, status);
	            stmt.setInt(2, taskId);
	            
	            int rowsUpdated = stmt.executeUpdate();
	            return rowsUpdated > 0;  // Trả về true nếu cập nhật thành công
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;  // Trả về false nếu có lỗi
	        } finally {
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
