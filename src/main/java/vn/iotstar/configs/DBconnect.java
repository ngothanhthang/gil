package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	private final String serverName = "localhost";
    private final String dbName = "ltweb";
    private final String portNumber = "1433";
    private final String instance = ""; // MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "thang";
    private final String password = "123";

    public Connection getConnection() throws ClassNotFoundException {
    	Connection conn = null;
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";

            conn = DriverManager.getConnection(url,userID,password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    public static void main(String [] args)
    {
    	try
    	{
    		System.out.println(new DBconnect().getConnection());

    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}