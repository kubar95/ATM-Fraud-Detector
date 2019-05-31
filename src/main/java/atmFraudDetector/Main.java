package atmFraudDetector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		TransactionGenerator generator = new TransactionGenerator(10000, 90000, 100000, 8, 12, 900, 1000);
//		ArrayList<Transaction> transactions = generator.getTransactionList();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String jsonOutput = gson.toJson(transactions);
//		try {
//			Serializer.writeGsonToFile(jsonOutput,"transactions.json");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		List<Transaction> tractionsFromJson = new ArrayList<>();
		try {
			tractionsFromJson= Serializer.readGsonFromFile("transactions.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		FraudDetector fraudDetector = new FraudDetector(tractionsFromJson);
		List <Transaction> fradulentTransactions = fraudDetector.detectFraud();
		fradulentTransactions.forEach(transaction -> System.out.println(transaction.toString()));

}}
