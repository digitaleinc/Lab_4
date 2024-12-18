package com.kpilabs;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// variant 25

// Lab 4

// 1. Модифікувати лабораторну роботу №2 наступним чином: для літер, слів, речень,
// розділових знаків та тексту створити окремі класи. Слово повинно складатися
// з масиву літер, речення з масиву слів та розділових знаків, текст з масиву речень.
// Замінити послідовність табуляцій та пробілів одним пробілом.

// 2. Створити клас, який складається з виконавчого методу,
// що виконує описану дію з лабораторної роботи №2, але в якості
// типів використовує створені класи. Код повинен бути детально задокументований.
// Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
// та бути завантаженим на GitHub.

/**
 * Клас Main відповідає за запуск програми обробки тексту.
 * <p>
 * Програма дозволяє користувачу вводити текст, вибирати літеру для підрахунку,
 * сортувати слова у кожному реченні за кількістю цієї літери, а також відображати результати.
 * </p>
 * <p>
 * Весь ввід та вивід здійснюється через консоль.
 * </p>
 *
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Введення тексту
            System.out.print("Введіть текст: ");
            String inputText = scanner.nextLine();

            // Замінюємо послідовності табуляцій та пробілів одним пробілом
            inputText = inputText.replaceAll("[\\t ]+", " ").trim();

            if (inputText.isEmpty()) {
                throw new IllegalArgumentException("Введений текст порожній.");
            }

            // Введення літери для підрахунку
            System.out.print("Введіть літеру для підрахунку: ");
            String letterInput = scanner.nextLine().trim();
            if (letterInput.length() != 1 || !Character.isLetter(letterInput.charAt(0))) {
                throw new IllegalArgumentException("Необхідно ввести одну літеру.");
            }
            char targetLetter = letterInput.charAt(0);

            // Розбір тексту на речення
            Text text = parseText(inputText);

            // Отримання всіх речень з тексту
            List<Sentence> sentences = text.getSentences();

            if (sentences.isEmpty()) {
                System.out.println("Текст не містить речень для обробки.");
                return;
            }

            // Обробка кожного речення окремо
            System.out.println("\nВідсортовані слова у кожному реченні:");
            int sentenceNumber = 1;
            for (Sentence sentence : sentences) {
                List<Word> words = sentence.getWords();
                if (words.isEmpty()) {
                    System.out.println("Речення #" + sentenceNumber + " не містить слів.");
                } else {
                    // Сортування слів за кількістю заданої літери у зростаючому порядку
                    words.sort(Comparator.comparingInt(word -> countLetterInWord(word, targetLetter)));

                    System.out.println("Речення #" + sentenceNumber + ":");
                    for (Word word : words) {
                        int count = countLetterInWord(word, targetLetter);
                        System.out.println(word + " (кількість '" + targetLetter + "': " + count + ")");
                    }
                }
                sentenceNumber++;
                System.out.println(); // Порожній рядок для кращої читабельності
            }


        } catch (IllegalArgumentException e) {
            System.err.println("Помилка введення: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Розбирає вхідний текст на речення, слова, літери та розділові знаки.
     *
     * @param input вхідний текст
     * @return об'єкт Text, що містить розібраний текст
     */
    private static Text parseText(String input) {
        Text text = new Text();
        // Розділення на речення за знаками кінця речення (., !, ?)
        String[] sentenceStrings = input.split("(?<=[.!?])\\s*");

        for (String sentenceStr : sentenceStrings) {
            if (sentenceStr.isEmpty()) continue; // Пропуск порожніх рядків
            Sentence sentence = new Sentence();
            // Розділення на слова та розділові знаки
            String[] tokens = sentenceStr.split("\\s+|(?=[,.!?;:])|(?<=[,.!?;:])");

            for (String token : tokens) {
                if (token.matches("[,.!?;:]")) {
                    // Якщо токен є розділовим знаком
                    sentence.addPunctuationMark(new PunctuationMark(token.charAt(0)));
                } else if (!token.isEmpty()) {
                    // Якщо токен є словом
                    Word word = new Word();
                    for (char c : token.toCharArray()) {
                        if (Character.isLetter(c)) {
                            word.addLetter(new Letter(c));
                        }
                    }
                    if (!word.getLetters().isEmpty()) { // Додаємо лише, якщо слово містить літери
                        sentence.addWord(word);
                    }
                }
            }
            text.addSentence(sentence);
        }
        return text;
    }


    /**
     * Перевіряє, чи символ є розділовим знаком.
     *
     * @param c символ для перевірки
     * @return true, якщо символ є розділовим знаком, інакше false
     */
    private static boolean isPunctuation(char c) {
        return ",.!?;:".indexOf(c) != -1;
    }

    /**
     * Рахує кількість заданої літери у слові.
     *
     * @param word слово для підрахунку
     * @param letter літера для підрахунку
     * @return кількість літери у слові
     */
    private static int countLetterInWord(Word word, char letter) {
        int count = 0;
        char target = Character.toLowerCase(letter);
        for (Letter l : word.getLetters()) {
            if (Character.toLowerCase(l.getCharacter()) == target) {
                count++;
            }
        }
        return count;
    }
}
