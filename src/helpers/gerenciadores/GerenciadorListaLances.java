/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.gerenciadores;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import lance.Lance;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class GerenciadorListaLances implements IGerenciador<Lance>{
    private final List<Lance> _listaLancesa;
    private static GerenciadorListaLances INSTANCE;

    private GerenciadorListaLances() {
        this._listaLancesa = new ArrayList<>();
    }
    
    public static GerenciadorListaLances getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GerenciadorListaLances();
        }
        return INSTANCE;
    }
    

    @Override
    public boolean add(Lance element) {
        return this._listaLancesa.add(element);
    }

    @Override
    public boolean remove(Lance element) {
        return this._listaLancesa.remove(element);
    }

    @Override
    public boolean update(Lance elemnt) {
        int index = this.getIndexById(elemnt.getId());
        if(index < 0){
            return false;
        }
        Lance aux = this._listaLancesa.set(index, elemnt);
        return null != aux;
    }

    @Override
    public Lance getById(long id) {
        for(Lance lance : this._listaLancesa){
            if(lance.getId() == id){
                return lance;
            }
        }
        return null;
    }

    @Override
    public Lance getByIndex(int index) {
        return this._listaLancesa.get(index);
    }

    @Override
    public List<Lance> getAll() {
        return this._listaLancesa;
    }

    @Override
    public int getIndexById(long id) {
        for(int x = 0; x < this._listaLancesa.size(); x++){
            if(this._listaLancesa.get(x).getId() == id){
                return x;
            }
        }
        return -1;
    }

    @Override
    public long getIdByIndex(int index) {
        return this._listaLancesa.get(index).getId();
    }
    
    public List<Lance> filtrarLancesPorProduto(Produto produto){
        List<Lance> listAux = new ArrayList<>();
        this._listaLancesa.stream().filter((lance) -> (lance.getProduto().getId() == produto.getId())).forEachOrdered((lance) -> {
            listAux.add(lance);
        });
        return listAux;
    }
    
    public Lance getLanceMaisAltoProduto(Produto produto){
        Lance lanceMaisAlto = new Lance();
        for(Lance lance : this._listaLancesa){
            if(lance.getValor() > lanceMaisAlto.getValor()){
                lanceMaisAlto = lance;
            }
        }
        return lanceMaisAlto;
    }
}
