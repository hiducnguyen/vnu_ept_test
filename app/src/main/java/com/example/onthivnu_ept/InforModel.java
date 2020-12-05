package com.example.onthivnu_ept;

public class InforModel {
    private int id;
    private String infor, type;

    @Override
    public String toString() {
        return "InforModel{" +
                "id=" + id +
                ", infor='" + infor + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InforModel(int id, String infor) {
        this.id = id;
        this.infor = infor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

}
