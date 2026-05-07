package com.myproject.validator;

import com.myproject.model.UserModel;
import com.myproject.exception.ValidatorException;

public class UserValidator {

    private UserValidator() {
    }

    public static void verifyModel(UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome válido");
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome deve conter mais de 1 caracter");
        if (stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um email válido");
        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um email válido");
    }

    private static boolean stringIsBlank(String value) {
        return value == null || value.isEmpty();
    }

}