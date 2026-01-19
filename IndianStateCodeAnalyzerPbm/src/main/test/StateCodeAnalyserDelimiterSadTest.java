package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCodeAnalyserDelimiterSadTest {

    // CSV file exists but delimiter is incorrect (e.g., ';' instead of ',')
    private static final String WRONG_DELIMITER_FILE =
            "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCodeData\\StateCodeData_WrongDelimiter.csv";

    @Test
    public void givenStateCodeCSVWithWrongDelimiter_ShouldThrowParsingException() {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            analyser.loadIndianStateCodeData(WRONG_DELIMITER_FILE);

            Assert.fail("Expected CensusAnalyserException was not thrown");

        } catch (CensusAnalyserException e) {
            // Validate exception type
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.CSV_PARSING_ERROR,
                    e.type
            );
        }
    }
}

