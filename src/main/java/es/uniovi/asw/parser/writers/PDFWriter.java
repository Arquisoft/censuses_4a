package es.uniovi.asw.parser.writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.LetterWriter;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

/**
 * @author Ricardo Suárez Rodríguez
 * @author Iván Modroño Álvarez
 */
public class PDFWriter implements LetterWriter {
	
	private WreportR wreportR;
	
	public PDFWriter() {
		this.wreportR = new WreportR(new ReportWriter());
	}

	@Override
	public void write(Voter voter) {
		
		Document doc = null;
		FileOutputStream file = null;

		try {
			
			file = new FileOutputStream("Letters/" + voter.getNif() + ".pdf");

			doc = new Document();
			PdfWriter.getInstance(doc, file);

			doc.open();
			doc.add(new Paragraph(
					"Don/Doña " + voter.getName() + 
					" ha sido añadido/a al censo.\n\nDatos de acceso:\n" +
					"Usuario: " + voter.getEmail() + 
					"\nPassword: " + voter.getPassword() + 
					"\n\nSu colegio electoral es el " + voter.getCode()));

		} 
		
		catch (FileNotFoundException e) {
			wreportR.log("ERROR PDFWriter: No se puede crear el archivo que contiene"
					+ " la carta PDF del usuario " + voter.getNif()
				);
		} 
		
		catch (DocumentException e) {
			wreportR.log("ERROR PDFWriter - Error al crear la carta PDF para " + 
					voter.getNif() + ": " + e.getMessage()
				);
		}
		
		finally {
			
			try {
				if (doc != null) doc.close();
				if (file != null) file.close();
			} 
			
			catch (Exception e) {
				wreportR.log("ERROR PDFWriter - Error cerrar I/O (" + 
						voter.getNif() + "): " + e.getMessage()
					);
			}
		}

	}

}
