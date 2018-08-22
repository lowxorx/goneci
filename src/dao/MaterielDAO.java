package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class MaterielDAO implements IMaterielDAO {

	private EntityManager eM = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllSon() {
		List<String> listeson = new ArrayList<String>();

		try {

			eM.getTransaction().begin();

			listeson = eM.createQuery("SELECT typeSon FROM Materiel").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return listeson;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllEcran() {
		List<String> listeecran = new ArrayList<String>();

		try {

			eM.getTransaction().begin();

			listeecran = eM.createQuery("SELECT typeEcran FROM Materiel").getResultList();

			eM.getTransaction().commit();
		} catch (Exception e) {
			if (eM.isOpen())
				eM.getTransaction().rollback();
			e.printStackTrace();
		} finally {
		}
		return listeecran;
	}

}
