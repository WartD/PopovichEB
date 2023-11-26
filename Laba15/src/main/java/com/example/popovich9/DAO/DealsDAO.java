package com.example.popovich9.DAO;

import com.example.popovich9.DAO.Connection.ConnectionBuilder;
import com.example.popovich9.DAO.Connection.DbConnectionBuilder;
import com.example.popovich9.Models.Deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DealsDAO implements RepositoryDAO<Deal> {
    public DealsDAO(){}

    private static final String select_all = "SELECT deal_id, deal_agreement, deal_tiker, deal_order, deal_num, deal_date, " +
            "deal_quantity, deal_price, deal_total, deal_trader, deal_commission FROM deal";
    private static final String select_deal_ById = "SELECT deal_id, deal_agreement, deal_tiker, deal_order, deal_num, deal_date," +
            "deal_quantity, deal_price, deal_total, deal_trader, deal_commission FROM deal WHERE deal_id =?";
    private static final String insert_deal = "INSERT INTO deal(deal_agreement, deal_tiker, deal_order, deal_num, deal_date," +
            "deal_quantity, deal_price, deal_total, deal_trader, deal_commission) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String edit_deal = "UPDATE deal SET deal_agreement = ?, deal_tiker = ?, deal_order = ?," +
            " deal_num = ?, deal_date = ?, deal_quantity = ?, deal_price = ?, deal_total = ?, deal_trader = ?," +
            " deal_commission = ? WHERE deal_id = ? ";
    private static final String delete_deal = "DELETE FROM deal WHERE deal_id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    // Добавление новой должности
    @Override
    public Long insert (Deal deals) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_deal, new String[] { "deal_id" })) {
            long Id = -1L;
            pst.setString(1, deals.getAgreement());
            pst.setString(2, deals.getTiker());
            pst.setString(3, deals.getOrder());
            pst.setString(4, deals.getNumber());
            pst.setString(5, deals.getData());
            pst.setString(6, deals.getQuantity());
            pst.setString(7, deals.getPrice());
            pst.setString(8, deals.getTotalCost());
            pst.setString(9, deals.getTrader());
            pst.setString(10, deals.getComission());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                Id = gk.getLong("deal_id");
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
    public void update(Deal deals) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_deal)) {
            pst.setString(1, deals.getAgreement());
            pst.setString(2, deals.getTiker());
            pst.setString(3, deals.getOrder());
            pst.setString(4, deals.getNumber());
            pst.setString(5, deals.getData());
            pst.setString(6, deals.getQuantity());
            pst.setString(7, deals.getPrice());
            pst.setString(8, deals.getTotalCost());
            pst.setString(9, deals.getTrader());
            pst.setString(10, deals.getComission());
            pst.setLong(11, deals.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Удаление должности
    @Override
    public void delete(Long Id) {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_deal)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Поиск должности по Id
    @Override
    public Deal findById(Long Id) {
        Deal deals = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_deal_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                deals = fillDeals(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deals;
    }
    // Формирование списка всех должностей
    @Override
    public List<Deal> findAll(){
        List<Deal> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillDeals(rs));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    // Формирование класса Должности по результатам запроса к БД
    private Deal fillDeals(ResultSet rs) throws SQLException {
        Deal deals = new Deal();
        deals.setId(rs.getLong("deal_id"));
        deals.setAgreement(rs.getString("deal_agreement"));
        deals.setTiker(rs.getString("deal_tiker"));
        deals.setOrder(rs.getString("deal_order"));
        deals.setNumber(rs.getString("deal_num"));
        deals.setData(rs.getString("deal_date"));
        deals.setQuantity(rs.getString("deal_quantity"));
        deals.setPrice(rs.getString("deal_price"));
        deals.setTotalCost(rs.getString("deal_total"));
        deals.setTrader(rs.getString("deal_trader"));
        deals.setComission(rs.getString("deal_commission"));
        return deals;
    }
    // Поиск должности по id из списка должностей
    public Deal FindById(Long id, List<Deal> deals) {
        if (deals != null) {
            for (Deal r : deals) {
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

