package DAO;

//import posjava.semana07_jdbc.exemplos.livroautor.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Properties properties;
    //Garente que não haverá instâncias da ConnectionFactory
    private ConnectionFactory(){
    }
    public static Connection getConnection() throws 
            SQLException, IOException{
        readProperties();
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String pwd = properties.getProperty("db.pwd");
        return DriverManager.getConnection(
                url,user,pwd);
    }
    private static void readProperties() throws IOException
    {
        if(properties==null){
            Properties props = new Properties();
            FileInputStream file = new FileInputStream(
                    "./src\\DAO\\DataBase.properties");
            props.load(file);
            properties = props ;
        }
    }
}
