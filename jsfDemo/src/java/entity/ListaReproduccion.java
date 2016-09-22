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
 * @author John
 */
@Entity
public class ListaReproduccion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Cancion> canciones;
    
    public String nombre;
    
       
    
}
