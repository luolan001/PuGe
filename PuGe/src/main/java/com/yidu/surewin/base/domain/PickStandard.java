package com.yidu.surewin.base.domain;

import java.io.Serializable;

public class PickStandard implements Serializable{
	
	private static final long serialVersionUID = 1438145418816023703L;
	private String pickStandardId;
	private String pickStandardName;
	private String minWeight;
	private String maxWeight;
	private String useable;
	private String description;
	
	public PickStandard(){
		
	}

	public PickStandard(String pickStandardId, String pickStandardName, String minWeight, String maxWeight,
			String useable, String description) {
		super();
		this.pickStandardId = pickStandardId;
		this.pickStandardName = pickStandardName;
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
		this.useable = useable;
		this.description = description;
	}

	public String getPickStandardId() {
		return pickStandardId;
	}

	public void setPickStandardId(String pickStandardId) {
		this.pickStandardId = pickStandardId;
	}

	public String getPickStandardName() {
		return pickStandardName;
	}

	public void setPickStandardName(String pickStandardName) {
		this.pickStandardName = pickStandardName;
	}

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PickStandard [pickStandardId=" + pickStandardId + ", pickStandardName=" + pickStandardName
				+ ", minWeight=" + minWeight + ", maxWeight=" + maxWeight + ", useable=" + useable + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((maxWeight == null) ? 0 : maxWeight.hashCode());
		result = prime * result + ((minWeight == null) ? 0 : minWeight.hashCode());
		result = prime * result + ((pickStandardId == null) ? 0 : pickStandardId.hashCode());
		result = prime * result + ((pickStandardName == null) ? 0 : pickStandardName.hashCode());
		result = prime * result + ((useable == null) ? 0 : useable.hashCode());
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
		PickStandard other = (PickStandard) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (maxWeight == null) {
			if (other.maxWeight != null)
				return false;
		} else if (!maxWeight.equals(other.maxWeight))
			return false;
		if (minWeight == null) {
			if (other.minWeight != null)
				return false;
		} else if (!minWeight.equals(other.minWeight))
			return false;
		if (pickStandardId == null) {
			if (other.pickStandardId != null)
				return false;
		} else if (!pickStandardId.equals(other.pickStandardId))
			return false;
		if (pickStandardName == null) {
			if (other.pickStandardName != null)
				return false;
		} else if (!pickStandardName.equals(other.pickStandardName))
			return false;
		if (useable == null) {
			if (other.useable != null)
				return false;
		} else if (!useable.equals(other.useable))
			return false;
		return true;
	}
	
	
}
