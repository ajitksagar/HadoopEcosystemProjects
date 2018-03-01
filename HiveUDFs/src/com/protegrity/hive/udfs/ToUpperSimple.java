package com.protegrity.hive.udfs;


import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


@Description(
  name="SimpleUDFExample",
  value="returns 'Uppercase of the input String', where x is whatever you give it (STRING)",
  extended="SELECT simpleudfexample('world') from foo limit 1;"
  )
public class ToUpperSimple extends UDF{

	  
	  public Text evaluate(Text input) {
	    if(input == null) return null;
	    return new Text(input.toString().toUpperCase());
	  }
	
}
