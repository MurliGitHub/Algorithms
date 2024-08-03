package m2j.utility;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovertTextToXML {
	static String out = "D:\\data\\OneDrive - Syncsort Inc\\Design\\Property-V2-Design-all\\out.txt";
	public static void main(String[] args) {
		boolean st = convert8("D:\\data\\OneDrive - Syncsort Inc\\Design\\Property-V2-Design-all\\att.txt");
		System.out.println("is File transformed: "+st);
	}

	private static boolean convert(String path) {
		try {
	        // input the (modified) file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(path));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	            line = line.replace(line, "<"+line+">"+" "+ "</"+line+">");
	            System.out.println(line);
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(out);
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	        return false;
	    }
		
		
		return true;
	}
	
	private static boolean convert8(String path) {
		String targetFile = "D:\\data\\SDM_Release\\ouut.txt"; 
		Path out = Paths.get(targetFile);
		
		try(Stream<String> lines = Files.lines(Paths.get(path))){
			
			  List<String> replacedLines = lines
				       .map(line-> line.replaceAll(line, "<"+line+">"+" "+ "</"+line+">"))
				       .collect(Collectors.toList());
			  Files.write(out, replacedLines);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	       
		return true;
	}

}
