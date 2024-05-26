package practica48;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "autos")//raiz

public class Autos {
	@XmlElement(name = "auto")
	private ArrayList<Auto> Autos = new ArrayList();

	public Autos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Auto> getAutos() {
		return Autos;
	}

	public void setAutos(ArrayList<Auto> autos) {
		Autos = autos;
	}
	
	
	

}
