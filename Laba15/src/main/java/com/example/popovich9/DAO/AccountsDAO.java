package com.example.popovich9.DAO;

import com.example.popovich9.DAO.Connection.ConnectionBuilder;
import com.example.popovich9.DAO.Connection.DbConnectionBuilder;
import com.example.popovich9.Models.Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AccountsDAO implements RepositoryDAO<Accounts> {
    public AccountsDAO(){}

    private static final String select_all = "SELECT account_id, acc_name, acc_type, acc_num FROM accountplan";
    private static final String select_account_ById = "SELECT account_id, acc_name, acc_type, acc_num FROM accountplan WHERE account_id =?";
    private static final String insert_account = "INSERT INTO accountplan(acc_name, acc_type, acc_num) VALUES(?, ?, ?)";
    private static final String edit_account = "UPDATE accountplan SET acc_name = ?, acc_type = ?, acc_num = ? WHERE account_id = ? ";
    private static final String delete_account = "DELETE FROM accountplan WHERE account_id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    // Добавление новой должности
    @Override
    public Long insert (Accounts accounts) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_account, new String[] { "account_id" })) {
            long Id = -1L;
            pst.setString(1, accounts.getName());
            pst.setString(2, accounts.getType());
            pst.setString(3, accounts.getNumber());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                Id = gk.getLong("account_id");
            }
            gk.close();
            return Id;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1L;
    }
    // Редактирование должности
    @Override
    public void update(Accounts accounts) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_account)) {
            pst.setString(1, accounts.getName());
            pst.setString(2, accounts.getType());
            pst.setString(3, accounts.getNumber());
            pst.setLong(4, accounts.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Удаление должности
    @Override
    public void delete(Long Id) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_account)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Поиск должности по Id
    @Override
    public Accounts findById(Long Id) {
        Accounts accounts = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_account_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                accounts = fillAccounts(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return accounts;
    }
    // Формирование списка всех должностей
    @Override
    public List<Accounts> findAll(){
        List<Accounts> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillAccounts(rs));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    // Формирование класса Должности по результатам запроса к БД
    private Accounts fillAccounts(ResultSet rs) throws SQLException {
        Accounts accounts = new Accounts();
        accounts.setId(rs.getLong("account_id"));
        accounts.setName(rs.getString("acc_name"));
        accounts.setType(rs.getString("acc_type"));
        accounts.setNumber(rs.getString("acc_num"));
        return accounts;
    }
    // Поиск должности по id из списка должностей
    public Accounts FindById(Long id, List<Accounts> accounts) {
        if (accounts != null) {
            for (Accounts r : accounts) {
                if ((r.getId()).equals(id)) {
                    return r;
                }
            }
        } else {
            return null;
        }
        return null;
    }
}
