package com.friquerette.primems.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5594566079507897195L;

	@Column(name = "create_date", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "update_date", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "created_by")
	private Customer createdBy;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "last_modified_by")
	private Customer lastModifiedBy;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	public Customer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Customer createdBy) {
		this.createdBy = createdBy;
	}

	public Customer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Customer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public abstract Long getId();
}
