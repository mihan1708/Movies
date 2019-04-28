package Classes;

public interface UserService {
     User loginUser(String login, String password);
     boolean registrationUser(String loginInput, String passwordInput);
     User getCurrentUser();
     void logOut();

}
