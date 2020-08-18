package com.best.exam_manager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.best.exam_manager.model.Answer;
import com.best.exam_manager.model.Question;
import com.best.exam_manager.util.HibernateUtlity;

public class ExamDao {

	private final SessionFactory sessionFactory;
	public ExamDao() {
		sessionFactory=HibernateUtlity.getSessionFactory();
	}
	public void saveQuestion(Question question) {
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(question);
		session.getTransaction().commit();
		session.close();
	}
	public Question getQuestionById(Integer id) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Question.class);
		cr.add(Restrictions.eq("id", id));
		return (Question)cr.uniqueResult();
	}
	public void saveAnswer(Answer ans) {
			Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(ans);
		session.getTransaction().commit();
		session.close();
	}
	public List<Question> getQuestionList(){
		Session session=sessionFactory.openSession();
		
		Criteria cr=session.createCriteria(Question.class);
		return (List<Question>)cr.list();
	}
	public List<Answer> getAnswerList(){
		Session session=sessionFactory.openSession();
		
		Criteria cr=session.createCriteria(Answer.class);
		return (List<Answer>)cr.list();
	}
}
