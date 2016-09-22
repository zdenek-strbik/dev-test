package com.goeuro;

import com.goeuro.api.CityFormatter;
import com.goeuro.api.CityWriter;
import com.goeuro.dto.City;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.goeuro.Main.UTF_8;
import static com.goeuro.util.FileUtil.readFile;
import static com.goeuro.util.FileUtil.readResourceFile;

/**
 * Created by Zdenek Strbik
 */
public class CityWriterFileImplTest {

    private final String OUT_FILE = "src/test/resources/out.csv";
    private final CityFormatter cityFormatter = new CityFormatterCsvImpl();

    @After
    public void deleteOutputFile() {
        FileUtils.deleteQuietly(new File(OUT_FILE));
    }

    @Test
    public void writeSingleTest() throws IOException {
        City[] cities = new City[]{new City(375649,"Jihlava","location",49.3961,-15.59124)};
        CityWriter cityDao = new CityWriterFileImpl(OUT_FILE, cityFormatter);

        File outFile = cityDao.write(cities);

        Assert.assertEquals(
                readResourceFile("jihlava.csv", UTF_8),
                readFile(outFile, UTF_8));
    }

    @Test
    public void writeMultipleTest() throws IOException {
        City[] cities = new City[]{
                new City(376217, "Berlin", "location", 52.52437, 13.41053),
                new City(448103, "Berlingo", "location", 45.50298, 10.04366),
                new City(425332, "Berlingerode", "location", 51.45775, 10.2384),
                new City(425326, "Bernau bei Berlin", "location", 52.67982, 13.58708),
                new City(314826, "Berlin Tegel", "airport", 52.5548, 13.28903),
                new City(314827, "Berlin Schönefeld", "airport", 52.3887261, 13.5180874),
                new City(334196, "Berlin Hbf", "station", 52.525589, 13.369548),
                new City(333977, "Berlin Ostbahnhof", "station", 52.510972, 13.434567)};

        CityWriter cityDao = new CityWriterFileImpl(OUT_FILE, cityFormatter);
        File outFile = cityDao.write(cities);

        Assert.assertEquals(
                readResourceFile("berlin.csv", UTF_8),
                readFile(outFile, UTF_8));
    }

    @Test(expected = GoEuroException.class)
    public void writeEmptyTest() throws IOException {
        CityWriter cityDao = new CityWriterFileImpl(OUT_FILE, cityFormatter);
        cityDao.write(new City[0]);
    }

    @Test(expected = GoEuroException.class)
    public void writeNullTest() throws IOException {
        CityWriter cityDao = new CityWriterFileImpl(OUT_FILE, cityFormatter);
        cityDao.write(null);
    }

}
