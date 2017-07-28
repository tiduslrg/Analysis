package cn.tianrui.mapping;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = t_p_biz_1m.tableName)
public class t_p_biz_1m implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String tableName = "t_p_biz_1m";
	
	@Id
	@Column(name = "TIME_TAG")
	private BigInteger TIME_TAG;

	@Id
	@Column(name = "NODE_ID")
	private Integer NODE_ID;

	@Id
	@Column(name = "BIZ_CODE")
	private String BIZ_CODE;

	@Column(name = "GROUP_COUNT")
	private BigInteger GROUP_COUNT;

	@Column(name = "NO_RESP")
	private BigInteger NO_RESP;

	@Column(name = "NO_REQU")
	private BigInteger NO_REQU;

	@Column(name = "RESP_LEN")
	private BigInteger RESP_LEN;

	@Column(name = "REQU_DURA")
	private BigInteger REQU_DURA;

	@Column(name = "VARI_REQU_DURA")
	private BigInteger VARI_REQU_DURA;

	@Column(name = "ERR")
	private BigInteger ERR;

	@Id
	@Column(name = "CHANNEL_NO")
	private String CHANNEL_NO;

	@Column(name = "TECERR")
	private BigInteger TECERR;

	public BigInteger getTIME_TAG() {
		return TIME_TAG;
	}

	public void setTIME_TAG(BigInteger tIME_TAG) {
		TIME_TAG = tIME_TAG;
	}

	public Integer getNODE_ID() {
		return NODE_ID;
	}

	public void setNODE_ID(Integer nODE_ID) {
		NODE_ID = nODE_ID;
	}

	public String getBIZ_CODE() {
		return BIZ_CODE;
	}

	public void setBIZ_CODE(String bIZ_CODE) {
		BIZ_CODE = bIZ_CODE;
	}

	public BigInteger getGROUP_COUNT() {
		return GROUP_COUNT;
	}

	public void setGROUP_COUNT(BigInteger gROUP_COUNT) {
		GROUP_COUNT = gROUP_COUNT;
	}

	public BigInteger getNO_RESP() {
		return NO_RESP;
	}

	public void setNO_RESP(BigInteger nO_RESP) {
		NO_RESP = nO_RESP;
	}

	public BigInteger getNO_REQU() {
		return NO_REQU;
	}

	public void setNO_REQU(BigInteger nO_REQU) {
		NO_REQU = nO_REQU;
	}

	public BigInteger getRESP_LEN() {
		return RESP_LEN;
	}

	public void setRESP_LEN(BigInteger rESP_LEN) {
		RESP_LEN = rESP_LEN;
	}

	public BigInteger getREQU_DURA() {
		return REQU_DURA;
	}

	public void setREQU_DURA(BigInteger rEQU_DURA) {
		REQU_DURA = rEQU_DURA;
	}

	public BigInteger getVARI_REQU_DURA() {
		return VARI_REQU_DURA;
	}

	public void setVARI_REQU_DURA(BigInteger vARI_REQU_DURA) {
		VARI_REQU_DURA = vARI_REQU_DURA;
	}

	public BigInteger getERR() {
		return ERR;
	}

	public void setERR(BigInteger eRR) {
		ERR = eRR;
	}

	public String getCHANNEL_NO() {
		return CHANNEL_NO;
	}

	public void setCHANNEL_NO(String cHANNEL_NO) {
		CHANNEL_NO = cHANNEL_NO;
	}

	public BigInteger getTECERR() {
		return TECERR;
	}

	public void setTECERR(BigInteger tECERR) {
		TECERR = tECERR;
	}

	@Override
	public int hashCode() {
		final Integer prime = new Integer(31);
		Integer result = new Integer(1);
		result = prime.intValue() * result.intValue() + new Integer(TIME_TAG.toString());
		result = prime * result + ((TIME_TAG == null) ? 0 : TIME_TAG.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof t_p_biz_1m))
			return false;
		t_p_biz_1m other = (t_p_biz_1m) obj;
		if (TIME_TAG.longValue() != other.TIME_TAG.longValue() && NODE_ID.longValue() != other.NODE_ID.longValue()
				&& !BIZ_CODE.equals(other.BIZ_CODE) && !CHANNEL_NO.equals(other.CHANNEL_NO))
			return false;
		if (TIME_TAG == null) {
			if (other.TIME_TAG != null)
				return false;
		} else if (!TIME_TAG.equals(other.TIME_TAG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "t_p_biz_1d [TIME_TAG=" + TIME_TAG + ", NODE_ID=" + NODE_ID + ", BIZ_CODE=" + BIZ_CODE + ", CHANNEL_NO="
				+ CHANNEL_NO + "]";
	}

}
