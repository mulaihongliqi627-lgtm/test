package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//通过jdbc实现对数据库的增删改操作
public class demo1 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        //1.建立数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Lzj051029.");

        //2.和数据源建立连接
        Connection connection = dataSource.getConnection();

        //3.编写sql语句,java构造sql字符串,转化为服务器可执行的sql语句statement交给服务器执行
        System.out.println("请输入学号");
        int id = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();
        String sql = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.setString(2,name);

        //4.服务器执行sql语句
         int n = statement.executeUpdate();//n代表sql语句影响的行数
        System.out.println("n = " + n);

        //5.释放资源,和创建顺序相反
        statement.close();
        connection.close();
    }
}
