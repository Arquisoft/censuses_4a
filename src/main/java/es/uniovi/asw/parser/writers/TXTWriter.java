package es.uniovi.asw.parser.writers;

import java.io.File;
import java.io.FileWriter;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.LetterWriter;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

public class TXTWriter implements LetterWriter {

	private WreportR wreportR;
	
	public TXTWriter() {
		this.wreportR = new WreportR(new ReportWriter());
	}

	@Override
	public void write(Voter voter) {

		FileWriter writeLetter = null;
		
		try {
			
			File letter = new File("Letters/" + voter.getNif() + ".txt");
			writeLetter = new FileWriter(letter, true);

			writeLetter.write(
					"Don/Doña " + voter.getName() + 
					" ha sido añadido/a al censo.\n\nDatos de acceso:\n" + 
					"Usuario: " + voter.getEmail() + 
					"\nPassword: " + voter.getPassword() + 
					"\n\nSu colegio electoral es el " + voter.getCode()
				);
			
		} catch (Exception e) {
			wreportR.log("ERROR TXTWriter - Error al crear la carta TXT para " + 
					voter.getNif() + ": " + e.getMessage()
				);
		}
		
		finally {
			
			try {
				if (writeLetter != null) 
					writeLetter.close();
			} 
			
			catch (Exception e) {
				wreportR.log("ERROR TXTWriter - Error cerrar I/O (" + 
						voter.getNif() + "): " + e.getMessage()
					);
			}
		}
	}

}
