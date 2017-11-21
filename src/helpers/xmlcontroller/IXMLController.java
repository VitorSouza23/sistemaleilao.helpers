/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.xmlcontroller;

/**
 *
 * @author Vitor
 * @param <T>
 */
public interface IXMLController<T> {
    public String toXML(T object);
    public T fromXML(String xml);
}
