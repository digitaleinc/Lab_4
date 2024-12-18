package com.kpilabs;

/**
 * Клас PunctuationMark представляє розділовий знак.
 *
 * @version 1.0
 */
public class PunctuationMark {
    private final char mark;

    /**
     * Конструктор для створення об'єкта PunctuationMark.
     *
     * @param mark символ розділового знаку
     */
    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    /**
     * Перевизначений метод toString для виведення розділового знаку.
     *
     * @return розділовий знак як рядок
     */
    @Override
    public String toString() {
        return String.valueOf(mark);
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів PunctuationMark.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо розділові знаки однакові, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PunctuationMark that = (PunctuationMark) o;

        return mark == that.mark;
    }

    /**
     * Перевизначений метод hashCode відповідно до equals.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return (int) mark;
    }
}

