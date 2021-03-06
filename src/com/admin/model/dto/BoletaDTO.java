package com.admin.model.dto;

import java.sql.Time;
import java.sql.Date;

/** * @author DANNY VASQUEZ RAFAEL */

public class BoletaDTO {
    private int codigo; // PK
    private int serie;
    private int numero;
    private String nomClie;
    private String direClie;
    private Date fecha;
    private Time hora;
    private double total;
    private int estCancelacion;
    private int estEntrega;
    private int estado;
    private Date fechaEntrega;
    private ClienteDTO cliente; // clie_codigo
    private DetalleCargoDTO detalleCargoVendedor; //detcarg_codigoVendedor
    private DetalleCargoDTO detalleCargoCajero; //detcarg_codigoCajero
    private DetalleTiendaDTO detalleTienda; //dettien_codigo

    public BoletaDTO(int codigo, int serie, int numero, String nomClie, String direClie, Date fecha, Time hora, double total, int estCancelacion, int estEntrega, int estado, Date fechaEntrega, ClienteDTO cliente, DetalleCargoDTO detalleCargoVendedor, DetalleCargoDTO detalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.nomClie = nomClie;
        this.direClie = direClie;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.estCancelacion = estCancelacion;
        this.estEntrega = estEntrega;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.detalleCargoVendedor = detalleCargoVendedor;
        this.detalleCargoCajero = detalleCargoCajero;
        this.detalleTienda = detalleTienda;
    }

    public BoletaDTO(int codigo, int serie, int numero, Date fecha, Time hora, double total, int estCancelacion, int estEntrega, Date fechaEntrega, DetalleCargoDTO detalleCargoCajero, DetalleTiendaDTO detalleTienda) {
        this.codigo = codigo;
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.estCancelacion = estCancelacion;
        this.estEntrega = estEntrega;
        this.fechaEntrega = fechaEntrega;
        this.detalleCargoCajero = detalleCargoCajero;
        this.detalleTienda = detalleTienda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomClie() {
        return nomClie;
    }

    public void setNomClie(String nomClie) {
        this.nomClie = nomClie;
    }

    public String getDireClie() {
        return direClie;
    }

    public void setDireClie(String direClie) {
        this.direClie = direClie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstCancelacion() {
        return estCancelacion;
    }

    public void setEstCancelacion(int estCancelacion) {
        this.estCancelacion = estCancelacion;
    }

    public int getEstEntrega() {
        return estEntrega;
    }

    public void setEstEntrega(int estEntrega) {
        this.estEntrega = estEntrega;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public DetalleCargoDTO getDetalleCargoVendedor() {
        return detalleCargoVendedor;
    }

    public void setDetalleCargoVendedor(DetalleCargoDTO detalleCargoVendedor) {
        this.detalleCargoVendedor = detalleCargoVendedor;
    }

    public DetalleCargoDTO getDetalleCargoCajero() {
        return detalleCargoCajero;
    }

    public void setDetalleCargoCajero(DetalleCargoDTO detalleCargoCajero) {
        this.detalleCargoCajero = detalleCargoCajero;
    }

    public DetalleTiendaDTO getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(DetalleTiendaDTO detalleTienda) {
        this.detalleTienda = detalleTienda;
    }
    
}
