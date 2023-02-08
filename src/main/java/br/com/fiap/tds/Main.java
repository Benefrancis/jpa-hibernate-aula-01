package br.com.fiap.tds;

import br.com.fiap.tds.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Nome do produto");
        String descricao = JOptionPane.showInputDialog("Descricao do produto");
        BigDecimal preco = new BigDecimal(JOptionPane.showInputDialog("Preço do produto"));
        LocalDate fabricacao = LocalDate.now();


        var produto = new Produto();

        produto.setNome(nome).setDescricao(descricao).setPreco(preco).setFabricacao(fabricacao);


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-casa");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(produto);

        entityManager.getTransaction().commit();

        entityManager.close();


    }
}