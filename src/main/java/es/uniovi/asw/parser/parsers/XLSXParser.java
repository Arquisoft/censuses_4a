package es.uniovi.asw.parser.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.dbupdate.model.Voter;
import es.uniovi.asw.parser.interfaces.ReadCensus;
import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.ReportWriter;

public class XLSXParser implements ReadCensus {

	private WreportR wreportR;
	
	public XLSXParser() {
		this.wreportR = new WreportR(new ReportWriter());
	}

	@Override
	public List<Voter> read(String fileName) {

		List<Voter> voters = new ArrayList<Voter>();
		XSSFWorkbook listaVotantes = null;

		try {

			FileInputStream file = new FileInputStream(new File("Censuses/" + fileName));
			listaVotantes = new XSSFWorkbook(file);

			XSSFSheet hoja = listaVotantes.getSheetAt(0);
			Iterator<Row> rowIterator = hoja.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> columns = row.cellIterator();
				addVoter(voters, columns);
			}
			
		}
		
		catch (FileNotFoundException e) {
			wreportR.log("ERROR - El fichero " + fileName + " no existe");
		} 
		
		catch (Exception e) {
			wreportR.log("Error al leer el fichero XSLX: " + e.getMessage());
		}
		
		finally {
			
			try {
				if (listaVotantes != null)
					listaVotantes.close();
			} 
			
			catch (Exception e) {
				wreportR.log("ERROR XSLParser - Error cerrar I/O: " + e.getMessage());
			}
		}
		
		return voters;
	}

	private void addVoter(List<Voter> voters, Iterator<Cell> columns) {

		//// OJO DETECTAR ERRORES
		
		try {
			
			if (!columns.hasNext())
				return;
			
			String name = columns.next().getStringCellValue();
			String email = columns.next().getStringCellValue();
			String nif = columns.next().getStringCellValue();
			int code = (int) columns.next().getNumericCellValue();

			Voter voter = new Voter(name, email, nif, code, null);

			voters.add(voter);

		} catch (Exception e) {
			wreportR.log("ERROR XLSXParser: el archivo no tiene el formato correcto");
		}

	}

}
