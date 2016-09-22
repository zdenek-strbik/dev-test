package com.goeuro;

import com.google.gson.JsonSyntaxException;
import com.goeuro.dto.City;
import org.junit.Assert;
import org.junit.Test;
import com.goeuro.util.FileUtil;
import com.goeuro.util.JsonUtil;

import java.io.IOException;

import static com.goeuro.Main.UTF_8;

/**
 * Created by Zdenek Strbik
 */
public class JsonUtilTest {

    @Test
    public void deserializeSingle() throws IOException {
        String json = FileUtil.readResourceFile("jihlava.json", UTF_8);

        City[] city = JsonUtil.deserialize(json);

        Assert.assertEquals(1, city.length);
        Assert.assertEquals(new Integer(375649), city[0].getId());
        Assert.assertEquals("Jihlava", city[0].getName());
        Assert.assertEquals("location", city[0].getType());
        Assert.assertNotNull(city[0].getGeoPosition());
        Assert.assertEquals(49.3961, city[0].getGeoPosition().getLatitude(), 0);
        Assert.assertEquals(-15.59124, city[0].getGeoPosition().getLongitude(), 0);
    }

    @Test
    public void deserializeMultiple() throws IOException {
        String json = FileUtil.readResourceFile("berlin.json", UTF_8);

        City[] city = JsonUtil.deserialize(json);

        Assert.assertEquals(8, city.length);
    }

    @Test
    public void notFoundTest() throws IOException {
        String json = FileUtil.readResourceFile("notFound.json", UTF_8);

        City[] cities = JsonUtil.deserialize(json);

        Assert.assertNull(cities);
    }

    @Test
    public void nullValuesTest() throws IOException {
        String json = FileUtil.readResourceFile("nullValues.json", UTF_8);

        City[] city = JsonUtil.deserialize(json);

        Assert.assertEquals(1, city.length);
        Assert.assertNull(city[0].getId());
        Assert.assertNull(city[0].getName());
        Assert.assertNull(city[0].getType());
        Assert.assertNotNull(city[0].getGeoPosition());
        Assert.assertNull(city[0].getGeoPosition().getLatitude());
        Assert.assertNull(city[0].getGeoPosition().getLongitude());
    }

    @Test(expected=JsonSyntaxException.class)
    public void invalidJsonTest() throws IOException {
        String json = "invalid json";

        JsonUtil.deserialize(json);
    }

}
