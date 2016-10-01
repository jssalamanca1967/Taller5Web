/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    ListaReproduccion listaActual;
    
    ArrayList<Cancion> cancionesActual;

    ArrayList<ListaReproduccion> listasRep =
		new ArrayList<ListaReproduccion>(Arrays.asList(

		new ListaReproduccion("Para hacer web :P", new Long(2345654), new ArrayList<Cancion>(Arrays.asList(

		new Cancion("La Camisa Negra", new Long(2345654), "Juanes", "Colombia"),
                new Cancion("Bad Romance", new Long(43567), "Lady Gaga", "USA")
            
	))))
	);
    
    ArrayList<Cancion> canciones =
		new ArrayList<Cancion>(Arrays.asList(

		new Cancion("La Camisa Negra", new Long(2345654), "Juanes", "Colombia"),
                new Cancion("Bad Romance", new Long(43567), "Lady Gaga", "USA")
            
	));
    
    ArrayList<Cancion> filteredCanciones;
    
    public ArrayList<Cancion> getFilteredCanciones()
    {
        return filteredCanciones;
    }
    
    public void setFilteredCanciones(ArrayList<Cancion> filteredCanciones) {
        this.filteredCanciones = filteredCanciones;
    }
    
    public ArrayList<Cancion> getCancionesActual()
    {
        return cancionesActual;
    }
    
    public ListaReproduccion getListaActual()
    {
        return listaActual;
    }
    
    public void setListaActual(ListaReproduccion lis)
    {
        listaActual = (lis);
        cancionesActual = listaActual.canciones;
        System.out.println(lis.canciones);
    }
    
    public ListaReproduccion buscarLista(String nom)
    {
        for (ListaReproduccion temp : listasRep) {
            if(temp.nombre.equals(nom))
                return temp;
        }
        
        return null;
    }
    
    
    public ArrayList<ListaReproduccion> getListasRep() {

		return listasRep;

	}
    
    public ArrayList<Cancion> getCanciones() {

		return canciones;

	}

    public void setLista(ListaReproduccion lista)
    {
        listaActual = lista;
        cancionesActual = listaActual.canciones;
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
    
    public String getLista(ListaReproduccion lista)
    {
        listaActual = lista;
        return listaActual.nombre;
    }
    
    public void crear()
    {
        
        ArrayList nuevas = new ArrayList();
        for (Cancion temp : canciones) {
            System.out.println(temp);
            if(temp.selected){
                temp.setSelected(false);
                nuevas.add(temp);
                
            }
                
        }
        ListaReproduccion temp = new ListaReproduccion(nombreListaNueva, new Long(12233), nuevas);
        listasRep.add(temp);
        nombreListaNueva = "";
        
    }
    
    public static class ListaReproduccion{

		String nombre;
		Long id;
		ArrayList canciones;

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
                public ArrayList getCanciones()
                {
                    return canciones;
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

        public void setSelected(boolean set) {
        this.selected = set;
    }
		//getter and setter methods
	}
}
