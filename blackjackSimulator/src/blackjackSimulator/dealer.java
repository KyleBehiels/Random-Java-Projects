package blackjackSimulator;

import java.lang.Math;

public class dealer {

	static int[] cards = {2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,0,0,0,0,0,0,0};
	static int[] cardsDeck = cards;
	static int[] dealt = new int[104]; 
	static int index = 0;
	
	public static int deal(){
		int dealtCard;
		int selection = (int)Math.round(Math.random()*104);
		boolean goodSelection = true;
		for(int i = 0; i< dealt.length;i++){
			if(dealt[i]==selection){
				goodSelection = false;
			}
			
		}
		if(goodSelection){
			dealt[index] = selection;
			dealtCard = cardsDeck[selection];
			cardsDeck[selection] = -1;
			return dealtCard;
		}
		else{
			goodSelection = true;
			deal();
			return (Integer) null;
		}
		
		
		
		
	}
	
	public static void main(String[] args){
		for(int i = 0; i<104;i++){
			System.out.println(deal());
		}
		
		
	}
	
}
