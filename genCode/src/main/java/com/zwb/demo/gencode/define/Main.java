package com.zwb.demo.gencode.define;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
//@PropertySource("classpath:application.yml")
//@ConfigurationProperties(prefix = "my")
public class Main {

    private  final String template = "select * from INFORMATION_SCHEMA.Columns where table_name='t_box' and  table_schema='led'";

//    @Value("${url}")
    private String url = "jdbc:mysql://localhost:3306/led?serverTimezone=UTC";
//    @Value("${userName}")
    private String userName = "root";
//    @Value("${password}")
    private String password = "123456";
//    @Value("${table_name}")
    private String table_name = "t_box";

    @SneakyThrows
    public  void main() {

        QueryRunner runner = new QueryRunner();
        runner.query(
                getConn(),
                template,
                resultSet -> {
//                    System.out.println(resultSet.getString(1));
                    System.out.println(resultSet);
                    return null;
                });
    }

    public Connection getConn(){
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = this.url;
        String userName =this.userName;
        String password = this.password;
        Connection conn = null;
        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("获取数据库连接成功！");
        return conn;
    }
}
