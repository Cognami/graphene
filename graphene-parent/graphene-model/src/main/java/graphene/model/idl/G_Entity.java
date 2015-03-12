/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,
	 specific proxies such as accounts, or the implicit individuals or groups behind those other entities. */
@org.apache.avro.specific.AvroGenerated
public class G_Entity extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_Entity\",\"namespace\":\"graphene.model.idl\",\"doc\":\"The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_EntityTag\",\"doc\":\"This is the current list of tags for Entities:\\r\\n\\t \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"CLUSTER_SUMMARY\",\"FILE\",\"ANONYMOUS\",\"PROMPT_FOR_DETAILS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"G_Provenance\",\"doc\":\"This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"G_Uncertainty\",\"doc\":\"This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1},{\"name\":\"currency\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express confidence in currency of data as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"G_Property\",\"doc\":\"Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t in terms of the semantics of the application.  \\r\\n\\t \\r\\n\\t CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"styleType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"range\",\"type\":[{\"type\":\"record\",\"name\":\"G_SingletonRange\",\"doc\":\"Single value\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"G_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\r\\n\\r\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_ListRange\",\"doc\":\"List of values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\"]}},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_BoundedRange\",\"doc\":\"Bounded or unbounded range values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_DistributionRange\",\"doc\":\"Describes a distribution of values. \\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Frequency\",\"doc\":\"A frequency or probability element of a distribution.\\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"G_ListRange\",\"G_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}}},{\"name\":\"rangeType\",\"type\":{\"type\":\"enum\",\"name\":\"G_RangeType\",\"doc\":\"Allowed types for Ranges of values.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]}],\"doc\":\"range of values\",\"default\":null},{\"name\":\"provenance\",\"type\":[\"G_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"G_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_PropertyTag\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\\r\\n\\t \\r\\n\\t CHANGED in 1.5:\\r\\n\\t   - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t   - added USD\\r\\n\\t   - added DURATION\\r\\n\\t   \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ENTITY_TYPE\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t   \\r\\n\\t CHANGED in 1.7:\\r\\n\\t   - added CLUSTER\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFL","OWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"USD\",\"DURATION\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"}]},\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an
			explicit entity, or (2) encoded query information that can be used to find a set of associated record
			notionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for
			IDs that aren't globally unique.  For example, in Kiva, "Lenders" has a UID ("L12345") while "Borrowers"
			have an encoded search in the Loans table for uid ("B{loan:23456;name=Daniel}").  The encoded information
			is data layer-specific, may be different from entity to entity or data set to data set, and should be
			considered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag
			ANONYMOUS to help distinguish them when required. */
   private java.lang.String uid;
  /** Entity Tags (see above, e.g. "ACCOUNT") */
   private java.util.List<graphene.model.idl.G_EntityTag> tags;
   private graphene.model.idl.G_Provenance provenance;
   private graphene.model.idl.G_Uncertainty uncertainty;
   private java.util.Map<java.lang.String,graphene.model.idl.G_Property> properties;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_Entity() {}

  /**
   * All-args constructor.
   */
  public G_Entity(java.lang.String uid, java.util.List<graphene.model.idl.G_EntityTag> tags, graphene.model.idl.G_Provenance provenance, graphene.model.idl.G_Uncertainty uncertainty, java.util.Map<java.lang.String,graphene.model.idl.G_Property> properties) {
    this.uid = uid;
    this.tags = tags;
    this.provenance = provenance;
    this.uncertainty = uncertainty;
    this.properties = properties;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return uid;
    case 1: return tags;
    case 2: return provenance;
    case 3: return uncertainty;
    case 4: return properties;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: uid = (java.lang.String)value$; break;
    case 1: tags = (java.util.List<graphene.model.idl.G_EntityTag>)value$; break;
    case 2: provenance = (graphene.model.idl.G_Provenance)value$; break;
    case 3: uncertainty = (graphene.model.idl.G_Uncertainty)value$; break;
    case 4: properties = (java.util.Map<java.lang.String,graphene.model.idl.G_Property>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'uid' field.
   * This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an
			explicit entity, or (2) encoded query information that can be used to find a set of associated record
			notionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for
			IDs that aren't globally unique.  For example, in Kiva, "Lenders" has a UID ("L12345") while "Borrowers"
			have an encoded search in the Loans table for uid ("B{loan:23456;name=Daniel}").  The encoded information
			is data layer-specific, may be different from entity to entity or data set to data set, and should be
			considered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag
			ANONYMOUS to help distinguish them when required.   */
  public java.lang.String getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an
			explicit entity, or (2) encoded query information that can be used to find a set of associated record
			notionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for
			IDs that aren't globally unique.  For example, in Kiva, "Lenders" has a UID ("L12345") while "Borrowers"
			have an encoded search in the Loans table for uid ("B{loan:23456;name=Daniel}").  The encoded information
			is data layer-specific, may be different from entity to entity or data set to data set, and should be
			considered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag
			ANONYMOUS to help distinguish them when required.   * @param value the value to set.
   */
  public void setUid(java.lang.String value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'tags' field.
   * Entity Tags (see above, e.g. "ACCOUNT")   */
  public java.util.List<graphene.model.idl.G_EntityTag> getTags() {
    return tags;
  }

  /**
   * Sets the value of the 'tags' field.
   * Entity Tags (see above, e.g. "ACCOUNT")   * @param value the value to set.
   */
  public void setTags(java.util.List<graphene.model.idl.G_EntityTag> value) {
    this.tags = value;
  }

  /**
   * Gets the value of the 'provenance' field.
   */
  public graphene.model.idl.G_Provenance getProvenance() {
    return provenance;
  }

  /**
   * Sets the value of the 'provenance' field.
   * @param value the value to set.
   */
  public void setProvenance(graphene.model.idl.G_Provenance value) {
    this.provenance = value;
  }

  /**
   * Gets the value of the 'uncertainty' field.
   */
  public graphene.model.idl.G_Uncertainty getUncertainty() {
    return uncertainty;
  }

  /**
   * Sets the value of the 'uncertainty' field.
   * @param value the value to set.
   */
  public void setUncertainty(graphene.model.idl.G_Uncertainty value) {
    this.uncertainty = value;
  }

  /**
   * Gets the value of the 'properties' field.
   */
  public java.util.Map<java.lang.String,graphene.model.idl.G_Property> getProperties() {
    return properties;
  }

  /**
   * Sets the value of the 'properties' field.
   * @param value the value to set.
   */
  public void setProperties(java.util.Map<java.lang.String,graphene.model.idl.G_Property> value) {
    this.properties = value;
  }

  /** Creates a new G_Entity RecordBuilder */
  public static graphene.model.idl.G_Entity.Builder newBuilder() {
    return new graphene.model.idl.G_Entity.Builder();
  }
  
  /** Creates a new G_Entity RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_Entity.Builder newBuilder(graphene.model.idl.G_Entity.Builder other) {
    return new graphene.model.idl.G_Entity.Builder(other);
  }
  
  /** Creates a new G_Entity RecordBuilder by copying an existing G_Entity instance */
  public static graphene.model.idl.G_Entity.Builder newBuilder(graphene.model.idl.G_Entity other) {
    return new graphene.model.idl.G_Entity.Builder(other);
  }
  
  /**
   * RecordBuilder for G_Entity instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_Entity>
    implements org.apache.avro.data.RecordBuilder<G_Entity> {

    private java.lang.String uid;
    private java.util.List<graphene.model.idl.G_EntityTag> tags;
    private graphene.model.idl.G_Provenance provenance;
    private graphene.model.idl.G_Uncertainty uncertainty;
    private java.util.Map<java.lang.String,graphene.model.idl.G_Property> properties;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_Entity.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_Entity.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.uid)) {
        this.uid = data().deepCopy(fields()[0].schema(), other.uid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tags)) {
        this.tags = data().deepCopy(fields()[1].schema(), other.tags);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.provenance)) {
        this.provenance = data().deepCopy(fields()[2].schema(), other.provenance);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uncertainty)) {
        this.uncertainty = data().deepCopy(fields()[3].schema(), other.uncertainty);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.properties)) {
        this.properties = data().deepCopy(fields()[4].schema(), other.properties);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_Entity instance */
    private Builder(graphene.model.idl.G_Entity other) {
            super(graphene.model.idl.G_Entity.SCHEMA$);
      if (isValidValue(fields()[0], other.uid)) {
        this.uid = data().deepCopy(fields()[0].schema(), other.uid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tags)) {
        this.tags = data().deepCopy(fields()[1].schema(), other.tags);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.provenance)) {
        this.provenance = data().deepCopy(fields()[2].schema(), other.provenance);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uncertainty)) {
        this.uncertainty = data().deepCopy(fields()[3].schema(), other.uncertainty);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.properties)) {
        this.properties = data().deepCopy(fields()[4].schema(), other.properties);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'uid' field */
    public java.lang.String getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public graphene.model.idl.G_Entity.Builder setUid(java.lang.String value) {
      validate(fields()[0], value);
      this.uid = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'uid' field has been set */
    public boolean hasUid() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'uid' field */
    public graphene.model.idl.G_Entity.Builder clearUid() {
      uid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'tags' field */
    public java.util.List<graphene.model.idl.G_EntityTag> getTags() {
      return tags;
    }
    
    /** Sets the value of the 'tags' field */
    public graphene.model.idl.G_Entity.Builder setTags(java.util.List<graphene.model.idl.G_EntityTag> value) {
      validate(fields()[1], value);
      this.tags = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'tags' field has been set */
    public boolean hasTags() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'tags' field */
    public graphene.model.idl.G_Entity.Builder clearTags() {
      tags = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'provenance' field */
    public graphene.model.idl.G_Provenance getProvenance() {
      return provenance;
    }
    
    /** Sets the value of the 'provenance' field */
    public graphene.model.idl.G_Entity.Builder setProvenance(graphene.model.idl.G_Provenance value) {
      validate(fields()[2], value);
      this.provenance = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'provenance' field has been set */
    public boolean hasProvenance() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'provenance' field */
    public graphene.model.idl.G_Entity.Builder clearProvenance() {
      provenance = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'uncertainty' field */
    public graphene.model.idl.G_Uncertainty getUncertainty() {
      return uncertainty;
    }
    
    /** Sets the value of the 'uncertainty' field */
    public graphene.model.idl.G_Entity.Builder setUncertainty(graphene.model.idl.G_Uncertainty value) {
      validate(fields()[3], value);
      this.uncertainty = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'uncertainty' field has been set */
    public boolean hasUncertainty() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'uncertainty' field */
    public graphene.model.idl.G_Entity.Builder clearUncertainty() {
      uncertainty = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'properties' field */
    public java.util.Map<java.lang.String,graphene.model.idl.G_Property> getProperties() {
      return properties;
    }
    
    /** Sets the value of the 'properties' field */
    public graphene.model.idl.G_Entity.Builder setProperties(java.util.Map<java.lang.String,graphene.model.idl.G_Property> value) {
      validate(fields()[4], value);
      this.properties = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'properties' field has been set */
    public boolean hasProperties() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'properties' field */
    public graphene.model.idl.G_Entity.Builder clearProperties() {
      properties = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public G_Entity build() {
      try {
        G_Entity record = new G_Entity();
        record.uid = fieldSetFlags()[0] ? this.uid : (java.lang.String) defaultValue(fields()[0]);
        record.tags = fieldSetFlags()[1] ? this.tags : (java.util.List<graphene.model.idl.G_EntityTag>) defaultValue(fields()[1]);
        record.provenance = fieldSetFlags()[2] ? this.provenance : (graphene.model.idl.G_Provenance) defaultValue(fields()[2]);
        record.uncertainty = fieldSetFlags()[3] ? this.uncertainty : (graphene.model.idl.G_Uncertainty) defaultValue(fields()[3]);
        record.properties = fieldSetFlags()[4] ? this.properties : (java.util.Map<java.lang.String,graphene.model.idl.G_Property>) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
