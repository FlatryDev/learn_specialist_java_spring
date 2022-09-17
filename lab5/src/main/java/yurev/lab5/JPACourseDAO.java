package yurev.lab5;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Repository("courseDAO")
@Transactional( isolation = Isolation.READ_COMMITTED, 
	timeout=20, propagation = Propagation.REQUIRED /*default*/)
public class JPACourseDAO implements CourseDAO {
	private static final Log LOG = LogFactory.getLog(JPACourseDAO.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Course findById(int id) {
		/*TypedQuery<Course>  query = em.createQuery(
			"select c from Course c where c.id = :id", Course.class); 
		query.setParameter("id", id);
		
		return query.getSingleResult();*/
		return em.find(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		return em.createQuery("select c from Course c", 
				Course.class).getResultList();
	}

	@Override
	public List<Course> findByTitle(String title) {
		TypedQuery<Course> q = em.createQuery("select c from Course c where lower(c.title) like lower(:parttitle)", Course.class); 
		q.setParameter("parttitle", "%"+title.trim()+"%");
		return q.getResultList();
	}
	
	@Override
	public void insert(Course course) {
		em.persist(course);
		//LOG.info("Course inserted with id=" + course.getId());
	}

	@Override
	public void update(Course course) {
		if (course.getId() != 0) {
			Course updatedCourse = em.merge(course);
		}
		//em.persist(course);
		LOG.info("Course updated with id=" + course.getId());
	}
	
	@Override
	public void delete(int id) {
		em.remove(findById(id));
		LOG.info("Course deleted with id=" + id);
	}

}
