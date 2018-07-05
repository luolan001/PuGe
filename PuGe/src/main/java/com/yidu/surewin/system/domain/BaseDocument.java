package com.yidu.surewin.system.domain;

import java.io.Serializable;

public class BaseDocument implements Serializable{
	
	private static final long serialVersionUID = 1438145418816023703L;
	private String baseDocumentId;
	private String baseDocumentNo;
	private String baseDocumentName;
	private String scale;
	private String description;
	
	public BaseDocument() {

	}

	public BaseDocument(String baseDocumentId, String baseDocumentNo, String baseDocumentName, String scale,
			String description) {
		this.baseDocumentId = baseDocumentId;
		this.baseDocumentNo = baseDocumentNo;
		this.baseDocumentName = baseDocumentName;
		this.scale = scale;
		this.description = description;
	}

	public String getBaseDocumentId() {
		return baseDocumentId;
	}

	public void setBaseDocumentId(String baseDocumentId) {
		this.baseDocumentId = baseDocumentId;
	}

	public String getBaseDocumentNo() {
		return baseDocumentNo;
	}

	public void setBaseDocumentNo(String baseDocumentNo) {
		this.baseDocumentNo = baseDocumentNo;
	}

	public String getBaseDocumentName() {
		return baseDocumentName;
	}

	public void setBaseDocumentName(String baseDocumentName) {
		this.baseDocumentName = baseDocumentName;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseDocumentId == null) ? 0 : baseDocumentId.hashCode());
		result = prime * result + ((baseDocumentName == null) ? 0 : baseDocumentName.hashCode());
		result = prime * result + ((baseDocumentNo == null) ? 0 : baseDocumentNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDocument other = (BaseDocument) obj;
		if (baseDocumentId == null) {
			if (other.baseDocumentId != null)
				return false;
		} else if (!baseDocumentId.equals(other.baseDocumentId))
			return false;
		if (baseDocumentName == null) {
			if (other.baseDocumentName != null)
				return false;
		} else if (!baseDocumentName.equals(other.baseDocumentName))
			return false;
		if (baseDocumentNo == null) {
			if (other.baseDocumentNo != null)
				return false;
		} else if (!baseDocumentNo.equals(other.baseDocumentNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseDocument [baseDocumentId=" + baseDocumentId + ", baseDocumentNo=" + baseDocumentNo
				+ ", baseDocumentName=" + baseDocumentName + ", scale=" + scale + ", description=" + description + "]";
	}
	
}
