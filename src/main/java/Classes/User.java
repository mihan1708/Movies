package Classes;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    private Long id;
    @Column(name="LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ISADMIN")
    private String isAdmin;

    public User(){}
    public User(String login, String password, String isAdmin)
    {
        this.login=login;
        this.password=password;
        this.isAdmin = isAdmin;
    }
    public String getPassword()
    {
        return password;
    }
    public String getLogin()
    {
        return login;
    }
    public boolean getAdmin()
    {
        if(isAdmin.equals("1"))
            return true;
        else
            return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
