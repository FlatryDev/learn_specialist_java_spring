package yurev.lab4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.cj.Query;

import yurev.lab4.CourseDAO;
import yurev.lab4.Course;

class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course c = new Course();
        c.setId(rs.getInt("id"));
        c.setTitle (rs.getString("title"));
        c.setLength(rs.getInt("length"));
        c.setDescription(rs.getString("description"));
        return c;
	}
	
}

public class JdbcCourceDAO implements CourseDAO{

    private static final String SQL_SELECT_COURSE = "select id, title, length, description from courses";
    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " where id = ?";
    
    private static final String SQL_SELECT_COURSE_BY_TITLE =
			SQL_SELECT_COURSE+" WHERE title LIKE ?";
	
	private static final String SQL_DELETE_COURSE_BY_ID =
			 "DELETE FROM courses WHERE id = ?";
	
	private static final String SQL_INSERT_COURSE =
			 "INSERT INTO courses (title, length, description) VALUES (?, ?, ?)";
	
	private static final String SQL_UPDATE_COURSE =
			 "UPDATE courses SET title = ?, length = ?, description = ? WHERE id = ?";
    
    private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
    public Course findById(int id) {
		Course course = getJdbcTemplate().queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[] {id}, new CourseRowMapper());
        return course;
    }

    @Override
    public List<Course> findAll() {
    	
    	// manual map rows -> objects
        /*List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
        List<Course> courses = new ArrayList<Course>();
        for(Map<String, Object> row : rows) {
            Course c = new Course();
            c.setId((int)row.get("id"));
            c.setTitle ((String)row.get("title"));
            c.setLength((int)row.get("length"));
            c.setDescription((String)row.get("description"));
            courses.add(c);
        }
        */
    	
    	List<Course> courses = getJdbcTemplate().query(SQL_SELECT_COURSE, new BeanPropertyRowMapper(Course.class));
    	
        return courses;
    }

	@Override
	public List<Course> findByTitle(String title) {
		return getJdbcTemplate().query(
				SQL_SELECT_COURSE_BY_TITLE, 
				new Object[]{"%"+title+"%"} , 
				new BeanPropertyRowMapper(Course.class)
		);
	}

	@Override
	public void insert(Course cource) {
		PreparedStatementCreatorFactory f = 
				new PreparedStatementCreatorFactory(SQL_INSERT_COURSE, Types.NVARCHAR, Types.INTEGER, Types.NVARCHAR);
		f.setGeneratedKeysColumnNames("id");
		KeyHolder kh = new GeneratedKeyHolder();
		getJdbcTemplate().update(f.newPreparedStatementCreator(new Object[] {cource.getTitle(), cource.getLength(), cource.getDescription()})
								,kh);
		
		cource.setId(kh.getKey().intValue());
	}

	@Override
	public void update(Course cource) {
		getJdbcTemplate().update(SQL_UPDATE_COURSE, cource.getTitle(), cource.getLength(), cource.getDescription(), cource.getId());
		
	}

	@Override
	public void delete(int id) {
		getJdbcTemplate().update(SQL_DELETE_COURSE_BY_ID, id);
	}
    
}
