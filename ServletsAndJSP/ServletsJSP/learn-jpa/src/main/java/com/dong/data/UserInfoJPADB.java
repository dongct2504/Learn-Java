package com.dong.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.dong.business.UserInfoJPA;
import com.mysql.cj.Query;

public class UserInfoJPADB {
	
	public static List<UserInfoJPA> getAll() {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
		
		String qString = "SELECT u FROM UserInfoJPA u";
		TypedQuery<UserInfoJPA> q = em.createQuery(qString, UserInfoJPA.class);
		
		try {
			List<UserInfoJPA> users = q.getResultList();
			return users;
		} finally {
			em.close();
		}
	}
	
	// retrieve an entity by primary key
	public static UserInfoJPA getUserInfoJPAById(long userId) {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			UserInfoJPA user = em.find(UserInfoJPA.class, userId);
			return user;
		} finally {
			// this code closes the entity manager, even if the find method throws an exception.
			em.close(); 
		}
	}
	
	public static UserInfoJPA getUserInfoJPA(String email) {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
		
		String qString = "SELECT u FROM UserInfoJPA u " +
				"WHERE u.email = :email";
		TypedQuery<UserInfoJPA> q = em.createQuery(qString, UserInfoJPA.class);
		q.setParameter("email", email);
		
		try {
			UserInfoJPA user = q.getSingleResult();
			return user;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
	
	public static boolean emailExists(String email) {
		UserInfoJPA user = getUserInfoJPA(email);
		return (user != null);
	}
	
	public static void insert(UserInfoJPA user) throws Exception {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void update(UserInfoJPA user) {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public void delete(UserInfoJPA user) {
		EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

}










