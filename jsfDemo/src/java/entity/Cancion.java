/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

/**
 * @generated
 */
@Entity
public class Cancion implements Serializable{
    
    @Id
    @GeneratedValue(generator = "Cancion")
    private Long id; 
    private String nombre;
    private String nombreArtista;
    private String paisArtista;
    
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
    public String getNombreArtista()
    {
        return nombreArtista;
    }
    public void setNombreArtista(String nombreArtista)
    {
        this.nombreArtista = nombreArtista;
    }
    public String getPaisArista()
    {
        return paisArtista;
    }
    public void setPaisArtista(String paisArtista)
    {
        this.paisArtista = paisArtista;
    }
    
    
}
