package aplication;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			Bussines b = new Bussines();;
			
			while (true) {
				
				final File folder = new File(".\\data");
				String arquivo = listFilesForFolder(folder);
				System.out.println(arquivo);
				
				if(arquivo!=null) {
					b.engine(".\\data\\" + arquivo);
					
					b.gravar(".\\out\\" + arquivo);
					
					Files.move(Paths.get("./data/" + arquivo), Paths.get("./old/" + arquivo), StandardCopyOption.REPLACE_EXISTING);
				}
				TimeUnit.SECONDS.sleep(3);
			}
			
			
			
			
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
}

	public static String listFilesForFolder (final File folder) throws Exception{
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				return fileEntry.getName();
				
			}
		}
		return null;
	}

}
