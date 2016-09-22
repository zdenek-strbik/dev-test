package com.goeuro.api;

import com.goeuro.dto.City;

import java.io.File;
import java.io.IOException;

/**
 * Created by Zdenek Strbik
 */
public interface CityWriter {

    File write(City[] cities) throws IOException;
}
