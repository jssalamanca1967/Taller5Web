/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author John y Juliana :v
 */
@Entity
public class ListaReproduccion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @OneToMany
    public List<Cancion> canciones;
    
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
    public List<Cancion> getCanciones()
    {
        return canciones;
    }
    public void setCanciones(List<Cancion> canciones)
    {
        this.canciones = canciones;
    }
    
       
    
}
