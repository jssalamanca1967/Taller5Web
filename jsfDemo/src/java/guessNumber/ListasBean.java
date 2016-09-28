/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Juleh
 */
@ManagedBean(name="listas")
@SessionScoped
public class ListasBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    String filtro;
    
    String nombreListaNueva;
    
    String crear;

    private static final ArrayList<ListaReproduccion> listasRep =
		new ArrayList<ListaReproduccion>(Arrays.asList(

		new ListaReproduccion("Para hacer web :P", new Long(2345654), null))
	);
    
    Cancion[] canciones = new Cancion[] {

		new Cancion("La Camisa Negra", new Long(2345654), "Juanes", "Colombia")
	};
    
    public ArrayList<ListaReproduccion> getListasRep() {

		return listasRep;

	}
    
    public Cancion[] getCanciones() {

		return canciones;

	}

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    public String getNombreListaNueva() {
        return nombreListaNueva;
    }

    public void setNombreListaNueva(String nombreListaNueva) {
        this.nombreListaNueva = nombreListaNueva;
    }
    
    public String getResponse() {
        return "";
    }
    
    public void crear()
    {
        
        ArrayList nuevas = new ArrayList();
        for (Cancion temp : canciones) {
            if(temp.selected)
                nuevas.add(temp);
        }
        ListaReproduccion temp = new ListaReproduccion(nombreListaNueva, new Long(12233), nuevas);
        listasRep.add(temp);
        nombreListaNueva = "";
    }
    
    public static class ListaReproduccion{

		String nombre;
		Long id;
		List canciones;

		public ListaReproduccion(String nombre, Long id, ArrayList canciones) 
                {

			this.id = id;
			this.nombre = nombre;
			this.canciones = canciones;
		}
                
                public Long getId()
                {
                    return id;
                }
                public String getNombre()
                {
                    return nombre;
                }

		//getter and setter methods
	}
    
    public static class Cancion{

		String nombre;
		String artista;
                String pais;
		Long id;
                private boolean selected;

		public Cancion(String nombre, Long id, String artista, String pais) 
                {

			this.id = id;
			this.nombre = nombre;
                        this.artista = artista;
                        this.pais = pais;
                        this.selected = false;
                        
		}
                
                public Long getId()
                {
                    return id;
                }
                public String getNombre()
                {
                    return nombre;
                }
                public String getPais()
                {
                    return pais;
                }
                public String getArtista()
                {
                    return artista;
                }
                public boolean isSelected() {
        return selected;
    }

        public void setSelected(boolean selected) {
        this.selected = selected;
    }

		//getter and setter methods
	}
}
