//package br.edu.uepb.sigeris.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import lombok.Data;
//
///**
// * Classe que representa o modelo da entidade Curso a ser persistida no banco,
// * com todos os seus atributos.
// *
// * @author Cássio Oliveira <cassio@cassioliveira.com.br>
// */
//@Data
//@Entity
//@Table(name = "curso")
//public class Curso implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "codigo", length = 20)
//    private String codigo;
//
//    @NotNull(message = "É necessário informar o nome do curso")
//    @Column(name = "nome", length = 250)
//    private String nome;
//
//}
