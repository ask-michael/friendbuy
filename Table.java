import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    private String tableName;
    private HashMap<String, Row> rows;

    public Table(String tableName, HashMap<String, Row> rows) {
        this.tableName = tableName;
        this.rows = rows;
    }

    public void createRecord(String name, int value){

        if(rows.containsKey(name)){
            Row row = rows.get(name);
            row.setValue(value);
        } else {
            Row row = new Row(value);
            rows.put(name,row);
        }
    }
    public void getRecord(String name){
        if(rows.containsKey(name)){
            System.out.println(rows.get(name).getValue());
        } else {
            System.out.println("NULL");

        }
    }

    public void deleteValue(String name){
        if (rows.containsKey(name)){
            rows.remove(name);
        }
    }

    public void getNumNamesWithValue(int value){
        AtomicInteger numMatches = new AtomicInteger();
        rows.entrySet().stream().forEach(row -> {
            if(row.getValue().getValue() == value){
                numMatches.set(numMatches.get() + 1);
            }
        });
        System.out.println(numMatches.get());
    }



}
