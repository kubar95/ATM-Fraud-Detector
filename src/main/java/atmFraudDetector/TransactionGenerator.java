package atmFraudDetector;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionGenerator {
	private int transactionNumber;
	private int cardNumberFrom;
	private int cardNumberTo;
	private int hourFrom;
	private int hourTo;
	private int atmNumberFrom;
	private int atmNumberTo;
	private List<Transaction> transactions;
	
	public TransactionGenerator(int transactionNumber, int cardNumberFrom, int cardNumberTo, int hourFrom, int hourTo,
			int atmNumberFrom, int atmNumberTo) {
		this.transactionNumber = transactionNumber;
		this.cardNumberFrom = cardNumberFrom;
		this.cardNumberTo = cardNumberTo;
		this.hourFrom = hourFrom;
		this.hourTo = hourTo;
		this.atmNumberFrom = atmNumberFrom;
		this.atmNumberTo = atmNumberTo;
		this.transactions = new ArrayList<Transaction>();
		generateTransactionsList();
	}
	
	
	public List<Transaction> getTransactionList() {
		return transactions;
	}
	private void generateTransactionsList() {
		Random rand = new Random();
		int cardNumber;
		int atmNumber;
		LocalDateTime trasactionDataTime;
		LocalDate dateNow= LocalDate.now();
		LocalTime timeFrom = LocalTime.of(hourFrom, 0, 0);
		LocalTime timeTo = LocalTime.of(hourTo, 0, 0);
		int secondOfTimeFrom = timeFrom.toSecondOfDay();
		int secondOfTimeTo = timeTo.toSecondOfDay();
		int randomSecondOfDay;
		LocalTime randomLocalTime;
		for (int i = 0; i < this.transactionNumber; i++) {
			cardNumber = rand.nextInt(cardNumberTo-cardNumberFrom)+cardNumberFrom;
			atmNumber = rand.nextInt(atmNumberTo-atmNumberFrom)+atmNumberFrom;
			randomSecondOfDay=secondOfTimeFrom + rand.nextInt(secondOfTimeTo-secondOfTimeFrom);
			randomLocalTime=LocalTime.ofSecondOfDay(randomSecondOfDay);
			trasactionDataTime = LocalDateTime.of(dateNow, randomLocalTime);
			transactions.add(new Transaction(cardNumber, atmNumber, trasactionDataTime));
		}
	}
	
	
}
