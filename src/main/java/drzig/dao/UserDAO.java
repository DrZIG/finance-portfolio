package drzig.dao;

import drzig.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Dr.ZIG
 */
@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users (login, email, password) VALUES (?, ?, ?)",
                user.getLogin(), user.getEmail(), user.getPassword());
    }
}
