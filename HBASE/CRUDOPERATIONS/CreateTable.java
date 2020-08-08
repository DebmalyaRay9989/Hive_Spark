package CRUDOPERATION;

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.conf.Configuration;

public class CreateTable {
      
   public static void main(String[] args) throws IOException {

     
      Configuration con = HBaseConfiguration.create();

    
      HBaseAdmin admin = new HBaseAdmin(con);

     /*
      HTableDescriptor tableDescriptor = new
      HTableDescriptor(TableName.valueOf("Employee"));
      
   
      tableDescriptor.addFamily(new HColumnDescriptor("Personal"));
      tableDescriptor.addFamily(new HColumnDescriptor("Professional"));
     
     admin.createTable(tableDescriptor);
      System.out.println(" Table created.... ");
      */
 //  Fetching Tables in HBase   
      
      HTableDescriptor [] td1 = admin.listTables();
      for(int i=0; i < td1.length; i++ )
      {
    	  System.out.println(td1[i].getNameAsString());
      }
      
      /*Adding Column Family 
		   HColumnDescriptor cd = new HColumnDescriptor("AddressDetails");
		   		HColumnDescriptor cd1 = new HColumnDescriptor("ContactDetails");
		     
		     admin.addColumn("Employee", cd);
		    	admin.addColumn("Employee", cd1);
		     		System.out.println(" 2 Coloumn added to table Successfully...");
		      */
	/*	 
      admin.deleteColumn("Employee", "ContactDetails");
		    System.out.println("Column Family Deleted Successfully....");
		     	
		     	*/
      //Checking table Existance 
      
      boolean b = admin.tableExists("Employee");
      System.out.println( "Table Existance is " + b);
      
      	/*	
      		//Deleting a Table
      			admin.disableTable("customer");
			      admin.deleteTable("customer");
			      System.out.println("Table deleted successfully..");
		     	
		     	*/
      //To Shut Down HBase
    //  admin.shutdown();
      
      		
		     
		     
		      
		      
		      
     
   }
}


