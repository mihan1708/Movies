package Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserServiceImpl implements UserService {


    private User currentUser;//текущий пользователь

    @Autowired
    private UserAccessService uas;
    public UserServiceImpl()
    {
        System.out.print("UserServiceImpl create");
    }

    @Override
    public boolean registrationUser(String loginInput, String passwordInput)//добавления пользователя
    {
        return uas.registrationUser(loginInput,passwordInput);
    }
    @Override
    public User loginUser(String loginInput, String passwordInput)//вход пользователя
    {
        User user = uas.getUserByLogin(loginInput);
        if(user != null && user.getPassword().equals(passwordInput)) {
            currentUser=user;
            return user;
        }
        else return null;

    }
    @Override
    public void logOut()
    {
        currentUser=null;
    }
    @Override
    public User getCurrentUser(){
        return currentUser;
    }


}
