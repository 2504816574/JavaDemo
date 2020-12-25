package jdbcTemplate;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int isadmin;

    @Override
    public String toString() {
        return "jdbcTemplate.User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isadmin=" + isadmin +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public User() {
    }

    public User(int id, String username, String password, String email, int isadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isadmin = isadmin;
    }
}
