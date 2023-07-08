/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Cep {
    
    public String cep;
    public String logradouro;
    public String cidade;
    public String bairro;
    public String uf;
    
    public String request(String cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            
            URLConnection urlConnection = url.openConnection();
            
            InputStream is = urlConnection.getInputStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
           return json;
           
        } 
        catch (IOException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public void consultaCep(String cep){
        
        String resposta = request(cep);
        
        resposta = resposta.replaceAll("[{},:]", "");
        
        resposta = resposta.replaceAll("\"", "\n");        
        
        String array[] = new String[30];
        
        array = resposta.split("\n");
            
        //JOptionPane.showMessageDialog(null, array);
        
        this.setCep(cep);
        this.setLogradouro(array[7]);
        this.setCidade(array[19]);
        this.setUf(array[23]);
        this.setBairro(array[15]);          
    }
    
     public String getDadosCEP(){
        return "\n\ncep: "         + cep         + "\n"
                + "logradouro: "   + logradouro  + "\n"
                + "UF: "           + uf          + "\n"
                + "cidade: "       + cidade      + "\n"
                + "bairro: "       + bairro      + "\n";                   
                             
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}