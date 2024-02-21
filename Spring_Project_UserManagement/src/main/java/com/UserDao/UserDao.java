package com.UserDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.UserDto.UserDetails;

public class UserDao {
	public void saveuser(UserDetails userdetails) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinmay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(userdetails);
		et.commit();
	}

	public List<UserDetails> fetchAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinmay");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT s FROM UserDetails s");
		List<UserDetails> list = query.getResultList();

		return list;
	}

	public UserDetails fetchUerbyID(int id) {
		return null;
	}

	public void updateUserbyID(UserDetails userDetails) {

	}

	public UserDetails fetchUserbyEmailAndPassword(String email, int password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinmay");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT u FROM UserDetails u WHERE u.email=?1");
		query.setParameter(1, email);
		List<UserDetails> list = query.getResultList();
		for (UserDetails userDetails : list) {
			if (userDetails != null) {
				int p1 = userDetails.getPassword();
				if (p1 == password) {
					return userDetails;
				}
			}
		}
		return null;
	}

}
