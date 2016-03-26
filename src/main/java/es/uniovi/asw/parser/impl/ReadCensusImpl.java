package es.uniovi.asw.parser.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.parsers.CensusParser;
import es.uniovi.asw.parser.ports.RCensus;
import es.uniovi.asw.parser.writers.LetterWriter;
import es.uniovi.asw.parser.writers.LetterWriterFactory;
import es.uniovi.asw.parser.impl.WriteReportImpl;
import es.uniovi.asw.util.ReadCensusException;

public class ReadCensusImpl implements ReadCensus {
	
	List<Map<String, Object>> voters;
	List<String> fileNames, formats;
	
	WriteReportImpl report;
	
	public ReadCensusImpl(List<String> fileNames, List<String> formats) {
		this.fileNames = fileNames;
		this.formats = formats;
		
		report = new WriteReportImpl();
	}

	@Override
	public void read() throws IOException {

		CensusParser parser;
		
		for (int i = 0; i < fileNames.size(); i++)
			
			try {
				
				parser = RCensus.create(fileNames.get(i));
				voters = parser.parse();
				
				insertVoters();
				writeLetters();
			
			} catch (ReadCensusException e) {
				report.log(e.getMessage());
			}

	}
	
	private void insertVoters() throws IOException {
		
		InsertVoterImpl insertVoterImpl = new InsertVoterImpl();
		List<Map<String, Object>> validVoters = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < voters.size(); i++)
			
			try {

				insertVoterImpl.insert(voters.get(i));
				validVoters.add(voters.get(i));
			
			} catch (ReadCensusException e) {
				report.log(e.getMessage());
			}
		
		voters = validVoters;

	}

	public void writeLetters() throws ReadCensusException, IOException {
		
		LetterWriter leterWritter;

		for (int i = 0; i < formats.size(); i++) {
			leterWritter = LetterWriterFactory.create(formats.get(i));
			
			for (int j = 0; j < voters.size(); j++)
				
				try {
					leterWritter.write(voters.get(j));
				}
				
				catch (ReadCensusException e) {
					report.log(e.getMessage());
				}
		}
		
	}

}
