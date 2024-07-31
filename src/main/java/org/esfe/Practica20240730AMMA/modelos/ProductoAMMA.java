package org.esfe.Practica20240730AMMA.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;




@Entity
@Table(name = "ProductoAMMA") 
public class ProductoAMMA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String nombreAMMA;

    @NotBlank(message = "La descripción es requerida")
    private String descripcionAMMA;

    @NotNull(message = "El precio es requerido")
    private BigDecimal precioAMMA;

    @NotNull(message = "La fecha de vencimiento es requerida")
    private LocalDate fechaVencimiento;


    @NotNull(message = "El estatus es requerido")
    private Byte estatusAMMA;

    @NotNull(message = "La existencia es requerida")
    private Integer existenciaAMMA;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAMMA() {
        return nombreAMMA;
    }

    public void setNombreAMMA(String nombreAMMA) {
        this.nombreAMMA = nombreAMMA;
    }

    public String getDescripcionAMMA() {
        return descripcionAMMA;
    }

    public void setDescripcionAMMA(String descripcionAMMA) {
        this.descripcionAMMA = descripcionAMMA;
    }

    public BigDecimal getPrecioAMMA() {
        return precioAMMA;
    }

    public void setPrecioAMMA(BigDecimal precioAMMA) {
        this.precioAMMA = precioAMMA;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Byte getEstatusAMMA() {
        return estatusAMMA;
    }

    public void setEstatusAMMA(Byte estatusAMMA) {
        this.estatusAMMA = estatusAMMA;
    }

    public Integer getExistenciaAMMA() {
        return existenciaAMMA;
    }

    public void setExistenciaAMMA(Integer existenciaAMMA) {
        this.existenciaAMMA = existenciaAMMA;
    }
}
