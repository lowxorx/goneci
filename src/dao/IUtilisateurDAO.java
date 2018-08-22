package dao;

import java.util.List;

import metier.Utilisateur;

public interface IUtilisateurDAO {
	public Utilisateur saveOrUpdate(Utilisateur user);

	public List<Utilisateur> getAll();

	public boolean remove(Utilisateur user);

	public boolean removeAll();

	public List<Utilisateur> findByNom(String nomUser);

	public boolean isAdmin(String login, String pass);

	Utilisateur findByNumAbo(String numabo);

	public Utilisateur CheckLoginMdp(String login, String mdp);

	public Utilisateur CheckbyName(String nom, String prenom);

	List<Utilisateur> getAllAdmin();

	List<Utilisateur> getAllClients();
}
