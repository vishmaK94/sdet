package session4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Activity4_2_MoveAndReadFile {

	public static void main(String[] args) throws IOException {
		
		String fileName = "ingredients.txt";
		String path = "src/session4/"+fileName;
		File file = new File(path);
		
		String dirName = "resources";
		//String dirPath = "src/session4/"+dirName;
		File destDir = new File(dirName);
		//boolean dirStatus = destDir.createNewFile();
		
		FileUtils.copyFileToDirectory(file, destDir);
		
		File newFile = FileUtils.getFile(destDir, fileName);
		String newFileData = FileUtils.readFileToString(newFile, StandardCharsets.UTF_8);
		
		System.out.println("New file data: \n"+newFileData);

	}

}
