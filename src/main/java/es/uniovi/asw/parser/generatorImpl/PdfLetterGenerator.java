package es.uniovi.asw.parser.generatorImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.voters.Voter;

/**
 * @author Ricardo Suárez Rodríguez
 */
public class PdfLetterGenerator extends LetterGenerator {

	@Override
	public void generate(Voter voter) {

		try {
			FileOutputStream file = new FileOutputStream("src/main/resources/letters/" + voter.getNif() + ".pdf");

			Document doc = new Document();
			PdfWriter.getInstance(doc, file);

			doc.open();
			doc.add(new Paragraph("Don/Doña " + voter.getName() + " ha sido añadido/a al censo. Sus datos son:\n"
					+ "Usuario:" + voter.getEmail() + "\nPassword: " + voter.getPassword()));

			doc.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {

			e.printStackTrace();
		}

	}

}
