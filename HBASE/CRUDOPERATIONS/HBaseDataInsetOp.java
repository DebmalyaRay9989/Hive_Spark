package CRUDOPERATION;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDataInsertOp {

	public static void main(String[] args) throws IOException {

		Configuration con = HBaseConfiguration.create();
		HTable t = new HTable(con, "Employee");

		// HTableDescriptor td = new HTableDescriptor(TableName.valueOf("Employee"));

		List<Put> putList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
System.out.println("Enter new records");
			String rowKey = sc.nextLine();
			String name = sc.nextLine();
			String id = sc.nextLine();
			String rollno = sc.nextLine();
			String marks = sc.nextLine();

			Put p0 = new Put(Bytes.toBytes(rowKey));

			p0.add(Bytes.toBytes("Personal"), Bytes.toBytes("name"), Bytes.toBytes(name));
			p0.add(Bytes.toBytes("Personal"), Bytes.toBytes("id"), Bytes.toBytes(id));
			p0.add(Bytes.toBytes("Personal"), Bytes.toBytes("rollno"), Bytes.toBytes(rollno));
			p0.add(Bytes.toBytes("Personal"), Bytes.toBytes("marks"), Bytes.toBytes(marks));
			t.put(p0);
//			putList.add(p0);
		}
		System.out.println("Done");
//		t.put(putList);

	}

}

