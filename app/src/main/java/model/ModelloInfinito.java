package model;

public class ModelloInfinito {
    // string course_name for storing course_name
    // and imgid for storing image id.
    private String infinito;
    private int imgid;

    public ModelloInfinito (String infinito, int imgid) {
        this.infinito = infinito;
        this.imgid = imgid;
    }

    public String getInfinito() {
        return infinito;
    }

    public void setInfinito(String infinito) {
        this.infinito = infinito;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
