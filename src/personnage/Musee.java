package personnage;

public class Musee {
	private Trophee[] trophee= new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Trophee equipement) {
		trophee[nbTrophee]=equipement;
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String listeStr= "";
		for(int i=0; nbTrophee >0; i++,nbTrophee++) {
			listeStr= listeStr + " " + trophee[i].donnerNom() +" "+trophee[i].getEquipement();
		}
		return listeStr;
	}
	
}
