
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Server đang chạy");
            LocateRegistry.createRegistry(1099);
            TaskServiceImpl taskService = new TaskServiceImpl();
            UserServiceImpl userService = new UserServiceImpl()
;            Naming.rebind("rmi://localhost/TaskService", taskService);
            Naming.rebind("rmi://localhost/UserService", userService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
