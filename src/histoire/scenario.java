package histoire;

import personnage.Druide;
import personnage.Gaulois;
import personnage.Romain;
public class scenario {

public static void main(String[] args) {

	Druide panoramix=new Druide("Panoramix",5,10);
	Gaulois asterix= new Gaulois("Astérix",8);
	Gaulois obelix= new Gaulois("Obélix",12);		
	Romain minus=new Romain("Minus",-6);
	panoramix.preparerPotion();
	panoramix.booster(obelix);
	asterix.parler("Bonjour à tous");
	obelix.parler("Par Bélénos, ce n'est pas juste !");
	panoramix.booster(asterix);
	asterix.parler("Bonjour");
	minus.parler("UN GAU... UN GAUGAU...»");
	asterix.frapper(minus);
	asterix.frapper(minus);
	asterix.frapper(minus);
	
		
	}
}

