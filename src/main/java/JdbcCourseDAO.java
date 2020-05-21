import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CourseRowMapper implements RowMapper<Course> {

    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        Course c = new Course();
        c.setId(resultSet.getInt("id"));
        c.setTitle(resultSet.getString("title"));
        c.setLength(resultSet.getInt("length"));
        c.setDescription(resultSet.getString("description"));
        return c;
    }
}

public class JdbcCourseDAO implements CourseDAO {
    private static final String SQL_SELECT_COURSE =
            "SELECT id, title, length, description FROM courses";

    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";



    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Course findById(int id){
        return (Course) getJdbcTemplate().queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[] {id}, new CourseRowMapper());
    }

    public List<Course> findAll() {
        return null;
    }
}
