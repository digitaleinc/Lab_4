package com.kpilabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Text представляє текст, який складається з речень.
 *
 * @version 1.0
 */
public class Text {
    private final List<Sentence> sentences;

    /**
     * Конструктор для створення об'єкта Text.
     */
    public Text() {
        this.sentences = new ArrayList<>();
    }

    /**
     * Додає речення до тексту.
     *
     * @param sentence об'єкт Sentence
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Отримує список речень у тексті.
     *
     * @return список речень
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Перевизначений метод toString для виведення тексту.
     *
     * @return текст як рядок
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів Text.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо тексти однакові, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        return sentences.equals(text.sentences);
    }

    /**
     * Перевизначений метод hashCode відповідно до equals.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return sentences.hashCode();
    }
}

