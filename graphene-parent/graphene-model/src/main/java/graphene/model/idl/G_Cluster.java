/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** Cluster of nodes in the social, financial, communications or other graphs. 
	 
	 CHANGED in 1.7:
	    - added version */
@org.apache.avro.specific.AvroGenerated
public class G_Cluster extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_Cluster\",\"namespace\":\"graphene.model.idl\",\"doc\":\"Cluster of nodes in the social, financial, communications or other graphs. \\r\\n\\t \\r\\n\\t CHANGED in 1.7:\\r\\n\\t    - added version\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"A unique identifier use to retrieve data about this cluster. Should not be used for non-global identifiers.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_EntityTag\",\"doc\":\"This is the current list of tags for Entities:\\r\\n\\t \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"CLUSTER_SUMMARY\",\"FILE\",\"ANONYMOUS\",\"PROMPT_FOR_DETAILS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see DataTypes, e.g. \\\"CLUSTER\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"G_Provenance\",\"doc\":\"This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"G_Uncertainty\",\"doc\":\"This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1},{\"name\":\"currency\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express confidence in currency of data as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Property\",\"doc\":\"Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t in terms of the semantics of the application.  \\r\\n\\t \\r\\n\\t CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"styleType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"singletonRange\",\"type\":{\"type\":\"record\",\"name\":\"G_SingletonRange\",\"doc\":\"Single value\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"G_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\r\\n\\r\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},\"doc\":\"range of values\",\"default\":null},{\"name\":\"listRange\",\"type\":{\"type\":\"record\",\"name\":\"G_ListRange\",\"doc\":\"List of values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\"]}},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},\"default\":null},{\"name\":\"boundedRange\",\"type\":{\"type\":\"record\",\"name\":\"G_BoundedRange\",\"doc\":\"Bounded or unbounded range values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},\"default\":null},{\"name\":\"distributionRange\",\"type\":{\"type\":\"record\",\"name\":\"G_DistributionRange\",\"doc\":\"Describes a distribution of values. \\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Frequency\",\"doc\":\"A frequency or probability element of a distribution.\\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"G_ListRange\",\"G_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}}},{\"name\":\"rangeType\",\"type\":{\"type\":\"enum\",\"name\":\"G_RangeType\",\"doc\":\"Allowed types for Ranges of values.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]},\"default\":null},{\"name\":\"provenance\",\"type\":[\"G_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"G_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_PropertyTag\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\\r\\n\\t \\r\\n\\t CHANGED in 1.5:\\r\\n\\t   - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t   - added USD\\r\\n\\t   - added DURATION\\r\\n\\t   \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ENTITY_TYPE\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t   \\r\\n\\t CHANGED in 1.7:\\r\\n\\t   - added CLUSTER\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"USD\",\"DURATION\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"}]}}},{\"name\":\"members\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"List of id's of the members of this cluster\"},{\"name\":\"subclusters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"List of id's of the subclusters of this cluster - empty if this is a leaf cluster in cluster hierarchy\"},{\"name\":\"parent\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The id of the parent cluster if this is a cluster in a ","hierarchy - Can be null if this is a root cluster *\",\"default\":null},{\"name\":\"root\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The id of the root cluster (top level cluster) if this is a cluster in a hierarchy - Can be null if this is a root cluster *\",\"default\":null},{\"name\":\"level\",\"type\":\"int\",\"doc\":\"The degree from the root this cluster is in the hierarchy - level = 0 if this is a root cluster *\",\"default\":0},{\"name\":\"version\",\"type\":\"int\",\"doc\":\"The version number of the cluster - each time the cluster contents is modified the version should be incremented *\",\"default\":1}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** A unique identifier use to retrieve data about this cluster. Should not be used for non-global identifiers. */
   private java.lang.String uid;
  /** Entity Tags (see DataTypes, e.g. "CLUSTER") */
   private java.util.List<graphene.model.idl.G_EntityTag> tags;
   private graphene.model.idl.G_Provenance provenance;
   private graphene.model.idl.G_Uncertainty uncertainty;
   private java.util.List<graphene.model.idl.G_Property> properties;
  /** List of id's of the members of this cluster */
   private java.util.List<java.lang.String> members;
  /** List of id's of the subclusters of this cluster - empty if this is a leaf cluster in cluster hierarchy */
   private java.util.List<java.lang.String> subclusters;
  /** The id of the parent cluster if this is a cluster in a hierarchy - Can be null if this is a root cluster * */
   private java.lang.String parent;
  /** The id of the root cluster (top level cluster) if this is a cluster in a hierarchy - Can be null if this is a root cluster * */
   private java.lang.String root;
  /** The degree from the root this cluster is in the hierarchy - level = 0 if this is a root cluster * */
   private int level;
  /** The version number of the cluster - each time the cluster contents is modified the version should be incremented * */
   private int version;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_Cluster() {}

  /**
   * All-args constructor.
   */
  public G_Cluster(java.lang.String uid, java.util.List<graphene.model.idl.G_EntityTag> tags, graphene.model.idl.G_Provenance provenance, graphene.model.idl.G_Uncertainty uncertainty, java.util.List<graphene.model.idl.G_Property> properties, java.util.List<java.lang.String> members, java.util.List<java.lang.String> subclusters, java.lang.String parent, java.lang.String root, java.lang.Integer level, java.lang.Integer version) {
    this.uid = uid;
    this.tags = tags;
    this.provenance = provenance;
    this.uncertainty = uncertainty;
    this.properties = properties;
    this.members = members;
    this.subclusters = subclusters;
    this.parent = parent;
    this.root = root;
    this.level = level;
    this.version = version;
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
    case 5: return members;
    case 6: return subclusters;
    case 7: return parent;
    case 8: return root;
    case 9: return level;
    case 10: return version;
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
    case 4: properties = (java.util.List<graphene.model.idl.G_Property>)value$; break;
    case 5: members = (java.util.List<java.lang.String>)value$; break;
    case 6: subclusters = (java.util.List<java.lang.String>)value$; break;
    case 7: parent = (java.lang.String)value$; break;
    case 8: root = (java.lang.String)value$; break;
    case 9: level = (java.lang.Integer)value$; break;
    case 10: version = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'uid' field.
   * A unique identifier use to retrieve data about this cluster. Should not be used for non-global identifiers.   */
  public java.lang.String getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * A unique identifier use to retrieve data about this cluster. Should not be used for non-global identifiers.   * @param value the value to set.
   */
  public void setUid(java.lang.String value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'tags' field.
   * Entity Tags (see DataTypes, e.g. "CLUSTER")   */
  public java.util.List<graphene.model.idl.G_EntityTag> getTags() {
    return tags;
  }

  /**
   * Sets the value of the 'tags' field.
   * Entity Tags (see DataTypes, e.g. "CLUSTER")   * @param value the value to set.
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
  public java.util.List<graphene.model.idl.G_Property> getProperties() {
    return properties;
  }

  /**
   * Sets the value of the 'properties' field.
   * @param value the value to set.
   */
  public void setProperties(java.util.List<graphene.model.idl.G_Property> value) {
    this.properties = value;
  }

  /**
   * Gets the value of the 'members' field.
   * List of id's of the members of this cluster   */
  public java.util.List<java.lang.String> getMembers() {
    return members;
  }

  /**
   * Sets the value of the 'members' field.
   * List of id's of the members of this cluster   * @param value the value to set.
   */
  public void setMembers(java.util.List<java.lang.String> value) {
    this.members = value;
  }

  /**
   * Gets the value of the 'subclusters' field.
   * List of id's of the subclusters of this cluster - empty if this is a leaf cluster in cluster hierarchy   */
  public java.util.List<java.lang.String> getSubclusters() {
    return subclusters;
  }

  /**
   * Sets the value of the 'subclusters' field.
   * List of id's of the subclusters of this cluster - empty if this is a leaf cluster in cluster hierarchy   * @param value the value to set.
   */
  public void setSubclusters(java.util.List<java.lang.String> value) {
    this.subclusters = value;
  }

  /**
   * Gets the value of the 'parent' field.
   * The id of the parent cluster if this is a cluster in a hierarchy - Can be null if this is a root cluster *   */
  public java.lang.String getParent() {
    return parent;
  }

  /**
   * Sets the value of the 'parent' field.
   * The id of the parent cluster if this is a cluster in a hierarchy - Can be null if this is a root cluster *   * @param value the value to set.
   */
  public void setParent(java.lang.String value) {
    this.parent = value;
  }

  /**
   * Gets the value of the 'root' field.
   * The id of the root cluster (top level cluster) if this is a cluster in a hierarchy - Can be null if this is a root cluster *   */
  public java.lang.String getRoot() {
    return root;
  }

  /**
   * Sets the value of the 'root' field.
   * The id of the root cluster (top level cluster) if this is a cluster in a hierarchy - Can be null if this is a root cluster *   * @param value the value to set.
   */
  public void setRoot(java.lang.String value) {
    this.root = value;
  }

  /**
   * Gets the value of the 'level' field.
   * The degree from the root this cluster is in the hierarchy - level = 0 if this is a root cluster *   */
  public java.lang.Integer getLevel() {
    return level;
  }

  /**
   * Sets the value of the 'level' field.
   * The degree from the root this cluster is in the hierarchy - level = 0 if this is a root cluster *   * @param value the value to set.
   */
  public void setLevel(java.lang.Integer value) {
    this.level = value;
  }

  /**
   * Gets the value of the 'version' field.
   * The version number of the cluster - each time the cluster contents is modified the version should be incremented *   */
  public java.lang.Integer getVersion() {
    return version;
  }

  /**
   * Sets the value of the 'version' field.
   * The version number of the cluster - each time the cluster contents is modified the version should be incremented *   * @param value the value to set.
   */
  public void setVersion(java.lang.Integer value) {
    this.version = value;
  }

  /** Creates a new G_Cluster RecordBuilder */
  public static graphene.model.idl.G_Cluster.Builder newBuilder() {
    return new graphene.model.idl.G_Cluster.Builder();
  }
  
  /** Creates a new G_Cluster RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_Cluster.Builder newBuilder(graphene.model.idl.G_Cluster.Builder other) {
    return new graphene.model.idl.G_Cluster.Builder(other);
  }
  
  /** Creates a new G_Cluster RecordBuilder by copying an existing G_Cluster instance */
  public static graphene.model.idl.G_Cluster.Builder newBuilder(graphene.model.idl.G_Cluster other) {
    return new graphene.model.idl.G_Cluster.Builder(other);
  }
  
  /**
   * RecordBuilder for G_Cluster instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_Cluster>
    implements org.apache.avro.data.RecordBuilder<G_Cluster> {

    private java.lang.String uid;
    private java.util.List<graphene.model.idl.G_EntityTag> tags;
    private graphene.model.idl.G_Provenance provenance;
    private graphene.model.idl.G_Uncertainty uncertainty;
    private java.util.List<graphene.model.idl.G_Property> properties;
    private java.util.List<java.lang.String> members;
    private java.util.List<java.lang.String> subclusters;
    private java.lang.String parent;
    private java.lang.String root;
    private int level;
    private int version;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_Cluster.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_Cluster.Builder other) {
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
      if (isValidValue(fields()[5], other.members)) {
        this.members = data().deepCopy(fields()[5].schema(), other.members);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.subclusters)) {
        this.subclusters = data().deepCopy(fields()[6].schema(), other.subclusters);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.parent)) {
        this.parent = data().deepCopy(fields()[7].schema(), other.parent);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.root)) {
        this.root = data().deepCopy(fields()[8].schema(), other.root);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.level)) {
        this.level = data().deepCopy(fields()[9].schema(), other.level);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.version)) {
        this.version = data().deepCopy(fields()[10].schema(), other.version);
        fieldSetFlags()[10] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_Cluster instance */
    private Builder(graphene.model.idl.G_Cluster other) {
            super(graphene.model.idl.G_Cluster.SCHEMA$);
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
      if (isValidValue(fields()[5], other.members)) {
        this.members = data().deepCopy(fields()[5].schema(), other.members);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.subclusters)) {
        this.subclusters = data().deepCopy(fields()[6].schema(), other.subclusters);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.parent)) {
        this.parent = data().deepCopy(fields()[7].schema(), other.parent);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.root)) {
        this.root = data().deepCopy(fields()[8].schema(), other.root);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.level)) {
        this.level = data().deepCopy(fields()[9].schema(), other.level);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.version)) {
        this.version = data().deepCopy(fields()[10].schema(), other.version);
        fieldSetFlags()[10] = true;
      }
    }

    /** Gets the value of the 'uid' field */
    public java.lang.String getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public graphene.model.idl.G_Cluster.Builder setUid(java.lang.String value) {
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
    public graphene.model.idl.G_Cluster.Builder clearUid() {
      uid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'tags' field */
    public java.util.List<graphene.model.idl.G_EntityTag> getTags() {
      return tags;
    }
    
    /** Sets the value of the 'tags' field */
    public graphene.model.idl.G_Cluster.Builder setTags(java.util.List<graphene.model.idl.G_EntityTag> value) {
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
    public graphene.model.idl.G_Cluster.Builder clearTags() {
      tags = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'provenance' field */
    public graphene.model.idl.G_Provenance getProvenance() {
      return provenance;
    }
    
    /** Sets the value of the 'provenance' field */
    public graphene.model.idl.G_Cluster.Builder setProvenance(graphene.model.idl.G_Provenance value) {
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
    public graphene.model.idl.G_Cluster.Builder clearProvenance() {
      provenance = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'uncertainty' field */
    public graphene.model.idl.G_Uncertainty getUncertainty() {
      return uncertainty;
    }
    
    /** Sets the value of the 'uncertainty' field */
    public graphene.model.idl.G_Cluster.Builder setUncertainty(graphene.model.idl.G_Uncertainty value) {
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
    public graphene.model.idl.G_Cluster.Builder clearUncertainty() {
      uncertainty = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'properties' field */
    public java.util.List<graphene.model.idl.G_Property> getProperties() {
      return properties;
    }
    
    /** Sets the value of the 'properties' field */
    public graphene.model.idl.G_Cluster.Builder setProperties(java.util.List<graphene.model.idl.G_Property> value) {
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
    public graphene.model.idl.G_Cluster.Builder clearProperties() {
      properties = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'members' field */
    public java.util.List<java.lang.String> getMembers() {
      return members;
    }
    
    /** Sets the value of the 'members' field */
    public graphene.model.idl.G_Cluster.Builder setMembers(java.util.List<java.lang.String> value) {
      validate(fields()[5], value);
      this.members = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'members' field has been set */
    public boolean hasMembers() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'members' field */
    public graphene.model.idl.G_Cluster.Builder clearMembers() {
      members = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'subclusters' field */
    public java.util.List<java.lang.String> getSubclusters() {
      return subclusters;
    }
    
    /** Sets the value of the 'subclusters' field */
    public graphene.model.idl.G_Cluster.Builder setSubclusters(java.util.List<java.lang.String> value) {
      validate(fields()[6], value);
      this.subclusters = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'subclusters' field has been set */
    public boolean hasSubclusters() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'subclusters' field */
    public graphene.model.idl.G_Cluster.Builder clearSubclusters() {
      subclusters = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'parent' field */
    public java.lang.String getParent() {
      return parent;
    }
    
    /** Sets the value of the 'parent' field */
    public graphene.model.idl.G_Cluster.Builder setParent(java.lang.String value) {
      validate(fields()[7], value);
      this.parent = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'parent' field has been set */
    public boolean hasParent() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'parent' field */
    public graphene.model.idl.G_Cluster.Builder clearParent() {
      parent = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'root' field */
    public java.lang.String getRoot() {
      return root;
    }
    
    /** Sets the value of the 'root' field */
    public graphene.model.idl.G_Cluster.Builder setRoot(java.lang.String value) {
      validate(fields()[8], value);
      this.root = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'root' field has been set */
    public boolean hasRoot() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'root' field */
    public graphene.model.idl.G_Cluster.Builder clearRoot() {
      root = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'level' field */
    public java.lang.Integer getLevel() {
      return level;
    }
    
    /** Sets the value of the 'level' field */
    public graphene.model.idl.G_Cluster.Builder setLevel(int value) {
      validate(fields()[9], value);
      this.level = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'level' field has been set */
    public boolean hasLevel() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'level' field */
    public graphene.model.idl.G_Cluster.Builder clearLevel() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'version' field */
    public java.lang.Integer getVersion() {
      return version;
    }
    
    /** Sets the value of the 'version' field */
    public graphene.model.idl.G_Cluster.Builder setVersion(int value) {
      validate(fields()[10], value);
      this.version = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'version' field has been set */
    public boolean hasVersion() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'version' field */
    public graphene.model.idl.G_Cluster.Builder clearVersion() {
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    public G_Cluster build() {
      try {
        G_Cluster record = new G_Cluster();
        record.uid = fieldSetFlags()[0] ? this.uid : (java.lang.String) defaultValue(fields()[0]);
        record.tags = fieldSetFlags()[1] ? this.tags : (java.util.List<graphene.model.idl.G_EntityTag>) defaultValue(fields()[1]);
        record.provenance = fieldSetFlags()[2] ? this.provenance : (graphene.model.idl.G_Provenance) defaultValue(fields()[2]);
        record.uncertainty = fieldSetFlags()[3] ? this.uncertainty : (graphene.model.idl.G_Uncertainty) defaultValue(fields()[3]);
        record.properties = fieldSetFlags()[4] ? this.properties : (java.util.List<graphene.model.idl.G_Property>) defaultValue(fields()[4]);
        record.members = fieldSetFlags()[5] ? this.members : (java.util.List<java.lang.String>) defaultValue(fields()[5]);
        record.subclusters = fieldSetFlags()[6] ? this.subclusters : (java.util.List<java.lang.String>) defaultValue(fields()[6]);
        record.parent = fieldSetFlags()[7] ? this.parent : (java.lang.String) defaultValue(fields()[7]);
        record.root = fieldSetFlags()[8] ? this.root : (java.lang.String) defaultValue(fields()[8]);
        record.level = fieldSetFlags()[9] ? this.level : (java.lang.Integer) defaultValue(fields()[9]);
        record.version = fieldSetFlags()[10] ? this.version : (java.lang.Integer) defaultValue(fields()[10]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
