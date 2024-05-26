package practica48;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "transmision")
public class Transmision {
	@XmlElement(name ="tipo")
	private String tipo;
	@XmlElement(name ="velocidades")
	private String velocidades;
	
	


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}


public String getVelocidades() {
	return velocidades;
}


public void setVelocidades(String velocidades) {
	this.velocidades = velocidades;
}



	
	
}
