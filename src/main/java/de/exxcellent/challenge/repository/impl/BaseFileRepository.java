/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author c.kaddatz
 */
public class BaseFileRepository {
    
    protected static final String DEFAULT_CSV_DELIMITER = ",";
    
    protected String fileName;
    protected String delimiter;

    public BaseFileRepository(String pFileName, String pDelimiter) {
        this.fileName = pFileName;
        this.delimiter = DEFAULT_CSV_DELIMITER;
        if(pDelimiter != null) {
            this.delimiter = pDelimiter;
        }
    }
    
    /**
     * get file url by name from resources
     * @return 
     */
    protected URL getFileUrl() {
        return getClass().getClassLoader().getResource(fileName);
    }
    
    /**
     * check if the given delimiter exist in given csv file
     * @param fileUrl
     * @return
     * @throws URISyntaxException
     * @throws IOException 
     */
    protected boolean isDelimiterExisting(URL fileUrl) throws URISyntaxException, IOException {
        try (Stream<String> lines = Files.lines(Paths.get(fileUrl.toURI()))) {
            return lines.anyMatch((String line) -> line.split(delimiter).length > 1);
        }
    }
         
    /**
     * read a csv file
     * @param fileUrl file url
     * @param columnNames list of columns to extract from csv file
     * @return a list from maps -> each map stands for a data line 
     * @throws java.net.URISyntaxException 
     * @throws java.io.IOException 
     */
    protected List<Map<String,String>> readCSVFile(URL fileUrl, List<String> columnNames) throws URISyntaxException, IOException {
        List<Map<String,String>> result = new ArrayList<>();
        //Stream csv file line by line
        try (Stream<String> lines = Files.lines(Paths.get(fileUrl.toURI()))) {
            //get a list which contains a list of each line values  
            List<List<String>> values = lines.map(line -> Arrays.asList(line.split(delimiter))).collect(Collectors.toList());
            //get the first line and extract the header columns by index
            final Map<String, Integer> headerMap = getHeaderColumnIndex(values.get(0), columnNames);
            //remove the header line from main list
            values.remove(0);
            //iterate over the remaining lines and get the values by column index
            values.forEach(valueLine -> {
                result.add(getValueLinesByColumnIndex(headerMap, valueLine));
            });
        }  
        return result;
    }
    
    /**
     * extract the header line
     * @param headerLine header line as string list
     * @param columnKeys list from expected column keys
     * @return a single map from the header line with columnName (Key) and columnIndex (Value) 
     */
    protected Map<String,Integer> getHeaderColumnIndex(List<String> headerLine, List<String> columnKeys) {
        final Map<String, Integer> indexValueMap = new HashMap<>();
        //ierate over header line
        IntStream.range(0, headerLine.size())
                .forEach(idx -> {
                    //contains expected column key list current header column key?
                    if(columnKeys.contains(headerLine.get(idx))) {
                        //put column key and column index into map
                        indexValueMap.put(headerLine.get(idx), idx);
                    }
               });
        return indexValueMap;
    }
    
    /**
     * extract the value lines
     * @param indexValueMap the map contains the extracted header column key and associated index
     * @param valueLines current value line
     * @return a single map from current line column keys and values
     */
    protected Map<String,String> getValueLinesByColumnIndex(Map<String,Integer> indexValueMap, List<String> valueLines) {
        final Map<String,String> valueLineMap = new HashMap<>();
        //iterate over header column key/index map
        indexValueMap.forEach((columnKey,columnIndex) -> {
            //iterate over current value line by index
            IntStream.range(0, valueLines.size())
                    //filter column index -> return only the current header column index
                    .filter(idx -> idx == columnIndex)
                    .forEach(idx -> {
                        //put current column key and value into result map
                        valueLineMap.put(columnKey, valueLines.get(idx));
               });
        });
        return valueLineMap;
    }            
}
