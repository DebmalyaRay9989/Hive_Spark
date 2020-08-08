package CRUDOPERATION;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
 
public class CreateHBaseTable
{
  public static void main(String[] args) throws IOException
  {
    HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
    HTableDescriptor htable = new HTableDescriptor("Test"); 
    htable.addFamily( new HColumnDescriptor("id"));
    htable.addFamily( new HColumnDescriptor("Name"));
    System.out.println( "Connecting..." );
    HBaseAdmin hbase_admin = new HBaseAdmin( hconfig );
    System.out.println( "Creating Table..." );
    hbase_admin.createTable( htable );
    System.out.println("Done!");
  }
}

