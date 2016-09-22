package com.test;

import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusXmlTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.message.MessageType;

/**
 * This is a sample Citrus integration test for loading XML syntax test case.
 *
 * @author Citrus
 */
@Test
public class PersistJavaDSLTest extends TestNGCitrusTestDesigner {

    @CitrusXmlTest(name = "PersistJavaDSLTest")
    public void sampleXmlTest() {
    	variable("PERSIST.DATA","citrus:randomString(10)");
    	echo("messsage ${PERSIST.DATA}");
    	send("persistEndpoint")
    		.payload("${PERSIST.DATA}");
    	send("sshClient")
    		.payload("<ssh-request xmlns=\"http://www.citrusframework.org/schema/ssh/message\"><command>"
    				+ "cat /tmp/tjug"
    				+ "</command><stdin /></ssh-request>");    	
    	receive("sshClient")    		
    		.validateScript("println receivedMessage")
    		.validate("//*[local-name()='stdout']", "${PERSIST.DATA}");
    	
    }
}
