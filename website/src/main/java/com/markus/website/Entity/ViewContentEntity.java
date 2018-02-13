package com.markus.website.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="view_content")
public class ViewContentEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	@Column(name="content_value")
	private String contentValue;
	
	@Column(name="angular_scope_name")
	private String angularScopeName;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="view_name", referencedColumnName="name")
	private ViewsEntity viewsEntity;
	
	@ManyToOne
	@JoinColumn(name="element_type_name", referencedColumnName="name")
	private ElementTypeEntity elementTypeEntity;

	public String getViewName() {
		return this.viewsEntity.getViewName();
	}

	public void setViewName(String viewName) {
		this.viewsEntity.setViewName(viewName);
	}

	public String getElementTypeName() {
		return this.elementTypeEntity.getElementTypeName();
	}

	public void setElementTypeName(String elementTypeName) {
		this.elementTypeEntity.setElementTypeName(elementTypeName);
	}

	public String getContentValue() {
		return contentValue;
	}

	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}

	public String getAngularScopeName() {
		return angularScopeName;
	}

	public void setAngularScopeName(String angularScopeName) {
		this.angularScopeName = angularScopeName;
	}

	public ViewsEntity getViewsEntity() {
		return viewsEntity;
	}

	public void setViewsEntity(ViewsEntity viewsEntity) {
		this.viewsEntity = viewsEntity;
	}

	public ElementTypeEntity getElementTypeEntity() {
		return elementTypeEntity;
	}

	public void setElementTypeEntity(ElementTypeEntity elementTypeEntity) {
		this.elementTypeEntity = elementTypeEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
