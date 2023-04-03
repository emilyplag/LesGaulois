package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert(force >= 0);
		this.force = force;
		equipements= new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		 } else {
			 equipementEjecte = ejecterEquipement();
		 	 parler("J'abandonne...");
		}
		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
		
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " +forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
				resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) {
			forceCoup= 0; }
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
	
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}}
			return equipementEjecte;
				

		}
		
		
		
		
//	public void recevoirCoup(int forceCoup) {
//		int avantforce=force;
//		force -= forceCoup;
//		
//		if (force > 0) {
//			parler("Aie");
//			
//		} else {
//			parler("J'abandonne...");
//		}
//	assert(force <= avantforce);
//	}
	
	
	private void mettreEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement+=1; 
		System.out.println("Le soldat " + nom + " s’équipe avec un " + equipement.toString()+".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat "+nom+ " est déjà bien protégé !");
			break;
		case 1:
			if(equipements[nbEquipement-1].toString()==equipement.toString()) {
				System.out.println("« Le soldat "+nom+" possède déjà "+equipement.toString()+".");}
			else {
				mettreEquipement(equipement);
			}
			break;
		default:
			
			mettreEquipement(equipement);
		}
		
	}

	
	public static void main(String[] args) {		
		Romain minus=new Romain("Minus",6);
		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
	
}