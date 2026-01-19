package main.test;

import org.junit.Assert;
import org.junit.Test;

import main.java.CensusAnalyserException;
import main.model.StateCensusAnalyser;

public class StateCodeAnalyserTest {

    private static final String STATE_CODE_CSV_FILE =
            "C:\\Users\\sathi\\OneDrive\\Desktop\\selva\\bridgelabz\\StateCodeData\\StateCodeData.csv";

    @Test
    public void givenStateCodeCSVFile_WhenLoaded_ShouldReturnCorrectRecordCount() {
        try {
            // Arrange
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int expectedRecordCount = 29;

            // Act
            int actualRecordCount =
                    analyser.loadIndianStateCodeData(STATE_CODE_CSV_FILE);

            // Assert
            Assert.assertEquals(expectedRecordCount, actualRecordCount);

        } catch (CensusAnalyserException e) {
            Assert.fail("Exception should not be thrown for valid State Code CSV");
        }
    }
}

