package yurev.lab4;

import java.util.List;

public interface CourseDAO {
    Course findById(int id);
    List<Course> findAll();
    
    // CRUD
    List<Course> findByTitle(String title);
    void insert(Course cource);                
    void update(Course cource);
    void delete(int id);
}
