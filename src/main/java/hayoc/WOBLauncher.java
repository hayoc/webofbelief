package hayoc;

import hayoc.database.ConceptWOBDatabase;
import hayoc.grs.WOBConcept;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by Hayo on 13/12/2016.
 */
public class WOBLauncher {

    public static void main(String[] args) throws IOException {
        WOBConcept concept = new WOBConcept();
        concept.setIdentifier("testConcept1");
        concept.setDescription("test description");
        concept.setContext("some context");

        ConceptWOBDatabase database = new ConceptWOBDatabase();
        database.open();
        database.put(concept);
        WOBConcept concept2 = (WOBConcept) database.get(concept.getIdentifier());

        System.out.println(concept2);

    }
}
