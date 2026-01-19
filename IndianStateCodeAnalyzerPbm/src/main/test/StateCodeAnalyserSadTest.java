package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCodeAnalyserSadTest {

	    // File path is incorrect or does not exist
	    private static final String WRONG_STATE_CODE_FILE = 
	            "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCodeData\\InvalidStateCode.csv";

	    @Test
	    public void givenIncorrectStateCodeCSVFile_ShouldThrowCustomException() {
	        try {
	            StateCensusAnalyser analyser = new StateCensusAnalyser();
	            analyser.loadIndianStateCodeData(WRONG_STATE_CODE_FILE);

	            Assert.fail("Expected CensusAnalyserException was not thrown");

	        } catch (CensusAnalyserException e) {
	            // Verify that the exception type is FILE_NOT_FOUND
	            Assert.assertEquals(
	                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,
	                    e.type
	            );
	        }
	    }
	}


