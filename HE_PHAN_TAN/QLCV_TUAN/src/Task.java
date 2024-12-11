import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
    private int id;
    private String name;
    private String description;
    private Date dueDate;  // Chuyển từ String sang java.sql.Date
    private String userFullName;
    private String categoryName;
    private String status;

    // Constructor
    public Task(int id, String name, String description, Date dueDate, String userFullName, String categoryName, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.userFullName = userFullName;
        this.categoryName = categoryName;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Date getDueDate() { return dueDate; }
    public String getUserFullName() { return userFullName; }
    public String getCategoryName() { return categoryName; }
    public String getStatus() { return status; }

    // Setters for dueDate
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
}
