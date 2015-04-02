package Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class MyConnection {
	private static String url = Config.DB_URL;
	private static String user =Config.USER;
	private static String password = Config.PASS;

	private static MyConnection instance = null;

	private MyConnection() {
	}

	/**
	 * @return
	 */
	public static MyConnection getInstance() {
		if (instance == null) {
			synchronized (MyConnection.class) {
				if (instance == null) {
					instance = new MyConnection();
				}
			}
		}
		return instance;
	}

	static {
		try {
			Class.forName(Config.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
}