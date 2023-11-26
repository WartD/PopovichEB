package com.example.popovich9.DAO;

import com.example.popovich9.DAO.Connection.ConnectionBuilder;
import com.example.popovich9.DAO.Connection.DbConnectionBuilder;
import com.example.popovich9.Models.Operation;
import com.example.popovich9.Models.SubAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OperationsDAO implements RepositoryDAO<Operation> {
    public OperationsDAO(){}

    private static final String select_all = "SELECT operation_id, deal_id, sub_id, op_num, op_date, op_type, op_sum, op_input, op_output FROM operation";
    private static final String select_op_ById = "SELECT operation_id, deal_id, sub_id, op_num, op_date, op_type, op_sum, op_input, op_output FROM operation WHERE operation_id = ?";
    private static final String insert_op = "INSERT INTO operation(deal_id, sub_id, op_num, op_date, op_type, op_sum, op_input, op_output) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String edit_op = "UPDATE operation SET deal_id = ?, sub_id = ?, op_num = ?, op_date = ?, op_type = ?, op_sum = ?, op_input = ?, op_output = ? WHERE operation_id = ? ";
    private static final String delete_op = "DELETE FROM operation WHERE operation_id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    // Добавление новой должности
    @Override
    public Long insert (Operation op) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_op, new String[] { "operation_id" })) {
            long Id = -1L;
            pst.setLong(1, op.getDealID());
            pst.setLong(2, op.getSubAccountID());
            pst.setString(3, op.getNumber());
            pst.setString(4, op.getData());
            pst.setString(5, op.getType());
            pst.setString(6, op.getSum());
            pst.setString(7, op.getSaldoInput());
            pst.setString(8, op.getSaldoOutput());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                Id = gk.getLong("operation_id");
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
    public void update(Operation op) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_op)) {
            pst.setLong(1, op.getDealID());
            pst.setLong(2, op.getSubAccountID());
            pst.setString(3, op.getNumber());
            pst.setString(4, op.getData());
            pst.setString(5, op.getType());
            pst.setString(6, op.getSum());
            pst.setString(7, op.getSaldoInput());
            pst.setString(8, op.getSaldoOutput());
            pst.setLong(9, op.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Удаление должности
    @Override
    public void delete(Long Id) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_op)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Поиск должности по Id
    @Override
    public Operation findById(Long Id) {
        Operation op = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_op_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                op = fillOperations(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return op;
    }
    // Формирование списка всех должностей
    @Override
    public List<Operation> findAll(){
        List<Operation> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillOperations(rs));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    // Формирование класса Должности по результатам запроса к БД
    private Operation fillOperations(ResultSet rs) throws SQLException {
        Operation op = new Operation();
        op.setId(rs.getLong("operation_id"));
        op.setDealID(rs.getLong("deal_id"));
        op.setSubAccountID(rs.getLong("sub_id"));
        op.setNumber(rs.getString("op_num"));
        op.setData(rs.getString("op_date"));
        op.setType(rs.getString("op_type"));
        op.setSum(rs.getString("op_sum"));
        op.setSaldoInput(rs.getString("op_input"));
        op.setSaldoOutput(rs.getString("op_output"));
        return op;
    }
    // Поиск должности по id из списка должностей
    public Operation FindById(Long id, List<Operation> op) {
        if (op != null) {
            for (Operation r : op) {
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
