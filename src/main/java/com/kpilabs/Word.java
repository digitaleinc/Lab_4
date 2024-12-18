package com.kpilabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word представляє слово, яке складається з літер та розділових знаків.
 *
 * @version 1.0
 */
public class Word {
    private final List<Letter> letters;
    private final List<PunctuationMark> punctuationMarks;

    /**
     * Конструктор для створення об'єкта Word.
     */
    public Word() {
        this.letters = new ArrayList<>();
        this.punctuationMarks = new ArrayList<>();
    }

    /**
     * Додає літеру до слова.
     *
     * @param letter об'єкт Letter
     */
    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    /**
     * Додає розділовий знак до слова.
     *
     * @param mark об'єкт PunctuationMark
     */
    public void addPunctuationMark(PunctuationMark mark) {
        punctuationMarks.add(mark);
    }

    /**
     * Отримує список літер у слові.
     *
     * @return список літер
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Отримує список розділових знаків у слові.
     *
     * @return список розділових знаків
     */
    public List<PunctuationMark> getPunctuationMarks() {
        return punctuationMarks;
    }

    /**
     * Перевизначений метод toString для виведення слова.
     *
     * @return слово як рядок
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів Word.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо слова однакові, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!letters.equals(word.letters)) return false;
        return punctuationMarks.equals(word.punctuationMarks);
    }

    /**
     * Перевизначений метод hashCode відповідно до equals.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        int result = letters.hashCode();
        result = 31 * result + punctuationMarks.hashCode();
        return result;
    }
}

