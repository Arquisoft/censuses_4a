package es.uniovi.asw.util;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.dbupdate.ports.InsertP;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.impl.ReadCensusImpl;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.reportwriter.ports.WreportP;

/**
 * @author ivan
 */
public class ServicesFactory {
	
	public static ReadCensus getParserService(List<String> fileNames, List<String> formats) {
		return new ReadCensusImpl(fileNames, formats);
	}
	
	public static InsertP getDBUpdateService() {
		return new InsertP();
	}

	public static WriteReport getWriteReportService() throws IOException {
		return WreportP.getInstance();
	}
}
