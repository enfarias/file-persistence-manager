package com.myproject.dao;

import java.util.ArrayList;
import java.util.List;
import com.myproject.model.UserModel;
import com.myproject.exception.EmptyStorageException;
import com.myproject.exception.UserNotFoundException;

public class UserDAO {

    private long nextId = 1L;

    private List<UserModel> models = new ArrayList<>();

    public UserModel save(UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(long id) {
        var message = String.format("Não existe usuário com o id %s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));

    }

    public List<UserModel> findAll() {
        List<UserModel> result;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage() {
        if (models.isEmpty()) {
            throw new EmptyStorageException("O armazenamento está vazio");
        }

    }

}
