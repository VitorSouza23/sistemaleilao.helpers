/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.gerenciadores;

import java.util.List;

/**
 *
 * @author Vitor
 */
public interface IGerenciador<T> {
    public boolean add(T element);
    public boolean remove(T element);
    public boolean update(T elemnt);
    public T getById(long id);
    public T getByIndex(int index);
    public List<T> getAll();
    public int getIndexById(long id);
    public long getIdByIndex(int index);
}
