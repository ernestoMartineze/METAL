/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.rupa.servicios.interoperabilidad;

/**
 *
 * @author Ernesto
 */
import javax.xml.bind.annotation.XmlRegistry;
 
@XmlRegistry
public class ObjectFactory {
 
        public ObjectFactory() {
        }
 
        public RespuestaCURP respuestaCURP() {
                return new RespuestaCURP();
        }
}
