package mx.frisa.tic.view.backing;

import java.util.Map;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;

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
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichCommandButton cb1;
    private RichTable tablaLC;

    private String idLinea;
    private RichPopup p1;
    private RichDialog d2;
    private RichTable t1;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr4;
    private RichGridCell gc4;
    private RichGridCell gc5;
    private RichTable t2;

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

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
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


    /*public String consultaLCPagos() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }*/


    public void setTablaLC(RichTable tablaLC) {
        this.tablaLC = tablaLC;
    }

    public RichTable getTablaLC() {
        return tablaLC;
    }
    
    


    public void tablaLC_selectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        Object selectedRowData = tablaLC.getSelectedRowData();
        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)selectedRowData;
        System.out.println("Selected values " + nodeBinding.getAttributeValues()[10]);
        Object lineaCaptura = nodeBinding.getAttributeValues()[10];
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultarLCFacturas");
        operationBinding.getParamsMap().put("lineaCaptura", lineaCaptura);
        //Object result = operationBinding.execute();
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("Error");
        }
    }


    public String cb2_action() {
        FacesContext facesContext= FacesContext.getCurrentInstance();
           Map requestMap=facesContext.getExternalContext().getRequestParameterMap();
           System.out.println(requestMap.toString());
        System.out.println(requestMap.values());
        System.out.println(requestMap.get("idLinea"));
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String cb2_action2() {
        // Add event code here...
        System.out.println(idLinea);
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("lineaCaptura", idLinea);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }


    public void setIdLinea(String idLinea) {
        this.idLinea = idLinea;
    }

    public String getIdLinea() {
        return idLinea;
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


    /*        System.out.println(idLinea);
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("lineaCaptura", idLinea);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;*/

    public Object cb2_action3() {
        System.out.println(idLinea);
        System.out.println("press");
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("lineaCaptura", idLinea);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String cb2_action4() {
        // Add event code here...
        System.out.println(idLinea);
        System.out.println("press");
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("lineaCaptura", idLinea);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
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


    public String cb2_action5() {
        // Add event code here...
        System.out.println(idLinea);
        System.out.println("press");
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("consultaDetalleLCPagos");
        operationBinding.getParamsMap().put("facturaERP", idLinea);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }


    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }
}
