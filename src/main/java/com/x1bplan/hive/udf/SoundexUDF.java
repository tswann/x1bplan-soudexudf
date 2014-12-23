package com.x1bplan.hive.udf;

import org.apache.commons.codec.language.Soundex;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/***
 * @author Tom Swann
 * @description UDF which provides a wrapper around the Apache commons-codec implementation
 * of SOUNDEX algorithm. Not currently provided by Hive out-of-the-box.
 */
@Description(name = "soundex",
value = "_FUNC_(string) - Retrieves the Soundex code for a given string.",
extended = "Example:\n"
			+ " SELECT _FUNC_(input_string) FROM src;")
public final class SoundexUDF extends UDF {

	public Text evaluate(final Text text) {
		if (text == null) { 
			return null; 
		}
		
		String soundex = new Soundex().soundex(text.toString());
		return new Text(soundex);
	}
}
