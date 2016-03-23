/**
 * 
 */
package es.uniovi.asw.util;

import es.uniovi.asw.dbupdate.DBUpdate;
import es.uniovi.asw.dbupdate.DBUpdateService;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.ParserService;

/**
 * @author ivan
 *
 */
public class ServicesFactory {
	
	public static ParserService getParserService() {
		return new Parser();
	}
	
	public static DBUpdateService getDBUpdateService() {
		return new DBUpdate();
	}

}
