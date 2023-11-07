package lotto;


import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.DIGIT_REGEX;
import static lotto.Constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.Constants.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.Objects;

public class LottoNumber {


    private LottoNumber(String input) {
        isBlank(input);
        input = input.trim();
        isDigit(input);
    }

    private void isBlank(String input) {
        if (input != null && !input.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NO_INPUT_BLANK);
    }

    private void isDigit(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ERROR_INPUT_DIGIT);
        }
    }

    private void validateRange(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num > MAX_LOTTO_NUMBER || num < MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_BETWEEN_MIN_AND_MAX);
        }
    }
}
