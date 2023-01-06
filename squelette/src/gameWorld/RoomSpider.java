package gameWorld;
import java.util.*;
import libraries.Vector2;
import gameobjects.Hero;
import gameobjects.Spider;
import gameobjects.projectile;
import resources.ImagePaths;
import resources.SpiderInfo;

public class RoomSpider extends Room {
	//private Spider spider;
	private List<Spider> spiders;
   private int nbreMonsters;
   
   
	// gestion de position aléatoire
	public static Vector2 controlposition() {
		Random posit = new Random();
		double pos = posit.nextDouble();
		if((pos<0.6 && pos>0.3) || pos<0.2||pos>0.8) return controlposition() ;
		else return new Vector2(pos,pos); 
		
		}
	
	// création et ajout de monstres
	public  void addmonster(){
		
	 	 for(int i=0;i<nbreMonsters;i++) {
	 		Spider spider = new Spider(controlposition(),SpiderInfo.SPIDER_SIZE,SpiderInfo.SPIDER_SPEED,ImagePaths.SPIDER,SpiderInfo.SPIDER_LIFE,SpiderInfo.SPIDER_DAMAGE);
	 		 this. spiders.add(i,spider);
	 		// System.out.println(controlposition());
	 	  }
	 	 //System.out.println(spiders);
		
	}
	
	public RoomSpider(Hero hero,int nbreMonsters) {
	 	   super(hero);
	 	  //System.out.println(hero.getPosition());
	 	   this.nbreMonsters= nbreMonsters;
	 	  this.spiders = new ArrayList<Spider>();
	 	  this.time1=0;
	 	 this.time2=0;
	 	 addmonster();
	 	 
	 	   
	    }
	
	/*public Spider  afficher() {
		 for(int i=0;i<nbreMonsters;i++) return spiders.get(i);
	   		
			 }*/
	@Override
	protected void makeHeroPlay(){
		super.makeHeroPlay();
		for(int i=0;i<spiders.size();i++) {
			spiders.get(i).updateGameObject();
			if(spiders.get(i).getPointlife()<=0)spiders.remove(i);
			}
		
		for(int i=0; i<this.spiders.size(); i++) {
		
				// contact d'isaac  avec un monstre 
				CollisionMonstre(hero,this.spiders.get(i));
				this.time1 = (int)System.nanoTime();
			
			
			
		};
		
		for(int i=0; i<hero.getLarmes().size(); i++) {
			for(int j=0;j<this.spiders.size(); j++) {
			
				CollisionTirHero(hero.getLarmes().get(i), this.spiders.get(j), hero);
				this.time2 = (int)System.nanoTime();
			}
		};
		
		
	}
       public void drawRoom()
   	{
    	   super.drawRoom();
    	 // for(int i=0;i<10;i++) spiders.get(i).drawGameObject();
    	   if(hero.getPointlife()!=0)  for(Spider spid : this.spiders) spid.drawGameObject();
   	}
	
	//GETTERS AND SETTERS
    public List<Spider> getSpider() {
		return spiders;
	}
	public void setSpider(List<Spider> spiders) {
		this.spiders = spiders;
	}


	public List<Spider> getSpiders() {
		return spiders;
	}


	public void setSpiders(List<Spider> spiders) {
		this.spiders = spiders;
	}


	public int getNbreMonsters() {
		return nbreMonsters;
	}


	public void setNbreMonsters(int nbreMonsters) {
		this.nbreMonsters = nbreMonsters;
	}

	

	
	
}
