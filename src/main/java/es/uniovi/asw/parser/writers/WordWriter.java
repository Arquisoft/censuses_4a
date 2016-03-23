/**
 * 
 */
package es.uniovi.asw.parser.writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.LetterWriter;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

/**
 * @author ivan
 *
 */
public class WordWriter implements LetterWriter {
	
	private WreportR wreportR;
	
	public WordWriter() {
		this.wreportR = new WreportR(new ReportWriter());
	}


	/* (non-Javadoc)
	 * @see es.uniovi.asw.parser.interfaces.LetterWriter#write(es.uniovi.asw.dbupdate.model.Voter)
	 */
	@Override
	public void write(Voter voter) {
		
		XWPFDocument document = new XWPFDocument();
		FileOutputStream out = null;
		
		try {
			
			out = new FileOutputStream(new File("Letters/" + voter.getNif() + ".docx"));
			
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			
			run.setFontFamily("Tahoma");
			run.setFontSize(12);
			
			generateContent(voter, run);
			document.write(out);

		} 
		
		catch (FileNotFoundException e) {
			wreportR.log("ERROR WordWriter: No se puede crear el archivo que contiene"
					+ " la carta Word del usuario " + voter.getNif()
				);
		} 
		
		catch (Exception e) {
			wreportR.log("ERROR PDFWriter - Error al crear la carta PDF para " + 
					voter.getNif() + ": " + e.getMessage()
				);
		}
		
		finally {
			
			try {
				if (out != null) out.close();
				if (document != null) document.close();
			} 
			
			catch (Exception e) {
				wreportR.log("ERROR WordWriter - Error cerrar I/O (" + 
						voter.getNif() + "): " + e.getMessage()
					);
			}
		}

	}

	private void generateContent(Voter voter, XWPFRun run) {
		run.setText("Don/Doña " + voter.getName() + " ha sido añadido/a al censo.");
		run.addBreak();
		run.addBreak();
		run.setText("Datos de acceso:");
		run.addBreak();
		run.setText("Usuario: " + voter.getEmail());
		run.addBreak();
		run.setText("Password: " + voter.getPassword());
		run.addBreak();
		run.addBreak();
		run.setText("Su colegio electoral es el " + voter.getCode());
	}

}
