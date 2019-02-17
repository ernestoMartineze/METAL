package mx.frisa.tic.view.backing;


import mx.frisa.tic.negocio.ws.FiltroPagoSinReferencia;
import mx.frisa.tic.negocio.ws.PeticionExistente;
import mx.frisa.tic.negocio.ws.GestorPagosWS;
import mx.frisa.tic.negocio.ws.GestorPagosWS_Service;
import mx.frisa.tic.negocio.ws.LineaEstadoCuentaDTO;
import mx.frisa.tic.negocio.ws.PagoSinReferenciaVO;
import mx.frisa.tic.negocio.ws.RespuestaPagoSinReferencia;
import mx.frisa.tic.negocio.ws.RespuestaClienteDTO;
import mx.frisa.tic.negocio.ws.PagoPorAplicarDTO;
import mx.frisa.tic.negocio.ws.AplicarPagoDTO;
import mx.frisa.tic.negocio.ws.CuentaBancariaDTO;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigInteger;

import java.util.Collection;

import javax.faces.component.UIParameter;
import javax.faces.model.SelectItem;

import mx.frisa.tic.negocio.ws.CatalogoWS;
import mx.frisa.tic.negocio.ws.CatalogoWS_Service;
import mx.frisa.tic.negocio.ws.RespuestaAplicarPagoDTO;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.render.ClientEvent;

public class PagoSinReferencia {
    
    //componentes
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichInputText cuentaBancariaIT;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr3;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichGridCell gc11;
    private RichInputDate fechaInicialIT;
    private RichInputDate fechaFinalIT;
    private RichSelectBooleanCheckbox aplicadosCB;
    private RichButton b1;
    private RichPanelGridLayout pgl4;
    private RichGridRow gr4;
    private RichGridCell gc12;
    private RichGridCell gc13;


    private RichGridCell gc14;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichPanelGridLayout pgl5;
    private RichGridRow gr5;
    private RichGridCell gc17;
    private RichButton b2;
    private RichButton b3;
    
    //variables y clases
    private List<PagoSinReferenciaVO> pagosVO;
    private List<PagoSinReferenciaVO> pagosAplicarVO;
    private AplicarPagoDTO aplicarPago;
    private RespuestaAplicarPagoDTO respuesta; 
    private RichTable t1;
    private RichPopup p1;
    private RichOutputText ot7;
    private RichDialog d2;
    private boolean activaITx;
    private UIParameter vp1;

    private String usuario;


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setCuentaBancariaIT(RichInputText cuentaBancariaIT) {
        this.cuentaBancariaIT = cuentaBancariaIT;
    }

    public RichInputText getCuentaBancariaIT() {
        return cuentaBancariaIT;
    }


    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setFechaInicialIT(RichInputDate fechaInicialIT) {
        this.fechaInicialIT = fechaInicialIT;
    }

    public RichInputDate getFechaInicialIT() {
        return fechaInicialIT;
    }

    public void setFechaFinalIT(RichInputDate fechaFinalIT) {
        this.fechaFinalIT = fechaFinalIT;
    }

    public RichInputDate getFechaFinalIT() {
        return fechaFinalIT;
    }


    public void setAplicadosCB(RichSelectBooleanCheckbox aplicadosCB) {
        this.aplicadosCB = aplicadosCB;
    }

    public RichSelectBooleanCheckbox getAplicadosCB() {
        return aplicadosCB;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setPgl4(RichPanelGridLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGridLayout getPgl4() {
        return pgl4;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setPgl5(RichPanelGridLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGridLayout getPgl5() {
        return pgl5;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc17(RichGridCell gc17) {
        this.gc17 = gc17;
    }

    public RichGridCell getGc17() {
        return gc17;
    }


    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB3() {
        return b3;
    }


    public void setPagosVO(List<PagoSinReferenciaVO> pagosVO) {
        this.pagosVO = pagosVO;
    }

    public List<PagoSinReferenciaVO> getPagosVO() {
        return pagosVO;
    }
    
    //eventos
    public String buscarP_Action() {
        // Add event code here...
        this.pagosVO=new ArrayList();
        pagosAplicarVO=null;
        GestorPagosWS_Service gestorPagosWS_Service = new GestorPagosWS_Service();
        GestorPagosWS gestorPagosWS = gestorPagosWS_Service.getGestorPagosWSPort();
        FiltroPagoSinReferencia filtros= new FiltroPagoSinReferencia();
        String formattedDateF="";
        String formattedDateI="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //validamos fechas nulas
        if(fechaFinalIT.getValue()!=null){
            formattedDateF = formatter.format(new Date(fechaFinalIT.getValue().toString()));
            filtros.setFechaFinal(formattedDateF);
        }else{
            filtros.setFechaFinal("");
        } 
        if(fechaFinalIT.getValue()!=null){
            formattedDateI = formatter.format(new Date(fechaInicialIT.getValue().toString()));
            filtros.setFechaInicial(formattedDateI);
        }else{
            filtros.setFechaInicial("");
        }
        //validamos cuenta bancaria nula
        if(cuentaBancariaIT.getValue() != null){
            filtros.setCuentaBancaria(cuentaBancariaIT.getValue().toString());    
        }else{
            filtros.setCuentaBancaria("");              
        }
        //validamos checkbox para pagos aplicados
        if(aplicadosCB.isSelected()){
            filtros.setMostrarAplicar("");
            this.activaITx=true;
        }else{
            filtros.setMostrarAplicar("NO");
            this.activaITx=false;
        }
        System.out.println(usuario);
        filtros.setUsuario(usuario);
        RespuestaPagoSinReferencia respuestaPagos = gestorPagosWS.consultarPagosSinReferencia(filtros);
        System.out.println(respuestaPagos.getLineas().size());
        for(LineaEstadoCuentaDTO linea: respuestaPagos.getLineas()){
            PagoSinReferenciaVO pagos= new PagoSinReferenciaVO();
            pagos.setCuentaBancaria(""+linea.getCuentaBancaria());
            pagos.setFecha(linea.getFecha());                
            pagos.setMoneda(null);
            pagos.setMonto(""+linea.getMonto());
            pagos.setTipoDeposito(linea.getTipoDeposito());
            pagos.setConceptoDeposito(null);
            pagos.setIdPago(linea.getIdPago().toString());
            //datos para pagos manual aplicados
            if(aplicadosCB.isSelected()){
                    pagos.setUnidadDeNegocio(linea.getOrgID());
                    pagos.setProyecto(linea.getProyecto()==null?null:linea.getProyecto().toString());
                    pagos.setCliente(linea.getCliente());
                    pagos.setNCuenta(linea.getIdPago().toString());    
                }
            
            //pagos.setNumeroRecibo(linea.get);
            this.pagosVO.add(pagos);
        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        System.out.println("Actualizando boton");
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setRespuesta(RespuestaAplicarPagoDTO respuesta) {
        this.respuesta = respuesta;
    }

    public RespuestaAplicarPagoDTO getRespuesta() {
        return respuesta;
    }
    
    public void setActivaITx(boolean activaITx) {
        this.activaITx = activaITx;
    }

    public boolean isActivaITx() {
        return activaITx;
    }

    public String validarP_Action() {
        // Add event code here...
        //pagosAplicar = new ArrayList();
        System.out.println("validando pagos");
        for(PagoSinReferenciaVO pagos:pagosVO){
            if(pagos.getLineaDeCaptura()!=null || pagos.getReferencia()!=null){
                GestorPagosWS_Service gestorPagosWS_Service = new GestorPagosWS_Service();
                GestorPagosWS gestorPagosWS = gestorPagosWS_Service.getGestorPagosWSPort();
                PeticionExistente peticion = new PeticionExistente();
                peticion.setIdPago(new BigInteger(pagos.getIdPago()));
                peticion.setLineaCaptura(pagos.getLineaDeCaptura()==null?"":pagos.getLineaDeCaptura());
                //peticion.setNumeroRecibo(new BigInteger(pagos.getNumeroRecibo()));
                peticion.setReferencia(pagos.getReferencia()==null?"":pagos.getReferencia());
                RespuestaClienteDTO respuesta= gestorPagosWS.consultarReferenciaLCExistente(peticion);
                System.out.println(respuesta.getProceso().getDescripcion());
                if(respuesta.getProceso().getDescripcion().equals("EXITOSO")){
                    if(respuesta.getIdPago()!=null){
                            pagos.setUnidadDeNegocio(respuesta.getUnidadNegocio());
                            pagos.setProyecto(respuesta.getProyectoID().toString());
                            pagos.setCliente(respuesta.getCliente());
                            //pagos.setNCuenta(a);
                            //pagos.setInlineStyle(inlineStyle);
                            //pagosAplicar.add(pagos);
                        }          
                }
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public String aplicarB_Action() {
        GestorPagosWS_Service gestorPagosWS_Service = new GestorPagosWS_Service();
        GestorPagosWS gestorPagosWS = gestorPagosWS_Service.getGestorPagosWSPort();
        AplicarPagoDTO aplicarPago = new AplicarPagoDTO();
        List<PagoPorAplicarDTO> pagoList=new ArrayList();
        //aplicarPago.
        if(pagosAplicarVO==null){
            return null;
            }
        for(PagoSinReferenciaVO pago :pagosAplicarVO){
            PagoPorAplicarDTO apago=new PagoPorAplicarDTO();
            //apago.setIdEdoCuenta(pago.get);
            apago.setIdLineaCaputura(pago.getLineaDeCaptura()==null?null:new BigInteger(pago.getLineaDeCaptura()));
            apago.setIdPago(pago.getIdPago()==null?new BigInteger("0"):new BigInteger(pago.getIdPago()));
            apago.setReferencia(pago.getReferencia());
            //apago.setTermino(pago.gett);
            pagoList.add(apago);
        }
        aplicarPago.setPagoPorAplicar(pagoList);
        respuesta = gestorPagosWS.aplicarPagoManual(aplicarPago);
        Collection<PagoSinReferenciaVO> toDelete = new ArrayList<PagoSinReferenciaVO>();
        if(respuesta.getAplicarPago()!=null){
                
                for(PagoPorAplicarDTO pago:respuesta.getAplicarPago().getPagoPorAplicar()){
                    System.out.println(pago.getTermino());
                    for(PagoSinReferenciaVO pagoVo :pagosVO){
                        if(pagoVo.getIdPago().equals(pago.getIdPago().toString()) && pago.getTermino().toString().equals("0")){
                            toDelete.add(pagoVo);
                            System.out.println("se remueve pago");
                        }else if(pagoVo.getIdPago().equals(pago.getIdPago().toString())){
                                pagoVo.setInlineStyle("background-color:#f74c1e;");
                            }
                    }
                }
            }
        //RichPopup.PopupHints hints = new RichPopup.PopupHints();
       // p1.show(hints);
        pagosVO.removeAll(toDelete);
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }
            
    public String b2_action() {
        pagosAplicarVO = new ArrayList();
        GestorPagosWS_Service gestorPagosWS_Service = new GestorPagosWS_Service();
        GestorPagosWS gestorPagosWS = gestorPagosWS_Service.getGestorPagosWSPort();
        
        RespuestaClienteDTO consulta = new RespuestaClienteDTO();
        aplicarPago = new AplicarPagoDTO();
        List<PagoPorAplicarDTO> pagoPorAplicar = new ArrayList();
        try{
            for( PagoSinReferenciaVO linea :pagosVO){
                PeticionExistente filtros = new PeticionExistente();
                String referencia = linea.getReferencia();
                String LC = linea.getLineaDeCaptura();
                if(referencia !=null || LC != null){
                    filtros.setReferencia(linea.getReferencia());
                    filtros.setLineaCaptura(linea.getLineaDeCaptura()==null?"":linea.getLineaDeCaptura());
                    consulta = gestorPagosWS.consultarReferenciaLCExistente(filtros);
                    if(consulta.getIdPago()!=null){
                        pagosAplicarVO.add(linea);
                        PagoPorAplicarDTO pagoDTO = new PagoPorAplicarDTO();
                        linea.setUnidadDeNegocio(consulta.getUnidadNegocio());
                        linea.setProyecto(consulta.getProyectoID()==null?"":""+consulta.getProyectoID());
                        linea.setCliente(consulta.getCliente());
                        linea.setNCuenta(linea.getIdPago());
                        //pagoDTO.setIdEdoCuenta(linea.get);
                        linea.setInlineStyle("background-color:#4bf50c;");
                        //pagoDTO.setIdLineaCaputura(new BigInteger(linea.getLineaDeCaptura()==null?"0":linea.getLineaDeCaptura()));
                        //pagoDTO.setIdPago(new BigInteger(linea.getIdPago()==null?"0":linea.getIdPago()));
                        //pagoDTO.setReferencia(linea.getReferencia());
                        //pagoPorAplicar.add(pagoDTO);
                    }else{
                        linea.setInlineStyle("background-color:#f74c1e;");
                    }
                } 
            //aplicarPago.setPagoPorAplicar(pagoPorAplicar);
        }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        return null;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setD2(RichDialog d2) {
        this.d2 = d2;
    }

    public RichDialog getD2() {
        return d2;
    }


    public void cuentaBancariaT_value(ClientEvent clientEvent) {
        // Add event code here...
        if(cuentaBancariaIT.getValue() != null && cuentaBancariaIT.getValue().toString().length() >=3){
                CatalogoWS_Service catalogoWS_Service = new CatalogoWS_Service();
                CatalogoWS catalogoWS = catalogoWS_Service.getCatalogoWSPort();
                
                System.out.println("press1");    
            }
    }
    
    public List getSuggestions(String input) {

         // create a new list to hold matching items
         List<SelectItem> items = new ArrayList<SelectItem>();
         CatalogoWS_Service catalogoWS_Service = new CatalogoWS_Service();
         CatalogoWS catalogoWS = catalogoWS_Service.getCatalogoWSPort();
         if(cuentaBancariaIT.getValue().toString().length()<3){
             items.add(new SelectItem("","Type in three or more characters..","",true));
         }else{
             List<CuentaBancariaDTO> cuentas = catalogoWS.consultarCuentaBancaria(cuentaBancariaIT.getValue().toString());
             for(CuentaBancariaDTO cuenta:cuentas){
                 items.add(new SelectItem(cuenta.getNumeroCuenta()));
             }    
         }
         //items.add(new SelectItem("Sydney"));
         return items;
     }

    public void setVp1(UIParameter vp1) {
        this.vp1 = vp1;
    }

    public UIParameter getVp1() {
        return vp1;
    }
}
