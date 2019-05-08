/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Подключил библиотеку PostgreSQL JDBC 4.2 Driver, 42.2.5
package simplepostgrebd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Muduck
 */
public class SimplePostgreBD {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String login = "postgres";
    static String password = "123456";
    private static void Connect() throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, login, password);
        System.out.println("Connection succesfull");
    }
    private static void TestConnect(){
        System.out.println("Testing connection to PostgreSQL JDBC");
 
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
		e.printStackTrace();
		return;
	}
 
	System.out.println("PostgreSQL JDBC Driver successfully connected");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection(url, login, password);
 
	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You successfully connected to database now");
	} else {
		System.out.println("Failed to make connection to database");
	}        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Connect(); ////////Коннектимся
        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(url, login, password);
        ////////////// делаем пару запросов
        //Statement statement = connection.createStatement();
        //statement.execute("create table user(" +
        //"id integer primary key auto_increment, " +
        //"name varchar(100));");
        //statement.execute("insert into BasicInformation(ID,Data_ID,Block,Address,District) values(DEFAULT),(DEFAULT),('Б'),('Корусант'),('Район 9')");
        //ResultSet rs = statement.executeQuery("select * from BasicInformation");
        //while (rs.next()) {
        //    System.out.println(rs.getInt("ID") + " : " + rs.getString("Block") + rs.getString("Address") + rs.getString("District"));
        //}
        PreparedStatement statement = connection.prepareStatement("insert into \"BasicInformation\"(\"ID\",\"Data_ID\",\"Block\",\"Address\",\"District\") values(?,?,?,?,?)");
        statement.setInt(1, 0);
        statement.setInt(2, 0);
        statement.setString(3, "Б");      //Индексирование параметров (индексируются только параметры помеченные ?) идет с единицы!
        statement.setString(4, "Корусант");
        statement.setString(5, "Район 9");
        statement.addBatch();
        statement.setInt(1, 1);
        statement.setInt(2, 1);
        statement.setString(3, "А");      //Индексирование параметров идет с единицы!
        statement.setString(4, "Джианосис");
        statement.setString(5, "Район 8");
        statement.addBatch();
        statement.executeBatch();
// TODO code application logic here
        
    }
    
}
