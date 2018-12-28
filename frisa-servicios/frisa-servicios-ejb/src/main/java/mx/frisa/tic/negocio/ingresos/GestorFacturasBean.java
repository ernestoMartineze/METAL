/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.InterfaceLineDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.ProcessInterfaceLineDTO;
import mx.frisa.tic.datos.dto.ingresos.TransactionInterfaceHeaderDffDTO;
import mx.frisa.tic.datos.dto.ingresos.TransactionInterfaceLineDffDTO;
import mx.frisa.tic.datos.dto.ingresos.TransactionLineDffDTO;
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
    public List<ProcessInterfaceLineDTO> consultarDetalleFactura(String idBatch) {
        DAO<XxfrDetalleFactura> detalleFacturaDAO = new DAO(XxfrDetalleFactura.class);
        List<ProcessInterfaceLineDTO> processInterfaceLineDTO = new ArrayList<ProcessInterfaceLineDTO>();
        List<XxfrDetalleFactura> detalleFacturas = new ArrayList<>();
        List<CatalogoParametroDTO> parametros =new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        parametros.add(new CatalogoParametroDTO("idbatch",idBatch,"CADENA"));
        detalleFacturas = detalleFacturaDAO.consultaQueryByParameters("XxfrDetalleFactura.findByIdbatch",parametros);
        System.out.println("busqueda = "+detalleFacturas.size());
        for (XxfrDetalleFactura detalleFactura : detalleFacturas) {
            
            TransactionInterfaceLineDffDTO TransactionInterfaceLineDff = new TransactionInterfaceLineDffDTO();
            TransactionInterfaceLineDff.setOrderLineNumber(""+detalleFactura.getOrderlinenumber());
            TransactionInterfaceLineDff.setOrderNumber(detalleFactura.getOrdernumber());
            TransactionInterfaceLineDff.set_FLEX_NumOfSegments(detalleFactura.getFlexNumofsegments());
            TransactionInterfaceLineDff.set__FLEX_Context(detalleFactura.getFlexContext());
            TransactionInterfaceLineDff.set__FLEX_Context_DisplayValue(detalleFactura.getFlexContextDisplayvalue());
            
            TransactionLineDffDTO TransactionLineDff = new TransactionLineDffDTO();
            TransactionLineDff.setDescripciOnAdicional1(detalleFactura.getDescripcionadicional1());
            TransactionLineDff.setDescripciOnAdicional2(detalleFactura.getDescripcionadicional2());
            TransactionLineDff.setDescripciOnAdicional3(detalleFactura.getDescripcionadicional3());
            TransactionLineDff.setDescripciOnAdicional4(detalleFactura.getDescripcionadicional4());
            TransactionLineDff.setDescripciOnAdicional5(detalleFactura.getDescripcionadicional5());
            TransactionLineDff.setPeriodoDeFacturacionDesde(formatter.format(detalleFactura.getPeriododefacturaciondesde()));
            TransactionLineDff.setPeriodoDeFacturacionHasta(formatter.format(detalleFactura.getPeriododefacturacionhasta()));
            TransactionLineDff.setSiguienteFechaDeExigibilidad(formatter.format(detalleFactura.getSiguientefechadeexigibilidad()));
            TransactionLineDff.set__FLEX_Context(detalleFactura.getFlexContext1());
            
            TransactionInterfaceHeaderDffDTO TransactionInterfaceHeaderDff = new TransactionInterfaceHeaderDffDTO();
            TransactionInterfaceHeaderDff.setAddendaid(detalleFactura.getAddendaid());
            TransactionInterfaceHeaderDff.setFacturaUnifier(detalleFactura.getFacturaunifier());
            TransactionInterfaceHeaderDff.setFolio(detalleFactura.getFolio());
            TransactionInterfaceHeaderDff.setLineaDeCaptura(detalleFactura.getLineadecaptura());
            TransactionInterfaceHeaderDff.setNUmeroDeLocal(detalleFactura.getNumerodelocal());
            TransactionInterfaceHeaderDff.setNumeroDeContrato(""+detalleFactura.getNumerodecontrato());
            TransactionInterfaceHeaderDff.setProyecto(""+detalleFactura.getProyecto());
            TransactionInterfaceHeaderDff.setSerie(detalleFactura.getSerie());
            TransactionInterfaceHeaderDff.set__FLEX_Context(detalleFactura.getFlexContext2());
            
            InterfaceLineDTO interfaceLine = new InterfaceLineDTO();
            interfaceLine.setOrgId(detalleFactura.getOrgid());
            interfaceLine.setBatchSourceName(detalleFactura.getBatchsourcename());
            interfaceLine.setBillCustomerAccountNumber(detalleFactura.getBillcustomeraccountnumber());
            interfaceLine.setBillCustomerSiteNumber(""+detalleFactura.getBillcustomersitenumber());
            interfaceLine.setCurrencyCode(detalleFactura.getCurrencycode());
            interfaceLine.setCustomerTrxTypeName(detalleFactura.getCustomertrxtypename());
            interfaceLine.setDescription(detalleFactura.getDescription());
            interfaceLine.setGlDate(formatter.format(detalleFactura.getGldate()));
            interfaceLine.setLineType(detalleFactura.getLinetype());
            interfaceLine.setMemoLineName(detalleFactura.getMemolinename());
            interfaceLine.setOrigSystemBatchName(detalleFactura.getOrigsystembatchname());
            interfaceLine.setPaymentTermsName(detalleFactura.getPaymenttermsname());
            interfaceLine.setQuantity(""+detalleFactura.getQuantity());
            interfaceLine.setTaxCode(detalleFactura.getTaxcode());
            interfaceLine.setTrxDate(formatter.format(detalleFactura.getTrxdate()));
            interfaceLine.setUnitSellingPrice(detalleFactura.getUnitsellingprice());
            interfaceLine.setUnitSellingPriceObjectCurrencyCode(detalleFactura.getCurrencycode());
            interfaceLine.setTransactionInterfaceHeaderDff(TransactionInterfaceHeaderDff);
            interfaceLine.setTransactionInterfaceLineDff(TransactionInterfaceLineDff);
            interfaceLine.setTransactionLineDff(TransactionLineDff);
            
            ProcessInterfaceLineDTO processInterfaceLine = new ProcessInterfaceLineDTO();
            processInterfaceLine.setInterfaceLine(interfaceLine);
            
            System.out.println(processInterfaceLine.getInterfaceLine().getBatchSourceName());
            //Agregar los valores necesarios requeridos....
            processInterfaceLineDTO.add(processInterfaceLine);

        }
        return processInterfaceLineDTO;
    }
    
    
}
