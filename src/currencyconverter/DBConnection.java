package currencyconverter;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DBConnection {

    public static DataSource connectToDB() {

        MysqlDataSource db_connection = new MysqlDataSource();

        try {
            db_connection.setServerName("localhost");
            db_connection.setPortNumber(3306);
            db_connection.setDatabaseName("currency_converter");
            db_connection.setUser("root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return db_connection;
    }
}
