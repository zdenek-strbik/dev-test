package com.goeuro.util;


/**
 * Created by Zdenek Strbik
 */
public final class ArgsUtil {

    private static final int MAX_LENGTH = 100;

    private static final String COMMAND = "Invalid command, expected: java -jar GoEuroTest.jar \"CITY_NAME\"\n";
    private static final String NAME_TOO_LONG = "City name is too long, max length allowed is " + MAX_LENGTH + "\n";

    private ArgsUtil() {
    }

    /**
     * Extracts city name from command line arguments
     * @param args Command line arguments
     * @return City name extracted from arguemnts
     */
    public static String readCityName(String[] args) {
        if (args == null || args.length != 1 || args[0] == null || args[0].length() == 0) {
            throw new ArgsUtilException(COMMAND);
        }

        String cityName = args[0];

        if (cityName.length() > MAX_LENGTH) {
            throw new ArgsUtilException(NAME_TOO_LONG);
        }

        return cityName;
    }

    public static class ArgsUtilException extends RuntimeException {

        public ArgsUtilException(String message) {
            super(message);
        }
    }
}
