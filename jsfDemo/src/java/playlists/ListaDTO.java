/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlists;

import java.util.List;

/**
 *
 * @author Juleh
 */
public class ListaDTO {
    
    public Long id;
    
    public List<CancionDTO> canciones;
    
    public String nombre;
    
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public List<CancionDTO> getCanciones()
    {
        return canciones;
    }
    public void setCanciones(List<CancionDTO> canciones)
    {
        this.canciones = canciones;
    }
    
}
