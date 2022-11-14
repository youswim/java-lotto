package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int WIN_NUMBER_SIZE = 6;

    private List<Integer> winNumbers = new ArrayList<>();
    private Integer bonusNumber;

    public void enterWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        getWinNumbers(Console.readLine());
    }

    public void getWinNumbers(String input) {
        String[] numbers = input.split(",");
        validateWinNumbers(numbers);
        for (String number : numbers) {
            winNumbers.add(Integer.valueOf(number));
        }
    }

    void validateWinNumbers(String[] numbers) {
        if (numbers.length != WIN_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionHandler.WORNG_WIN_NUMBERS);
        }
        for (String number : numbers) {
            if (isNotNumeric(number) || isNotInRange(number)) {
                throw new IllegalArgumentException(ExceptionHandler.WORNG_WIN_NUMBERS);
            }
        }
    }

    public boolean isNotInRange(String number) {
        int num = Integer.parseInt(number);
        return num < MIN_NUMBER || MAX_NUMBER < num;
    }

    public boolean isNotNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}