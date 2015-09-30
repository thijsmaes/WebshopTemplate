package be.webshop.templatewebshop.backend.entities;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;

@MappedSuperclass
public abstract class AbstractEntity {}
/*
	@Column(name = "\"PROPERTIES\"", length = 1000000)
	private String properties;

	// @Transient (doesn't work for update @PreUpdate - have to create bidon column instead)
	@Column(name = "\"PROPERTIESHOLDER\"", insertable = false, updatable = false)
	private PropertiesHolder propertiesHolder;

	@Column(name = "\"ACTIVE\"")
	private Boolean active;

	@PostLoad
	public void load() {
		if (properties == null) {
			propertiesHolder = new PropertiesHolder();
		} else {
			propertiesHolder = PropertyUtil.jsonToPropertiesHolder(properties);
		}
	}

	public String getProperties() {
		return properties;
	}

	public PropertiesHolder getPropertiesHolder() {
		return propertiesHolder;
	}

	public void setPropertiesHolder(PropertiesHolder propertiesHolder) {
		this.propertiesHolder = propertiesHolder;
		this.properties = PropertyUtil.propertiesHolderToJson(propertiesHolder);
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	PropertiesHolder clonePropertiesHolder() {
		if (propertiesHolder != null) {
			return PropertyUtil.jsonToPropertiesHolder(
					PropertyUtil.propertiesHolderToJson(propertiesHolder));
		}
		return new PropertiesHolder();
	}

}*/
