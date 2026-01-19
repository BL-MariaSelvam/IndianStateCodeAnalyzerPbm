package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCodeAnalyserTypeSadTest {

    // File exists but extension is incorrect
    private static final String WRONG_FILE_TYPE = 
            "src/test/resources/StateCode.txt";  // should be .csv

    @Test
    public void givenStateCodeFileWithIncorrectType_ShouldThrowInvalidFileTypeException() {
        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            analyser.loadIndianStateCodeData(WRONG_FILE_TYPE);

            Assert.fail("Expected CensusAnalyserException was not thrown");

        } catch (CensusAnalyserException e) {
            // Verify the exception type
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                    e.type
            );
        }
    }
}

