package es.uniovi.asw.parser.parsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.ReadCensus;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

public class TXTParser implements ReadCensus {

	private WreportR wreportR;
	
	public TXTParser() {
		this.wreportR = new WreportR(new ReportWriter());
	}

	@Override
	public List<Voter> read(String fileName) {
		
		List<Voter> voters = new ArrayList<Voter>();
		BufferedReader br = null;
		
		String line = "";
		String splitBy = "\t";

		try {

			br = new BufferedReader(new FileReader("Censuses/" + fileName));
			
			while ((line = br.readLine()) != null) {
				String[] voter = line.split(splitBy);
				addVoter(voters, voter);
			}

		} 
		
		catch (FileNotFoundException e) {
			wreportR.log("ERROR - El fichero " + fileName + " no existe");
		} 
		
		catch (Exception e) {
			wreportR.log("Error al leer el fichero TXT: " + e.getMessage());
		} 
		
		finally {
			
			try {
				if (br != null) 
					br.close();
			} 
			
			catch (Exception e) {
				wreportR.log("ERROR TXTParser - Error cerrar I/O: " + e.getMessage());
			}
		}
		
		return voters;
	}
	
	private void addVoter(List<Voter> voters, String[] voter) {

		//// OJO DETECTAR ERRORES
		
		try {
			
			String name = voter[0];
			String email = voter[1];
			String nif = voter[2];
			int code = Integer.parseInt(voter[3]);

			Voter v = new Voter(name, email, nif, code, null);

			voters.add(v);

		} catch (Exception e) {
			wreportR.log("ERROR TXTParser: el votante no tiene el formato correcto");
		}

	}

}
