package service;

import Dao.ManageCustomer;
import Dao.ManageNhanVien;
import Model.Customer;
import Model.NhanVien;

import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienService {
    public ArrayList<NhanVien> list = new ArrayList<>();

    public NhanVienService() {
        try {
            list = ManageNhanVien.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void create(NhanVien nhanVien) throws SQLException {
        ManageNhanVien.create(nhanVien);
        list.add(nhanVien);
    }
    public void edit(int index,NhanVien nhanVien) throws SQLException {
        ManageNhanVien.edit(nhanVien);
        list.set(index,nhanVien);
    }
    public void delete(int index) throws SQLException {
        ManageNhanVien.delete(list.get(index));
        list.remove(index);
    }
    public ArrayList<NhanVien> findName(String name) throws SQLException {
        return ManageNhanVien.findByName(name);
    }

}
