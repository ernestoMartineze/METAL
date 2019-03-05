package mx.frisa.tic.view.backing;

import java.util.Map;
import java.util.List;

import javax.faces.context.FacesContext;

import mx.frisa.tic.negocio.ws.DetalleLCPagosDTO;
import mx.frisa.tic.negocio.ws.DetalleLineaCapturaDTO;
import mx.frisa.tic.negocio.ws.GestorFacturasWS;
import mx.frisa.tic.negocio.ws.GestorFacturasWS_Service;
import mx.frisa.tic.negocio.ws.GestorLineaCapturaWS;
import mx.frisa.tic.negocio.ws.GestorLineaCapturaWS_Service;

import mx.frisa.tic.negocio.ws.LcFacturaDTO;
import mx.frisa.tic.negocio.ws.RespuestaDetalleLCPagosDTO;
import mx.frisa.tic.negocio.ws.RespuestaDetalleLineaCapturaDTO;

import mx.frisa.tic.negocio.ws.RespuestaLCFacturaDTO;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;

public class LineaReferencia {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichMessages m1;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichCommandButton cb1;

    private String idERP;
    private RichPopup p1;
    private RichDialog d2;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr4;
    private RichGridCell gc4;
    private RichGridCell gc5;

    private GestorLineaCapturaWS_Service gestorLineaCapturaWS_Service;
    private GestorLineaCapturaWS gestorLineaCapturaWS;
    private GestorFacturasWS_Service gestorFacturasWS_Service ;
    private GestorFacturasWS gestorFacturasWS ;
    private List<DetalleLineaCapturaDTO> detalleLinea;
    private List<LcFacturaDTO> lcFacturas;
    private List<DetalleLCPagosDTO> detalleLCPagos;
    private String lineaCaptura, entidadLegal, referencia, banco, unidadNegocio;
    private RichTable t3;
    private RichPanelGroupLayout pgl4;
    private RichTable t4;
    private RichTable t1;

    public LineaReferencia(){
        gestorLineaCapturaWS_Service = new GestorLineaCapturaWS_Service();
        gestorLineaCapturaWS = gestorLineaCapturaWS_Service.getGestorLineaCapturaWSPort();
        gestorFacturasWS_Service = new GestorFacturasWS_Service();
        gestorFacturasWS = gestorFacturasWS_Service.getGestorFacturasWSPort();
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

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
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

    
    public String buscaFactura(){
        return null;
        }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setLineaCaptura(String lineaCaptura) {
        this.lineaCaptura = lineaCaptura;
    }

    public String getLineaCaptura() {
        return lineaCaptura;
    }

    public void setEntidadLegal(String entidadLegal) {
        this.entidadLegal = entidadLegal;
    }

    public String getEntidadLegal() {
        return entidadLegal;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getBanco() {
        return banco;
    }

    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setIdERP(String idERP) {
        this.idERP = idERP;
    }

    public String getIdERP() {
        return idERP;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }


    public void setD2(RichDialog d2) {
        this.d2 = d2;
    }

    public RichDialog getD2() {
        return d2;
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


    public void setDetalleLinea(List<DetalleLineaCapturaDTO> detalleLinea) {
        this.detalleLinea = detalleLinea;
    }

    public List<DetalleLineaCapturaDTO> getDetalleLinea() {
        return detalleLinea;
    }


    public void setLcFacturas(List<LcFacturaDTO> lcFacturas) {
        this.lcFacturas = lcFacturas;
    }

    public List<LcFacturaDTO> getLcFacturas() {
        return lcFacturas;
    }


    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }


    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }


    public void setDetalleLCPagos(List<DetalleLCPagosDTO> detalleLCPagos) {
        this.detalleLCPagos = detalleLCPagos;
    }

    public List<DetalleLCPagosDTO> getDetalleLCPagos() {
        return detalleLCPagos;
    }

    public void t3_selectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        System.out.println("presiono tabla 3");
        Object selectedRowData = t3.getSelectedRowData();
        DetalleLineaCapturaDTO detalle = (DetalleLineaCapturaDTO) selectedRowData;
        RespuestaLCFacturaDTO respestaLcFactura = gestorFacturasWS.consultarLCFacturas(detalle.getIdlineacaptura().toString());
        lcFacturas = respestaLcFactura.getLcFacturas();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t4);
    }
    
    public String buscarLineas_action() {
        
        RespuestaDetalleLineaCapturaDTO respuestaLinea = gestorLineaCapturaWS.consultaDetalleLineaCaptura(lineaCaptura, entidadLegal, referencia, banco, unidadNegocio);
        detalleLinea = respuestaLinea.getLineasCaptura();
        AdfFacesContext.getCurrentInstance().addPartialTarget(t3);
        return null;
    }
    
    public String cb2_action5() {
        // Add event code here...
        System.out.println(idERP);
        RespuestaDetalleLCPagosDTO respuestaDetallePagos = gestorLineaCapturaWS.consultaDetalleLCPagos(idERP);
        detalleLCPagos = respuestaDetallePagos.getDetalleLCPagos();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }
}
