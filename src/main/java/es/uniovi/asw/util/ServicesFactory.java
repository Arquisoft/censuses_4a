package es.uniovi.asw.util;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.dbupdate.impl.InsertImpl;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.impl.ReadCensusImpl;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.reportwriter.impl.WriteReportImpl;

/**
 * @author ivan
 */
public class ServicesFactory {
	
	public static ReadCensus getParserService(List<String> fileNames, List<String> formats) {
		return new ReadCensusImpl(fileNames, formats);
	}
	
	public static InsertImpl getDBUpdateService() {
		return new InsertImpl();
	}

	public static WriteReport getWriteReportService() throws IOException {
		return WriteReportImpl.getInstance();
	}
}
