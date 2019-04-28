package Classes;

public interface UserAccessService {
    User getUserByLogin(String loginInput);
    boolean registrationUser(String loginInput, String passwordInput);
    boolean connectToDataBase();
}
