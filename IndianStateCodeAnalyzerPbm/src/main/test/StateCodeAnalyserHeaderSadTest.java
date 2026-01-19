package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCodeAnalyserHeaderSadTest {

    // CSV file exists but header is incorrect
    private static final String WRONG_HEADER_FILE =
            "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCodeData\\StateCode_WrongHeader.csv";

    @Test
    public void givenStateCodeCSVWithWrongHeader_ShouldThrowHeaderException() {

        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            analyser.loadIndianStateCodeData(WRONG_HEADER_FILE);

            Assert.fail("Expected CensusAnalyserException was not thrown");

        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.CSV_HEADER_ERROR,
                    e.type
            );
        }
    }
}
