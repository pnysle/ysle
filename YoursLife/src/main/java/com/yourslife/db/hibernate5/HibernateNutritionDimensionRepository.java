package com.yourslife.db.hibernate5;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourslife.db.NutritionDimensionRepository;
import com.yourslife.domain.NutritionDimension;

@Repository
@Transactional
public class HibernateNutritionDimensionRepository implements NutritionDimensionRepository{

	private SessionFactory sessionFactory;

//	@Autowired
	@Inject
	public HibernateNutritionDimensionRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public NutritionDimension findOne(long id) {
		return (NutritionDimension) currentSession().get(NutritionDimension.class, id); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NutritionDimension> findAll() {
		return (List<NutritionDimension>) currentSession() 
				.createCriteria(NutritionDimension.class).list(); 
	}

}
