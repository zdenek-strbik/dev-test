package com.goeuro;

import com.goeuro.api.CityFormatter;
import com.goeuro.dto.City;

import java.util.StringJoiner;

/**
 * Created by Zdenek Strbik
 */
public class CityFormatterCsvImpl implements CityFormatter {

    public static final String DELIMITER = ", ";

    @Override
    public String apply(City city) {
        return new StringJoiner(DELIMITER)
                .add(String.valueOf(city.getId()))
                .add(city.getName())
                .add(city.getType())
                .add(String.valueOf(city.getLatitude()))
                .add(String.valueOf(city.getLongitude()))
                .toString();
    }
}
