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
public class ListaDeProdutosPreCadastrados {
    private ArrayList<Produto> listaDeProdutos;

    public ListaDeProdutosPreCadastrados() {
        this.listaDeProdutos = new ArrayList<>();
        this.listaDeProdutos.add(new Produto("Teste 1", "Descricao 1", 1.2, true));
        this.listaDeProdutos.add(new Produto("Teste 2", "Descricao 2", 1.5, true));
        this.listaDeProdutos.add(new Produto("Teste 5", "Descricao 5", 3.2, true));
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
    
    
}
