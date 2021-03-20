package drzig.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Dr.ZIG
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Login is required")
    private String login;

    @Email
    private String email;

    @Size(min = 7, max = 20, message = "From 7 to 20 symbols")
    private String password;

    public User() {
    }

    public User(@NotBlank(message = "Login is required") String login,
                @Email String email,
                @Size(min = 7, max = 20, message = "From 7 to 20 symbols") String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
