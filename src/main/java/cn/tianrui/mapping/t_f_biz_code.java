package cn.tianrui.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = t_f_biz_code.tableName)
public class t_f_biz_code implements Serializable {

	private static final long serialVersionUID = 3L;

	public static final String tableName = "t_f_biz_code";

	@Id
	@Column(name = "NODE_ID")
	private Integer NODE_ID;

	@Id
	@Column(name = "BIZ_CODE")
	private String BIZ_CODE;

	@Column(name = "BIZ_NAME")
	private String BIZ_NAME;

	public Integer getNODE_ID() {
		return NODE_ID;
	}

	public String getBIZ_CODE() {
		return BIZ_CODE;
	}

	public String getBIZ_NAME() {
		return BIZ_NAME;
	}

	public void setNODE_ID(Integer nODE_ID) {
		NODE_ID = nODE_ID;
	}

	public void setBIZ_CODE(String bIZ_CODE) {
		BIZ_CODE = bIZ_CODE;
	}

	public void setBIZ_NAME(String bIZ_NAME) {
		BIZ_NAME = bIZ_NAME;
	}

	@Override
	public int hashCode() {
		final Integer prime = new Integer(31);
		Integer result = new Integer(1);
		result = prime.intValue() * result.intValue() + new Integer(BIZ_CODE.toString());
		result = prime * result + ((BIZ_CODE == null) ? 0 : BIZ_CODE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof t_f_biz_code))
			return false;
		t_f_biz_code other = (t_f_biz_code) obj;
		if (NODE_ID.longValue() != other.NODE_ID.longValue() && !BIZ_CODE.equals(other.BIZ_CODE))
			return false;
		if (NODE_ID == null) {
			if (other.BIZ_CODE != null)
				return false;
		} else if (!NODE_ID.equals(other.NODE_ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "t_f_biz_code [NODE_ID=" + NODE_ID + ", BIZ_CODE=" + BIZ_CODE + ", BIZ_NAME=" + BIZ_NAME + "]";
	}

}
