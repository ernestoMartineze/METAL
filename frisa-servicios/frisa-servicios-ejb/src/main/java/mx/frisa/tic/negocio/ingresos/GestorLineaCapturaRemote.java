/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;


import java.rmi.RemoteException; 
import java.rmi.Remote;
import java.util.List;
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
/**
 *
 * @author soultech
 */
public interface GestorLineaCapturaRemote  extends Remote{
    
    public List<LineaCapturaDTO> consultarLineaCaptura(LineaCapturaDTO lineaCaptura) throws RemoteException;
    
}
