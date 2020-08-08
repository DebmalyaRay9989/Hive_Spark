package CRUDOPERATION;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDataRead {
	
	public static void main(String[] args) throws IOException {
		
		Configuration con = new Configuration();
		HTable t = new HTable(con,"Employee");
					
		Scan s = new Scan();
		s.addColumn(Bytes.toBytes("Personal"),Bytes.toBytes("name"));
		s.addColumn(Bytes.toBytes("Personal"),Bytes.toBytes("id"));
		s.addColumn(Bytes.toBytes("Personal"),Bytes.toBytes("rollno"));
		s.addColumn(Bytes.toBytes("Personal"),Bytes.toBytes("marks"));
		
		
		/*Scan s1 = new Scan();
		s1.addColumn(Bytes.toBytes("Personal"),Bytes.toBytes("id")); */
		
		  ResultScanner scanner = t.getScanner(s);
	      for (Result res1 = scanner.next(); res1 != null; res1 = scanner.next())
	      {
	byte[] value = res1.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("name"));
	byte[] value1 = res1.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("id"));
	byte[] value2 = res1.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("rollno"));
	byte[] value3 = res1.getValue(Bytes.toBytes("Personal"),Bytes.toBytes("marks"));
	 
	      String name = Bytes.toString(value);
	      String id = Bytes.toString(value1);
	      String rollno= Bytes.toString(value2);
	      String marks = Bytes.toString(value3);
	      
	      System.out.println("Name : " + name + " ID : " + id + " Rollno : " + rollno + " Marks : " + marks);
	      
	} 
	}
}
