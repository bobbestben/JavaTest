package JavaTest;

import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	@Autowired
	private JdbcTemplate template;

	@PostConstruct
	public void createTable() {
		template.execute(
				"CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
	}

	public void createStudent(String name, String gender) {
		template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)", null, name, gender);
	}

	public List<Student> findStudentByName(String nameStartsWith) {
		String sql = "select * from student where name like 'nameStartsWith%';";
		try (ResultSet resultset = executeQuery(sql)) {
			return List<Student> resultSet.list();
		} 
	}
}