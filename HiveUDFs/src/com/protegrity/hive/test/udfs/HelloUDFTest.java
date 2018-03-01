package com.protegrity.hive.test.udfs;
import com.protegrity.hive.udfs.*;
import junit.framework.*;
import org.apache.hadoop.io.Text;
import org.junit.Assert;
import org.junit.Test;


public class HelloUDFTest {
	 @Test
	  public void testUDF() {
	    HelloUDF example = new HelloUDF();
	    ToUpperSimple simple = new ToUpperSimple();
	    ToUpperGeneric generic = new ToUpperGeneric();
	    Assert.assertEquals("Hello world", example.evaluate(new Text("world")).toString());
	    Assert.assertEquals("WORLD", simple.evaluate(new Text("world")).toString());
//	    Assert.assertEquals("Hello world", generic(new Text("world")).toString());
	  }
}
