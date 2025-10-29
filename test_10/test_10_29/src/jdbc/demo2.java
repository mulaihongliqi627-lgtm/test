package jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//通过jdbc实现对数据库的查询操作
public class demo2 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        //1.建立数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Lzj051029.");

        //2.和数据源建立连接
        Connection connection = dataSource.getConnection();

        //3.构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.sql语句执行成功后返回一个结果集
        ResultSet resultSet = statement.executeQuery();

        //5.遍历结果集
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " " + name);
        }

        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
