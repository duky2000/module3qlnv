package Dao;

import Model.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ManageCustomer {

    static ArrayList<Customer> arrayList = new ArrayList<>();
    static Connection connection = ConnectionSql.getConnection();

    public static ArrayList<Customer> select() throws SQLException {
        String select = "select*from customer";
        //   ArrayList<Customer> arrayList = new ArrayList<>();
        // tạo connection kết nối đến CSDL
        //   Connection connection = ConnectionSql.getConnection();
        // tạo statement thông qua connection
        java.sql.Statement statement = connection.createStatement();
        // thực hiện câu truy vấn statement.executeQuery và thực hiện trả về bằng  ResultSet
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            arrayList.add(new Customer(id, name, email, address));
        }
        return arrayList;
    }

    public static void create(Customer customer) throws SQLException {
         String create = "insert into customer value(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1,customer.getId());
        preparedStatement.setString(2,customer.getName());
        preparedStatement.setString(3,customer.getEmail());
        preparedStatement.setString(4,customer.getAddress());
        preparedStatement.execute();
    }
    public static void edit(Customer customer) throws SQLException {
        String edit = "update customer set name = ? , email = ? , address = ? where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(4,customer.getId());
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getEmail());
        preparedStatement.setString(3,customer.getAddress());
        preparedStatement.execute();
    }
    public static void delete(Customer customer) throws SQLException {
        String delete = "delete from customer where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,customer.getId());
        preparedStatement.execute();
    }
    public static ArrayList<Customer> findByName(String ten) throws SQLException {
        ArrayList<Customer> findlist = new ArrayList<>();
        String find = "select * from customer where name like '%"+ten+"%' ";
        PreparedStatement preparedStatement = connection.prepareStatement(find);
//        preparedStatement.setString(1,ten);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            findlist.add(new Customer(id, name, email, address));
        }
        return findlist;
    }
}
