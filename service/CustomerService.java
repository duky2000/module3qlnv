package service;

import Dao.ManageCustomer;
import Model.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {
    public ArrayList<Customer> list = new ArrayList<>();

    public CustomerService() {
        try {
            list = ManageCustomer.select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Customer customer) throws SQLException {

        ManageCustomer.create(customer);
        list.add(customer);
    }

    public void edit(int id, Customer customer) throws SQLException {
        ManageCustomer.edit(customer);
        list.set(id, customer);
    }

    public void delete(int id) throws SQLException {
        ManageCustomer.delete(list.get(id));
        list.remove(id);
    }

    public ArrayList<Customer> findName(String name) throws SQLException {
        return ManageCustomer.findByName(name);
    }
}
