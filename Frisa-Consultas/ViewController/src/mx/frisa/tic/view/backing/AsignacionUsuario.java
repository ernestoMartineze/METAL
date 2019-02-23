package mx.frisa.tic.view.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import mx.frisa.tic.negocio.ws.AccesoUsuarioDTO;
import mx.frisa.tic.negocio.ws.AgregarUsuarioDTO;
import mx.frisa.tic.negocio.ws.CatalogoWS;
import mx.frisa.tic.negocio.ws.CatalogoWS_Service;
import mx.frisa.tic.negocio.ws.ConsultarAccesoUsuarioDTO;
import mx.frisa.tic.negocio.ws.ConsultarCentroCostosDTO;
import mx.frisa.tic.negocio.ws.ConsultarUniNegocioDTO;
import mx.frisa.tic.negocio.ws.ConsultarUsuarioDTO;
import mx.frisa.tic.negocio.ws.GestorAccesoWS;
import mx.frisa.tic.negocio.ws.GestorAccesoWS_Service;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichActiveOutputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

public class AsignacionUsuario {
    private RichForm f1;
    private RichDocument d1;
    
    private CatalogoWS_Service catalogoWS_Service;
    private CatalogoWS catalogoWS;
    private GestorAccesoWS_Service gestorAccesoWS_Service;
    private GestorAccesoWS gestorAccesoWS;
    private List<SelectItem> itemsUsuarios;
    private List<SelectItem> itemsCentrosC;
    private List<SelectItem> itemsUnidadN;
    private List<AccesoUsuarioDTO> listaAccesos;
    private String idAcceso;
    private String fullname;
    
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichGridRow gr4;
    private RichGridCell gc4;
    private RichGridRow gr5;
    private RichGridCell gc5;
    private RichOutputText ot1;
    private RichSelectOneChoice selectUsuarios;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichTable t1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl3;
    private RichButton b1;
    private RichActiveOutputText aot1;

    public AsignacionUsuario(){
            catalogoWS_Service = new CatalogoWS_Service();
            catalogoWS = catalogoWS_Service.getCatalogoWSPort();
            gestorAccesoWS_Service = new GestorAccesoWS_Service();
            gestorAccesoWS = gestorAccesoWS_Service.getGestorAccesoWSPort();
            getUsernamesWS();
            // Add your code to call the desired methods.
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

    public void setItemsUsuarios(List<SelectItem> itemsUsuarios) {
        this.itemsUsuarios = itemsUsuarios;
    }

    public List<SelectItem> getItemsUsuarios() {
        return itemsUsuarios;
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

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }


    public void setItemsCentrosC(List<SelectItem> itemsCentrosC) {
        this.itemsCentrosC = itemsCentrosC;
    }

    public List<SelectItem> getItemsCentrosC() {
        return itemsCentrosC;
    }

    public void setItemsUnidadN(List<SelectItem> itemsUnidadN) {
        this.itemsUnidadN = itemsUnidadN;
    }

    public List<SelectItem> getItemsUnidadN() {
        return itemsUnidadN;
    }

    public void setSelectUsuarios(RichSelectOneChoice selectUsuarios) {
        this.selectUsuarios = selectUsuarios;
    }

    public RichSelectOneChoice getSelectUsuarios() {
        return selectUsuarios;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }
    
    public void getUsernamesWS(){
            itemsUsuarios = new ArrayList();
            itemsCentrosC = new ArrayList();
            itemsUnidadN = new ArrayList();
            List<ConsultarUsuarioDTO> usuarios = catalogoWS.consultarUsuarios("");
            for(ConsultarUsuarioDTO usuario: usuarios){
                    itemsUsuarios.add(new SelectItem(usuario.getUsername()));
                }
            List<ConsultarCentroCostosDTO> centrosC = catalogoWS.consultarCentroCostos("");
            for( ConsultarCentroCostosDTO centro: centrosC){
                    itemsCentrosC.add(new SelectItem(centro.getFlexValue()));
                }
            List<ConsultarUniNegocioDTO> unidadesN = catalogoWS.consultarUnidadNegocio("");
            for( ConsultarUniNegocioDTO unidad :unidadesN){
                    itemsUnidadN.add(new SelectItem(unidad.getCveBu()));
                }
        }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setListaAccesos(List<AccesoUsuarioDTO> listaAccesos) {
        this.listaAccesos = listaAccesos;
    }

    public List<AccesoUsuarioDTO> getListaAccesos() {
        return listaAccesos;
    }

    public void soc1_attributeChangeListener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...
        //ConsultarAccesoUsuarioDTO consultaAcceso = gestorAccesoWS.consultarAccesos(selectUsuarios.getValue().toString());
        //listaAccesos = consultaAcceso.getAccesos();
        //System.out.println(listaAccesos.size());
        //AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setIdAcceso(String idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getIdAcceso() {
        return idAcceso;
    }

    public void soc1_valueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
      updateAcceso();
        
    }
    
    public void updateAcceso(){
            ConsultarAccesoUsuarioDTO consultaAcceso = gestorAccesoWS.consultarAccesos(selectUsuarios.getValue().toString());
            listaAccesos = consultaAcceso.getAccesos();
            fullname = consultaAcceso.getUsuario();
            System.out.println(fullname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            AdfFacesContext.getCurrentInstance().addPartialTarget(aot1);
        }

    public Object eliminar_action() {
        // Add event code here...
        System.out.println(idAcceso);
        return null;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAot1(RichActiveOutputText aot1) {
        this.aot1 = aot1;
    }

    public RichActiveOutputText getAot1() {
        return aot1;
    }

    public String guardaAcceso_action() {
        // Add event code here...
        AgregarUsuarioDTO usuarioAcceso = new AgregarUsuarioDTO();
        usuarioAcceso.setCentroCostos(soc2.getValue().toString());
        usuarioAcceso.setUnidadNegocio(soc3.getValue().toString());
        usuarioAcceso.setUsuario(selectUsuarios.getValue().toString());
        gestorAccesoWS.agregarUsuario(usuarioAcceso);
        
        updateAcceso();
        return null;
    }
}
