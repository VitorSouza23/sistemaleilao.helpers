/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.webservice;

import java.util.ArrayList;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public interface IWebServiceHelper {
    public void addProduto(Produto produto);
    public void removeProduto(Produto produto);
    public void upadateProduto(Produto produto);
    public Produto getProdutoById(long id);
    public void preencherListaDeProdutos();
    public ArrayList<Produto> getAllProdutos();
}
