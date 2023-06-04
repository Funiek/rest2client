package pl.ds360.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "responseList")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ResponseList implements Serializable {

    private static final long serialVersionUID = 2L;
    @XmlElement(name = "product")
    private List<Product> lista;

    public List<Product> getList() {
        return lista;
    }

    public void setList(List<Product> plist) {
        this.lista = plist;
    }
    public ResponseList() {
        super();
    }
    public ResponseList(List<Product> list) {
        super();
        this.lista = list;
    }


}