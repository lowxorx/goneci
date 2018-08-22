package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import metier.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@Override
	public Utilisateur saveOrUpdate(Utilisateur user) {
		if (user == null)
			return null;
		try {
			eM.getTransaction().begin();
			if (eM.find(Utilisateur.class, user.getIdUtilisateur()) == null) {
				eM.persist(user);
			} else if (eM.find(Utilisateur.class, user.getIdUtilisateur()) != null) {
				eM.merge(user);
			}
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return user;
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAllAdmin() {
		List<Utilisateur> adminlist = new ArrayList<Utilisateur>();
		boolean IsAdmin = true;
		try {
			eM.getTransaction().begin();
			adminlist = eM.createQuery("SELECT u FROM Utilisateur u WHERE u.admin =:isadmin", Utilisateur.class)
					.setParameter("isadmin", IsAdmin).getResultList();
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return adminlist;
	}

	@Override
	public List<Utilisateur> getAllClients() {
		List<Utilisateur> clientlist = new ArrayList<Utilisateur>();
		boolean IsAdmin = false;
		try {
			eM.getTransaction().begin();
			clientlist = eM.createQuery("SELECT u FROM Utilisateur u WHERE u.admin =:isadmin", Utilisateur.class)
					.setParameter("isadmin", IsAdmin).getResultList();
			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return clientlist;
	}

	@Override
	public boolean remove(Utilisateur user) {
		boolean isDeleted = false;

		if (user == null) {
			return isDeleted;
		}
		user.getIdUtilisateur();

		try {
			eM.getTransaction().begin();

			if (eM.find(Utilisateur.class, user.getIdUtilisateur()) != null) {
				eM.remove(eM.find(Utilisateur.class, user.getIdUtilisateur()));
				isDeleted = true;
			}

			eM.getTransaction().commit();
		} catch (Exception e) {
			isDeleted = false;
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return isDeleted;
	}

	@Override
	public boolean removeAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur findByNumAbo(String numabo) {
		Utilisateur user = null;
		eM.getTransaction().begin();

		try {

			user = eM.createQuery("select u from Utilisateur u where u.numFidélité =:numabo", Utilisateur.class)
					.setParameter("numabo", numabo).getSingleResult();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return user;
	}

	@Override
	public List<Utilisateur> findByNom(String nomUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdmin(String login, String pass) {

		boolean isadmin = false;
		Utilisateur user = null;

		if (login == null || pass == null)
			return isadmin;

		eM.getTransaction().begin();
		try {

			user = eM.createQuery("SELECT u FROM Utilisateur u WHERE u.numFidélité =:login", Utilisateur.class)
					.setParameter("login", login).getSingleResult();

			eM.getTransaction().commit();

			if (user.isAdmin() == true && user.getPassword().equals(pass)) {
				isadmin = true;
			}

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}

		return isadmin;
	}

	@Override
	public Utilisateur CheckLoginMdp(String login, String mdp) {

		Utilisateur util = new Utilisateur();

		try {

			eM.getTransaction().begin();

			util = eM.createQuery("select u from Utilisateur u where u.nom =:login", Utilisateur.class)
					.setParameter("login", login).getSingleResult();

			eM.getTransaction().commit();

			if (util.getNom().equals(login) && util.getPassword().equals(mdp)) {

				System.out.println("c'est bon !!");
				return util;

			} else {

				System.out.println("Plantage !!");
				return null;

			}

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public Utilisateur CheckbyName(String nom, String prenom) {

		Utilisateur util = null;

		try {

			eM.getTransaction().begin();

			util = eM
					.createQuery("select u from Utilisateur u where u.nom =:nom AND u.prenom =:prenom ",
							Utilisateur.class)
					.setParameter("nom", nom).setParameter("prenom", prenom).getSingleResult();

			eM.getTransaction().commit();

		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {

		}

		return util;

	}

}
