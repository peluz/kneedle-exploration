import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Linha {
    public String texto;
	public float startX;
    public float endX;
    public float endY;    
    public String endFontFamily;
    public float fontSizePT = 0;
    public float height = 0;
    float xscale = 0;
    float space = 0;
    int pageNumber = 0;
    String dataDODF = "";
    int numeroDODF = 0;    
    public String TipoBloco = "";
    public Integer numeroLinha = 0;
    public String complemento = ""; 
    public Integer numeroLinhaGeral = 0;
    
    public Linha(String texto, float startX, float endX, float endY, String endFontFamily, float fontSizePT,  float height, float space, float xscale, Integer pageNumber, Integer numeroDODF, String dataDODF) {
        this.texto = texto;
    	this.startX = startX;
        this.endX = endX;
        this.endY = endY;        
        this.endFontFamily = endFontFamily;
        this.fontSizePT = fontSizePT;
        this.height = height;
        this.xscale = xscale;        
        this.space = space;
        this.pageNumber = pageNumber;        
        this.dataDODF = dataDODF;
        this.numeroDODF = numeroDODF;
        //this.TipoBloco = TipoBloco;  
    }

public Linha(double d) {
		// TODO Auto-generated constructor stub
	}

public void setTexto(String texto) {	
	this.texto = texto;
}

public String getTexto() {
	return this.texto;
}

public void setPageNumber(Integer page) {
	this.pageNumber = page;	
}


public void setBloco(String tipoBloco) {
	this.TipoBloco = tipoBloco;
	
}

public String getPageNumber() {
	return this.texto;
}

public void setComplemento(String complemento) {
	this.complemento = complemento;
}

public String getComplemento() {
	return this.complemento;
}

public void setDataDODF(String dataDODF) {	
	this.dataDODF = dataDODF;
}

public String getDataDODF() {
	return this.dataDODF;
}

public float getY() {
	return this.endY;
}

public float getX() {
	return this.endX;
}

public String getTipoBloco() {
	return this.TipoBloco;
}

public void setNumeroDODF(Integer numeroDODF) {	
	this.numeroDODF = numeroDODF;
}

public Integer getNumeroDODF() {
	return this.numeroDODF;
}

public void setNumeroLinha(Integer numeroLinha) {	
	this.numeroLinha = numeroLinha;
}

public Integer getNumeroLinha() {
	return this.numeroLinha;
}

public void setNumeroLinhaGeral(Integer numeroLinhaGeral) {	
	this.numeroLinhaGeral = numeroLinhaGeral;
}

public Integer getNumeroLinhaGeral() {
	return this.numeroLinhaGeral;
}



public static void main(String[] args) throws Exception{

	List<Linha> list = new ArrayList<>();
	
	String[] values = new String[]{ "one", "two", "three" };
	
	
	
	List<String[]> stringlist = new ArrayList<>();
	
	stringlist.add(values);
	stringlist.add(values);	
	
	//System.out.println(stringlist.get(0));

	for (int i = 0; i <= stringlist.size() -1; ++i) {
		for (int j = 0; j <= stringlist.get(i).length -1; ++j) {
			//System.out.println(values[i]);
			System.out.println(stringlist.get(i)[j]);
		//System.out.println(values[i]);
		//System.out.println(stringlist.get(0)[i]);
		}
	}
	
	//System.out.println(stringlist.get(0)[0]);


	
	Comparator<Linha> carBrandComparator = new Comparator<Linha>() {
	    @Override
	    public int compare(Linha car1, Linha car2) {
	        return car1.endFontFamily.compareTo(car2.endFontFamily);
	    }
	};

	for (int i = 0; i <= list.size()-1; ++i) {
		System.out.println(list.get(i).startX);
	}
	
	System.out.println(list.get(2).startX);
	System.out.println(list.get(1).startX);	
	System.out.println("Volvo V40".compareTo("Volvo V40"));
	Collections.sort(list, carBrandComparator);
	
	for (int i = 0; i <= list.size()-1; ++i) {
		System.out.println(list.get(i).startX);
	}
	
	for (int i = 0; i <= list.size()-1; ++i) {
		System.out.println(values[i]);
	}	

	
}

public Object getBirthday() {
	// TODO Auto-generated method stub
	return null;
}


}