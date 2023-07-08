/*

 */

package com.mycompany.empresa;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Empresa {

     
    public static void main(String[] args) {
        
        Cep cep = new Cep();
        CNPJ empresacnpj = new CNPJ();
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o CEP da sua empresa");
        String formCep = teclado.next();
        
        teclado.nextLine();
        
        System.out.println("Digite o CNPJ da sua empresa");
        String cnpj = teclado.nextLine();
        
        cep.consultaCep(formCep);
        
        System.out.println(cep.getDadosCEP());
        
        if (empresacnpj.validar(cnpj)) 
        {
            
            System.out.println("\nCNPJ válido!");
            
            empresacnpj.consultaCnpj(cnpj);
            
          
            System.out.println(empresacnpj.getDadosCNPJ());
            //System.out.println("\n\n id: "                    +empresacnpj.id                       + "\n" + 
                               //"\n Nome: "                    +empresacnpj.nome                     + "\n" + 
                               //"\n UF: "                      +empresacnpj.uf                       + "\n" + 
                               //"\n Telefone: "                +empresacnpj.telefone                 + "\n" + 
                               //"\n numero: "                  +empresacnpj.numero                   + "\n" + 
                               //"\n cep: "                     +empresacnpj.cep                      + "\n" + 
                               //"\n bairro: "                  +empresacnpj.bairro                   + "\n" + 
                               //"\n complemento: "             +empresacnpj.complemento              + "\n" + 
                               ///"\n municipio: "               +empresacnpj.municipio                + "\n" + 
                               //"\n logradouro: "              +empresacnpj.logradouro               + "\n" + 
                               //"\n natureza_juridica: "       +empresacnpj.natureza_juridica        + "\n" + 
                               //"\n numero_de_inscricao: "     +empresacnpj.numero_de_inscricao      + "\n" + 
                               //"\n situacao_especial: "       +empresacnpj.situacao_especial        + "\n" + 
                               //"\n situacao_especial: "       +empresacnpj.situacao_especial        + "\n" + 
                               //"\n atividade_principal_code: "+empresacnpj.atividade_principal_code + "\n" + 
                               //"\n atividade_principal_nome: "+empresacnpj.atividade_principal_nome + "\n");
            
             
        } 
        else 
        {
            System.out.println("CNPJ inválido!");
        }
    }
}
