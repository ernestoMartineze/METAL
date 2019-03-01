package mx.frisa.tic.view.backing;

import mx.frisa.tic.negocio.ws.GestorFacturasWS;
import mx.frisa.tic.negocio.ws.GestorFacturasWS_Service;
import mx.frisa.tic.negocio.ws.GestorLineaCapturaWS;
import mx.frisa.tic.negocio.ws.GestorLineaCapturaWS_Service;
import mx.frisa.tic.negocio.ws.LcFactDetDTO;
import mx.frisa.tic.negocio.ws.RespuestaLCFactDetDTO;
import mx.frisa.tic.negocio.ws.RespuestaDetalleLCPagosDTO;
import mx.frisa.tic.negocio.ws.DetalleLCPagosDTO;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import java.util.List;

import oracle.adf.view.rich.context.AdfFacesContext;

public class ClienteDocumento {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichCommandButton cb1;
    private RichMessages m1;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr4;
    private RichGridCell gc4;
    private RichGridCell gc5;

    private GestorLineaCapturaWS_Service gestorLineaCapturaWS_Service;
    private GestorLineaCapturaWS gestorLineaCapturaWS;
    private GestorFacturasWS_Service gestorFacturasWS_Service ;
    private GestorFacturasWS gestorFacturasWS ;
    private String cliente, cuenta, centroCostos, entidadLegal, unidadNegocio;
    private List<LcFactDetDTO> facturasDetalle;
    private List<DetalleLCPagosDTO> detallePagos;
    private RichTable t3;
    private RichTable t4;

    public ClienteDocumento() {
        gestorLineaCapturaWS_Service = new GestorLineaCapturaWS_Service();
        gestorLineaCapturaWS = gestorLineaCapturaWS_Service.getGestorLineaCapturaWSPort();
        gestorFacturasWS_Service = new GestorFacturasWS_Service();
        gestorFacturasWS = gestorFacturasWS_Service.getGestorFacturasWSPort();
    }


    public void setDetallePagos(List<DetalleLCPagosDTO> detallePagos) {
        this.detallePagos = detallePagos;
    }

    public List<DetalleLCPagosDTO> getDetallePagos() {
        return detallePagos;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setEntidadLegal(String entidadLegal) {
        this.entidadLegal = entidadLegal;
    }

    public String getEntidadLegal() {
        return entidadLegal;
    }

    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
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


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }


    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }


    public void setFacturasDetalle(List<LcFactDetDTO> facturasDetalle) {
        this.facturasDetalle = facturasDetalle;
    }

    public List<LcFactDetDTO> getFacturasDetalle() {
        return facturasDetalle;
    }


   /* public void t1_selectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        Object selectedRowData = t1.getSelectedRowData();
        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)selectedRowData;
        System.out.println("Selected values " + nodeBinding.getAttributeValues()[10]);
        Object lineaCaptura = nodeBinding.getAttributeValues()[14];
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("facturaERP", lineaCaptura);
        //Object result = operationBinding.execute();
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("Error");
        }
    }*/
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
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


    public String buscarLineas_action() {
        RespuestaLCFactDetDTO respuestaLcFacturas = gestorLineaCapturaWS.consultaLCFactDet(cliente, cuenta, centroCostos, entidadLegal, unidadNegocio);
        System.out.println(cliente+ 
                           cuenta+ centroCostos+ entidadLegal+unidadNegocio);
        facturasDetalle =respuestaLcFacturas.getLcFactDetalle();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        /*BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaLCFactDet");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }*/
        return null;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void t3_selectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        Object selectedRowData = t3.getSelectedRowData();
        LcFactDetDTO facturaDetalle = (LcFactDetDTO) selectedRowData;
        RespuestaDetalleLCPagosDTO respuesta = gestorLineaCapturaWS.consultaDetalleLCPagos(facturaDetalle.getRelatederpinvoice());
         detallePagos = respuesta.getDetalleLCPagos();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
        
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }
}
