package com.trade.trade;

import java.util.Date;

public class TradeStore {

	private String trade_Id;
	private Integer version;
	private String counterParty_Id;
	private String Book_Id;
	private Date maturity_Date;
	private Date created_Date;
	String expired;

	public String getTrade_Id() {
		return trade_Id;
	}

	public void setTrade_Id(String trade_Id) {
		this.trade_Id = trade_Id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCounterParty_Id() {
		return counterParty_Id;
	}

	public void setCounterParty_Id(String counterParty_Id) {
		this.counterParty_Id = counterParty_Id;
	}

	public String getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}

	public Date getMaturity_Date() {
		return maturity_Date;
	}

	public void setMaturity_Date(Date maturity_Date) {
		this.maturity_Date = maturity_Date;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Book_Id == null) ? 0 : Book_Id.hashCode());
		result = prime * result + ((counterParty_Id == null) ? 0 : counterParty_Id.hashCode());
		result = prime * result + ((created_Date == null) ? 0 : created_Date.hashCode());
		result = prime * result + ((expired == null) ? 0 : expired.hashCode());
		result = prime * result + ((maturity_Date == null) ? 0 : maturity_Date.hashCode());
		result = prime * result + ((trade_Id == null) ? 0 : trade_Id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		TradeStore other = (TradeStore) obj;
		if (Book_Id == null) {
			if (other.Book_Id != null)
				return false;
		} else if (!Book_Id.equals(other.Book_Id))
			return false;
		if (counterParty_Id == null) {
			if (other.counterParty_Id != null)
				return false;
		} else if (!counterParty_Id.equals(other.counterParty_Id))
			return false;
		if (created_Date == null) {
			if (other.created_Date != null)
				return false;
		} else if (!created_Date.equals(other.created_Date))
			return false;
		if (expired == null) {
			if (other.expired != null)
				return false;
		} else if (!expired.equals(other.expired))
			return false;
		if (maturity_Date == null) {
			if (other.maturity_Date != null)
				return false;
		} else if (!maturity_Date.equals(other.maturity_Date))
			return false;
		if (trade_Id == null) {
			if (other.trade_Id != null)
				return false;
		} else if (!trade_Id.equals(other.trade_Id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradeStore [trade_Id=" + trade_Id + ", version=" + version + ", counterParty_Id=" + counterParty_Id
				+ ", Book_Id=" + Book_Id + ", maturity_Date=" + maturity_Date + ", created_Date=" + created_Date
				+ ", expired=" + expired + "]";
	}

}
