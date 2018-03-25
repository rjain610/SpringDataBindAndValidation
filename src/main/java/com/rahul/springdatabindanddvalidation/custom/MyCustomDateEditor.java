package com.rahul.springdatabindanddvalidation.custom;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * To Create <i>custom editor</i> class must extends <b>PropertyEditorSupport</b>
 * @author rahul
 *
 */
public class MyCustomDateEditor extends PropertyEditorSupport {
	
	SimpleDateFormat usSdf = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat inSDF = new SimpleDateFormat("dd-MM-yyyy");
	Date dt = null;

	@Override
	public void setAsText(String date) throws IllegalArgumentException {
		try {
			dt = usSdf.parse(date);
		} catch(Exception e) {
			try {
				dt = inSDF.parse(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		setValue(dt);
	}
	
	

}
