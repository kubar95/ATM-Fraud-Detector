package atmFraudDetector;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable{
	private int cardNumber;
	private int atmNumber;
	private LocalDateTime transactionDataTime;
	public Transaction(int cardNumber, int atmNumber, LocalDateTime transactionDataTime) {
		this.cardNumber = cardNumber;
		this.atmNumber = atmNumber;
		this.transactionDataTime = transactionDataTime;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getAtmNumber() {
		return atmNumber;
	}
	public LocalDateTime getTime() {
		return transactionDataTime;
	}
	@Override
	public String toString() {
		return "Transaction [cardNumber=" + cardNumber + ", atmNumber=" + atmNumber + ", transactionDataTime="
				+ transactionDataTime + "]";
	}

	
}
