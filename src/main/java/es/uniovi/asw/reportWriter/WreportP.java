package es.uniovi.asw.reportWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class WreportP implements WriteReport{

	@Override
	public void report(String data) {
		
		try{
			
		File file = new File("src/main/resources/log/log.txt");
		FileWriter writer = new FileWriter(file, true);
		
		writer.write("DATE: "+  new Date(System.currentTimeMillis()) + " [ " + data + " ]\n");
		writer.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
