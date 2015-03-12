/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** Used to add constraints for entity searches.

          The 'memberOf' parameter is a list of G_TypeMapping that describe the property in the given types.

          ADDED IN 1.8
     * */
@org.apache.avro.specific.AvroGenerated
public class G_PropertyDescriptor extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_PropertyDescriptor\",\"namespace\":\"graphene.model.idl\",\"doc\":\"Used to add constraints for entity searches.\\r\\n\\r\\n          The 'memberOf' parameter is a list of G_TypeMapping that describe the property in the given types.\\r\\n\\r\\n          ADDED IN 1.8\\r\\n     *\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"property descriptor unique key\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"a human readable property name to display if the key isn't friendly (optional)\",\"default\":null},{\"name\":\"propertyType\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\r\\n\\r\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"data type of the property\"},{\"name\":\"range\",\"type\":[{\"type\":\"enum\",\"name\":\"G_RangeType\",\"doc\":\"Allowed types for Ranges of values.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"null\"],\"doc\":\"range of the Property to search on\"},{\"name\":\"constraint\",\"type\":[{\"type\":\"enum\",\"name\":\"G_Constraint\",\"doc\":\"Property value matching constraints\\r\\n\\r\\n\\t ADDED IN 1.8\",\"symbols\":[\"REQUIRED_EQUALS\",\"FUZZY_PARTIAL_OPTIONAL\",\"NOT\",\"OPTIONAL_EQUALS\",\"FUZZY_REQUIRED\"]},\"null\"],\"doc\":\"REQUIRED_EQUALS, FUZZY_PARTIAL_OPTIONAL, NOT, OPTIONAL_EQUALS, FUZZY_REQUIRED\"},{\"name\":\"freeTextIndexed\",\"type\":\"boolean\",\"doc\":\"indicates whether this property is indexed for free text queries *\",\"default\":false},{\"name\":\"defaultTerm\",\"type\":\"boolean\",\"doc\":\"indicates whether this property should be included in the set of default criteria to specify *\",\"default\":false},{\"name\":\"memberOf\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_TypeMapping\",\"doc\":\"Used to describe how an G_PropertyDescriptor maps to given a type.\\r\\n\\r\\n\\t\\tADDED IN 1.8\\r\\n\\t *\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The type that the mapping applies to *\"},{\"name\":\"memberKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"field that the G_Property maps to in the type *\"}]}},\"doc\":\"List of mappings against types to which this property belongs,  *\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** property descriptor unique key */
   private java.lang.String key;
  /** a human readable property name to display if the key isn't friendly (optional) */
   private java.lang.String friendlyText;
  /** data type of the property */
   private graphene.model.idl.G_PropertyType propertyType;
  /** range of the Property to search on */
   private graphene.model.idl.G_RangeType range;
  /** REQUIRED_EQUALS, FUZZY_PARTIAL_OPTIONAL, NOT, OPTIONAL_EQUALS, FUZZY_REQUIRED */
   private graphene.model.idl.G_Constraint constraint;
  /** indicates whether this property is indexed for free text queries * */
   private boolean freeTextIndexed;
  /** indicates whether this property should be included in the set of default criteria to specify * */
   private boolean defaultTerm;
  /** List of mappings against types to which this property belongs,  * */
   private java.util.List<graphene.model.idl.G_TypeMapping> memberOf;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_PropertyDescriptor() {}

  /**
   * All-args constructor.
   */
  public G_PropertyDescriptor(java.lang.String key, java.lang.String friendlyText, graphene.model.idl.G_PropertyType propertyType, graphene.model.idl.G_RangeType range, graphene.model.idl.G_Constraint constraint, java.lang.Boolean freeTextIndexed, java.lang.Boolean defaultTerm, java.util.List<graphene.model.idl.G_TypeMapping> memberOf) {
    this.key = key;
    this.friendlyText = friendlyText;
    this.propertyType = propertyType;
    this.range = range;
    this.constraint = constraint;
    this.freeTextIndexed = freeTextIndexed;
    this.defaultTerm = defaultTerm;
    this.memberOf = memberOf;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return key;
    case 1: return friendlyText;
    case 2: return propertyType;
    case 3: return range;
    case 4: return constraint;
    case 5: return freeTextIndexed;
    case 6: return defaultTerm;
    case 7: return memberOf;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: key = (java.lang.String)value$; break;
    case 1: friendlyText = (java.lang.String)value$; break;
    case 2: propertyType = (graphene.model.idl.G_PropertyType)value$; break;
    case 3: range = (graphene.model.idl.G_RangeType)value$; break;
    case 4: constraint = (graphene.model.idl.G_Constraint)value$; break;
    case 5: freeTextIndexed = (java.lang.Boolean)value$; break;
    case 6: defaultTerm = (java.lang.Boolean)value$; break;
    case 7: memberOf = (java.util.List<graphene.model.idl.G_TypeMapping>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'key' field.
   * property descriptor unique key   */
  public java.lang.String getKey() {
    return key;
  }

  /**
   * Sets the value of the 'key' field.
   * property descriptor unique key   * @param value the value to set.
   */
  public void setKey(java.lang.String value) {
    this.key = value;
  }

  /**
   * Gets the value of the 'friendlyText' field.
   * a human readable property name to display if the key isn't friendly (optional)   */
  public java.lang.String getFriendlyText() {
    return friendlyText;
  }

  /**
   * Sets the value of the 'friendlyText' field.
   * a human readable property name to display if the key isn't friendly (optional)   * @param value the value to set.
   */
  public void setFriendlyText(java.lang.String value) {
    this.friendlyText = value;
  }

  /**
   * Gets the value of the 'propertyType' field.
   * data type of the property   */
  public graphene.model.idl.G_PropertyType getPropertyType() {
    return propertyType;
  }

  /**
   * Sets the value of the 'propertyType' field.
   * data type of the property   * @param value the value to set.
   */
  public void setPropertyType(graphene.model.idl.G_PropertyType value) {
    this.propertyType = value;
  }

  /**
   * Gets the value of the 'range' field.
   * range of the Property to search on   */
  public graphene.model.idl.G_RangeType getRange() {
    return range;
  }

  /**
   * Sets the value of the 'range' field.
   * range of the Property to search on   * @param value the value to set.
   */
  public void setRange(graphene.model.idl.G_RangeType value) {
    this.range = value;
  }

  /**
   * Gets the value of the 'constraint' field.
   * REQUIRED_EQUALS, FUZZY_PARTIAL_OPTIONAL, NOT, OPTIONAL_EQUALS, FUZZY_REQUIRED   */
  public graphene.model.idl.G_Constraint getConstraint() {
    return constraint;
  }

  /**
   * Sets the value of the 'constraint' field.
   * REQUIRED_EQUALS, FUZZY_PARTIAL_OPTIONAL, NOT, OPTIONAL_EQUALS, FUZZY_REQUIRED   * @param value the value to set.
   */
  public void setConstraint(graphene.model.idl.G_Constraint value) {
    this.constraint = value;
  }

  /**
   * Gets the value of the 'freeTextIndexed' field.
   * indicates whether this property is indexed for free text queries *   */
  public java.lang.Boolean getFreeTextIndexed() {
    return freeTextIndexed;
  }

  /**
   * Sets the value of the 'freeTextIndexed' field.
   * indicates whether this property is indexed for free text queries *   * @param value the value to set.
   */
  public void setFreeTextIndexed(java.lang.Boolean value) {
    this.freeTextIndexed = value;
  }

  /**
   * Gets the value of the 'defaultTerm' field.
   * indicates whether this property should be included in the set of default criteria to specify *   */
  public java.lang.Boolean getDefaultTerm() {
    return defaultTerm;
  }

  /**
   * Sets the value of the 'defaultTerm' field.
   * indicates whether this property should be included in the set of default criteria to specify *   * @param value the value to set.
   */
  public void setDefaultTerm(java.lang.Boolean value) {
    this.defaultTerm = value;
  }

  /**
   * Gets the value of the 'memberOf' field.
   * List of mappings against types to which this property belongs,  *   */
  public java.util.List<graphene.model.idl.G_TypeMapping> getMemberOf() {
    return memberOf;
  }

  /**
   * Sets the value of the 'memberOf' field.
   * List of mappings against types to which this property belongs,  *   * @param value the value to set.
   */
  public void setMemberOf(java.util.List<graphene.model.idl.G_TypeMapping> value) {
    this.memberOf = value;
  }

  /** Creates a new G_PropertyDescriptor RecordBuilder */
  public static graphene.model.idl.G_PropertyDescriptor.Builder newBuilder() {
    return new graphene.model.idl.G_PropertyDescriptor.Builder();
  }
  
  /** Creates a new G_PropertyDescriptor RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_PropertyDescriptor.Builder newBuilder(graphene.model.idl.G_PropertyDescriptor.Builder other) {
    return new graphene.model.idl.G_PropertyDescriptor.Builder(other);
  }
  
  /** Creates a new G_PropertyDescriptor RecordBuilder by copying an existing G_PropertyDescriptor instance */
  public static graphene.model.idl.G_PropertyDescriptor.Builder newBuilder(graphene.model.idl.G_PropertyDescriptor other) {
    return new graphene.model.idl.G_PropertyDescriptor.Builder(other);
  }
  
  /**
   * RecordBuilder for G_PropertyDescriptor instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_PropertyDescriptor>
    implements org.apache.avro.data.RecordBuilder<G_PropertyDescriptor> {

    private java.lang.String key;
    private java.lang.String friendlyText;
    private graphene.model.idl.G_PropertyType propertyType;
    private graphene.model.idl.G_RangeType range;
    private graphene.model.idl.G_Constraint constraint;
    private boolean freeTextIndexed;
    private boolean defaultTerm;
    private java.util.List<graphene.model.idl.G_TypeMapping> memberOf;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_PropertyDescriptor.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_PropertyDescriptor.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.key)) {
        this.key = data().deepCopy(fields()[0].schema(), other.key);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.friendlyText)) {
        this.friendlyText = data().deepCopy(fields()[1].schema(), other.friendlyText);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.propertyType)) {
        this.propertyType = data().deepCopy(fields()[2].schema(), other.propertyType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.range)) {
        this.range = data().deepCopy(fields()[3].schema(), other.range);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.constraint)) {
        this.constraint = data().deepCopy(fields()[4].schema(), other.constraint);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.freeTextIndexed)) {
        this.freeTextIndexed = data().deepCopy(fields()[5].schema(), other.freeTextIndexed);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.defaultTerm)) {
        this.defaultTerm = data().deepCopy(fields()[6].schema(), other.defaultTerm);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.memberOf)) {
        this.memberOf = data().deepCopy(fields()[7].schema(), other.memberOf);
        fieldSetFlags()[7] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_PropertyDescriptor instance */
    private Builder(graphene.model.idl.G_PropertyDescriptor other) {
            super(graphene.model.idl.G_PropertyDescriptor.SCHEMA$);
      if (isValidValue(fields()[0], other.key)) {
        this.key = data().deepCopy(fields()[0].schema(), other.key);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.friendlyText)) {
        this.friendlyText = data().deepCopy(fields()[1].schema(), other.friendlyText);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.propertyType)) {
        this.propertyType = data().deepCopy(fields()[2].schema(), other.propertyType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.range)) {
        this.range = data().deepCopy(fields()[3].schema(), other.range);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.constraint)) {
        this.constraint = data().deepCopy(fields()[4].schema(), other.constraint);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.freeTextIndexed)) {
        this.freeTextIndexed = data().deepCopy(fields()[5].schema(), other.freeTextIndexed);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.defaultTerm)) {
        this.defaultTerm = data().deepCopy(fields()[6].schema(), other.defaultTerm);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.memberOf)) {
        this.memberOf = data().deepCopy(fields()[7].schema(), other.memberOf);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the 'key' field */
    public java.lang.String getKey() {
      return key;
    }
    
    /** Sets the value of the 'key' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setKey(java.lang.String value) {
      validate(fields()[0], value);
      this.key = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'key' field has been set */
    public boolean hasKey() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'key' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearKey() {
      key = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'friendlyText' field */
    public java.lang.String getFriendlyText() {
      return friendlyText;
    }
    
    /** Sets the value of the 'friendlyText' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setFriendlyText(java.lang.String value) {
      validate(fields()[1], value);
      this.friendlyText = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'friendlyText' field has been set */
    public boolean hasFriendlyText() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'friendlyText' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearFriendlyText() {
      friendlyText = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'propertyType' field */
    public graphene.model.idl.G_PropertyType getPropertyType() {
      return propertyType;
    }
    
    /** Sets the value of the 'propertyType' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setPropertyType(graphene.model.idl.G_PropertyType value) {
      validate(fields()[2], value);
      this.propertyType = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'propertyType' field has been set */
    public boolean hasPropertyType() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'propertyType' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearPropertyType() {
      propertyType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'range' field */
    public graphene.model.idl.G_RangeType getRange() {
      return range;
    }
    
    /** Sets the value of the 'range' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setRange(graphene.model.idl.G_RangeType value) {
      validate(fields()[3], value);
      this.range = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'range' field has been set */
    public boolean hasRange() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'range' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearRange() {
      range = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'constraint' field */
    public graphene.model.idl.G_Constraint getConstraint() {
      return constraint;
    }
    
    /** Sets the value of the 'constraint' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setConstraint(graphene.model.idl.G_Constraint value) {
      validate(fields()[4], value);
      this.constraint = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'constraint' field has been set */
    public boolean hasConstraint() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'constraint' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearConstraint() {
      constraint = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'freeTextIndexed' field */
    public java.lang.Boolean getFreeTextIndexed() {
      return freeTextIndexed;
    }
    
    /** Sets the value of the 'freeTextIndexed' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setFreeTextIndexed(boolean value) {
      validate(fields()[5], value);
      this.freeTextIndexed = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'freeTextIndexed' field has been set */
    public boolean hasFreeTextIndexed() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'freeTextIndexed' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearFreeTextIndexed() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'defaultTerm' field */
    public java.lang.Boolean getDefaultTerm() {
      return defaultTerm;
    }
    
    /** Sets the value of the 'defaultTerm' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setDefaultTerm(boolean value) {
      validate(fields()[6], value);
      this.defaultTerm = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'defaultTerm' field has been set */
    public boolean hasDefaultTerm() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'defaultTerm' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearDefaultTerm() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'memberOf' field */
    public java.util.List<graphene.model.idl.G_TypeMapping> getMemberOf() {
      return memberOf;
    }
    
    /** Sets the value of the 'memberOf' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder setMemberOf(java.util.List<graphene.model.idl.G_TypeMapping> value) {
      validate(fields()[7], value);
      this.memberOf = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'memberOf' field has been set */
    public boolean hasMemberOf() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'memberOf' field */
    public graphene.model.idl.G_PropertyDescriptor.Builder clearMemberOf() {
      memberOf = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public G_PropertyDescriptor build() {
      try {
        G_PropertyDescriptor record = new G_PropertyDescriptor();
        record.key = fieldSetFlags()[0] ? this.key : (java.lang.String) defaultValue(fields()[0]);
        record.friendlyText = fieldSetFlags()[1] ? this.friendlyText : (java.lang.String) defaultValue(fields()[1]);
        record.propertyType = fieldSetFlags()[2] ? this.propertyType : (graphene.model.idl.G_PropertyType) defaultValue(fields()[2]);
        record.range = fieldSetFlags()[3] ? this.range : (graphene.model.idl.G_RangeType) defaultValue(fields()[3]);
        record.constraint = fieldSetFlags()[4] ? this.constraint : (graphene.model.idl.G_Constraint) defaultValue(fields()[4]);
        record.freeTextIndexed = fieldSetFlags()[5] ? this.freeTextIndexed : (java.lang.Boolean) defaultValue(fields()[5]);
        record.defaultTerm = fieldSetFlags()[6] ? this.defaultTerm : (java.lang.Boolean) defaultValue(fields()[6]);
        record.memberOf = fieldSetFlags()[7] ? this.memberOf : (java.util.List<graphene.model.idl.G_TypeMapping>) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
