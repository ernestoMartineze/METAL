/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author Ernesto
 */
public class TransactionInterfaceLineDffDTO {
    
    private String __FLEX_Context;
    private String __FLEX_Context_DisplayValue;
    private String _FLEX_NumOfSegments;
    private String orderNumber;
    private String orderLineNumber;

    // Getter Methods 

    public String get__FLEX_Context() {
     return __FLEX_Context;
    }

    public String get__FLEX_Context_DisplayValue() {
     return __FLEX_Context_DisplayValue;
    }

    public String get_FLEX_NumOfSegments() {
     return _FLEX_NumOfSegments;
    }

    public String getOrderNumber() {
     return orderNumber;
    }

    public String getOrderLineNumber() {
     return orderLineNumber;
    }


    // Setter Methods 

    public void set__FLEX_Context(String __FLEX_Context) {
     this.__FLEX_Context = __FLEX_Context;
    }

    public void set__FLEX_Context_DisplayValue(String __FLEX_Context_DisplayValue) {
     this.__FLEX_Context_DisplayValue = __FLEX_Context_DisplayValue;
    }

    public void set_FLEX_NumOfSegments(String _FLEX_NumOfSegments) {
     this._FLEX_NumOfSegments = _FLEX_NumOfSegments;
    }

    public void setOrderNumber(String orderNumber) {
     this.orderNumber = orderNumber;
    }

    public void setOrderLineNumber(String orderLineNumber) {
     this.orderLineNumber = orderLineNumber;
    }
}
