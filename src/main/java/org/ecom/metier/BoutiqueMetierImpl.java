package org.ecom.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.ecom.dao.IBoutiqueDao;
import org.ecom.entities.Categorie;
import org.ecom.entities.Client;
import org.ecom.entities.Commande;
import org.ecom.entities.Panier;
import org.ecom.entities.Produit;
import org.ecom.entities.Role;
import org.ecom.entities.User;
@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier{

	private IBoutiqueDao dao;
	
	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
		
	}

	@Override
	public List<Categorie> listeCatgories() {
		// TODO Auto-generated method stub
		return dao.listeCatgories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
		
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
		
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		dao.attribuerRole(r, userID);
	}

}
