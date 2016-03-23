package es.uniovi.asw.reportwriter.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class WreportPFormatter extends Formatter {

	@Override
	public String format(LogRecord text) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[")
			.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()))
			.append("] ")
			.append(formatMessage(text))
			.append("\n");
		
		return sb.toString();
	}

}
