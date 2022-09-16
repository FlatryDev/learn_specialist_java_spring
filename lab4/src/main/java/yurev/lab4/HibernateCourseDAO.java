package yurev.lab4;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("courseDAO") // courseDAO - назвали по-старому чтобы не менять клиентскую часть
public class HibernateCourseDAO implements CourseDAO {
	private static final Log LOG = LogFactory.getLog(HibernateCourseDAO.class);
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

	@Override
	public Course findById(int id) {
		List res = getSessionFactory().getCurrentSession().createQuery("from Course where id = :id")
				.setParameter("id", id).list()
		;
		
		return (res.size() > 0)?(Course)res.get(0):null;
	}

	@Override
	public List<Course> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Course c").list();
	}

	@Override
	public List<Course> findByTitle(String title) {
		return getSessionFactory().getCurrentSession()
				.createQuery("from Course c where lower(title) like lower(:partTitle)")
				.setParameter("partTitle", "%"+title.trim()+"%").list()
				;
	}

	@Override
	public void insert(Course cource) {
		getSessionFactory().getCurrentSession().save(cource);
		LOG.info("Insert into course new line with id="+cource.getId());
		
	}

	@Override
	public void update(Course cource) {
		getSessionFactory().getCurrentSession().update(cource);
		LOG.info("Update course with id="+cource.getId());
	}

	@Override
	public void delete(int id) {
		Course c = new Course();
		c.setId(id);
		getSessionFactory().getCurrentSession().delete(c);
		LOG.info("Delete course with id="+id);
	}
	

}
