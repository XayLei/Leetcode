public static String intToRoman(int num) {
        String str = "";
	String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	int value[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        //这使用了贪心算法，类似于日常生活中的付钱，如果要付36元，我们会先拿出20，然后分别是10、5、1		
        for (int i = 0; num != 0; ++i) {
		while (num >= value[i]) {
			num -= value[i];
			str += symbol[i];
		}
	}
	return str;
}
