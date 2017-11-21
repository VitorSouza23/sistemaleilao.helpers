/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.xmlcontroller;

import com.thoughtworks.xstream.XStream;
/**
 *
 * @author Vitor
 * @param <T>
 */
public class XMLController<T> implements IXMLController<T>{
    private final XStream xstream;

    public XMLController() {
        this.xstream = new XStream();
    }

    @Override
    public String toXML(T object) {
        return this.xstream.toXML(object);
    }

    @Override
    public T fromXML(String xml) {
        return (T)this.xstream.fromXML(xml);
    }
    
    
}
