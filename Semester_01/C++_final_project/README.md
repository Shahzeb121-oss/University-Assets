# C++ Computer Science Quiz

A console-based application that quizzes users on computer science fundamentals, calculates their performance, and exports the results to a text file.

## 📋 Features in this Code

* **ANSI Color Formatting**: Uses escape codes to display specific header text in red for a stylized terminal interface.
* **Sequential Questioning**: A 10-question multiple-choice quiz covering topics like hardware (CPU, storage), software (OS, applications), and networking (URL, Wi-Fi).
* **Input Handling**: 
    * Captures the user's full name using `getline`.
    * Accepts numerical inputs (1-3) for quiz answers.
* **Scoring System**: 
    * Increments the score for correct answers.
    * Identifies and displays the correct answer when the user is incorrect.
    * Calculates a final percentage based on the 10 questions.
* **Error Validation**: Includes logic to detect if the user enters a number or symbol outside the provided options (1-3).
* **File Export (Persistence)**: Automatically generates a `result.txt` file at the end of the session to save the user's name, total score, and percentage.

---

## 🛠 Technical Implementation

* **Arrays**: Utilizes a 1D array for questions and a 2D array for the multiple-choice options.
* **Control Flow**: Uses a `for` loop to iterate through the quiz and `if-else` branching to evaluate answers.
* **File I/O**: Employs the `<fstream>` library to handle outputting results to a local file.

---

## 🚀 How to Run

1.  **Compile**: Use a C++ compiler (like G++):
    ```bash
    g++ main.cpp -o QuizApp
    ```
2.  **Execute**: Run the program:
    ```bash
    ./QuizApp
    ```

## 📂 Output File
The program generates a file named `result.txt` in the same directory, containing:
* User Name
* Final Score (out of 10)
* Percentage