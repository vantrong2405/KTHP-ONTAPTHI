import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface UserService extends Remote {
    // Lấy thông tin người dùng theo username
    User getUserInfo(String username) throws RemoteException;

    // Cập nhật thông tin người dùng
    boolean updateUserInfo(String username, String newEmail, String newPassword) throws RemoteException;

    // Tìm kiếm người dùng theo email hoặc username
    User getUserInfoBySearch(String searchQuery) throws RemoteException;
    boolean checkPassword(String username, String password) throws RemoteException;
    boolean updatePassword(String username, String newPassword) throws RemoteException;
}
