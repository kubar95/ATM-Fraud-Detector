package atmFraudDetector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

import java.util.ArrayList;


public class Serializer {

    public static void writeGsonToFile(String gsonObject, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(gsonObject);
        writer.close();
    }
    public static ArrayList<Transaction> readGsonFromFile(String filePath) throws IOException {
        Gson gson = new Gson();
        ArrayList<Transaction> transactions = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        Type collectionType = new TypeToken<ArrayList<Transaction>>(){}.getType();
        transactions = gson.fromJson(bufferedReader, collectionType);
        return  transactions;
    }
}
