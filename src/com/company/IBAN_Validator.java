package com.company;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class IBAN_Validator {
    /**
     *Takes an IBAN as a String and validates it
     * @param iban
     * @return String
     */
    public static String iban_Validator(String iban){
        Map<String, Integer> country = new HashMap<>();
        country.put("AL", 28);country.put("AD", 24);country.put("AT", 20);country.put("AZ", 28);
        country.put("BH", 22);country.put("BY", 28);country.put("BE", 16);country.put("BA", 20);
        country.put("BR", 29);country.put("BG", 22);country.put("CR", 22);country.put("HR", 21);
        country.put("CY", 28);country.put("CZ", 24);country.put("DK", 18);country.put("DO", 28);
        country.put("EG", 29);country.put("SV", 28);country.put("EE", 20);country.put("FO", 18);
        country.put("FI", 18);country.put("FR", 27);country.put("GE", 22);country.put("DE", 22);
        country.put("GI", 23);country.put("GR", 27);country.put("GL", 18);country.put("GT", 28);
        country.put("VA", 22);country.put("HU", 28);country.put("IS", 26);country.put("IQ", 23);
        country.put("IE", 22);country.put("IL", 23);country.put("IT", 27);country.put("JO", 30);
        country.put("KZ", 20);country.put("XK", 20);country.put("KW", 30);country.put("LV", 21);
        country.put("LB", 28);country.put("LY", 25);country.put("LI", 21);country.put("LT", 20);
        country.put("LU", 20);country.put("MT", 31);country.put("MR", 27);country.put("MU", 30);
        country.put("MD", 24);country.put("MC", 27);country.put("ME", 22);country.put("NL", 18);
        country.put("MK", 19);country.put("NO", 15);country.put("PK", 24);country.put("PS", 29);
        country.put("PL", 28);country.put("PT", 25);country.put("QA", 29);country.put("RO", 24);
        country.put("LC", 32);country.put("SM", 27);country.put("ST", 25);country.put("SA", 24);
        country.put("RS", 22);country.put("SC", 31);country.put("SK", 24);country.put("SI", 19);
        country.put("ES", 24);country.put("SD", 18);country.put("SE", 24);country.put("CH", 21);
        country.put("TL", 23);country.put("TN", 24);country.put("TR", 26);country.put("UA", 29);
        country.put("AE", 23);country.put("GB", 22);country.put("VG", 24);

        Map<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('A', 10);alphabet.put('B', 11);alphabet.put('C', 12);alphabet.put('D', 13);
        alphabet.put('E', 14);alphabet.put('F', 15);alphabet.put('G', 16);alphabet.put('H', 17);
        alphabet.put('I', 18);alphabet.put('J', 19);alphabet.put('K', 20);alphabet.put('L', 21);
        alphabet.put('M', 22);alphabet.put('N', 23);alphabet.put('O', 24);alphabet.put('P', 25);
        alphabet.put('Q', 26);alphabet.put('R', 27);alphabet.put('S', 28);alphabet.put('T', 29);
        alphabet.put('U', 30);alphabet.put('V', 31);alphabet.put('W', 32);alphabet.put('X', 33);
        alphabet.put('Y', 34);alphabet.put('Z', 35);

        iban = iban.replaceAll("\\s", "");
        String countryCode = iban.substring(0, 2);

        if (country.containsKey(countryCode)) {
            if (iban.length() != country.get(countryCode))
                return "\nLength is not correct\n";
        }else
            return "\nCountry code is not valid\n";

        //First four elements move to the end
        String ibanReversed = iban.substring(4) + iban.substring(0, 4);
        char[] charArray = ibanReversed.toCharArray();

        StringBuilder builder = new StringBuilder();

        //Checks Iban for letters and change them for a number from alphabet HashMap
        for (char i : charArray) {
            if (Character.isAlphabetic(i))
                builder.append(alphabet.get(i));
            else
                builder.append(i);
        }
        // Computes the mod 97 (iban % 97) and returns statement based on the remainder
         return new BigInteger(builder.toString()).mod(new BigInteger(String.valueOf(97))).intValue() == 1
                 ? "\nIs valid\n"
                 : "\nIs not valid\n";
    }

}
