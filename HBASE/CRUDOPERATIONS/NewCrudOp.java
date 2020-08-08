package CRUDOPERATION;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class NewCrudOp {
	
	public static void main(String[] args) throws MasterNotRunningException, 
					ZooKeeperConnectionException, IOException {
		
		Configuration con = HBaseConfiguration.create();
		
		HBaseAdmin a = new HBaseAdmin(con);
		
		HTableDescriptor td = new
			      HTableDescriptor(TableName.valueOf("Student"));
		
		td.addFamily(new HColumnDescriptor("Personal"));
	      td.addFamily(new HColumnDescriptor("Official"));
	      
	      
	      a.createTable(td);
	      System.out.println("Student Table Created....");
	      
	      
	      HColumnDescriptor cd = new HColumnDescriptor("AddressDetails");
	   		HColumnDescriptor cd1 = new HColumnDescriptor("ContactDetails");
	     
	     a.addColumn("Employee", cd);
	    	a.addColumn("Employee", cd1);
	     		System.out.println(" 2 Coloumn added to table Successfully...");
		
	}

}

