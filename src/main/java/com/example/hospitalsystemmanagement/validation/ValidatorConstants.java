package com.example.hospitalsystemmanagement.validation;

/**
 * Created by bonda on 28.05.2023 11:03
 *
 * @author bonda
 */
public final class ValidatorConstants {
    public static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}";
    public static final String PHONE_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
}
