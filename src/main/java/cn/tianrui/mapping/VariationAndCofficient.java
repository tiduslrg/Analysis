package cn.tianrui.mapping;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class VariationAndCofficient implements Comparable<VariationAndCofficient> {
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "NODE_ID")
	private Integer NODE_ID;

	@Id
	@Column(name = "BIZ_CODE")
	private String BIZ_CODE;

	@Id
	@Column(name = "DATE")
	private Date DATE;

	@Column(name = "AMOUNT")
	private BigInteger AMOUNT;

	@Column(name = "VARIANCE")
	private Double VARIANCE;

	@Column(name = "COFFICIENT")
	private Double COFFICIENT;

	public VariationAndCofficient(Integer NODE_ID, String BIZ_CODE, Date DATE, Integer AMOUNT, Double VARIANCE,
			Double COFFICIENT) {
		this.NODE_ID = NODE_ID;
		this.BIZ_CODE = BIZ_CODE;
		this.DATE = DATE;
		this.AMOUNT = new BigInteger(AMOUNT.toString());
		this.VARIANCE = VARIANCE;
		this.COFFICIENT = COFFICIENT;
	}

	public Integer getNODE_ID() {
		return NODE_ID;
	}

	public String getBIZ_CODE() {
		return BIZ_CODE;
	}

	public Date getDATE() {
		return DATE;
	}

	public BigInteger getAMOUNT() {
		return AMOUNT;
	}

	public Double getVARIANCE() {
		return VARIANCE;
	}

	public Double getCOFFICIENT() {
		return COFFICIENT;
	}

	public void setNODE_ID(Integer nODE_ID) {
		NODE_ID = nODE_ID;
	}

	public void setBIZ_CODE(String bIZ_CODE) {
		BIZ_CODE = bIZ_CODE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
	}

	public void setAMOUNT(BigInteger aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public void setVARIANCE(Double vARIANCE) {
		VARIANCE = vARIANCE;
	}

	public void setCOFFICIENT(Double cOFFICIENT) {
		COFFICIENT = cOFFICIENT;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VariationAndCofficient))
			return false;
		VariationAndCofficient other = (VariationAndCofficient) obj;
		if (this.NODE_ID.intValue() == other.getNODE_ID().intValue() && this.BIZ_CODE.equals(other.getBIZ_CODE())
				&& this.DATE.compareTo(other.getDATE()) == 0) {
			return true;
		}
		return true;
	}

	@Override
	public int compareTo(VariationAndCofficient o) {
		if (this.DATE.compareTo(o.getDATE()) > 0) {
			return 1;
		} else if (this.DATE.compareTo(o.getDATE()) < 0) {
			return -1;
		}
		return 0;
	}
}
