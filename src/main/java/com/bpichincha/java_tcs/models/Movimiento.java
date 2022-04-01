package com.bpichincha.java_tcs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private Date fecha;
    private String descripcion;
    @JsonIgnore
    @ManyToOne
    private Cuenta cuenta;
}
