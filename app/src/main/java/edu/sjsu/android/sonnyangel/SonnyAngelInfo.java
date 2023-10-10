package edu.sjsu.android.sonnyangel;

public class SonnyAngelInfo {
    public String name;
    public int img;
    public String info;


    public SonnyAngelInfo(String name, int img, String info) {
        this.name = name;
        this.img = img;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getInfo() {
        return info;
    }
}
