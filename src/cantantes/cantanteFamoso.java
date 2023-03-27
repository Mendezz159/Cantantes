/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

/**
 *
 * @author HP PORTATIL
 */
class cantanteFamoso {
    private String Nombre;
    private String DiscoConMasVentas;
    private long VentasDeDisco;

    public cantanteFamoso(String Nombre, String DiscoConMasVentas, long VentasDeDisco) {
        this.Nombre = Nombre;
        this.DiscoConMasVentas = DiscoConMasVentas;
        this.VentasDeDisco = VentasDeDisco;
    }

    public long getVentasDeDisco() {
        return VentasDeDisco;
    }

    public void setVentasDeDisco(long VentasDeDisco) {
        this.VentasDeDisco = VentasDeDisco;
    }

    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDiscoConMasVentas() {
        return DiscoConMasVentas;
    }

    public void setDiscoConMasVentas(String DiscoConMasVentas) {
        this.DiscoConMasVentas = DiscoConMasVentas;
    }
    
    
}
