package com.example.onthivnu_ept;

public class listening_question_p1
{
    question [] questions;
    String direction="In Part 1 you will hear ten conversations between two people. After the second listening" +
            "of each conversation, you will hear a question and there are four possible answers provided." +
            "Select the best answer to each question.";

    class question
    {
        String question="";
        String answerA="";
        String answerB="";
        String answerC="";
        String answerD="";
        String correctAnwer="";
        int conversation_file;
        int question_file;

        public question(String question, String answerA, String answerB, String answerC, String answerD, String correctAnwer, int conversation_file, int question_file) {
            this.question = question;
            this.answerA = answerA;
            this.answerB = answerB;
            this.answerC = answerC;
            this.answerD = answerD;
            this.correctAnwer = correctAnwer;
            this.conversation_file = conversation_file;
            this.question_file = question_file;
        }
    }

}
