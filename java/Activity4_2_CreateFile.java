package session4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Activity4_2_CreateFile {

	public static void main(String[] args) throws IOException {
		
		String fileName = "ingredients.txt";
		String path = "src/session4/"+fileName;
		File file = new File(path);
		boolean fStatus = file.createNewFile();
		
		if(fStatus) {
			System.out.println("\""+fileName+"\" file has been created succesfully!");
			
			String data = "Ingredients to create Khichdi\n1. Rice\n2. Pulses\n3. Salt\n4. Water\n5. Cooking oil";
			FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8);
			
			String fileData = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			System.out.println("The contents of the file \""+fileName+"\" are\n**********\n"+fileData+"\n**********");
			
		} else {
			System.out.println("Unable to create file : "+fileName);
		}
		
		
		
	}

}
