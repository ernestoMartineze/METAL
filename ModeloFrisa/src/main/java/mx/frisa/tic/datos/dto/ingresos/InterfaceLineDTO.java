/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import org.eclipse.persistence.oxm.annotations.XmlPath;

/**
 *
 * @author Ernesto
 */
public class InterfaceLineDTO {
    
    private String OrgId;
    private String OrigSystemBatchName;
    private String BillCustomerAccountNumber;
    private String BillCustomerSiteNumber;
    private String TrxDate;
    private String Description;
    private String CurrencyCode;
    private String BatchSourceName;
    private String CustomerTrxTypeName;
    private String GlDate;
    private String LineType;
    private String MemoLineName;
    private String Quantity;
    private String TaxCode;
    private String PaymentTermsName;
    private String unitSellingPrice;
    private String UnitSellingPriceObjectCurrencyCode;
    private TransactionInterfaceLineDffDTO TransactionInterfaceLineDffObject;
    private TransactionLineDffDTO TransactionLineDffObject;
    private TransactionInterfaceHeaderDffDTO TransactionInterfaceHeaderDffObject;


    // Getter Methods 

    public String getOrgId() {
     return OrgId;
    }

    public String getOrigSystemBatchName() {
     return OrigSystemBatchName;
    }

    public String getBillCustomerAccountNumber() {
     return BillCustomerAccountNumber;
    }

    public String getBillCustomerSiteNumber() {
     return BillCustomerSiteNumber;
    }

    public String getTrxDate() {
     return TrxDate;
    }

    public String getDescription() {
     return Description;
    }

    public String getCurrencyCode() {
     return CurrencyCode;
    }

    public String getBatchSourceName() {
     return BatchSourceName;
    }

    public String getCustomerTrxTypeName() {
     return CustomerTrxTypeName;
    }

    public String getGlDate() {
     return GlDate;
    }

    public String getLineType() {
     return LineType;
    }

    public String getMemoLineName() {
     return MemoLineName;
    }

    public String getQuantity() {
     return Quantity;
    }

    public String getTaxCode() {
     return TaxCode;
    }

    public String getPaymentTermsName() {
     return PaymentTermsName;
    }

    public String getUnitSellingPrice() {
     return unitSellingPrice;
    }

    public TransactionInterfaceLineDffDTO getTransactionInterfaceLineDff() {
     return TransactionInterfaceLineDffObject;
    }

    public TransactionLineDffDTO getTransactionLineDff() {
     return TransactionLineDffObject;
    }

    public TransactionInterfaceHeaderDffDTO getTransactionInterfaceHeaderDff() {
     return TransactionInterfaceHeaderDffObject;
    }


    // Setter Methods 

    public void setOrgId(String OrgId) {
     this.OrgId = OrgId;
    }

    public void setOrigSystemBatchName(String OrigSystemBatchName) {
     this.OrigSystemBatchName = OrigSystemBatchName;
    }

    public void setBillCustomerAccountNumber(String BillCustomerAccountNumber) {
     this.BillCustomerAccountNumber = BillCustomerAccountNumber;
    }

    public void setBillCustomerSiteNumber(String BillCustomerSiteNumber) {
     this.BillCustomerSiteNumber = BillCustomerSiteNumber;
    }

    public void setTrxDate(String TrxDate) {
     this.TrxDate = TrxDate;
    }

    public void setDescription(String Description) {
     this.Description = Description;
    }

    public void setCurrencyCode(String CurrencyCode) {
     this.CurrencyCode = CurrencyCode;
    }

    public void setBatchSourceName(String BatchSourceName) {
     this.BatchSourceName = BatchSourceName;
    }

    public void setCustomerTrxTypeName(String CustomerTrxTypeName) {
     this.CustomerTrxTypeName = CustomerTrxTypeName;
    }

    public void setGlDate(String GlDate) {
     this.GlDate = GlDate;
    }

    public void setLineType(String LineType) {
     this.LineType = LineType;
    }

    public void setMemoLineName(String MemoLineName) {
     this.MemoLineName = MemoLineName;
    }

    public void setQuantity(String Quantity) {
     this.Quantity = Quantity;
    }

    public void setTaxCode(String TaxCode) {
     this.TaxCode = TaxCode;
    }

    public void setPaymentTermsName(String PaymentTermsName) {
     this.PaymentTermsName = PaymentTermsName;
    }

    public void setUnitSellingPrice(String unitSellingPrice) {
     this.unitSellingPrice = unitSellingPrice;
    }

    public void setTransactionInterfaceLineDff(TransactionInterfaceLineDffDTO TransactionInterfaceLineDffObject) {
     this.TransactionInterfaceLineDffObject = TransactionInterfaceLineDffObject;
    }

    public void setTransactionLineDff(TransactionLineDffDTO TransactionLineDffObject) {
     this.TransactionLineDffObject = TransactionLineDffObject;
    }

    public void setTransactionInterfaceHeaderDff(TransactionInterfaceHeaderDffDTO TransactionInterfaceHeaderDffObject) {
     this.TransactionInterfaceHeaderDffObject = TransactionInterfaceHeaderDffObject;
    }

    public String getUnitSellingPriceObjectCurrencyCode() {
        return UnitSellingPriceObjectCurrencyCode;
    }

    @XmlPath("unitSellingPrice/@currencyCode")
    public void setUnitSellingPriceObjectCurrencyCode(String UnitSellingPriceObjectCurrencyCode) {
        this.UnitSellingPriceObjectCurrencyCode = UnitSellingPriceObjectCurrencyCode;
    }

}
