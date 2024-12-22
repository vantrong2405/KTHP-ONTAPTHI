import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    
    private static final String URL = "jdbc:mysql://localhost:3306/test_db"; // Đảm bảo sửa đúng thông tin DB
    private static final String USER = "root";
    private static final String PASSWORD = "Admin123@";

    public UserServiceImpl() throws RemoteException {
        super();
    }
    
    @Override
    public boolean checkPassword(String username, String password) throws RemoteException {
        String query = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);  // Gán tên người dùng vào query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password"); // Lấy mật khẩu từ DB
                    return storedPassword.equals(password); // So sánh trực tiếp mật khẩu
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi kiểm tra mật khẩu", e);
            throw new RemoteException("Không thể kiểm tra mật khẩu", e);
        }
        return false; // Trả về false nếu không tìm thấy người dùng
    }

    // Cập nhật mật khẩu người dùng
    @Override
    public boolean updatePassword(String username, String newPassword) throws RemoteException {
        String updateQuery = "UPDATE users SET password = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, newPassword);  // Gán mật khẩu mới vào query
            stmt.setString(2, username);     // Gán tên người dùng vào query
            int rowsAffected = stmt.executeUpdate();

            // Nếu có ít nhất một dòng bị ảnh hưởng thì cập nhật thành công
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật mật khẩu", e);
            throw new RemoteException("Không thể cập nhật mật khẩu", e);
        }
    }
    
    
    @Override
    public User getUserInfo(String username) throws RemoteException {
        User user = null;
        String query = "SELECT username, email, full_name FROM users WHERE username = ?";

        try {
            // Đảm bảo rằng driver MySQL đã được nạp đúng cách
            Class.forName("com.mysql.cj.jdbc.Driver");  // Nạp driver MySQL
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String email = rs.getString("email");
                        String fullName = rs.getString("full_name");
                        user = new User(username, email, fullName);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Không thể lấy thông tin người dùng", e);
            throw new RemoteException("Không thể lấy thông tin người dùng", e);
        }
        return user;
    }

    @Override
    public boolean updateUserInfo(String username, String newEmail, String newPassword) throws RemoteException {
        String updateQuery = "UPDATE users SET email = ?, password = ? WHERE username = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Nạp driver MySQL
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

                stmt.setString(1, newEmail);
                stmt.setString(2, newPassword);  // Không mã hóa mật khẩu, trực tiếp lưu vào DB
                stmt.setString(3, username);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Không thể cập nhật thông tin người dùng", e);
            throw new RemoteException("Không thể cập nhật thông tin người dùng", e);
        }
    }

    @Override
    public User getUserInfoBySearch(String searchQuery) throws RemoteException {
        User user = null;
        String query = "SELECT username, email, full_name FROM users WHERE username = ? OR email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Nạp driver MySQL
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, searchQuery);
                stmt.setString(2, searchQuery);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String username = rs.getString("username");
                        String email = rs.getString("email");
                        String fullName = rs.getString("full_name");
                        user = new User(username, email, fullName);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Không thể tìm kiếm thông tin người dùng", e);
            throw new RemoteException("Không thể tìm kiếm thông tin người dùng", e);
        }
        return user;
    }
}
