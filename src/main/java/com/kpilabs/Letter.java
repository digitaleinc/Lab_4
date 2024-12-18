package com.kpilabs;

/**
 * Клас Letter представляє окрему літеру.
 *
 * @version 1.0
 */
public class Letter {
    private char character;

    /**
     * Конструктор для створення об'єкта Letter.
     *
     * @param character символ літери
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Отримує символ літери.
     *
     * @return символ літери
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Встановлює символ літери.
     *
     * @param character символ літери
     */
    public void setCharacter(char character) {
        this.character = character;
    }

    /**
     * Перевизначений метод toString для виведення символу.
     *
     * @return символ як рядок
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }

    /**
     * Перевизначений метод equals для порівняння двох об'єктів Letter.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо символи однакові, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        return character == letter.character;
    }

    /**
     * Перевизначений метод hashCode відповідно до equals.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return (int) character;
    }
}

