package com.goeuro;

import com.goeuro.util.ArgsUtil.ArgsUtilException;
import com.goeuro.util.ArgsUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zdenek Strbik
 */
public class ArgsUtilTest {

    @Test(expected = ArgsUtilException.class)
    public void verifyNullArgs() {
        ArgsUtil.readCityName(null);
    }

    @Test(expected = ArgsUtilException.class)
    public void verifyEmptyArgs() {
        ArgsUtil.readCityName(new String[0]);
    }

    @Test(expected = ArgsUtilException.class)
    public void verifyMultipleArgs() {
        String[] args = {"1", "2"};
        ArgsUtil.readCityName(args);
    }

    @Test(expected = ArgsUtilException.class)
    public void verifyNullFirstArg() {
        String[] args = {null};
        ArgsUtil.readCityName(args);
    }

    @Test(expected = ArgsUtilException.class)
    public void verifyEmptyFirstArg() {
        String[] args = {""};
        ArgsUtil.readCityName(args);
    }

    @Test
    public void verifySimpleName() {
        String[] args = {"Berlin"};
        String city = ArgsUtil.readCityName(args);
        Assert.assertEquals("Berlin", city);
    }

    @Test(expected = ArgsUtilException.class)
    public void verifyLongName() {
        String[] args = {"x0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"};
        ArgsUtil.readCityName(args);
    }

}
