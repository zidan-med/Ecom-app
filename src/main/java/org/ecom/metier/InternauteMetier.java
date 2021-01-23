package org.ecom.metier;

import java.util.List;

import org.ecom.entities.*;


public interface InternauteMetier {
	public List<Categorie> listeCatgories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p,Client c);

}
