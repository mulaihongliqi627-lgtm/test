package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据库查询
public class demo2 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Lzj051029.");
        //2.和数据库建立连接
        Connection connection =  dataSource.getConnection();
        //3.构造sql语句
        String sql = "select * from student";
        //4.处理sql语句
        PreparedStatement statement = connection.prepareStatement(sql);
        //5.把sql语句传给服务器执行
        ResultSet resultSet = statement.executeQuery(sql);
        //6.遍历结果集
        while (resultSet.next()){
//            int id= resultSet.getInt(1);
//            String name = resultSet.getString(2);
            int id= resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " " + name);
        }
        //7.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
