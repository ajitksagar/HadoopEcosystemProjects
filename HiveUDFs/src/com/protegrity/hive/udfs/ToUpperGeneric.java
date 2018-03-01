package com.protegrity.hive.udfs;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.Text;


public class ToUpperGeneric extends GenericUDF {

	  PrimitiveObjectInspector inputOI;
	  PrimitiveObjectInspector outputOI;

	  public ObjectInspector initialize(ObjectInspector[] args) throws UDFArgumentException {
	  // This UDF accepts one argument
	  assert (args.length == 1);
	  // The first argument is a primitive type
	  assert(args[0].getCategory() == Category.PRIMITIVE);

	  inputOI  = (PrimitiveObjectInspector)args[0];
	  /* We only support INTEGER type */
	  assert(inputOI.getPrimitiveCategory() == PrimitiveCategory.STRING);

	  /* And we'll return a type int, so let's return the corresponding object inspector */
	  outputOI = PrimitiveObjectInspectorFactory.javaStringObjectInspector;

	  return outputOI;
	}

	public Object evaluate(DeferredObject[] args) throws HiveException {
	if (args.length != 1) return null;

	// Access the deferred value. Hive passes the arguments as "deferred" objects 
	// to avoid some computations if we don't actually need some of the values
	Object oin = args[0].get();

	if (oin == null) return null;

	String value = (String) inputOI.getPrimitiveJavaObject(oin); 

	String output = value.toUpperCase();
	return new Text(output);
	}

	@Override
	public String getDisplayString(String[] args) {
	return "Here, write a nice description";
	}
	
}
