package gameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import gameobjects.Fly;
import gameobjects.Hero;
import gameobjects.Personnage;
import gameobjects.Spider;
import gameobjects.projectile;
import libraries.Vector2;
import resources.FlyInfo;
import resources.ImagePaths;
import resources.SpiderInfo;

public class RoomFly extends Room {
		//private Spider spider;
		private List<Fly> flys;
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
		 		Fly fly = new Fly(controlposition(),FlyInfo.Fly_SIZE,FlyInfo.Fly_SPEED,ImagePaths.FLY,FlyInfo.FLY_LIFE,FlyInfo.FLY_DAMAGE);
		 		 this. flys.add(i,fly);
		 		// System.out.println(controlposition());
		 	  }
		 	 //System.out.println(spiders);
			
		}
		
		public RoomFly(Hero hero,int nbreMonsters) {
		 	   super(hero);
		 	  //System.out.println(hero.getPosition());
		 	   this.nbreMonsters= nbreMonsters;
		 	  this.flys = new ArrayList<Fly>();
		 	 addmonster();
		 	 
		 	   
		    }
		
		/*public Spider  afficher() {
			 for(int i=0;i<nbreMonsters;i++) return spiders.get(i);
		   		
				 }*/
		@Override
		protected void makeHeroPlay(){
			super.makeHeroPlay();
			//for(Fly fl : this.flys) fl.updateGameObject();
			for(int i=0;i< this.flys.size();i++) { 
	    		   flys.get(i).updateGameObject();
	    		   
	    		   for(int j=0; j<  this.flys.get(i).getLarmes().size();j++) {
	    			   this.flys.get(i).getLarmes().get(j).updateGameObject();
	    			   if(this.flys.get(i).getLarmes().get(j).getPosition().getX()>0.86||this.flys.get(i).getLarmes().get(j).getPosition().getX()<0.14||this.flys.get(i).getLarmes().get(j).getPosition().getY()>0.8||this.flys.get(i).getLarmes().get(j).getPosition().getY()<0.2)
	    				   this.flys.get(i).getLarmes().remove(j);
	   			
	    		   }
	    	   }
			for(int i=0; i<this.flys.size(); i++) {
				
					// contact d'isaac  avec un monstre 
					CollisionMonstre(hero,this.flys.get(i));
					
				
			};
			for(int i=0; i<this.flys.size(); i++) {
				for(int j=0;j<this.flys.get(i).getLarmes().size(); j++) {
					
					CollisionTirHeroFLY(this.flys.get(i).getLarmes().get(j), hero, this.flys.get(i));
					
					
				}
			};
			for(int i=0; i<this.flys.size(); i++) {
				for(int j=0;j<this.hero.getLarmes().size(); j++) {
					
					CollisionTirHero(hero.getLarmes().get(j), this.flys.get(i), hero);
					
					
					
				}
			};
			for(int i=0; i<this.flys.size(); i++) if(  flys.get(i).getPointlife()<=0)flys.remove(i);
			
		}
	       public void drawRoom()
	   	{
	    	   super.drawRoom();
	    	 // for(int i=0;i<10;i++) spiders.get(i).drawGameObject();
	    	   if(hero.getPointlife()!=0)   for(int i=0;i< this.flys.size();i++) { 
	    		   flys.get(i).drawGameObject();
	    		   for(int j=0; j<  this.flys.get(i).getLarmes().size();j++) {
	    			   this.flys.get(i).getLarmes().get(j).drawGameObject();
	    		   }
	    	   }
	   	}

		public List<Fly> getFlys() {
			return flys;
		}

		public void setFlys(List<Fly> flys) {
			this.flys = flys;
		}

		public int getNbreMonsters() {
			return nbreMonsters;
		}

		public void setNbreMonsters(int nbreMonsters) {
			this.nbreMonsters = nbreMonsters;
		}
		
		//GETTERS AND SETTERS
	    


		

}
