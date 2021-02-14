package repository;

import model.CardUserModel;

import java.util.List;

public interface CardUserRepository {
    void add(CardUserModel cardUser);

    void update(CardUserModel cardUser);

    void delete(int id);

    CardUserModel getById(int id);
    
    List<CardUserModel> getAll();
    
}
