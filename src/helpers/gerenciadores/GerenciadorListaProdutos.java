/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.gerenciadores;

import java.util.ArrayList;
import java.util.List;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class GerenciadorListaProdutos implements IGerenciador<Produto>{
    private final List<Produto> _listaProdutos;
    private static GerenciadorListaProdutos INSTANCE;
    
    private GerenciadorListaProdutos() {
        this._listaProdutos = new ArrayList<>();
    }
    
    public static GerenciadorListaProdutos getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GerenciadorListaProdutos();
        }
        return INSTANCE;
    }
    
    @Override
    public boolean add(Produto element) {
        return this._listaProdutos.add(element);
    }

    @Override
    public boolean remove(Produto element) {
        return this._listaProdutos.remove(element);
    }

    @Override
    public boolean update(Produto elemnt) {
        int index = this.getIndexById(elemnt.getId());
        if(index < 0){
            return false;
        }
        Produto aux = this._listaProdutos.set(index, elemnt);
        return null != aux;
    }

    @Override
    public Produto getById(long id) {
        for(Produto produto : this._listaProdutos){
            if(produto.getId() == id){
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto getByIndex(int index) {
        return this._listaProdutos.get(index);
    }

    @Override
    public List<Produto> getAll() {
        return this._listaProdutos;
    }

    @Override
    public int getIndexById(long id) {
        for(int x = 0; x < this._listaProdutos.size(); x++){
            if(this._listaProdutos.get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    @Override
    public long getIdByIndex(int index) {
        return this._listaProdutos.get(index).getId();
    }
    
}
