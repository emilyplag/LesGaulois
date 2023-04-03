package personnage;

public class Gaulois {
	private String nom;
	private int effetPotion=1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	
	public Gaulois(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "«" + texte +"»");
		
	}
	
	
//	private String prendreParole() {
//		
//		return "Le gaulois " + nom +" : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
    
//	public void frapper(Romain romain) {
//		System.out.println(nom +  " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//		
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] lesTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; lesTrophees != null && i < lesTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = lesTrophees[i];
		}
		}
	
	public void faireUneDonnation(Gaulois gaulois, Musee musee) {
		if (nbTrophees > 0) {
			System.out.println("Le gaulois"+getNom()+"<<Je donne au musee"
					+ " tous mes trophees: ");
			
			for(int i=nbTrophees-1; nbTrophees>0; i--,nbTrophees--) {
				
				Trophee tropheeConvertit= new Trophee(gaulois, trophees[i]);
				musee.donnerTrophees(gaulois, tropheeConvertit);
				System.out.println("- "+ trophees[i].toString());
			
			
		}}
			else {
				parler("Il n'y a aucun equipement que je puisse donner");
			}
	}

	
	
	
	// @Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		System.out.println(prendreParole()+ "« Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée.»");
			
		
	}}
	
	




