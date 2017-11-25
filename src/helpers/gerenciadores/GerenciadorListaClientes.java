/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.gerenciadores;

import cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class GerenciadorListaClientes implements IGerenciador<Cliente>{
    private final List<Cliente> _listaCliente;
    private static GerenciadorListaClientes INSTANCE;

    private GerenciadorListaClientes() {
        this._listaCliente = new ArrayList<>();
    }
    
    public static GerenciadorListaClientes getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GerenciadorListaClientes();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Cliente element) {
        return this._listaCliente.add(element);
    }

    @Override
    public boolean remove(Cliente element) {
        return this._listaCliente.remove(element);
    }

    @Override
    public boolean update(Cliente elemnt) {
        int index = this.getIndexById(elemnt.getId());
        if(index < 0){
            return false;
        }
        Cliente aux = this._listaCliente.set(index, elemnt);
        return null != aux;
    }

    @Override
    public Cliente getById(long id) {
        for(Cliente client : this._listaCliente){
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }

    @Override
    public Cliente getByIndex(int index) {
        return this._listaCliente.get(index);
    }

    @Override
    public List<Cliente> getAll() {
        return this._listaCliente;
    }

    @Override
    public int getIndexById(long id) {
        for(int x = 0; x < this._listaCliente.size(); x++){
            if(this._listaCliente.get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    @Override
    public long getIdByIndex(int index) {
        return this._listaCliente.get(index).getId();
    }
    
}
