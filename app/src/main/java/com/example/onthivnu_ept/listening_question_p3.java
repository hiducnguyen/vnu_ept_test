package com.example.onthivnu_ept;

public class listening_question_p3
{
    question[]questions;
    String direction="In Part 3 you will hear a talk. After the second listening, there are eight questions." +
            "Select the best answer to each question.";
    int listen_file;
    class question
    {
        String question = "";
        String answerA = "";
        String answerB = "";
        String answerC = "";
        String answerD = "";
        String correctAnwer = "";

        public question(String question, String answerA, String answerB, String answerC, String answerD, String correctAnwer, int listen_file) {
            this.question = question;
            this.answerA = answerA;
            this.answerB = answerB;
            this.answerC = answerC;
            this.answerD = answerD;
            this.correctAnwer = correctAnwer;
        }
    }
}
