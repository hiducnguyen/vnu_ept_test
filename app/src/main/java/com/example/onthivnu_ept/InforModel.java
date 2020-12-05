package com.example.onthivnu_ept;

public class InforModel {
    private int id;
    private int imgInfor, listeningInfor;
    private String readingInfor;

    public InforModel() {
    }

    public InforModel(int id, int imgInfor, int listeningInfor, String readingInfor) {
        this.id = id;
        this.imgInfor = imgInfor;
        this.listeningInfor = listeningInfor;
        this.readingInfor = readingInfor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgInfor() {
        return imgInfor;
    }

    public void setImgInfor(int imgInfor) {
        this.imgInfor = imgInfor;
    }

    public int getListeningInfor() {
        return listeningInfor;
    }

    public void setListeningInfor(int listeningInfor) {
        this.listeningInfor = listeningInfor;
    }

    public String getReadingInfor() {
        return readingInfor;
    }

    public void setReadingInfor(String readingInfor) {
        this.readingInfor = readingInfor;
    }

    @Override
    public String toString() {
        return "InforModel{" +
                "id=" + id +
                ", imgInfor=" + imgInfor +
                ", listeningInfor=" + listeningInfor +
                ", readingInfor='" + readingInfor + '\'' +
                '}';
    }
}
