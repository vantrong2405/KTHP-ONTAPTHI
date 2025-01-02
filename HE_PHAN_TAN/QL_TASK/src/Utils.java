import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Admin123@";
	
	public static Date resetTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	private static boolean isDueDateInThePast(String dueDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = sdf.parse(dueDate);
			return parsedDate.before(new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String convertToDateFormat(String inputDate) {
		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			Date date = inputFormat.parse(inputDate);
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
			return outputFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getUserId(String userFullName) {
		int userId = -1;
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT id FROM users WHERE full_name = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userFullName);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				userId = rs.getInt("id"); 
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	public static int getCategoryId(String categoryName) {
		int categoryId = -1;
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT id FROM categories WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, categoryName);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				categoryId = rs.getInt("id"); 
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryId;
	}
}
