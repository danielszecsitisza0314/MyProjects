package lotterygame;

import java.util.ArrayList;
import java.util.HashSet;

public class LotteryGame {

    private final String WIN0 = "Sajnos nem nyertél!";
    private final String WIN1 = "Sajnos nem nyertél! Csak egy találatod volt!";
    private final String WIN2 = "Gratulálok! Van egy kettes találatod!";
    private final String WIN3 = "Gratulálok! Van egy hármas találatod!";
    private final String WIN4 = "Gratulálok! Van egy négyes találatod!";
    private final String WIN5 = "Gratulálok! Ötösöd van!!!!";

    private final int MIN = 1;
    private final int MAX = 90;

    private int genNum1;
    private int genNum2;
    private int genNum3;
    private int genNum4;
    private int genNum5;
    private int yourhint1;
    private int yourhint2;
    private int yourhint3;
    private int yourhint4;
    private int yourhint5;
    private boolean fiveDifferentnumbers = false;
    private boolean fallOutOFTheInterval = false;
    private boolean isEmpty = true;

    public String getWIN0() {
        return WIN0;
    }

    public String getWIN1() {
        return WIN1;
    }

    public String getWIN2() {
        return WIN2;
    }

    public String getWIN3() {
        return WIN3;
    }

    public String getWIN4() {
        return WIN4;
    }

    public String getWIN5() {
        return WIN5;
    }

    HashSet<Integer> selectedNumbers = new HashSet<>();

    public String getGenNum1() {
        return Integer.toString(genNum1);
    }

    public String getGenNum2() {
        return Integer.toString(genNum2);
    }

    public String getGenNum3() {
        return Integer.toString(genNum3);
    }

    public String getGenNum4() {
        return Integer.toString(genNum4);
    }

    public String getGenNum5() {
        return Integer.toString(genNum5);
    }

    public boolean getIsFiveDifferentnumbers() {
        return fiveDifferentnumbers;
    }

    public boolean getIsFallOutOFTheInterval() {
        return fallOutOFTheInterval;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public boolean testYourHintAndCalculateWinnerNumber(String hint1, String hint2, String hint3, String hint4, String hint5) {

        if (!hint1.equals("") && !hint2.equals("") && !hint3.equals("") && !hint4.equals("") && !hint5.equals("")) {
            isEmpty = false;
            yourhint1 = Integer.parseInt(hint1);
            yourhint2 = Integer.parseInt(hint2);
            yourhint3 = Integer.parseInt(hint3);
            yourhint4 = Integer.parseInt(hint4);
            yourhint5 = Integer.parseInt(hint5);
        }

        selectedNumbers.add(yourhint1);
        selectedNumbers.add(yourhint2);
        selectedNumbers.add(yourhint3);
        selectedNumbers.add(yourhint4);
        selectedNumbers.add(yourhint5);

        if (selectedNumbers.size() == 5) {
            fiveDifferentnumbers = true;
        }

        ArrayList<Integer> userNumbers = new ArrayList<>(selectedNumbers);

        for (Integer userNumber : userNumbers) {
            if (userNumber >= MIN && userNumber <= MAX) {
                fallOutOFTheInterval = true;
            } else {
                fallOutOFTheInterval = false;
                break;
            }
        }
        if (fiveDifferentnumbers == true && fallOutOFTheInterval == true && isEmpty == false) {
            generationNumbers();
            return true;
        }

        return false;
    }

    public int compareToNumbers() {
        int result = 0;
        for (Integer selectedNumber : selectedNumbers) {
            if (selectedNumber == genNum1 || selectedNumber == genNum2 || selectedNumber == genNum3 || selectedNumber == genNum4 || selectedNumber == genNum5) {
                result++;
            }
        }
        return result;
    }

    private void generationNumbers() {
        genNum1 = getRandomNumbers();
        genNum2 = getRandomNumbers();
        genNum3 = getRandomNumbers();
        genNum4 = getRandomNumbers();
        genNum5 = getRandomNumbers();
    }

    private int getRandomNumbers() {
        int random = (int) (Math.random() * MAX) + MIN;

        if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5) {
            return getRandomNumbers();
        }

        return random;
    }

}
