package com.example.onthivnu_ept;

public class listening_question_p2
{
    question []questions;
    String direction="In Part 2 you will hear a conversation. After the second listening, there are six " +
            "incomplete sentences and four possible options provided for each gap. Select the best option to" +
            "complete the sentence.";
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
