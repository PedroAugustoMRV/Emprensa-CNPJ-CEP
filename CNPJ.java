package com.mycompany.empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CNPJ {

    
    public String id;
    public String numero;
    public String telefone;
    public String numero_de_inscricao;
    public String atividade_principal_code;
    public String tipo;
    public String nome;
    public String fantasia;
    public String atividade_principal_nome;
    public String natureza_juridica;
    public String logradouro;
    public String complemento;
    public String abertura;
    public String cep;
    public String municipio;
    public String bairro;
    public String uf;
    public String situacao;
    public String dt_situacao_cadastral;
    public String situacao_especial;
    public double capital_social;
    
    public String request(String cnpj) 
    {
        String json;        

          try {
            URL url = new URL("https://sisdel.com.br/api/hub/cnpjHub/"+ cnpj);
           
            URLConnection urlConnection = url.openConnection();
           
            InputStream is = urlConnection.getInputStream();
           
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
           
            json = jsonSb.toString();
           
            //JOptionPane.showMessageDialog(null, json);
           
           return json;
        } 
        catch (IOException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public void consultaCnpj(String cnpj){
       
        String resposta = request(cnpj);
       
        resposta = resposta.replaceAll("[{},:]", "");
       
        resposta = resposta.replaceAll("\"", "\n");        
       
        String array[] = new String[50];
       
        array = resposta.split("\n");
           
        
        
        //for (int i = 0; i < 50; i++) ;
        //{
           // if (array[i] != null && !array[i].isEmpty()) 
            //{
                //System.out.printf("%d %s\n", i, array[i]);
            //}
        //}
         
        this.setCep(array[49]);
        this.setLogradouro(array[37]);
        this.setId(array[2]);
        this.setNumero_de_inscricao(array[5]);
        this.setTipo(array[9]);     
        this.setAbertura(array[13]);    
        this.setNome(array[17]);    
        this.setFantasia(array[9]);    
        this.setAtividade_principal_nome(array[25]);    
        this.setAtividade_principal_code(array[29]);    
        this.setNatureza_juridica(array[33]);    
        this.setNumero(array[41]);    
        this.setComplemento(array[45]);  
    }
    
    public String getDadosCNPJ(){
        return "id: "                       + id                       + "\n"
             + "Nome: "                     + nome                     + "\n"
             + "UF: "                       + uf                       + "\n"
             + "Telefone: "                 + telefone                 + "\n"
             + "numero: "                   + numero                   + "\n"
             + "cep: "                      + cep                      + "\n"
             + "bairro: "                   + bairro                   + "\n"
             + "complemento: "              + complemento              + "\n"
             + "municipio: "                + municipio                + "\n"
             + "logradouro: "               + logradouro               + "\n"
             + "natureza_juridica: "        + natureza_juridica        + "\n"
             + "numero_de_inscricao: "      + numero_de_inscricao      + "\n"
             + "situacao_especial: "        + situacao_especial        + "\n"
             + "atividade_principal_code: " + atividade_principal_code + "\n"
             + "atividade_principal_nome: " + atividade_principal_nome + "\n";                   
                             
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNumero_de_inscricao(String numero_de_inscricao) {
        this.numero_de_inscricao = numero_de_inscricao;
    }

    public void setAtividade_principal_code(String atividade_principal_code) {
        this.atividade_principal_code = atividade_principal_code;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public void setAtividade_principal_nome(String atividade_principal_nome) {
        this.atividade_principal_nome = atividade_principal_nome;
    }

    public void setNatureza_juridica(String natureza_juridica) {
        this.natureza_juridica = natureza_juridica;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setDt_situacao_cadastral(String dt_situacao_cadastral) {
        this.dt_situacao_cadastral = dt_situacao_cadastral;
    }

    public void setSituacao_especial(String situacao_especial) {
        this.situacao_especial = situacao_especial;
    }

    public void setCapital_social(double capital_social) {
        this.capital_social = capital_social;
    }
 
    public  int primeiroDigito(int[] numeros){

        int[] multiplicadores = {5,4,3,2,9,8,7,6,5,4,3,2};
        int soma = 0;
        int resultado = 0;

        for (int i = 0; i < multiplicadores.length; i++) 
        {
            soma += numeros[i] * multiplicadores[i];
        }

        resultado = 11 - (soma % 11);

        if ((resultado == 10) || (resultado == 11)){
            return 0;
        }
            return resultado;
    }

    public  int segundoDigito(int[] numeros){
        
        int[] multiplicadores = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        int soma = 0;
        int resultado = 0;

        for (int i = 0; i < multiplicadores.length; i++) {
            soma += numeros[i] * multiplicadores[i];   
        }

        resultado = 11 - (soma % 11);

        if ((resultado == 10) || (resultado == 11)){
            return 0;
        }
            return resultado;
    }

    public  boolean validar(String cnpj) {

        if (cnpj.length() != 14) 
        {
            return false;
        }

        int[] numeros = new int[14];

        for (int i = 0; i < 14; i++) {
            numeros[i] = Integer.parseInt(cnpj.substring(i, i + 1));
        }

        if(primeiroDigito(numeros) != numeros[12] || segundoDigito(numeros) != numeros[13]){
            return false;
        }
            return true;
    }  
}
