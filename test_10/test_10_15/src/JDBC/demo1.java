package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//数据库增删改
public class demo1 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Lzj051029.");

        //2.和数据库建立连接
        Connection connection =  dataSource.getConnection();
        //3.创建sql语句
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        int id = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();
        String sql = "insert into student values(?,?)";
        //4.客户端预处理语句,把sql字符串转化为服务器可识别的statement语句
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        //5.把语句发给服务器去执行
        int n = statement.executeUpdate();
        System.out.println("n = " + n);//n代表上诉sql语句影响了多少行
        //6.释放资源,释放顺序和创建顺序相反
        statement.close();
        connection.close();

    }
}
