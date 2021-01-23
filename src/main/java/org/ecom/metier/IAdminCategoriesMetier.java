package org.ecom.metier;

import org.ecom.entities.Categorie;
import org.ecom.entities.Role;
import org.ecom.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier{
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	 

}
