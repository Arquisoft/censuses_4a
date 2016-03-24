package es.uniovi.asw.reportwriter.interfaces;

import java.io.IOException;

public interface WriteReport {

	void log(String msg) throws IOException;

	void close() throws Exception;

}
