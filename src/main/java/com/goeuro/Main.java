package com.goeuro;

import com.goeuro.api.CityFormatter;
import com.goeuro.api.CityReader;
import com.goeuro.api.CityWriter;
import com.goeuro.dto.City;
import com.goeuro.util.ArgsUtil;
import com.goeuro.util.JsonUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zdenek Strbik
 */
public class Main {

    public static final String UTF_8 = "UTF-8";

    private static final String API_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    private static final String OUT_FILE_NAME = "out.csv";

    public static void main(String[] args) throws IOException {
        System.out.println("Removing previous output");
        FileUtils.deleteQuietly(new File(OUT_FILE_NAME));

        try {
            System.out.println("Reading input parameters");
            String cityName = ArgsUtil.readCityName(args);

            System.out.println("Downloading data: " + API_URL + cityName);
            CityReader cityReader= new CityReaderHttpImpl(API_URL, UTF_8);
            String citiesJson = cityReader.read(cityName);

            System.out.println("Deserializing data");
            City[] cities = JsonUtil.deserialize(citiesJson);

            System.out.println("Writing data to file");
            CityFormatter cityFormatter = new CityFormatterCsvImpl();
            CityWriter cityWriter = new CityWriterFileImpl(OUT_FILE_NAME, cityFormatter);
            File outputFile = cityWriter.write(cities);

            System.out.println("Result csv file path: " + outputFile.getAbsolutePath());
        } catch (GoEuroException | ArgsUtil.ArgsUtilException e) {
            System.err.println(e.getMessage());
        }
    }
}
