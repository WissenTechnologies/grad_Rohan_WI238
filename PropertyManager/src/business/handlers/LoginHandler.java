package business.handlers;

import database.UserInterface;

public interface LoginHandler {
    boolean login(String username, String password, UserInterface userInterface) throws Exception;
}
