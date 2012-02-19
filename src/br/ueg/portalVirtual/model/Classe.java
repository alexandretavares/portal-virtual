package br.ueg.portalVirtual.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ueg.portalVirtual.annotation.RequiredField;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "classe")
public class Classe extends Entity {
	
	@Id
	@GeneratedValue
	@Column(name = "id_classe")
	private long id;
	
	@RequiredField
	@Column(name = "nome")
	private String classe;
	
	@ManyToOne(optional = false, targetEntity = Filo.class)
	@JoinColumn(name = "id_filo", referencedColumnName = "id_filo")
	@RequiredField
	private Filo filo;
	
	public Classe() {}
	
	public Classe(long id, String classe, Filo filo) {
		this.id = id;
		this.classe = classe;
		this.filo = filo;
	}

	@Override
	public String getSearchColumnTable() {
		return "nome";
	}

	@Override
	public String getSearchColumnEntity() {
		return "classe";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Filo getFilo() {
		return filo;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}
	
}
