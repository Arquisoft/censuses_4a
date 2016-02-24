package es.uniovi.asw.parser.readerImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Parser;

public class XLSXParser implements Parser {
	
	private List<Voter> voters;
	
	public XLSXParser() {
		voters = new ArrayList<Voter>();
	}

	@SuppressWarnings({ "rawtypes", "resource" })
	@Override
	public List<Voter> loadVoters(String fileName) {
		
		List cellDataList = new ArrayList();
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = hssfSheet.rowIterator();
			while (rowIterator.hasNext()) {
				XSSFRow hssfRow = (XSSFRow) rowIterator.next();
				Iterator<Cell> iterator = hssfRow.cellIterator();
				List cellTempList = new ArrayList();
				while (iterator.hasNext()) {
					XSSFCell hssfCell = (XSSFCell) iterator.next();
					cellTempList.add(hssfCell);
				}
				cellDataList.add(cellTempList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Leer(cellDataList);
		addToCensus(cellDataList);
		ImprimirCenso();
		
		return voters;
	}
	
//	private void Leer(List cellDataList){
//		for (int i = 0; i < cellDataList.size(); i++) {
//			List cellTempList = (List) cellDataList.get(i);
//			for (int j = 0; j < cellTempList.size(); j++) {
//				XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
//				String stringCellValue = hssfCell.toString();
//				System.out.print(stringCellValue+" ");
//			}
//			System.out.println();
//		}
//	}
	
	private void addToCensus(List cellDataList) {
		for (int i = 1; i < cellDataList.size(); i++) {
			List cellTempList = (List) cellDataList.get(i);
			String nombre = cellTempList.get(0).toString();
			String nif = cellTempList.get(1).toString();
			float cp = Float.parseFloat(cellTempList.get(2).toString());
			float mesa = Float.parseFloat(cellTempList.get(3).toString());
			String email = cellTempList.get(4).toString();
	
			voters.add(new Voter(nombre, nif, (int) cp, email));
		}
	}
	
	private void ImprimirCenso() {
		for(Voter voter : voters) {
			System.out.println(voter.toString());
		}
	}

}
