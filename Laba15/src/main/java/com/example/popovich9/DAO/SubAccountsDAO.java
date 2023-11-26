package com.example.popovich9.DAO;

import com.example.popovich9.DAO.Connection.ConnectionBuilder;
import com.example.popovich9.DAO.Connection.DbConnectionBuilder;
import com.example.popovich9.Models.SubAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SubAccountsDAO implements RepositoryDAO<SubAccount> {
    public SubAccountsDAO(){}

    private static final String select_all = "SELECT sub_id, account_id, sub_name, sub_num FROM subaccount";
    private static final String select_sub_ById = "SELECT sub_id, account_id, sub_name, sub_num FROM subaccount WHERE sub_id = ?";
    private static final String insert_sub = "INSERT INTO subaccount(account_id, sub_name, sub_num) VALUES(?, ?, ?)";
    private static final String edit_sub = "UPDATE subaccount SET account_id = ?, sub_name = ?, sub_num = ? WHERE sub_id = ? ";
    private static final String delete_sub = "DELETE FROM subaccount WHERE sub_id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    // Добавление новой должности
    @Override
    public Long insert (SubAccount sub) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_sub, new String[] { "sub_id" })) {
            long Id = -1L;
            pst.setLong(1, sub.getAccountPlanID());
            pst.setString(2, sub.getName());
            pst.setString(3, sub.getNumber());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                Id = gk.getLong("sub_id");
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
    public void update(SubAccount sub) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_sub)) {
            pst.setLong(1, sub.getAccountPlanID());
            pst.setString(2, sub.getName());
            pst.setString(3, sub.getNumber());
            pst.setLong(4, sub.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Удаление должности
    @Override
    public void delete(Long Id) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_sub)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Поиск должности по Id
    @Override
    public SubAccount findById(Long Id) {
        SubAccount sub = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_sub_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sub = fillSubAccounts(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sub;
    }
    // Формирование списка всех должностей
    @Override
    public List<SubAccount> findAll(){
        List<SubAccount> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillSubAccounts(rs));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    // Формирование класса Должности по результатам запроса к БД
    private SubAccount fillSubAccounts(ResultSet rs) throws SQLException {
        SubAccount sub = new SubAccount();
        sub.setId(rs.getLong("sub_id"));
        sub.setAccountPlanID(rs.getLong("account_id"));
        sub.setName(rs.getString("sub_name"));
        sub.setNumber(rs.getString("sub_num"));
        return sub;
    }
    // Поиск должности по id из списка должностей
    public SubAccount FindById(Long id, List<SubAccount> sub) {
        if (sub != null) {
            for (SubAccount r : sub) {
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
