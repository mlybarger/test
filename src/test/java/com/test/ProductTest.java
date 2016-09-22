package com.test;

import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusXmlTest;
import com.consol.citrus.testng.AbstractTestNGCitrusTest;

/**
 * This is a sample Citrus integration test for loading XML syntax test case.
 *
 * @author Citrus
 */
@Test
public class ProductTest extends AbstractTestNGCitrusTest {

    @CitrusXmlTest(name = "ProductTest")
    public void sampleXml() {}
}
