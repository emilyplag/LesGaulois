package personnage;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		forcePotion=1;
		parler("Bonjour, je suis le druide" + nom + " et ma potion peut aller d'une force " 
		 + " de " + effetPotionMax + ".");
		
	}
	
	

	public String getNom() {
		return nom;
	}

	
	

	public int getForcePotion() {
		return forcePotion;
	}




	public void parler(String texte) {
		System.out.println(prendreParole()+ "« " + texte + "»");
		
	}

	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random=new Random();
		forcePotion= random.nextInt(effetPotionMax+1-effetPotionMin)+effetPotionMin;
		if (forcePotion > 7) {
			System.out.println(prendreParole()+"« J'ai préparé\r\n"
					+ "une super potion de force "+forcePotion +".»");
		}
		else {
			System.out.println(prendreParole()+"« Je n'ai pas trouvé tous les ingrédients, ma potion est\r\n"
					+ "seulement de force "+ forcePotion+ "»");}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom()=="Obélix") {
			parler("« Non, Obélix !... Tu n’auras pas de potion\r\n"
					+ "magique ! »");
		}
		else {
		gaulois.boirePotion(forcePotion);}
		
	}
}