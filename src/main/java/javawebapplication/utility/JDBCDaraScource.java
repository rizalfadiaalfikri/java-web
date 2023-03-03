package javawebapplication.utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDaraScource {
//	public static void main(String[] args) {
//		ResourceBundle rb = ResourceBundle.getBundle("javawebapplication.System");
//		String url = rb.getString("url");
//		System.out.println(url+rb.getString("password"));
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebapp", "root", "");
//			System.out.println(connection);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace(); 
//		}
//		
//		
//	}
	
	private static JDBCDaraScource datasource;
    private JDBCDaraScource() {
    }
    private ComboPooledDataSource cpds = null;
    /**
     * Create instance of Connection Pool
     *
     * @return
     */
    public static JDBCDaraScource getInstance() {
        if (datasource == null) {
            ResourceBundle rb = ResourceBundle.getBundle("javawebapplication.System");
            datasource = new JDBCDaraScource();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass(rb.getString("driver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            datasource.cpds.setJdbcUrl(rb.getString("url"));
            datasource.cpds.setUser(rb.getString("username"));
            datasource.cpds.setPassword(rb.getString("password"));
            datasource.cpds.setInitialPoolSize(new Integer((String) rb .getString("initialPoolSize")));
            datasource.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
            datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
            datasource.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));
            datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));
        }
        return datasource;
    }
    /**
     * Gets the connection from ComboPooledDataSource
     *
     * @return connection
     */
    public static Connection getConnection() throws Exception {
        return getInstance().cpds.getConnection();
    }
    /**
     * Closes a connection4
     *
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) {
		JDBCDaraScource con = new JDBCDaraScource();
		try {
			Connection connection = con.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
