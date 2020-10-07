package day1;

class NumToWord { 
	  
    static String one[] = { "", "one ", "two ", "three ", "four ", 
                            "five ", "six ", "seven ", "eight ", 
                            "nine ", "ten ", "eleven ", "twelve ", 
                            "thirteen ", "fourteen ", "fifteen ", 
                            "sixteen ", "seventeen ", "eighteen ", 
                            "nineteen " }; 
  
    static String ten[] = { "", "", "twenty ", "thirty ", "forty ", 
                            "fifty ", "sixty ", "seventy ", "eighty ", 
                            "ninety " }; 
  
    static String numToWords(int n, String s) 
    { 
        String str = ""; 
        if (n > 19) { 
            str += ten[n / 10] + one[n % 10]; 
        } 
        else { 
            str += one[n]; 
        } 
        if (n != 0) { 
            str += s; 
        } 
  
        return str; 
    } 
 
    static String convertToWords(long n) 
    { 
        String out = ""; 
        out += numToWords((int)((n / 100) % 10), "hundred "); 
        return out; 
    } 
    public static void main(String[] args) 
    { 
        
        long n = 123; 
        System.out.printf(convertToWords(n)); 
    } 
} 