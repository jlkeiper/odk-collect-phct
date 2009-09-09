package org.odk.collect.android;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Vector;

import org.javarosa.core.model.condition.IFunctionHandler;

/**
 * Looks for a "review" call in XForm and stores this field
 * for review
 * 
 * @author Samuel Mbugua (sthaiya@gmail.com)
 */

public class ReviewFunction implements IFunctionHandler {

	public Object eval(Object[] args) {
		String strOne = (String) args[0];
		String strTwo = (String) args[1];
		if (SharedConstants.reviews==null)
			SharedConstants.reviews=new ArrayList<String>();
		else if (!SharedConstants.reviews.isEmpty()) {
        	ListIterator<String> li=SharedConstants.reviews.listIterator();
        	String item;
        	String[] vals;
        	while (li.hasNext()) {
        		item=li.next();
        		vals=item.split(",");
        		if (vals[0].equals(strOne))
        			// An item has been edited
        			li.remove();
        	}
		}
		SharedConstants.reviews.add(strOne + "," + strTwo);
		return true;
	}

	public String getName() {
		return "review";
	}

	@SuppressWarnings("unchecked")
	public Vector getPrototypes() {

		Class[] prototypes = { String.class, String.class };
		Vector v = new Vector();
		v.add(prototypes);
		return v;
	}

	public boolean rawArgs() {
		// Auto-generated method stub
		return false;
	}

	public boolean realTime() {
		// Auto-generated method stub
		return false;
	}
}
