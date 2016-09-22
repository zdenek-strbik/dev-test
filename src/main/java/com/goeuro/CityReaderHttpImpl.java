package com.goeuro;

import com.goeuro.api.CityReader;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Zdenek Strbik
 */
public class CityReaderHttpImpl implements CityReader {

    private final String api;
    private final String encoding;

    public CityReaderHttpImpl(String api, String encoding) {
        this.api = api;
        this.encoding = encoding;
    }

    @Override
    public String read(String cityName) throws IOException {
        String encodedCityName = URLEncoder.encode(cityName, encoding);
        URL url = new URL(api + encodedCityName);

        return IOUtils.toString(url, encoding);
    }
}
