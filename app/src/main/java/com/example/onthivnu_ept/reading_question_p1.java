package com.example.onthivnu_ept;

public class reading_question_p1
{
    String passage;
    question[] questions;
    class question
    {
        String question="";
        String answerA="";
        String answerB="";
        String answerC="";
        String answerD="";
        String correctAnwer="";

        public question(String question, String answerA, String answerB, String answerC, String answerD, String correctAnwer) {
            this.question = question;
            this.answerA = answerA;
            this.answerB = answerB;
            this.answerC = answerC;
            this.answerD = answerD;
            this.correctAnwer = correctAnwer;
        }
    }

}
