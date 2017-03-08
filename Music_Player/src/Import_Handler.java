import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JApplet;

public class Import_Handler {
	
	public static AudioClip[] allSongs = new AudioClip[10];
	public static AudioClip[] rockSongs = new AudioClip[10];
	public static AudioClip[] rapSongs = new AudioClip[10];
	public static AudioClip[] popSongs = new AudioClip[10];
	public static AudioClip[] countrySongs = new AudioClip[10];
	public static AudioClip[] bluesSongs = new AudioClip[10];
	public static AudioClip[] electronicSongs = new AudioClip[10];
	
	public static String[] allNames = new String[10];
	public static String[] rockNames = new String[10];
	public static String[] rapNames = new String[10];
	public static String[] popNames = new String[10];
	public static String[] countryNames = new String[10];
	public static String[] bluesNames = new String[10];
	public static String[] electronicNames = new String[10];
	
	static int allIndex=0, rockIndex=0, rapIndex=0, popIndex=0, countryIndex=0, bluesIndex=0, electronicIndex=0;
	
	public static void expandArray(AudioClip[] arrayToExpand){
		arrayToExpand = Arrays.copyOf(arrayToExpand, arrayToExpand.length*2);
	}
	
	public static AudioClip importFromUrl(String urlInput){
		AudioClip thisSong;
		try {
			URL url1 = new URL(urlInput);
			System.out.println("Download Started");
			thisSong = JApplet.newAudioClip(url1);
			System.out.println("Download Finished");
			return thisSong;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
