package Classes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.*;

@Service
@Component
public class UserAccessServiceImpl implements UserAccessService {

    @PersistenceContext
    private EntityManager em;



    Connection con = null;
    PreparedStatement stmt=null;
    ResultSet rs = null;

    public UserAccessServiceImpl()
    {
        //System.out.print("UserAccessServiceImpl create");
    }

    @Override
    public User getUserByLogin(String loginInput) {
            TypedQuery<User> q = em.createQuery("Select u from User u where u.login = :login", User.class);
            q.setParameter("login",loginInput);
            User user = q.getSingleResult();
            return user;
    }

    @Override
    public boolean registrationUser(String loginInput, String passwordInput) {
        try {
            connectToDataBase();
            stmt = con.prepareStatement("select login, password from USERS where login=?");
            stmt.setString(1,loginInput);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                return false;
            }
            stmt = con.prepareStatement("insert into USERS(login, password,isadmin) values(?,?,?)");
            stmt.setString(1,loginInput);
            stmt.setString(2,passwordInput);
            stmt.setString(3,"0");
            stmt.executeUpdate();
            con.close();
            return true;
        }

        catch (SQLException e){e.printStackTrace();}
        return false;
    }
    @Override
    public boolean connectToDataBase() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##user1", "123456");
            return true;
        }
        catch (SQLException e){e.printStackTrace();}
        return false;
    }
}
