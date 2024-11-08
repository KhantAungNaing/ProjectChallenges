package com.binarytodecimal.converter;

import java.util.Scanner;

public class Runner {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BinaryToDecimalConverter converter = new BinaryToDecimalConverter();
		System.out.println("Enter binary digits : ");
		String binaryDigits = sc.nextLine();
		String result = converter.convertToDecimal(binaryDigits);

		if (result.equals("")) {
			return;
		}
		System.out.println(String.format("Decimal result for %s is %s.", binaryDigits, result));
	}

}
