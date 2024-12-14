
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class TaskServer {

    public static void main(String[] args) {
        try {
            System.out.println("Server đang chạy");
            LocateRegistry.createRegistry(1099);
            TaskServiceImpl taskService = new TaskServiceImpl();
            Naming.rebind("rmi://localhost/TaskService", taskService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
