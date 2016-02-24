package es.uniovi.asw.parser.readerImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.reportWriter.WreportP;
import es.uniovi.asw.voters.Voter;

public class XLSXParser implements Parser {

	private WreportP log;

	public XLSXParser() {

		log = new WreportP();
	}

	@SuppressWarnings({ "rawtypes", "resource" })
	@Override
	public List<Voter> loadVoters(String fileName) {

		List<Voter> voters = new ArrayList<Voter>();

		try {

			FileInputStream file = new FileInputStream(new File(fileName));

			XSSFWorkbook listaVotantes = new XSSFWorkbook(file);

			XSSFSheet hoja = listaVotantes.getSheetAt(0);

			Iterator<Row> rowIterator = hoja.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> columns = row.cellIterator();
				addVoterToCensus(voters, fileName, columns); // Cargamos los
																// datos del
																// votante
			}
			listaVotantes.close();

		} catch (IOException ioe) {

			log.report("Error al leer el fichero");

		}
		return voters;
	}

	private void addVoterToCensus(List<Voter> voters, String file, Iterator<Cell> columns) {

		try {
			String name = columns.next().getStringCellValue();
			String nif = columns.next().getStringCellValue();
			int code = (int) columns.next().getNumericCellValue();
			String email = columns.next().getStringCellValue();

			Voter voter = new Voter(name, nif, code, email, null);

			voters.add(voter);

		} catch (IllegalStateException | NumberFormatException ne) {

			log.report("Formato incorrecto");
		}

	}

	// private void Leer(List cellDataList){
	// for (int i = 0; i < cellDataList.size(); i++) {
	// List cellTempList = (List) cellDataList.get(i);
	// for (int j = 0; j < cellTempList.size(); j++) {
	// XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
	// String stringCellValue = hssfCell.toString();
	// System.out.print(stringCellValue+" ");
	// }
	// System.out.println();
	// }
	// }

}
