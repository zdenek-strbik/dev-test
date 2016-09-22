package com.goeuro.api;

import java.io.IOException;

/**
 * Created by Zdenek Strbik
 */
public interface CityReader {

    String read(String cityName) throws IOException;
}
