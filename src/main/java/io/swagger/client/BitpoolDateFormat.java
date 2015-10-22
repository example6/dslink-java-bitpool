package io.swagger.client;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class BitpoolDateFormat extends DateFormat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 157251801228033838L;


	public BitpoolDateFormat() {
	}

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		fieldPosition.setBeginIndex(0);
		fieldPosition.setEndIndex(0);
		return toAppendTo.append("/Date(").append(date.getTime()).append(")/");
	}


	@Override
	public Date parse(String source, ParsePosition pos) {
		String toParse = source.substring(pos.getIndex()).split("\\)\\/")[0];
		long l = Long.parseLong(toParse.replaceAll("[^0-9]", ""));
		Date d = new Date(l);
		pos.setIndex(pos.getIndex() + toParse.length() + 1);
		return d;
	}

}
