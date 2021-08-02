package Dao;

import Model.Customer;
import Model.NhanVien;

import java.sql.*;
import java.util.ArrayList;

public class ManageNhanVien {
    static ArrayList<NhanVien> arrayList = new ArrayList<>();
    static Connection connection = ConnectionSql.getConnection();

    public static ArrayList<NhanVien> show() throws SQLException {
        String select = "select*from nhanvien";

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String department = resultSet.getString("department");

            arrayList.add(new NhanVien(id, name, birthday, address, sdt, email, department));
        }
        return arrayList;
    }

    public static void create(NhanVien nhanVien) throws SQLException {
        String create = "insert into nhanvien value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1, nhanVien.getId());
        preparedStatement.setString(2, nhanVien.getName());
        preparedStatement.setString(3, nhanVien.getBirthday());
        preparedStatement.setString(4, nhanVien.getAddress());
        preparedStatement.setString(5, nhanVien.getSdt());
        preparedStatement.setString(6, nhanVien.getEmail());
        preparedStatement.setString(7, nhanVien.getDepartment());
        preparedStatement.execute();
    }

    public static void edit(NhanVien nhanVien) throws SQLException {
        String edit = "update nhanvien set name = ? ,birthday = ? , address = ?,sdt = ? , email = ?,department = ? where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(7, nhanVien.getId());
        preparedStatement.setString(1, nhanVien.getName());
        preparedStatement.setString(2, nhanVien.getBirthday());
        preparedStatement.setString(3, nhanVien.getAddress());
        preparedStatement.setString(4, nhanVien.getSdt());
        preparedStatement.setString(5, nhanVien.getEmail());
        preparedStatement.setString(6, nhanVien.getDepartment());
        preparedStatement.execute();
    }
    public static void delete(NhanVien nhanVien) throws SQLException {
        String delete = "delete from nhanvien where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,nhanVien.getId());
        preparedStatement.execute();
    }
    public static ArrayList<NhanVien> findByName(String ten) throws SQLException {
        ArrayList<NhanVien> findlist = new ArrayList<>();
        String find = "select * from nhanvien where name like '%"+ten+"%' ";
        PreparedStatement preparedStatement = connection.prepareStatement(find);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String birthday = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String department = resultSet.getString("department");
            findlist.add(new NhanVien(id, name, birthday, address,sdt,email,department));
        }
        return findlist;
    }
}
