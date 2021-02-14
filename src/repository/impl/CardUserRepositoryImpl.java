package repository.impl;

import model.CardUserModel;
import repository.CardUserRepository;
import util.ConnectionToSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CardUserRepositoryImpl implements CardUserRepository {

    @Override
    public void add(CardUserModel cardUser) {
        try {
            Connection connection = ConnectionToSQL.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO card(`id`,`name`, `surname`, `cardnumber`, `validUntil`, `money`,`currency`,`password`) " +
                    "values(0,?,?,?,?,?,?,?)");
            pstmt.setString(1, cardUser.getName());
            pstmt.setString(2, cardUser.getSurname());
            pstmt.setString(3, cardUser.getCardNumber());
            pstmt.setString(4, cardUser.getValidUntil());
            pstmt.setInt(5, cardUser.getMoney());
            pstmt.setString(6, cardUser.getCurrency());
            pstmt.setInt(7, cardUser.getPassword());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }
    }

    @Override
    public void update(CardUserModel cardUser) {
        try {
            Connection connection = ConnectionToSQL.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE card " +
                    "                                 set `name` = ? ,`surname` = ?, `cardNumber` = ?," +
                    "`validUntil` = ?, `money` = ?, `currency` = ?, `password` = ?" +
                    "  where `id` = ? ");
            pstmt.setString(1, cardUser.getName());
            pstmt.setString(2, cardUser.getSurname());
            pstmt.setString(3, cardUser.getCardNumber());
            pstmt.setString(4, cardUser.getValidUntil());
            pstmt.setInt(5, cardUser.getMoney());
            pstmt.setString(6, cardUser.getCurrency());
            pstmt.setInt(7, cardUser.getPassword());
            pstmt.setInt(8, cardUser.getId());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = ConnectionToSQL.getConnection();
            PreparedStatement pstmt = null;
            pstmt = connection.prepareStatement("DELETE FROM `card` WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }
    }

    @Override
    public CardUserModel getById(int id) {
        CardUserModel user = null;
        try {
            Connection connection = ConnectionToSQL.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `card` WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                user = map(resultSet);
            }
            resultSet.close();
            pstmt.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }

        return user;
    }

    @Override
    public List<CardUserModel> getAll() {
        List<CardUserModel> users = new LinkedList<>();

        try {
            Connection connection = ConnectionToSQL.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `card`");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
            resultSet.close();
            pstmt.close();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }

        return users;

    }


    private CardUserModel map(ResultSet resultSet) {
        CardUserModel user = new CardUserModel();
        try {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setCardNumber(resultSet.getString("cardNumber"));
            user.setValidUntil(resultSet.getString("validUntil"));
            user.setMoney(resultSet.getInt("money"));
            user.setCurrency(resultSet.getString("currency"));
            user.setPassword(resultSet.getInt("password"));

        } catch (SQLException exception) {
            exception.printStackTrace();

        }

        return user;
    }
}
