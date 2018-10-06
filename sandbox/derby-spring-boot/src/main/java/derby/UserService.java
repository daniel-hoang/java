package derby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    @Transactional(readOnly=true)
    public User findUserById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from users where id=?",
                new Object[]{id}, new UserRowMapper());
    }

    public User create(final User user)
    {
        final String sql = "insert into users(name, email) values(?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            return ps;
        }, holder);

        int newId = holder.getKey().intValue();
        user.setId(newId);
        return user;
    }
}
