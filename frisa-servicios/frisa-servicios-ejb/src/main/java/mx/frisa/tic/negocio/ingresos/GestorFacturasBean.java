/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.Cabecera_FacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaLCDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaDTO;
import mx.frisa.tic.datos.dto.ingresos.Lineas_FacturaDTO;
import mx.frisa.tic.datos.entidades.XxfrDetalleFactura;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcFactura;

/**
 *
 * @author Ernesto
 */
@Stateless(name = "GestorFacturasBean")
@LocalBean
public class GestorFacturasBean implements GestorFacturas{

    @Override
    public List<LCFacturaDTO> consultarLCFactura(String facturaERp) {
        
        DAO<XxfrvConsultaLcFactura> lcFacturaDAO = new DAO(XxfrvConsultaLcFactura.class);
        List<LCFacturaDTO> lcFacturasDTO = new ArrayList<LCFacturaDTO>();
        List<XxfrvConsultaLcFactura> lcFacturas = new ArrayList<>();
        if(facturaERp!=null && !facturaERp.equals("")){
            List<CatalogoParametroDTO> parametros =new ArrayList<>();
            parametros.add(new CatalogoParametroDTO("idlineacaptura",facturaERp,"CADENA"));
            lcFacturas = lcFacturaDAO.consultaQueryByParameters("XxfrvConsultaLcFactura.findByIdlineacaptura",parametros);
        }


        for (XxfrvConsultaLcFactura lcFacturaRespuesta : lcFacturas) {
            LCFacturaDTO lcFacturaDTO = new LCFacturaDTO();
            lcFacturaDTO.setBilltoconsumername(lcFacturaRespuesta.getBilltoconsumername());
            lcFacturaDTO.setCompanyaccountcode(lcFacturaRespuesta.getCompanyaccountcode());
            lcFacturaDTO.setIdfacturaprimavera(lcFacturaRespuesta.getIdfacturaprimavera());
            lcFacturaDTO.setIdlineacaptura(lcFacturaRespuesta.getIdlineacaptura());
            lcFacturaDTO.setLinenumber(lcFacturaRespuesta.getLinenumber());
            lcFacturaDTO.setMontobrutolinea(lcFacturaRespuesta.getMontobrutolinea());
            lcFacturaDTO.setPaymenttermdate(lcFacturaRespuesta.getPaymenttermdate());
            lcFacturaDTO.setProjectid(lcFacturaRespuesta.getProjectid());
            lcFacturaDTO.setRelatederpinvoice(lcFacturaRespuesta.getRelatederpinvoice());
            lcFacturaDTO.setTaxrate(lcFacturaRespuesta.getTaxrate());
            lcFacturaDTO.setTotalamount(lcFacturaRespuesta.getTotalamount());
            //Agregar los valores necesarios requeridos....
            lcFacturasDTO.add(lcFacturaDTO);

        }
        return lcFacturasDTO;
    }

    @Override
    public List<FacturaLCDTO> consultarDetalleFactura(String idBatch) {
        DAO<XxfrDetalleFactura> detalleFacturaDAO = new DAO(XxfrDetalleFactura.class);
        List<FacturaLCDTO> Factura_LC = new ArrayList<FacturaLCDTO>();
        List<XxfrDetalleFactura> detalleFacturas = new ArrayList<>();
        List<CatalogoParametroDTO> parametros =new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        parametros.add(new CatalogoParametroDTO("idbatch",idBatch,"CADENA"));
        detalleFacturas = detalleFacturaDAO.consultaQueryByParameters("XxfrDetalleFactura.findByIdbatch",parametros);
//        System.out.println("busqueda = "+detalleFacturas.size());
        for (XxfrDetalleFactura detalleFactura : detalleFacturas) {
//            System.out.println("detalleFactura.getDescripmanual()"+ detalleFactura.getDescripmanual());
            LineaDTO linea = new LineaDTO();
            linea.setDescripManual(detalleFactura.getDescripmanual());
            linea.setDescripOrigen(detalleFactura.getDescriporigen());
            linea.setDescripciOnAdicional1(detalleFactura.getDescripcionadicional1());
            linea.setDescripciOnAdicional2(detalleFactura.getDescripcionadicional2());
            linea.setDescripciOnAdicional3(detalleFactura.getDescripcionadicional3());
            linea.setDescripciOnAdicional4(detalleFactura.getDescripcionadicional4());
            linea.setDescripciOnAdicional5(detalleFactura.getDescripcionadicional5());
            linea.setLineType(detalleFactura.getLinetype());
            linea.setMemoLineName(detalleFactura.getMemolinename());
            linea.setMontoIVALinea(detalleFactura.getMontoivalinea());
            linea.setMontotaxCodeRetIva(detalleFactura.getMontotaxcoderetiva());
            linea.setMontotaxCodoRetISR(detalleFactura.getMontotaxcodoretisr());
            linea.setOrderLineNumber(detalleFactura.getOrderlinenumber());
            linea.setOrderNumber(detalleFactura.getOrdernumber());
            linea.setPeriodoDeFacturacionDesde(formatter.format(detalleFactura.getPeriododefacturaciondesde()));
            linea.setPeriodoDeFacturacionHasta(formatter.format(detalleFactura.getPeriododefacturacionhasta()));
            linea.setQuantity(detalleFactura.getQuantity());
            linea.setSiguienteFechaDeExigibilidad(formatter.format(detalleFactura.getSiguientefechadeexigibilidad()));
            linea.setTaxCode(detalleFactura.getTaxcode());
            linea.setTaxCodeRetIva(detalleFactura.getTaxcoderetiva());
            linea.setTaxCodoRetISR(detalleFactura.getTaxcodoretisr());
            linea.setUnitSellingPrice(detalleFactura.getUnitsellingprice());
            linea.setFlexContext(detalleFactura.getFlexContext());
            linea.setFlexContextDisplayvalue(detalleFactura.getFlexContextDisplayvalue());
            linea.setFlexNumofsegments(detalleFactura.getFlexNumofsegments());
            //Agregar los valores necesarios requeridos....
            int indiceFactura = getIndiceFactura(detalleFactura.getFacturaunifier(), Factura_LC);
            if(indiceFactura == -1){
                Cabecera_FacturaDTO cabecera_Factura = new Cabecera_FacturaDTO();
                cabecera_Factura.setAddendaid(detalleFactura.getAddendaid());
                cabecera_Factura.setBillCustomerAccountNumber(detalleFactura.getBillcustomeraccountnumber());
                cabecera_Factura.setBillCustomerSiteNumber(detalleFactura.getBillcustomersitenumber());
                cabecera_Factura.setBusinessUnit(detalleFactura.getBusinessunit());
                cabecera_Factura.setCurrencyCode(detalleFactura.getCurrencycode());
                cabecera_Factura.setCustomerTrxTypeName(detalleFactura.getCustomertrxtypename());
                cabecera_Factura.setDescription(detalleFactura.getDescription());
                cabecera_Factura.setFacturaUnifier(detalleFactura.getFacturaunifier());
                cabecera_Factura.setGlDate(formatter.format(detalleFactura.getGldate()));
                cabecera_Factura.setLineaDeCaptura(detalleFactura.getLineadecaptura());
                cabecera_Factura.setNumeroDeContrato(detalleFactura.getNumerodecontrato());
                cabecera_Factura.setNumeroDeLocal(detalleFactura.getNumerodelocal());
                cabecera_Factura.setOrgId(detalleFactura.getOrgid());
                cabecera_Factura.setOrigSystemBatchName(detalleFactura.getOrigsystembatchname());
                cabecera_Factura.setPaymentTermsName(detalleFactura.getPaymenttermsname());
                cabecera_Factura.setProyecto(detalleFactura.getProyecto());
                cabecera_Factura.setTrxDate(formatter.format(detalleFactura.getTrxdate()));
                cabecera_Factura.setBatchSourceName(detalleFactura.getBatchsourcename());
                cabecera_Factura.setFolio(detalleFactura.getFolio());
                //Agregar los valores necesarios requeridos....
                
                Lineas_FacturaDTO lineas_Factura = new Lineas_FacturaDTO();
                List<LineaDTO> lineas= new ArrayList<LineaDTO>();
                lineas.add(linea);
                lineas_Factura.setLineaDTO(lineas);
                
                FacturaLCDTO facturaLC = new FacturaLCDTO();
                facturaLC.setCabecera_Factura(cabecera_Factura);
                facturaLC.setLineas_Factura(lineas_Factura);

                Factura_LC.add(facturaLC);
            }else{
                Factura_LC.get(indiceFactura).getLineas_Factura().getLineaDTO().add(linea);
            }
        }
        return Factura_LC;
    }
    
    public int getIndiceFactura(BigInteger idFacturaPrimavera, List<FacturaLCDTO> facturaLC){
        int indice=-1;
        int count=0;
        for(FacturaLCDTO factura :facturaLC){
            if(factura.getCabecera_Factura().getFacturaUnifier() == idFacturaPrimavera){
                indice=count;
            }
            count++;
        }
        return indice;
    }

}
