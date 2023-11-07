package lotto;

import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.LOTTO_NUMBER_LENGTH;
import static lotto.Constants.MessageConstant.COMMA;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {


    public static final int ONE = 1;
    public static final int INIT_NUM = 0;
    public static final char COMMA_CHARACTER = ',';
    private final List<LottoNumber> winningNumbers;

    private WinningNumber(String input) {
        isBlank(input);
        input = input.trim();
        String[] numbers = input.split(COMMA);

        winningNumbers = Arrays.stream(numbers).map(LottoNumber::newInstance).toList();
    }

    public static WinningNumber newInstance(String input) {
        return new WinningNumber(input);
    }



    private void isBlank(String input) {
        if (input != null && !input.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NO_INPUT_BLANK);
    }


}
