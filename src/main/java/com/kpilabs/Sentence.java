package com.kpilabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Sentence представляє речення, яке складається з слів та розділових знаків.
 *
 * @version 1.0
 */
public class Sentence {
    private final List<Word> words;
    private final List<PunctuationMark> punctuationMarks;

    /**
     * Конструктор для створення об'єкта Sentence.
     */
    public Sentence() {
        this.words = new ArrayList<>();
        this.punctuationMarks = new ArrayList<>();
    }

    /**
     * Додає слово до речення.
     *
     * @param word об'єкт Word
     */
    public void addWord(Word word) {
        words.add(word);
    }

    /**
     * Додає розділовий знак до речення.
     *
     * @param mark об'єкт PunctuationMark
     */
    public void addPunctuationMark(PunctuationMark mark) {
        punctuationMarks.add(mark);
    }

    /**
     * Отримує список слів у реченні.
     *
     * @return список слів
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Отримує список розділових знаків у реченні.
     *
     * @return список розділових знаків
     */
    public List<PunctuationMark> getPunctuationMarks() {
        return punctuationMarks;
    }

    /**
     * Перевизначений метод toString для виведення речення.
     *
     * @return речення як рядок
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int wordIndex = 0;
        int markIndex = 0;

        while (wordIndex < words.size() || markIndex < punctuationMarks.size()) {
            if (wordIndex < words.size()) {
                sb.append(words.get(wordIndex));
                wordIndex++;
            }
            if (markIndex < punctuationMarks.size()) {
                sb.append(punctuationMarks.get(markIndex));
                markIndex++;
            }
            if (wordIndex < words.size()) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів Sentence.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо речення однакові, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (!words.equals(sentence.words)) return false;
        return punctuationMarks.equals(sentence.punctuationMarks);
    }

    /**
     * Перевизначений метод hashCode відповідно до equals.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        int result = words.hashCode();
        result = 31 * result + punctuationMarks.hashCode();
        return result;
    }
}

