package CRUDOPERATION;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class CRUDoperation {
	
	 public static void main(String[] args) throws IOException {

	     
	      Configuration con = HBaseConfiguration.create();
	      HTable t = new HTable(con, "Employee");
	      
	      Put p = new Put(Bytes.toBytes("row1"));
	    /*  
	      p.add(Bytes.toBytes("Personal"), Bytes.toBytes("Name"),Bytes.toBytes("Chandan"));
	      
	      
	      p.add(Bytes.toBytes("Personal"),Bytes.toBytes("Country"),Bytes.toBytes("India"));
	      p.add(Bytes.toBytes("Professional"),Bytes.toBytes("Designation"),Bytes.toBytes("Developers"));
	    	      
	    	      t.put(p);
	    	      System.out.println("Data inserted...");
			      // Updating a cell value
			      p.add(Bytes.toBytes("Personal"),Bytes.toBytes("Country"),Bytes.toBytes("USA"));
		
			      // Saving the put Instance to the HTable.
			      t.put(p);
			      System.out.println("Data Updation....");
	    	       */
	      
	      Get g = new Get(Bytes.toBytes("row1"));

	      // Reading the data
	      Result result = t.get(g);


	      byte [] val = result.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("Name"));

	      byte [] val1 = result.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("Country"));

	      // Printing the values
	      String name = Bytes.toString(val);
	      String country = Bytes.toString(val1);
	      
	      System.out.println("Name: " + name + " Country: " + country);
	      
	      		//Delete Operation
	   
				      Delete delete = new Delete(Bytes.toBytes("row1"));
				      delete.deleteColumn(Bytes.toBytes("Personal"), Bytes.toBytes("Country"));
				//      delete.deleteFamily(Bytes.toBytes("Professional"));
			
				      t.delete(delete);
				   
				      System.out.println("Data Deleted Successfully.....");

	      
	      //Fetching Data From Table
	      Scan s = new Scan();
		      s.addColumn(Bytes.toBytes("Personal"), Bytes.toBytes("Name"));
		      s.addColumn(Bytes.toBytes("Personal"), Bytes.toBytes("Country"));

	      ResultScanner scanner = t.getScanner(s);
	      for (Result res1 = scanner.next(); res1 != null; res1 = scanner.next())

	      System.out.println("Found row : " + res1);
	     
	      scanner.close();
	      
}
	}


