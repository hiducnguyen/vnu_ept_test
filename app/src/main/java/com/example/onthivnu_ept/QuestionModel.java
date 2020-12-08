package com.example.onthivnu_ept;

import java.util.Objects;

public class QuestionModel {
    private String question, answerA, answerB, answerC, answerD, rightAnswer, type;
    private int idInfor, part;

    @Override
    public String toString() {
        return "QuestionModel{" +
                "question='" + question + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", type='" + type + '\'' +
                ", idInfor=" + idInfor +
                ", part=" + part +
                '}';
    }

    public QuestionModel() {
    }

    public QuestionModel(String question, String answerA, String answerB, String answerC, String answerD, String rightAnswer, String type, int idInfor, int part) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.rightAnswer = rightAnswer;
        this.type = type;
        this.idInfor = idInfor;
        this.part = part;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdInfor() {
        return idInfor;
    }

    public void setIdInfor(int idInfor) {
        this.idInfor = idInfor;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public void set(String myQuestion, String myAnswerA, String myAnswerB, String myAnswerC, String myAnswerD, String myRightAnswer, String myType, int myIdInfor, int myPart) {
        setQuestion(myQuestion);
        setAnswerA(myAnswerA);
        setAnswerB(myAnswerB);
        setAnswerC(myAnswerC);
        setAnswerD(myAnswerD);
        setRightAnswer(myRightAnswer);
        setType(myType);
        setIdInfor(myIdInfor);
        setPart(myPart);
    }
}
