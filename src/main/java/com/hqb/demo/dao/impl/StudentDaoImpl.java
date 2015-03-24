package com.hqb.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Settings;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.util.Assert;

import com.hqb.demo.dao.StudentDao;
import com.hqb.demo.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;

	public void save(Student student) {
		Assert.notNull(student, "entity Can not be empty");
		getSession().saveOrUpdate(student);
	}

	public Student getStudent(int id) {
		Assert.notNull(id, "id can not be empty");
		return (Student) getSession().load(Student.class, id);
	}

	public List<Student> getAllStudent() {
		return find();
	}

	@SuppressWarnings("unchecked")
	public List<Student> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(Student.class);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get the current Session.
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public StatelessSession getStatelsesSession() {
		return sessionFactory.openStatelessSession();
	}

	public void initConfiguration() {
		Settings settings = ((SessionFactoryImplementor) this.sessionFactory)
				.getSettings();

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Student.class);

		PersistentClass model = cfg.getClassMapping(Student.class.getName());

		// ((SessionFactoryImpl)this.sessionFactory).addPersistentClass(model,);
	}
}
