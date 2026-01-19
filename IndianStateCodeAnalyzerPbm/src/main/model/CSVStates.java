package main.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import main.java.CensusAnalyserException;

public class CSVStates {

    private static final String EXPECTED_HEADER = "SrNo,StateName,TIN,StateCode";
    private static final int EXPECTED_COLUMN_COUNT = 4;

    public Iterator<StateCode> loadCSVData(String csvFilePath) throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        List<StateCode> stateCodeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String header = reader.readLine();

            // Header validation
            if (!EXPECTED_HEADER.equals(header)) {
                throw new CensusAnalyserException(
                        "Incorrect CSV header",
                        CensusAnalyserException.ExceptionType.CSV_HEADER_ERROR);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != EXPECTED_COLUMN_COUNT) {
                    throw new CensusAnalyserException(
                            "CSV parsing error",
                            CensusAnalyserException.ExceptionType.CSV_PARSING_ERROR);
                }

                StateCode stateCode = new StateCode(
                        Integer.parseInt(data[0].trim()),
                        data[1].trim(),
                        Integer.parseInt(data[2].trim()),
                        data[3].trim()
                );
                stateCodeList.add(stateCode);
            }

        } catch (IOException e) {
            throw new CensusAnalyserException(
                    "File not found",
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }

        return stateCodeList.iterator();
    }
}


