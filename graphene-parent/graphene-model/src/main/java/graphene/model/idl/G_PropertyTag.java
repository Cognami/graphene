/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** Tags are defined by the application layer as a taxonomy of user and application concepts,
	 independent of the data sources. This allows application semantics to be re-used with new
	 data, with a minimum of new software design and development. Data layer entity types, link
	 types and properties should be mapped into the list of tags. The application layer must be
	 able to search by native field name or by tag interchangeably, and properties returned must
	 contain both native field names as well as tags.
	 
	 The list of tags may change as application features evolve, though that will require
	 collaboration with the data layer providers. Evolving the tag list should not change the
	 Data Access or Search APIs.

	 This is the current list of tags for Properties:
	 
	 CHANGED in 1.5:
	   - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING
	   - added USD
	   - added DURATION
	   
	 CHANGED in 1.6:
	   - added ENTITY_TYPE
	   - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE
	   
	 CHANGED in 1.7:
	   - added CLUSTER */
@org.apache.avro.specific.AvroGenerated
public enum G_PropertyTag { 
  ID, TYPE, ENTITY_TYPE, ACCOUNT_OWNER, CLUSTER_SUMMARY, CLUSTER, NAME, LABEL, STAT, TEXT, STATUS, ANNOTATION, WARNING, LINKED_DATA, IMAGE, GEO, COUNTRY_CODE, DATE, AMOUNT, INFLOWING, OUTFLOWING, COUNT, SERIES, CONSTRUCTED, RAW, USD, DURATION  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"G_PropertyTag\",\"namespace\":\"graphene.model.idl\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\\r\\n\\t \\r\\n\\t CHANGED in 1.5:\\r\\n\\t   - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t   - added USD\\r\\n\\t   - added DURATION\\r\\n\\t   \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ENTITY_TYPE\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t   \\r\\n\\t CHANGED in 1.7:\\r\\n\\t   - added CLUSTER\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"USD\",\"DURATION\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}