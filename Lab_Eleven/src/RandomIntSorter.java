import java.lang.Math;

public class RandomIntSorter {
	
	public static void main(String[] args){
		
		int[] randomInts = new int[40];
		
		for(int i = 0; i<40; i++){
			randomInts[i] = (int) Math.round((Math.random()*999));
			System.out.println(randomInts[i]+"--"+i);
		
		}
	}

}
