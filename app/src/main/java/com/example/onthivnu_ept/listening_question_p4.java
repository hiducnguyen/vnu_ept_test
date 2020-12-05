package com.example.onthivnu_ept;

public class listening_question_p4
{
    question[] questions;
    String direction="In Part 4 you will hear part of a lecture. After the second listening, there is a summary of" +
            "the lecture with eight gaps. Select the best option for each gap to complete the summary. ";
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
