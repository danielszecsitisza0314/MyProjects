package randompasswordgeneration;

public class RandomPasswordGeneration {

    public static final String UPPERCASELETTERS = "ABCDEFGHIKLMNOPQRSTVXYZ";
    public static final String LOWERCASELETTERS = "abcdefghiklmnopqrstvxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!.-?_&@";

    public static String generatePassword(int lenght) {
        String pass = "";
        int firstChar = 0;
        firstChar = getRandomNumber(0, 2);
        for (int i = 0; i < lenght; i++) {
            if (i == 0) {
                if (firstChar == 0) {
                    firstChar = getRandomNumber(0, 1);
                    pass = pass + addLettersToString(firstChar, UPPERCASELETTERS);
                } else if (firstChar == 1) {
                    firstChar = getRandomNumber(0, 1);
                    pass = pass + addLettersToString(firstChar, LOWERCASELETTERS);
                }
            } else {
                firstChar = getRandomNumber(0, 4);
                if (firstChar == 0) {
                    firstChar = getRandomNumber(0, UPPERCASELETTERS.length());
                    pass = pass + addLettersToString(firstChar, UPPERCASELETTERS);
                } else if (firstChar == 1) {
                    firstChar = getRandomNumber(0, LOWERCASELETTERS.length());
                    pass = pass + addLettersToString(firstChar, LOWERCASELETTERS);
                } else if (firstChar == 2) {
                    firstChar = getRandomNumber(0, NUMBERS.length());
                    pass = pass + addLettersToString(firstChar, NUMBERS);
                } else if (firstChar == 3) {
                    firstChar = getRandomNumber(0, SYMBOLS.length());
                    pass = pass + addLettersToString(firstChar, SYMBOLS);
                }
            }
        }
        return pass;
    }

    public static String addLettersToString(int number, String letter) {
        String result = "";
        if (number == letter.length()) {
            result = result + letter.substring(number);
        } else {
            result = result + letter.substring(number, number + 1);
        }
        return result;

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
