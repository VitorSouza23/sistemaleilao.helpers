/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.webservice;

import java.util.ArrayList;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class WebServiceHelperImpl implements IWebServiceHelper{
    private static long _idCounter = 0;
    private static WebServiceHelperImpl _INSTANCE;
    private final SistemaLeilaoPort_JerseyClient serverce;

    private WebServiceHelperImpl() {
        _idCounter = 0;
        this.serverce = new SistemaLeilaoPort_JerseyClient();
    }
    
    public static WebServiceHelperImpl getInstance(){
        if(_INSTANCE == null){
            _INSTANCE = new WebServiceHelperImpl();
        }
        return _INSTANCE;
    }
    
    
    @Override
    public void addProduto(Produto produto) {
        produto.setId(_idCounter++);
        this.serverce.postAddProduto(produto);
    }

    @Override
    public void removeProduto(Produto produto) {
        this.serverce.postRemoveProduto(produto);
    }

    @Override
    public void upadateProduto(Produto produto) {
         this.serverce.postUpdateProduto(produto);
    }

    @Override
    public Produto getProdutoById(long id) {
        return (Produto)this.serverce.getProdutoById(Produto.class, Long.toString(id));
    }

    @Override
    public void preencherListaDeProdutos() {
        new PreListaDeProdutos().listaPrePreenchida.forEach((produto) -> {
            addProduto(produto);
        });
    }

    @Override
    public ArrayList<Produto> getAllProdutos() {
        return (ArrayList<Produto>)this.serverce.getAllProdutos(ArrayList.class);
    }

    static class SistemaLeilaoPort_JerseyClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/SistemaLeilao.WebService/webresources";

        public SistemaLeilaoPort_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("sistemaleilaoport");
        }

        public String postUpdateProduto(Object requestEntity) throws ClientErrorException {
            return webTarget.path("updateproduto").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), String.class);
        }

        public <T> T getProdutoById(Class<T> responseType, String id) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (id != null) {
                resource = resource.queryParam("id", id);
            }
            resource = resource.path("getprodutobyid");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
        }

        public <T> T getAllProdutos(Class<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path("getallprodutos");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
        }

        public String postRemoveProduto(Object requestEntity) throws ClientErrorException {
            return webTarget.path("removeproduto").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), String.class);
        }

        public String postAddProduto(Object requestEntity) throws ClientErrorException {
            return webTarget.path("addproduto").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), String.class);
        }

        public void close() {
            client.close();
        }
    }
    private class PreListaDeProdutos{
        public ArrayList<Produto> listaPrePreenchida = new ArrayList<Produto>(){{ 
            add(new Produto("Teste 1", "Descrição 1", 0.1, true));
            add(new Produto("Teste 2", "Descrição 2", 0.2, true));
            add(new Produto("Teste 3", "Descrição 3", 0.3, true));
            add(new Produto("Teste 4", "Descrição 4", 0.4, true));
            add(new Produto("Teste 5", "Descrição 5", 0.5, true));
            add(new Produto("Teste 6", "Descrição 6", 0.6, true));
            add(new Produto("Teste 7", "Descrição 7", 0.7, true));
        }};
    }
}
