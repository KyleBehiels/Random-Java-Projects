package dougsFileRenamer;
import java.io.*;
import java.nio.file.Path;

public class main_logic {
	
	public void changeFiles(String filePath, String origionalExtension, String newExtension ) throws IOException{
		File folder = new File(filePath); 
		File[] files = folder.listFiles();
		System.out.println(files.length);
		for(int i = 0; i<= files.length-1; i++){
			String currentExtension = files[i].getName().substring(files[i].getName().length()-3, files[i].getName().length());
			String currentName = files[i].getName().substring(0, files[i].getName().length()-3);
			System.out.println(files[i].getName().substring(0, files[i].getName().length()-3));
			System.out.println(currentExtension);
			if(currentExtension.equals(origionalExtension)){
				files[i].renameTo(new File(filePath+"\\"+currentName+newExtension));
			}
		}
		
	}

}
