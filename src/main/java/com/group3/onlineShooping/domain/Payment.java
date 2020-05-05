package com.group3.onlineShooping.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long Id;

	@NotBlank
	private String cardType;
	@NotBlank
	private String cardName;
	@NotBlank
	private String number;
	@NotNull
	@DateTimeFormat(pattern = "MM-yyyy")
	private LocalDate expiryDate;

	public Payment() {
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Payment{" + "cardType='" + cardType + '\'' + ", cardName='" + cardName + '\'' + ", number='" + number
				+ '\'' + ", expiryDate=" + expiryDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Payment))
			return false;
		Payment payment = (Payment) o;
		return Objects.equals(getCardType(), payment.getCardType())
				&& Objects.equals(getCardName(), payment.getCardName())
				&& Objects.equals(getNumber(), payment.getNumber())
				&& Objects.equals(getExpiryDate(), payment.getExpiryDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCardType(), getCardName(), getNumber(), getExpiryDate());
	}
}
