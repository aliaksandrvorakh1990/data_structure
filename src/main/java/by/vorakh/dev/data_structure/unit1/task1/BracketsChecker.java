package by.vorakh.dev.data_structure.unit1.task1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class BracketsChecker {

    public static String check(String line) {

        char[] symbols = line.toCharArray();
        Deque<Character> openBrackets = new LinkedList<>();
        Deque<Integer> openBracketIndexes = new LinkedList<>();
        int index = 0;
        for (; index < symbols.length; index++) {
            char symbol = symbols[index];
            if (isBracket(symbol)) {
                if (isOpenedBracket(symbol)) {
                    openBrackets.addFirst(symbol);
                    openBracketIndexes.addFirst(index + 1);
                } else {
                    Character previousOpenBracket = openBrackets.peekFirst();
                    if ((previousOpenBracket != null) && isSameBrackets(previousOpenBracket, symbol)) {
                        openBrackets.pollFirst();
                        openBracketIndexes.pollFirst();
                    } else {
                        return String.valueOf(index + 1);
                    }
                }
            }
        }

        return (openBrackets.isEmpty()) ? "Success" : openBracketIndexes.getLast().toString();
    }

    public static String checkV2(String line) {

        char[] symbols = line.toCharArray();
        Deque<Character> openBrackets = new LinkedList<>();
        Deque<Integer> openBracketIndexes = new LinkedList<>();
        int index = 0;
        for (; index < symbols.length; index++) {
            char symbol = symbols[index];
            Optional<Character> bracket = Optional.of(symbol).filter(BracketsChecker::isBracket);
            if (bracket.isPresent()) {
                final int currentIndex = index + 1;
                Optional<Character> openBracket = bracket.filter(BracketsChecker::isOpenedBracket);
                if (openBracket.isPresent()) {
                    openBrackets.addFirst(openBracket.get());
                    openBracketIndexes.addFirst(currentIndex);
                } else {
                    Optional<Character> sameBracket = Optional.ofNullable(openBrackets.peekFirst())
                        .filter(aOpenBracket -> isSameBrackets(aOpenBracket, bracket.get()));
                    if (sameBracket.isPresent()) {
                        openBrackets.pollFirst();
                        openBracketIndexes.pollFirst();
                    } else {
                        return String.valueOf(currentIndex);
                    }
                }
            }
        }

        return (openBrackets.isEmpty()) ? "Success" : openBracketIndexes.getLast().toString();
    }

    private static boolean isBracket(char symbol) {

        boolean bracket = false;
        switch (symbol) {
            case '[':
            case ']':
            case '(':
            case ')':
            case '{':
            case '}':
                bracket = true;
                break;
        }
        return bracket;
    }

    private static boolean isOpenedBracket(char symbol) {

        boolean bracket = false;
        switch (symbol) {
            case '[':
            case '(':
            case '{':
                bracket = true;
                break;
        }
        return bracket;
    }

    private static boolean isSameBrackets(char openedBracket, char closedBracket) {

        boolean isSame = false;
        switch (openedBracket) {
            case '[':
                isSame = closedBracket == ']';
                break;
            case '(':
                isSame = closedBracket == ')';
                break;
            case '{':
                isSame = closedBracket == '}';
                break;
        }
        return isSame;
    }
}
