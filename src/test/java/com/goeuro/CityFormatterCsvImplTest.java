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
public class CityFormatterCsvImplTest {

    @Test
    public void formatSingleTest() throws IOException {
        City city = new City(375649, "Jihlava", "location", 49.3961, -15.59124);
        CityFormatter formatter = new CityFormatterCsvImpl();

        String formatted = formatter.apply(city);

        Assert.assertEquals(
                "375649, Jihlava, location, 49.3961, -15.59124",
                formatted);
    }

    @Test
    public void formatNullValuesTest() throws IOException {
        City city = new City(null, null, null, null, null);
        CityFormatter formatter = new CityFormatterCsvImpl();

        String formatted = formatter.apply(city);

        Assert.assertEquals(
                "null, null, null, null, null",
                formatted);
    }

}
