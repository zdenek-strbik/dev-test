package com.goeuro;

import com.goeuro.api.CityFormatter;
import com.goeuro.api.CityWriter;
import com.goeuro.dto.City;
import com.goeuro.util.ArgsUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zdenek Strbik
 */
public class CityWriterFileImpl implements CityWriter {

    private final String filePath;
    private final CityFormatter formatter;

    public CityWriterFileImpl(String filePath, CityFormatter formatter) {
        this.filePath = filePath;
        this.formatter = formatter;
    }

    @Override
    public File write(City[] cities) throws IOException {
        if (cities == null || cities.length == 0) {
            throw new GoEuroException("Nothing to write");
        }

        List<String> names = Arrays.stream(cities)
                .map(formatter)
                .collect(Collectors.toList());

        File outputFile = new File(filePath);

        FileUtils.writeLines(outputFile, names);

        return outputFile;
    }
}
