package br.ueg.portalVirtual.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ueg.portalVirtual.annotation.RequiredField;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "reino")
public class Reino extends Entity {

	@Id
	@GeneratedValue
	@OneToMany(targetEntity = Filo.class, mappedBy = "reino")
	@Column(name = "id_reino")
	private long id;
	
	@Column(name="nome")
	@RequiredField
	private String reino;
	
	public Reino() {
	}
	
	public Reino(long id, String reino) {
		this.id = id;
		this.reino = reino;
	}

	@Override
	public long getId() {
		return id;
	}

	public String getReino() {
		return reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getSearchColumnTable() {
		return "nome";
	}

	@Override
	public String getSearchColumnEntity() {
		return "reino";
	}

}
