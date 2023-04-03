package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMaximum];
	}

		
	public void setChef(Chef chef) {
		this.chef = chef;
		
	}
	
	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois+=1;
	}
	
	public String trouverHabitant(int reference){
		return villageois[reference].getNom();
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires gaulois :");
		for(int i=0 ; i< nbVillageois;i++) {
			System.out.println("- "+ villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village=new Village("Village des Irréductibles",30);
		Chef abraracourcix= new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix=new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix=new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		
	}
	
}
