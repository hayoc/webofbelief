package hayoc.database;

import hayoc.grs.WOBConcept;
import hayoc.util.PropertiesLoader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.io.compress.Compression;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Hayo on 14/12/2016.
 */
public class ConceptWOBDatabase implements WOBDatabase {

    private static final Logger LOG = Logger.getLogger(ConceptWOBDatabase.class);
    private static final String PROPERTIES_PATH = "database.properties";

    private PropertiesLoader properties;
    private Table table;

    private String tableID;
    private String columnFamilyID;
    private byte[] columnFamilyBytes;

    private byte[] descriptionBytes = Bytes.toBytes("description");
    private byte[] contextBytes = Bytes.toBytes("context");


    public ConceptWOBDatabase() {
        properties = new PropertiesLoader(PROPERTIES_PATH);
        tableID = properties.get("table");
        columnFamilyID = properties.get("column_family");
        columnFamilyBytes = Bytes.toBytes(columnFamilyID);
    }

    @Override
    public boolean open() {
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableID));
        tableDescriptor.addFamily(new HColumnDescriptor(columnFamilyID).setCompressionType(Compression.Algorithm.NONE));

        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort", properties.get("zk_port"));
        configuration.set("hbase.zookeeper.quorum", properties.get("host"));
        configuration.set("hbase.master", properties.get("host") + ":" + properties.get("master_port"));

        try {
            Connection connection = ConnectionFactory.createConnection(configuration);
            Admin admin = connection.getAdmin();
            TableName tableName = tableDescriptor.getTableName();
            if (!admin.tableExists(tableName)) {
                LOG.error("Table "+ tableName.getNameAsString() + "doesn't exist");
                System.exit(1);
            }
            table = connection.getTable(tableName);
        } catch (IOException e) {
            LOG.error("Error opening connection");
            return false;
        }

        return true;
    }

    @Override
    public void put(WOBConcept concept) throws IOException {
        Put put = new Put(Bytes.toBytes(concept.getIdentifier()));
        put.addColumn(columnFamilyBytes, descriptionBytes, Bytes.toBytes(concept.getDescription()));
        put.addColumn(columnFamilyBytes, contextBytes, Bytes.toBytes(concept.getContext()));
        table.put(put);
    }

    @Override
    public Object get(String identifier) throws IOException {
        Result result = table.get(new Get(Bytes.toBytes(identifier)));
        WOBConcept concept = new WOBConcept();
        concept.setIdentifier(identifier);
        concept.setDescription(Bytes.toString(result.getValue(columnFamilyBytes, descriptionBytes)));
        concept.setContext(Bytes.toString(result.getValue(columnFamilyBytes, contextBytes)));
        return concept;
    }
}
