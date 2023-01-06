package gameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import gameobjects.Fly;
import gameobjects.Hero;
import gameobjects.Personnage;
import gameobjects.Spider;
import gameobjects.Boss;
import gameobjects.projectile;
import libraries.StdDraw;
import libraries.Vector2;
import resources.FlyInfo;
import resources.ImagePaths;
import resources.RoomInfos;
import resources.SpiderInfo;
import resources.BossInfo;

public class RoomBoss extends Room {
		//private Spider spider;
		private Boss boss;
	   private int nbreMonsters;
	   
		// gestion de position aléatoire
		public static Vector2 controlposition() {
			Random posit = new Random();
			double pos = posit.nextDouble();
			if((pos<0.6 && pos>0.3) || pos<0.2||pos>0.8) return controlposition() ;
			else return new Vector2(pos,pos); 
			
			}
		
		// création et ajout de monstres
		/*public  void addmonster(){
			
		 	 for(int i=0;i<nbreMonsters;i++) {
		 		Fly fly = new Fly(controlposition(),FlyInfo.Fly_SIZE,FlyInfo.Fly_SPEED,ImagePaths.FLY,FlyInfo.FLY_LIFE,FlyInfo.FLY_DAMAGE);
		 		 this. flys.add(i,fly);
		 		// System.out.println(controlposition());
		 	  }
		 	 //System.out.println(spiders);
			
		}*/
		
		public RoomBoss(Hero hero,int nbreMonsters) {
		 	   super(hero);
		 	  //System.out.println(hero.getPosition());
		 	   this.nbreMonsters= nbreMonsters;
		 	  this.boss= new Boss(controlposition(),BossInfo.BOSS_SIZE,BossInfo.BOSS_SPEED,ImagePaths.SPIDER,BossInfo.BOSS_LIFE,FlyInfo.FLY_DAMAGE);
		 	 //addmonster();
		 	 
		 	   
		    }
		
		/*public Spider  afficher() {
			 for(int i=0;i<nbreMonsters;i++) return spiders.get(i);
		   		
				 }*/
		@Override
		protected void makeHeroPlay(){
			super.makeHeroPlay(); 
	    		   boss.updateGameObject();
	    		   for(int j=0; j<  this.boss.getLarmes().size();j++) {
	    			   this.boss.getLarmes().get(j).updateGameObject();
	    			   if(this.boss.getLarmes().get(j).getPosition().getX()>0.86||this.boss.getLarmes().get(j).getPosition().getX()<0.14||this.boss.getLarmes().get(j).getPosition().getY()>0.8||this.boss.getLarmes().get(j).getPosition().getY()<0.2)
	    				   this.boss.getLarmes().remove(j);
	   			
	    		   }
	  
					CollisionMonstre(hero,this.boss);
					//for(int i=0; i<this.flys.size(); i++) {
						for(int j=0;j<this.boss.getLarmes().size(); j++) {
							
							CollisionTirHeroFLY(this.boss.getLarmes().get(j), hero, boss);
							
							
						}
					
					//for(int i=0; i<this.flys.size(); i++) {
						for(int j=0;j<this.hero.getLarmes().size(); j++) {
							
							CollisionTirHero(hero.getLarmes().get(j), boss, hero);
							
							
							
						}
					
				//	for(int i=0; i<this.flys.size(); i++) if(  flys.get(i).getPointlife()<=0)flys.remove(i);
					
				
		
			
		}
	       public void drawRoom()
	   	{
	    	   super.drawRoom();
	    	 // for(int i=0;i<10;i++) spiders.get(i).drawGameObject();
	    	  // for(int i=0;i< this.flys.size();i++) { 
	    	   if(hero.getPointlife()!=0) {   boss.drawGameObject();
	    		   for(int j=0; j<  boss.getLarmes().size();j++) {
	    			   this.boss.getLarmes().get(j).drawGameObject();
	    		   }
	    	  // }
	   	}
	    	   if(boss.getPointlife()==0)	 StdDraw.picture(RoomInfos.POSITION_CENTER_OF_ROOM.getX(),RoomInfos.POSITION_CENTER_OF_ROOM.getY(),ImagePaths. WIN_SCREEN,RoomInfos.SIZE.getX(),RoomInfos.SIZE.getY());   
	   	}


		public int getNbreMonsters() {
			return nbreMonsters;
		}

		public void setNbreMonsters(int nbreMonsters) {
			this.nbreMonsters = nbreMonsters;
		}

		public Boss getBoss() {
			return boss;
		}

		public void setBoss(Boss boss) {
			this.boss = boss;
		}
		
		//GETTERS AND SETTERS
	    


		

}
