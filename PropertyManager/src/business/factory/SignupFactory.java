package business.factory;

import business.handlers.*;
import business.users.signup.*;

public class SignupFactory {

    public static SignupHandler create(String role) {
        return switch (role) {
            case "-a" -> new AdminSignup();
            // case "-o" -> new OwnerSignup();
            default -> throw new IllegalArgumentException("Unknown role: " + role);
        };
    }
}
