/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
public class ScalarVariableAttribute extends org.apache.thrift.TUnion<ScalarVariableAttribute, ScalarVariableAttribute._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ScalarVariableAttribute");
  private static final org.apache.thrift.protocol.TField INTEGER_ATTRIBUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("integerAttribute", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField REAL_ATTRIBUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("realAttribute", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField STRING_ATTRIBUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("stringAttribute", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField BOOLEAN_ATTRIBUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("booleanAttribute", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField ENUMERATION_ATTRIBUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("enumerationAttribute", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INTEGER_ATTRIBUTE((short)1, "integerAttribute"),
    REAL_ATTRIBUTE((short)2, "realAttribute"),
    STRING_ATTRIBUTE((short)3, "stringAttribute"),
    BOOLEAN_ATTRIBUTE((short)4, "booleanAttribute"),
    ENUMERATION_ATTRIBUTE((short)5, "enumerationAttribute");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // INTEGER_ATTRIBUTE
          return INTEGER_ATTRIBUTE;
        case 2: // REAL_ATTRIBUTE
          return REAL_ATTRIBUTE;
        case 3: // STRING_ATTRIBUTE
          return STRING_ATTRIBUTE;
        case 4: // BOOLEAN_ATTRIBUTE
          return BOOLEAN_ATTRIBUTE;
        case 5: // ENUMERATION_ATTRIBUTE
          return ENUMERATION_ATTRIBUTE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INTEGER_ATTRIBUTE, new org.apache.thrift.meta_data.FieldMetaData("integerAttribute", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, IntegerAttribute.class)));
    tmpMap.put(_Fields.REAL_ATTRIBUTE, new org.apache.thrift.meta_data.FieldMetaData("realAttribute", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RealAttribute.class)));
    tmpMap.put(_Fields.STRING_ATTRIBUTE, new org.apache.thrift.meta_data.FieldMetaData("stringAttribute", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StringAttribute.class)));
    tmpMap.put(_Fields.BOOLEAN_ATTRIBUTE, new org.apache.thrift.meta_data.FieldMetaData("booleanAttribute", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BooleanAttribute.class)));
    tmpMap.put(_Fields.ENUMERATION_ATTRIBUTE, new org.apache.thrift.meta_data.FieldMetaData("enumerationAttribute", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, EnumerationAttribute.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ScalarVariableAttribute.class, metaDataMap);
  }

  public ScalarVariableAttribute() {
    super();
  }

  public ScalarVariableAttribute(_Fields setField, java.lang.Object value) {
    super(setField, value);
  }

  public ScalarVariableAttribute(ScalarVariableAttribute other) {
    super(other);
  }
  public ScalarVariableAttribute deepCopy() {
    return new ScalarVariableAttribute(this);
  }

  public static ScalarVariableAttribute integerAttribute(IntegerAttribute value) {
    ScalarVariableAttribute x = new ScalarVariableAttribute();
    x.setIntegerAttribute(value);
    return x;
  }

  public static ScalarVariableAttribute realAttribute(RealAttribute value) {
    ScalarVariableAttribute x = new ScalarVariableAttribute();
    x.setRealAttribute(value);
    return x;
  }

  public static ScalarVariableAttribute stringAttribute(StringAttribute value) {
    ScalarVariableAttribute x = new ScalarVariableAttribute();
    x.setStringAttribute(value);
    return x;
  }

  public static ScalarVariableAttribute booleanAttribute(BooleanAttribute value) {
    ScalarVariableAttribute x = new ScalarVariableAttribute();
    x.setBooleanAttribute(value);
    return x;
  }

  public static ScalarVariableAttribute enumerationAttribute(EnumerationAttribute value) {
    ScalarVariableAttribute x = new ScalarVariableAttribute();
    x.setEnumerationAttribute(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
    switch (setField) {
      case INTEGER_ATTRIBUTE:
        if (value instanceof IntegerAttribute) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type IntegerAttribute for field 'integerAttribute', but got " + value.getClass().getSimpleName());
      case REAL_ATTRIBUTE:
        if (value instanceof RealAttribute) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type RealAttribute for field 'realAttribute', but got " + value.getClass().getSimpleName());
      case STRING_ATTRIBUTE:
        if (value instanceof StringAttribute) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type StringAttribute for field 'stringAttribute', but got " + value.getClass().getSimpleName());
      case BOOLEAN_ATTRIBUTE:
        if (value instanceof BooleanAttribute) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type BooleanAttribute for field 'booleanAttribute', but got " + value.getClass().getSimpleName());
      case ENUMERATION_ATTRIBUTE:
        if (value instanceof EnumerationAttribute) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type EnumerationAttribute for field 'enumerationAttribute', but got " + value.getClass().getSimpleName());
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case INTEGER_ATTRIBUTE:
          if (field.type == INTEGER_ATTRIBUTE_FIELD_DESC.type) {
            IntegerAttribute integerAttribute;
            integerAttribute = new IntegerAttribute();
            integerAttribute.read(iprot);
            return integerAttribute;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case REAL_ATTRIBUTE:
          if (field.type == REAL_ATTRIBUTE_FIELD_DESC.type) {
            RealAttribute realAttribute;
            realAttribute = new RealAttribute();
            realAttribute.read(iprot);
            return realAttribute;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case STRING_ATTRIBUTE:
          if (field.type == STRING_ATTRIBUTE_FIELD_DESC.type) {
            StringAttribute stringAttribute;
            stringAttribute = new StringAttribute();
            stringAttribute.read(iprot);
            return stringAttribute;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BOOLEAN_ATTRIBUTE:
          if (field.type == BOOLEAN_ATTRIBUTE_FIELD_DESC.type) {
            BooleanAttribute booleanAttribute;
            booleanAttribute = new BooleanAttribute();
            booleanAttribute.read(iprot);
            return booleanAttribute;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case ENUMERATION_ATTRIBUTE:
          if (field.type == ENUMERATION_ATTRIBUTE_FIELD_DESC.type) {
            EnumerationAttribute enumerationAttribute;
            enumerationAttribute = new EnumerationAttribute();
            enumerationAttribute.read(iprot);
            return enumerationAttribute;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case INTEGER_ATTRIBUTE:
        IntegerAttribute integerAttribute = (IntegerAttribute)value_;
        integerAttribute.write(oprot);
        return;
      case REAL_ATTRIBUTE:
        RealAttribute realAttribute = (RealAttribute)value_;
        realAttribute.write(oprot);
        return;
      case STRING_ATTRIBUTE:
        StringAttribute stringAttribute = (StringAttribute)value_;
        stringAttribute.write(oprot);
        return;
      case BOOLEAN_ATTRIBUTE:
        BooleanAttribute booleanAttribute = (BooleanAttribute)value_;
        booleanAttribute.write(oprot);
        return;
      case ENUMERATION_ATTRIBUTE:
        EnumerationAttribute enumerationAttribute = (EnumerationAttribute)value_;
        enumerationAttribute.write(oprot);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case INTEGER_ATTRIBUTE:
          IntegerAttribute integerAttribute;
          integerAttribute = new IntegerAttribute();
          integerAttribute.read(iprot);
          return integerAttribute;
        case REAL_ATTRIBUTE:
          RealAttribute realAttribute;
          realAttribute = new RealAttribute();
          realAttribute.read(iprot);
          return realAttribute;
        case STRING_ATTRIBUTE:
          StringAttribute stringAttribute;
          stringAttribute = new StringAttribute();
          stringAttribute.read(iprot);
          return stringAttribute;
        case BOOLEAN_ATTRIBUTE:
          BooleanAttribute booleanAttribute;
          booleanAttribute = new BooleanAttribute();
          booleanAttribute.read(iprot);
          return booleanAttribute;
        case ENUMERATION_ATTRIBUTE:
          EnumerationAttribute enumerationAttribute;
          enumerationAttribute = new EnumerationAttribute();
          enumerationAttribute.read(iprot);
          return enumerationAttribute;
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case INTEGER_ATTRIBUTE:
        IntegerAttribute integerAttribute = (IntegerAttribute)value_;
        integerAttribute.write(oprot);
        return;
      case REAL_ATTRIBUTE:
        RealAttribute realAttribute = (RealAttribute)value_;
        realAttribute.write(oprot);
        return;
      case STRING_ATTRIBUTE:
        StringAttribute stringAttribute = (StringAttribute)value_;
        stringAttribute.write(oprot);
        return;
      case BOOLEAN_ATTRIBUTE:
        BooleanAttribute booleanAttribute = (BooleanAttribute)value_;
        booleanAttribute.write(oprot);
        return;
      case ENUMERATION_ATTRIBUTE:
        EnumerationAttribute enumerationAttribute = (EnumerationAttribute)value_;
        enumerationAttribute.write(oprot);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case INTEGER_ATTRIBUTE:
        return INTEGER_ATTRIBUTE_FIELD_DESC;
      case REAL_ATTRIBUTE:
        return REAL_ATTRIBUTE_FIELD_DESC;
      case STRING_ATTRIBUTE:
        return STRING_ATTRIBUTE_FIELD_DESC;
      case BOOLEAN_ATTRIBUTE:
        return BOOLEAN_ATTRIBUTE_FIELD_DESC;
      case ENUMERATION_ATTRIBUTE:
        return ENUMERATION_ATTRIBUTE_FIELD_DESC;
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public IntegerAttribute getIntegerAttribute() {
    if (getSetField() == _Fields.INTEGER_ATTRIBUTE) {
      return (IntegerAttribute)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'integerAttribute' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setIntegerAttribute(IntegerAttribute value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.INTEGER_ATTRIBUTE;
    value_ = value;
  }

  public RealAttribute getRealAttribute() {
    if (getSetField() == _Fields.REAL_ATTRIBUTE) {
      return (RealAttribute)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'realAttribute' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setRealAttribute(RealAttribute value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.REAL_ATTRIBUTE;
    value_ = value;
  }

  public StringAttribute getStringAttribute() {
    if (getSetField() == _Fields.STRING_ATTRIBUTE) {
      return (StringAttribute)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'stringAttribute' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setStringAttribute(StringAttribute value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.STRING_ATTRIBUTE;
    value_ = value;
  }

  public BooleanAttribute getBooleanAttribute() {
    if (getSetField() == _Fields.BOOLEAN_ATTRIBUTE) {
      return (BooleanAttribute)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'booleanAttribute' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBooleanAttribute(BooleanAttribute value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.BOOLEAN_ATTRIBUTE;
    value_ = value;
  }

  public EnumerationAttribute getEnumerationAttribute() {
    if (getSetField() == _Fields.ENUMERATION_ATTRIBUTE) {
      return (EnumerationAttribute)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'enumerationAttribute' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setEnumerationAttribute(EnumerationAttribute value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.ENUMERATION_ATTRIBUTE;
    value_ = value;
  }

  public boolean isSetIntegerAttribute() {
    return setField_ == _Fields.INTEGER_ATTRIBUTE;
  }


  public boolean isSetRealAttribute() {
    return setField_ == _Fields.REAL_ATTRIBUTE;
  }


  public boolean isSetStringAttribute() {
    return setField_ == _Fields.STRING_ATTRIBUTE;
  }


  public boolean isSetBooleanAttribute() {
    return setField_ == _Fields.BOOLEAN_ATTRIBUTE;
  }


  public boolean isSetEnumerationAttribute() {
    return setField_ == _Fields.ENUMERATION_ATTRIBUTE;
  }


  public boolean equals(java.lang.Object other) {
    if (other instanceof ScalarVariableAttribute) {
      return equals((ScalarVariableAttribute)other);
    } else {
      return false;
    }
  }

  public boolean equals(ScalarVariableAttribute other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(ScalarVariableAttribute other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
    list.add(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      list.add(setField.getThriftFieldId());
      java.lang.Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        list.add(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        list.add(value);
      }
    }
    return list.hashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
