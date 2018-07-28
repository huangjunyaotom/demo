package com.h.myapp.util.no;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class NoUtil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noUtilId;
	private String entityName;
	private String entityPrefix;
	private int count;
	private String today;

	public NoUtil() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noUtilId == null) ? 0 : noUtilId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "NoUtil [noUtilId=" + noUtilId + ", entityName=" + entityName + ", entityPrefix=" + entityPrefix
				+ ", count=" + count + ", today=" + today + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoUtil other = (NoUtil) obj;
		if (noUtilId == null) {
			if (other.noUtilId != null)
				return false;
		} else if (!noUtilId.equals(other.noUtilId))
			return false;
		return true;
	}

	public Integer getNoUtilId() {
		return noUtilId;
	}

	public void setNoUtilId(Integer noUtilId) {
		this.noUtilId = noUtilId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityPrefix() {
		return entityPrefix;
	}

	public void setEntityPrefix(String entityPrefix) {
		this.entityPrefix = entityPrefix;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

}
