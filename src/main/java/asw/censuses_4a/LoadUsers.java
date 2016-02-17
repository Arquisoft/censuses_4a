package es.uniovi.asw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SheetDataWriter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Main application
 * 
 * @author David Fdez Garrido
 *
 */
public class LoadUsers {
	
	private Set<Voter> censo = new HashSet<Voter>();
	
	
	protected Set<Voter> getCenso() {
		return censo;
	}

	public LoadUsers(File fileName) throws ParseException {
		List cellDataList = new ArrayList();
		try {
			FileInputStream fileInputStream = new FileInputStream( fileName);
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
		A�adirAlCenso(cellDataList);
		ImprimirCenso();
	}
	
	private void Leer(List cellDataList){
		for (int i = 0; i < cellDataList.size(); i++) {
			List cellTempList = (List) cellDataList.get(i);
			for (int j = 0; j < cellTempList.size(); j++) {
				XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
				String stringCellValue = hssfCell.toString();
				System.out.print(stringCellValue+" ");
			}
			System.out.println();
		}
	}
	
	private void A�adirAlCenso(List cellDataList) {
		for (int i = 1; i < cellDataList.size(); i++) {
			List cellTempList = (List) cellDataList.get(i);
			String nombre = cellTempList.get(0).toString();
			String nif = cellTempList.get(1).toString();
			float cp = Float.parseFloat(cellTempList.get(2).toString());
			float mesa = Float.parseFloat(cellTempList.get(3).toString());
			String email = cellTempList.get(4).toString();
	
			censo.add(new Voter(nombre, nif, (int) cp, (int) mesa, email));
		}
	}
	
	private void ImprimirCenso() {
		for(Voter voter : censo) {
			System.out.println(voter.toString());
		}
	}
	
	public static void main(String[] args) throws ParseException {
		File f = new File(args[0]);
		if(f.exists()) {
			LoadUsers pb = new LoadUsers(f);
		}
	}
	
}
