/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.geradorid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vitor
 */
public class GeradorId {
    private final Random _geradorId;
    private final List<Long> _listaId;
    private static GeradorId INSTANCE;

    private GeradorId() {
        this._geradorId = new Random();
        this._listaId = new ArrayList<>();
    }
    
    public static GeradorId getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GeradorId();
        }
        return INSTANCE;
    }
    
    public long getNewID(){
        long newID = this._geradorId.nextLong();
        newID = newID < 0 ? -1 * newID : newID;
        for(Long exitedID : this._listaId){
            if(exitedID == newID){
                newID = this.getNewID();
            }
        }
        return newID;
    }
    
    public List<Long> getAllIDs(){
        return _listaId;
    }
    
    public boolean deleteID(long id){
        for(Long aux : this._listaId){
            if(aux == id){
                this._listaId.remove(aux);
                return true;
            }
        }
        return false;
    }
    
}
