package main.model;

import java.util.Iterator;

import main.java.CensusAnalyserException;

public class StateCensusAnalyser {

	 public int loadIndianStateCensusData(String csvFilePath)
	            throws CensusAnalyserException {

	        CSVStateCensus loader = new CSVStateCensus();
	        Iterator<StateCensus> iterator = loader.loadCSVData(csvFilePath);

	        int count = 0;
	        while (iterator.hasNext()) {
	            iterator.next();
	            count++;
	        }
	        return count;
	    }
	 
	 // NEW: Load State Code Data
	    public int loadIndianStateCodeData(String csvFilePath)
	            throws CensusAnalyserException {

	        CSVStates stateLoader = new CSVStates();
	        Iterator<StateCode> iterator = stateLoader.loadCSVData(csvFilePath);

	        int count = 0;
	        while (iterator.hasNext()) {
	            iterator.next();
	            count++;
	        }
	        return count;
	    }
}
