package es.uniovi.asw.parser.impl;

import java.io.IOException;

import es.uniovi.asw.parser.ports.WreportR;
import es.uniovi.asw.reportwriter.WriteReport;
import es.uniovi.asw.util.ServicesFactory;

/**
 * @author ivan
 *
 */
public class WriteReportImpl implements WriteReport {

	@Override
	public void log(String msg) throws IOException {	
		if (WreportR.verify(msg)) {
			ServicesFactory.getWriteReportService().log(msg);
		}
	}

	@Override
	public void close() throws IOException {
		ServicesFactory.getWriteReportService().close();
	}

}
