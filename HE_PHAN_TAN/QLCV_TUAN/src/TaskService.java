import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaskService extends Remote {
    void addTask(String name, String description, String dueDate, int userId, int categoryId , String status) throws RemoteException;
    void updateTask(int id, String name, String description, String dueDate, int userId, int categoryId, String status) throws RemoteException;
    void deleteTask(int id) throws RemoteException;
    List<Task> searchTasks(String keyword) throws RemoteException;
    List<Task> getAllTasks() throws RemoteException;
     List<Task> getTasksByStatus(String status) throws RemoteException;
}
