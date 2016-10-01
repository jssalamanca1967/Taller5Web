/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlists;

/**
 *
 * @author Juleh
 */
public class CancionDTO {
    
    private Long id; 
    private String nombre;
    private String artista;
    private String pais;
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getArtista()
    {
        return artista;
    }
    public void setArtista(String artista)
    {
        this.artista = artista;
    }
    public String getPais()
    {
        return pais;
    }
    public void setPais(String pais)
    {
        this.pais = pais;
    }
    
}
