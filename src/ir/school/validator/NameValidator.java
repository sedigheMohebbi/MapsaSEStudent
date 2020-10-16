package ir.school.validator;

import ir.school.exception.NameFormatException;

import java.util.regex.Pattern;

public class NameValidator {
    private static NameValidator instance = null;

    private NameValidator() {
    }

    public static NameValidator getInstance() {
        if (instance == null) {
            instance = new NameValidator();
        }
        return instance;
    }

    public boolean validateName(String name) throws NameFormatException {
        final Pattern pattern = Pattern.compile("^[A-Za-z, ]+$");
        if (!pattern.matcher(name).matches()) {
            throw new NameFormatException("Invalid String " + name);
        }
        return true;
    }
}
