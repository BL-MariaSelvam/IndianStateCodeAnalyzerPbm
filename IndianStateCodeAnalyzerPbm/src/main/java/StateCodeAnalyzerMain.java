package main.java;

import main.model.StateCensusAnalyser;

public class StateCodeAnalyzerMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Indian State Code Analyzer Problem");
		
		        String stateCensusCSVFile = "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCencusData\\StateCensusData.csv";
		        String stateCodeCSVFile = "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCodeData\\StateCodeData.csv";

		        StateCensusAnalyser analyser = new StateCensusAnalyser();

		        try {
		            // Load State Census Data
		            int censusRecords = analyser.loadIndianStateCensusData(stateCensusCSVFile);
		            System.out.println("Number of State Census Records: " + censusRecords);

		            // Load State Code Data
		            int stateCodeRecords = analyser.loadIndianStateCodeData(stateCodeCSVFile);
		            System.out.println("Number of State Code Records: " + stateCodeRecords);

		        } catch (CensusAnalyserException e) {
		            System.err.println("Error: " + e.getMessage() + " | Exception Type: " + e.type);
		        }
		    }
	}

