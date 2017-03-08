import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
public class main_logic {
	
	//=======================================--------Variables
	private static String toDisplay = "";
	private static int directoriesFound = 0;
	public static displayArray display_Array = new displayArray();
	private static int depth = 0;
	//=======================================
	
	//=======================================--------Getter method for depth
	public static int getDepth(){
		return depth;
	}
	//=======================================

	//=======================================--------Main method for mapping a given directory (currentFile)
	public static void getSubDirectories(String currentFile){
		
		main_GUI mainGui = new main_GUI();
		
		try{
			File directory = new File(currentFile);
			File[] subdirs = directory.listFiles();
			//depth--;																												Not critical and broken
			for (int i = 0; i<=subdirs.length-1; i++) {
				display_Array.add(subdirs[i].toString());
				toDisplay= toDisplay+"\n"+subdirs[i].toString();
				directoriesFound++;
				System.out.println("Appending: "+ subdirs[i].toString());
				if(getFileExtension(subdirs[i].toString()).equals("_directory_")){
					//depth++;																									Not critical and broken
					getSubDirectories(subdirs[i].toString());
				}
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException){
			toDisplay = toDisplay+"\n"+"Program was denied access. Continuing.";
		}
	}
	//=======================================
	
	//=======================================--------Getter method for directoriesFound
	public static int getDirectoriesFound(){
		return directoriesFound;
	}
	//=======================================
	
	//=======================================--------Method that returns a files .___ extension
	public static String getFileExtension(String file){
		String returnExtension = "";
		if(file.contains(".")){
			for(int i = file.indexOf('.');i<file.length();i++){
				returnExtension = returnExtension + file.charAt(i);
				
			}
			return returnExtension;
		}
		
		return "_directory_";
		
	}
	//=======================================
	
}
