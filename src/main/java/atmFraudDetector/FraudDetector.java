package atmFraudDetector;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FraudDetector {
	private final Duration MINUTE = Duration.ofMinutes(1);
	private ArrayList<Transaction> transactions;

	public FraudDetector(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Transaction> detectFraud() {
		long timeStart = System.currentTimeMillis();
		List<Transaction> fradulentTransactions = transactions.parallelStream()
				.collect(Collectors.groupingBy(Transaction::getCardNumber))
				.values()
				.parallelStream()
				.filter(list -> list.size() > 1)
				.map(list -> list.stream()
						.sorted(Comparator.comparing(Transaction::getTime))
						.collect(Collectors.toList()))
				.map(list -> removeNotFraudulentTransactions(list))
				.filter(list -> list.size() > 0)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		long timeStop = System.currentTimeMillis();
		return  fradulentTransactions;
	}
	private List<Transaction> removeNotFraudulentTransactions(List<Transaction> transactions) {
		boolean isFradulent = true;
		Transaction transactionBefore;
		Transaction transaction;
		Transaction transactionAfter;
		int listSize = transactions.size();
		for (int i = 0; i < transactions.size(); i++) {
			if(transactions.size()<2) {
				transactions.remove(i);
				break;
			}
			if (i == 0) {
				transaction = transactions.get(i);
				transactionAfter = transactions.get(i + 1);
				isFradulent = compareTwoTransactions(transaction, transactionAfter);
			} else if (i == (transactions.size() - 1)) {
				transactionBefore = transactions.get(i - 1);
				transaction = transactions.get(i);
				isFradulent = compareTwoTransactions(transactionBefore, transaction);
			} else {
				transactionBefore = transactions.get(i - 1);
				transaction = transactions.get(i);
				transactionAfter = transactions.get(i + 1);
				isFradulent = compareTwoTransactions(transactionBefore, transaction)
						|| compareTwoTransactions(transaction, transactionAfter);
			}
			if (!isFradulent) {
				transactions.remove(i);
				i--;

			}
			
		}
		
		return transactions;
	}

	private boolean compareTwoTransactions(Transaction firstTransaction, Transaction secondTransaction) {
		return 	 isBetweenMinute(firstTransaction.getTime(), secondTransaction.getTime())
				&& !isAtmTheSame(firstTransaction.getAtmNumber(), secondTransaction.getAtmNumber());

	}

	private boolean isBetweenMinute(LocalDateTime time1, LocalDateTime time2) {
		Duration durationBetweenTwoTransactions = Duration.between(time1, time2);
		return MINUTE.compareTo(durationBetweenTwoTransactions) == 1;
	}

	private boolean isAtmTheSame(int atm1, int atm2) {
		return atm1 == atm2;
	}

}
