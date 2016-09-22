/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** A frequency or probability element of a distribution.
	 
	ADDED IN 1.6 */
@org.apache.avro.specific.AvroGenerated
public class G_Frequency extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_Frequency\",\"namespace\":\"graphene.model.idl\",\"doc\":\"A frequency or probability element of a distribution.\\n\\t \\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"G_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]},{\"type\":\"record\",\"name\":\"G_ListRange\",\"doc\":\"List of values\\n\\t\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\"]}},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\n\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_BoundedRange\",\"doc\":\"Bounded or unbounded range values\\n\\t\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]}],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** the value range which occurs with some specified frequency */
   private java.lang.Object range;
  /** frequency as a count, or probability as a value from 0-1. */
   private double frequency;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_Frequency() {}

  /**
   * All-args constructor.
   */
  public G_Frequency(java.lang.Object range, java.lang.Double frequency) {
    this.range = range;
    this.frequency = frequency;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return range;
    case 1: return frequency;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: range = (java.lang.Object)value$; break;
    case 1: frequency = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'range' field.
   * the value range which occurs with some specified frequency   */
  public java.lang.Object getRange() {
    return range;
  }

  /**
   * Sets the value of the 'range' field.
   * the value range which occurs with some specified frequency   * @param value the value to set.
   */
  public void setRange(java.lang.Object value) {
    this.range = value;
  }

  /**
   * Gets the value of the 'frequency' field.
   * frequency as a count, or probability as a value from 0-1.   */
  public java.lang.Double getFrequency() {
    return frequency;
  }

  /**
   * Sets the value of the 'frequency' field.
   * frequency as a count, or probability as a value from 0-1.   * @param value the value to set.
   */
  public void setFrequency(java.lang.Double value) {
    this.frequency = value;
  }

  /** Creates a new G_Frequency RecordBuilder */
  public static graphene.model.idl.G_Frequency.Builder newBuilder() {
    return new graphene.model.idl.G_Frequency.Builder();
  }
  
  /** Creates a new G_Frequency RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_Frequency.Builder newBuilder(graphene.model.idl.G_Frequency.Builder other) {
    return new graphene.model.idl.G_Frequency.Builder(other);
  }
  
  /** Creates a new G_Frequency RecordBuilder by copying an existing G_Frequency instance */
  public static graphene.model.idl.G_Frequency.Builder newBuilder(graphene.model.idl.G_Frequency other) {
    return new graphene.model.idl.G_Frequency.Builder(other);
  }
  
  /**
   * RecordBuilder for G_Frequency instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_Frequency>
    implements org.apache.avro.data.RecordBuilder<G_Frequency> {

    private java.lang.Object range;
    private double frequency;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_Frequency.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_Frequency.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.range)) {
        this.range = data().deepCopy(fields()[0].schema(), other.range);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.frequency)) {
        this.frequency = data().deepCopy(fields()[1].schema(), other.frequency);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_Frequency instance */
    private Builder(graphene.model.idl.G_Frequency other) {
            super(graphene.model.idl.G_Frequency.SCHEMA$);
      if (isValidValue(fields()[0], other.range)) {
        this.range = data().deepCopy(fields()[0].schema(), other.range);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.frequency)) {
        this.frequency = data().deepCopy(fields()[1].schema(), other.frequency);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'range' field */
    public java.lang.Object getRange() {
      return range;
    }
    
    /** Sets the value of the 'range' field */
    public graphene.model.idl.G_Frequency.Builder setRange(java.lang.Object value) {
      validate(fields()[0], value);
      this.range = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'range' field has been set */
    public boolean hasRange() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'range' field */
    public graphene.model.idl.G_Frequency.Builder clearRange() {
      range = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'frequency' field */
    public java.lang.Double getFrequency() {
      return frequency;
    }
    
    /** Sets the value of the 'frequency' field */
    public graphene.model.idl.G_Frequency.Builder setFrequency(double value) {
      validate(fields()[1], value);
      this.frequency = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'frequency' field has been set */
    public boolean hasFrequency() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'frequency' field */
    public graphene.model.idl.G_Frequency.Builder clearFrequency() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public G_Frequency build() {
      try {
        G_Frequency record = new G_Frequency();
        record.range = fieldSetFlags()[0] ? this.range : (java.lang.Object) defaultValue(fields()[0]);
        record.frequency = fieldSetFlags()[1] ? this.frequency : (java.lang.Double) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
