package pl.ds360.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchParam {
    String nazwa;
    double cenaMniejszaNiz;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCenaMniejszaNiz() {
        return cenaMniejszaNiz;
    }

    public void setCenaMniejszaNiz(double cenaMniejszaNiz) {
        this.cenaMniejszaNiz = cenaMniejszaNiz;
    }

    public SearchParam(String nazwa, double cenaMniejszaNiz) {
        this.nazwa = nazwa;
        this.cenaMniejszaNiz = cenaMniejszaNiz;
    }

    public SearchParam(){}
}
