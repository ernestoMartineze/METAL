package mx.frisa.tic.view.backing;

import mx.frisa.tic.negocio.ws.FiltroPagoSinReferencia;
import mx.frisa.tic.negocio.ws.GestorPagosWS;
import mx.frisa.tic.negocio.ws.GestorPagosWS_Service;
import mx.frisa.tic.negocio.ws.LineaEstadoCuentaDTO;
import mx.frisa.tic.negocio.ws.RespuestaPagoSinReferencia;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

public class PagoSinReferencia {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichInputText it1;
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
    private RichInputDate id1;
    private RichInputDate id2;
    private RichSelectBooleanCheckbox sbc1;
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
    private RichTable t1;
    private RichButton b2;
    private RichButton b3;

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


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
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

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public String buscarP_Action() {
        // Add event code here...
        GestorPagosWS_Service gestorPagosWS_Service = new GestorPagosWS_Service();
        GestorPagosWS gestorPagosWS = gestorPagosWS_Service.getGestorPagosWSPort();
        FiltroPagoSinReferencia filtros= new FiltroPagoSinReferencia();
        
        RespuestaPagoSinReferencia respuestaPagos = gestorPagosWS.consultarPagosSinReferencia(filtros);
        for(LineaEstadoCuentaDTO linea: respuestaPagos.getLineas()){
            System.out.println(linea.getConceptoMovimiento());
            }
        return null;
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

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
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
}
