package practica48;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "auto")  //raiz
public class Auto {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "marca")
    private String marca;
    @XmlElement(name = "modelo")
    private String modelo;
    @XmlElement(name = "año")
    private String año;
    @XmlElement(name = "color")
    private String color;
    @XmlElement(name = "tipo_motor")
    private String tipoMotor;
    @XmlElement(name = "cilindrada")
    private String cilindrada;
    @XmlElement(name = "potencia")
    private String potencia;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}
