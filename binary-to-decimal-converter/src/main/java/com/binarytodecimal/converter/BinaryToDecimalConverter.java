package com.binarytodecimal.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryToDecimalConverter {

	private static final Logger logger = LoggerUtil.getLogger();

	// 10101101
	public String convertToDecimal(String binary) {

		var biArr = binary.split("");

		if (!isValidBinary(biArr)) {
			logger.log(Level.WARNING, "** The binary digits must not be more than 8 digits. **");
			return "";
		}

		if (!isValidBinaryDigit(biArr)) {
			logger.log(Level.WARNING, "** Invalid binary digit. **");
			return "";
		}

		int decimalValue = 0;
		int index = 0;
		for (int i = biArr.length - 1; i >= 0; i--) {
			var biDigit = Integer.parseInt(biArr[index]);
			int powerOfTwo = getPowerOfTwo(i, 1);
			if (i == 0)
				powerOfTwo = 1;
			decimalValue += biDigit * powerOfTwo;
			index++;
		}
		return String.valueOf(decimalValue);
	}

	private int getPowerOfTwo(int times, int start) {
		if (times > 0) {
			start *= 2;
			times--;
			return getPowerOfTwo(times, start);
		}
		return start;
	}

	private boolean isValidBinary(String[] strArr) {
		if (strArr.length > 8) {
			return false;
		}
		return true;
	}

	private boolean isValidBinaryDigit(String[] strArr) {
		for (String str : strArr) {
			if (Integer.parseInt(str) != 0 && Integer.parseInt(str) != 1)
				return false;
		}
		return true;
	}
}
