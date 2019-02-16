package mx.frisa.tic.view.backing;

import mx.frisa.tic.negocio.ws.AgregarUsuarioDTO;
import mx.frisa.tic.negocio.ws.GestorAccesoWS;
import mx.frisa.tic.negocio.ws.GestorAccesoWS_Service;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

public class RegistraUsuario {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichGridRow gr4;
    private RichGridCell gc4;
    private RichInputText usuarioTx;
    private RichInputText centroCostosTx;
    private RichInputText uniNegocioTx;
    private RichButton b1;

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


    public void setUsuarioTx(RichInputText usuarioTx) {
        this.usuarioTx = usuarioTx;
    }

    public RichInputText getUsuarioTx() {
        return usuarioTx;
    }

    public void setCentroCostosTx(RichInputText centroCostosTx) {
        this.centroCostosTx = centroCostosTx;
    }

    public RichInputText getCentroCostosTx() {
        return centroCostosTx;
    }

    public void setUniNegocioTx(RichInputText uniNegocioTx) {
        this.uniNegocioTx = uniNegocioTx;
    }

    public RichInputText getUniNegocioTx() {
        return uniNegocioTx;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public String registrar_action() {
        // Add event code here...
        AgregarUsuarioDTO usuarioAcceso= new AgregarUsuarioDTO();
        usuarioAcceso.setCentroCostos(centroCostosTx.getValue()==null?"":centroCostosTx.getValue().toString());
        usuarioAcceso.setUnidadNegocio(uniNegocioTx.getValue()==null?"":uniNegocioTx.getValue().toString());
        usuarioAcceso.setUsuario(usuarioTx.getValue()==null?"":usuarioTx.getValue().toString());
        GestorAccesoWS_Service gestorAccesoWS_Service = new GestorAccesoWS_Service();
        GestorAccesoWS gestorAccesoWS = gestorAccesoWS_Service.getGestorAccesoWSPort();
        gestorAccesoWS.agregarUsuario(usuarioAcceso);
        return null;
    }
}
