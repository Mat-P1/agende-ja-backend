package br.edu.unifametro.aluno.agendeja.util.user;

import java.util.List;

public class GovernmentIdValidator {

    private static final List<String> SAME_NUMBER_SEQUENCE = List.of(
            "00000000000", "00000000000000", "11111111111", "11111111111111", "22222222222",
            "22222222222222", "33333333333", "33333333333333", "44444444444", "44444444444444",
            "55555555555", "55555555555555", "66666666666", "66666666666666", "77777777777",
            "77777777777777", "88888888888", "88888888888888", "99999999999", "99999999999999");

    /**
     * Validates a government ID (CPF or CNPJ).
     *
     * @param governmentId The CPF (11 digits) or CNPJ (14 digits) to be validated.
     * @return true if the government ID is valid, false otherwise.
     */

    public static boolean isValidGovernmentId(String governmentId) {

        boolean isValid = false;

        if (isCpf(governmentId) && isNotRepeatedSameNumber(governmentId)) {
            if (calculateCpf(governmentId)) {
                isValid = true;
            }
        } else if (isCnpj(governmentId) && isNotRepeatedSameNumber(governmentId)) {
            if (calculateCnpj(governmentId)) {
                isValid = true;
            }
        }

        return isValid;
    }

    /**
     * Checks if a government ID is a CPF or CNPJ.
     *
     * @param governmentId The government ID to be checked.
     * @return true if the government ID is a CPF (11 digits) or CNPJ (14 digits), false otherwise.
     */

    public static boolean isCnpj(String governmentId) {
        return governmentId.length() == 14;
    }

    private static boolean isCpf(String governmentId) {
        return governmentId.length() == 11;
    }

    /**
     * Verifies if a CPF or CNPJ are not a sequence of the same number (e.g., "11111111111" or "11111111111111").
     *
     * @param governmentId The CPF or CNPJ to be checked.
     * @return true if the CPF or CNPJ are not a repeated sequence, false otherwise.
     */

    private static boolean isNotRepeatedSameNumber(String governmentId) {
        for (String s : SAME_NUMBER_SEQUENCE) {
            if (s.equals(governmentId)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates and verifies if the CPF's or CNPJ's check digits are valid.
     *
     * @param governmentId The CPF or CNPJ to be validated.
     * @return true if the CPF or CNPJ are valid, false otherwise.
     */

    private static boolean calculateCpf(String governmentId) {

        try {
            int sum = 0;

            // Calculate the first check digit
            for (int i = 0; i < 9; i++) {
                sum += (10 - i) * (governmentId.charAt(i) - '0');
            }
            int firstCheckDigit = 11 - (sum % 11);
            if (firstCheckDigit >= 10) {
                firstCheckDigit = 0;
            }

            if (firstCheckDigit != (governmentId.charAt(9) - '0')) {
                return false;
            }

            // Calculate the second check digit
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (11 - i) * (governmentId.charAt(i) - '0');
            }
            int secondCheckDigit = 11 - (sum % 11);
            if (secondCheckDigit >= 10) {
                secondCheckDigit = 0;
            }

            return secondCheckDigit == (governmentId.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }

    private static boolean calculateCnpj(String governmentId) {

        try {
            int[] weightsFirstCheck = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] weightsSecondCheck = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            // Calculate the first check digit
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                sum += (governmentId.charAt(i) - '0') * weightsFirstCheck[i];
            }
            int firstCheckDigit = 11 - (sum % 11);
            if (firstCheckDigit >= 10) {
                firstCheckDigit = 0;
            }

            if (firstCheckDigit != (governmentId.charAt(12) - '0')) {
                return false;
            }

            // Calculate the second check digit
            sum = 0;
            for (int i = 0; i < 13; i++) {
                sum += (governmentId.charAt(i) - '0') * weightsSecondCheck[i];
            }
            int secondCheckDigit = 11 - (sum % 11);
            if (secondCheckDigit >= 10) {
                secondCheckDigit = 0;
            }

            return secondCheckDigit == (governmentId.charAt(13) - '0');

        } catch (Exception e) {
            return false;
        }
    }
}