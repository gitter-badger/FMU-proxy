/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-09")
public class ModelStructure implements org.apache.thrift.TBase<ModelStructure, ModelStructure._Fields>, java.io.Serializable, Cloneable, Comparable<ModelStructure> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ModelStructure");

  private static final org.apache.thrift.protocol.TField OUTPUTS_FIELD_DESC = new org.apache.thrift.protocol.TField("outputs", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField DERIVATIVES_FIELD_DESC = new org.apache.thrift.protocol.TField("derivatives", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField INITIAL_UNKNOWNS_FIELD_DESC = new org.apache.thrift.protocol.TField("initialUnknowns", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ModelStructureStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ModelStructureTupleSchemeFactory();

  public java.util.List<Unknown> outputs; // required
  public java.util.List<Unknown> derivatives; // required
  public java.util.List<Unknown> initialUnknowns; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OUTPUTS((short)1, "outputs"),
    DERIVATIVES((short)2, "derivatives"),
    INITIAL_UNKNOWNS((short)3, "initialUnknowns");

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
        case 1: // OUTPUTS
          return OUTPUTS;
        case 2: // DERIVATIVES
          return DERIVATIVES;
        case 3: // INITIAL_UNKNOWNS
          return INITIAL_UNKNOWNS;
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

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OUTPUTS, new org.apache.thrift.meta_data.FieldMetaData("outputs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Unknown.class))));
    tmpMap.put(_Fields.DERIVATIVES, new org.apache.thrift.meta_data.FieldMetaData("derivatives", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Unknown.class))));
    tmpMap.put(_Fields.INITIAL_UNKNOWNS, new org.apache.thrift.meta_data.FieldMetaData("initialUnknowns", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Unknown.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ModelStructure.class, metaDataMap);
  }

  public ModelStructure() {
  }

  public ModelStructure(
    java.util.List<Unknown> outputs,
    java.util.List<Unknown> derivatives,
    java.util.List<Unknown> initialUnknowns)
  {
    this();
    this.outputs = outputs;
    this.derivatives = derivatives;
    this.initialUnknowns = initialUnknowns;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ModelStructure(ModelStructure other) {
    if (other.isSetOutputs()) {
      java.util.List<Unknown> __this__outputs = new java.util.ArrayList<Unknown>(other.outputs.size());
      for (Unknown other_element : other.outputs) {
        __this__outputs.add(new Unknown(other_element));
      }
      this.outputs = __this__outputs;
    }
    if (other.isSetDerivatives()) {
      java.util.List<Unknown> __this__derivatives = new java.util.ArrayList<Unknown>(other.derivatives.size());
      for (Unknown other_element : other.derivatives) {
        __this__derivatives.add(new Unknown(other_element));
      }
      this.derivatives = __this__derivatives;
    }
    if (other.isSetInitialUnknowns()) {
      java.util.List<Unknown> __this__initialUnknowns = new java.util.ArrayList<Unknown>(other.initialUnknowns.size());
      for (Unknown other_element : other.initialUnknowns) {
        __this__initialUnknowns.add(new Unknown(other_element));
      }
      this.initialUnknowns = __this__initialUnknowns;
    }
  }

  public ModelStructure deepCopy() {
    return new ModelStructure(this);
  }

  @Override
  public void clear() {
    this.outputs = null;
    this.derivatives = null;
    this.initialUnknowns = null;
  }

  public int getOutputsSize() {
    return (this.outputs == null) ? 0 : this.outputs.size();
  }

  public java.util.Iterator<Unknown> getOutputsIterator() {
    return (this.outputs == null) ? null : this.outputs.iterator();
  }

  public void addToOutputs(Unknown elem) {
    if (this.outputs == null) {
      this.outputs = new java.util.ArrayList<Unknown>();
    }
    this.outputs.add(elem);
  }

  public java.util.List<Unknown> getOutputs() {
    return this.outputs;
  }

  public ModelStructure setOutputs(java.util.List<Unknown> outputs) {
    this.outputs = outputs;
    return this;
  }

  public void unsetOutputs() {
    this.outputs = null;
  }

  /** Returns true if field outputs is set (has been assigned a value) and false otherwise */
  public boolean isSetOutputs() {
    return this.outputs != null;
  }

  public void setOutputsIsSet(boolean value) {
    if (!value) {
      this.outputs = null;
    }
  }

  public int getDerivativesSize() {
    return (this.derivatives == null) ? 0 : this.derivatives.size();
  }

  public java.util.Iterator<Unknown> getDerivativesIterator() {
    return (this.derivatives == null) ? null : this.derivatives.iterator();
  }

  public void addToDerivatives(Unknown elem) {
    if (this.derivatives == null) {
      this.derivatives = new java.util.ArrayList<Unknown>();
    }
    this.derivatives.add(elem);
  }

  public java.util.List<Unknown> getDerivatives() {
    return this.derivatives;
  }

  public ModelStructure setDerivatives(java.util.List<Unknown> derivatives) {
    this.derivatives = derivatives;
    return this;
  }

  public void unsetDerivatives() {
    this.derivatives = null;
  }

  /** Returns true if field derivatives is set (has been assigned a value) and false otherwise */
  public boolean isSetDerivatives() {
    return this.derivatives != null;
  }

  public void setDerivativesIsSet(boolean value) {
    if (!value) {
      this.derivatives = null;
    }
  }

  public int getInitialUnknownsSize() {
    return (this.initialUnknowns == null) ? 0 : this.initialUnknowns.size();
  }

  public java.util.Iterator<Unknown> getInitialUnknownsIterator() {
    return (this.initialUnknowns == null) ? null : this.initialUnknowns.iterator();
  }

  public void addToInitialUnknowns(Unknown elem) {
    if (this.initialUnknowns == null) {
      this.initialUnknowns = new java.util.ArrayList<Unknown>();
    }
    this.initialUnknowns.add(elem);
  }

  public java.util.List<Unknown> getInitialUnknowns() {
    return this.initialUnknowns;
  }

  public ModelStructure setInitialUnknowns(java.util.List<Unknown> initialUnknowns) {
    this.initialUnknowns = initialUnknowns;
    return this;
  }

  public void unsetInitialUnknowns() {
    this.initialUnknowns = null;
  }

  /** Returns true if field initialUnknowns is set (has been assigned a value) and false otherwise */
  public boolean isSetInitialUnknowns() {
    return this.initialUnknowns != null;
  }

  public void setInitialUnknownsIsSet(boolean value) {
    if (!value) {
      this.initialUnknowns = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case OUTPUTS:
      if (value == null) {
        unsetOutputs();
      } else {
        setOutputs((java.util.List<Unknown>)value);
      }
      break;

    case DERIVATIVES:
      if (value == null) {
        unsetDerivatives();
      } else {
        setDerivatives((java.util.List<Unknown>)value);
      }
      break;

    case INITIAL_UNKNOWNS:
      if (value == null) {
        unsetInitialUnknowns();
      } else {
        setInitialUnknowns((java.util.List<Unknown>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case OUTPUTS:
      return getOutputs();

    case DERIVATIVES:
      return getDerivatives();

    case INITIAL_UNKNOWNS:
      return getInitialUnknowns();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case OUTPUTS:
      return isSetOutputs();
    case DERIVATIVES:
      return isSetDerivatives();
    case INITIAL_UNKNOWNS:
      return isSetInitialUnknowns();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ModelStructure)
      return this.equals((ModelStructure)that);
    return false;
  }

  public boolean equals(ModelStructure that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_outputs = true && this.isSetOutputs();
    boolean that_present_outputs = true && that.isSetOutputs();
    if (this_present_outputs || that_present_outputs) {
      if (!(this_present_outputs && that_present_outputs))
        return false;
      if (!this.outputs.equals(that.outputs))
        return false;
    }

    boolean this_present_derivatives = true && this.isSetDerivatives();
    boolean that_present_derivatives = true && that.isSetDerivatives();
    if (this_present_derivatives || that_present_derivatives) {
      if (!(this_present_derivatives && that_present_derivatives))
        return false;
      if (!this.derivatives.equals(that.derivatives))
        return false;
    }

    boolean this_present_initialUnknowns = true && this.isSetInitialUnknowns();
    boolean that_present_initialUnknowns = true && that.isSetInitialUnknowns();
    if (this_present_initialUnknowns || that_present_initialUnknowns) {
      if (!(this_present_initialUnknowns && that_present_initialUnknowns))
        return false;
      if (!this.initialUnknowns.equals(that.initialUnknowns))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetOutputs()) ? 131071 : 524287);
    if (isSetOutputs())
      hashCode = hashCode * 8191 + outputs.hashCode();

    hashCode = hashCode * 8191 + ((isSetDerivatives()) ? 131071 : 524287);
    if (isSetDerivatives())
      hashCode = hashCode * 8191 + derivatives.hashCode();

    hashCode = hashCode * 8191 + ((isSetInitialUnknowns()) ? 131071 : 524287);
    if (isSetInitialUnknowns())
      hashCode = hashCode * 8191 + initialUnknowns.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ModelStructure other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetOutputs()).compareTo(other.isSetOutputs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOutputs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.outputs, other.outputs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDerivatives()).compareTo(other.isSetDerivatives());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDerivatives()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.derivatives, other.derivatives);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInitialUnknowns()).compareTo(other.isSetInitialUnknowns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInitialUnknowns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.initialUnknowns, other.initialUnknowns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ModelStructure(");
    boolean first = true;

    sb.append("outputs:");
    if (this.outputs == null) {
      sb.append("null");
    } else {
      sb.append(this.outputs);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("derivatives:");
    if (this.derivatives == null) {
      sb.append("null");
    } else {
      sb.append(this.derivatives);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("initialUnknowns:");
    if (this.initialUnknowns == null) {
      sb.append("null");
    } else {
      sb.append(this.initialUnknowns);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class ModelStructureStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ModelStructureStandardScheme getScheme() {
      return new ModelStructureStandardScheme();
    }
  }

  private static class ModelStructureStandardScheme extends org.apache.thrift.scheme.StandardScheme<ModelStructure> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ModelStructure struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OUTPUTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.outputs = new java.util.ArrayList<Unknown>(_list8.size);
                Unknown _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = new Unknown();
                  _elem9.read(iprot);
                  struct.outputs.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setOutputsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DERIVATIVES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list11 = iprot.readListBegin();
                struct.derivatives = new java.util.ArrayList<Unknown>(_list11.size);
                Unknown _elem12;
                for (int _i13 = 0; _i13 < _list11.size; ++_i13)
                {
                  _elem12 = new Unknown();
                  _elem12.read(iprot);
                  struct.derivatives.add(_elem12);
                }
                iprot.readListEnd();
              }
              struct.setDerivativesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // INITIAL_UNKNOWNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list14 = iprot.readListBegin();
                struct.initialUnknowns = new java.util.ArrayList<Unknown>(_list14.size);
                Unknown _elem15;
                for (int _i16 = 0; _i16 < _list14.size; ++_i16)
                {
                  _elem15 = new Unknown();
                  _elem15.read(iprot);
                  struct.initialUnknowns.add(_elem15);
                }
                iprot.readListEnd();
              }
              struct.setInitialUnknownsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ModelStructure struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.outputs != null) {
        oprot.writeFieldBegin(OUTPUTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.outputs.size()));
          for (Unknown _iter17 : struct.outputs)
          {
            _iter17.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.derivatives != null) {
        oprot.writeFieldBegin(DERIVATIVES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.derivatives.size()));
          for (Unknown _iter18 : struct.derivatives)
          {
            _iter18.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.initialUnknowns != null) {
        oprot.writeFieldBegin(INITIAL_UNKNOWNS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.initialUnknowns.size()));
          for (Unknown _iter19 : struct.initialUnknowns)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ModelStructureTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ModelStructureTupleScheme getScheme() {
      return new ModelStructureTupleScheme();
    }
  }

  private static class ModelStructureTupleScheme extends org.apache.thrift.scheme.TupleScheme<ModelStructure> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ModelStructure struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetOutputs()) {
        optionals.set(0);
      }
      if (struct.isSetDerivatives()) {
        optionals.set(1);
      }
      if (struct.isSetInitialUnknowns()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetOutputs()) {
        {
          oprot.writeI32(struct.outputs.size());
          for (Unknown _iter20 : struct.outputs)
          {
            _iter20.write(oprot);
          }
        }
      }
      if (struct.isSetDerivatives()) {
        {
          oprot.writeI32(struct.derivatives.size());
          for (Unknown _iter21 : struct.derivatives)
          {
            _iter21.write(oprot);
          }
        }
      }
      if (struct.isSetInitialUnknowns()) {
        {
          oprot.writeI32(struct.initialUnknowns.size());
          for (Unknown _iter22 : struct.initialUnknowns)
          {
            _iter22.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ModelStructure struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list23 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.outputs = new java.util.ArrayList<Unknown>(_list23.size);
          Unknown _elem24;
          for (int _i25 = 0; _i25 < _list23.size; ++_i25)
          {
            _elem24 = new Unknown();
            _elem24.read(iprot);
            struct.outputs.add(_elem24);
          }
        }
        struct.setOutputsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list26 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.derivatives = new java.util.ArrayList<Unknown>(_list26.size);
          Unknown _elem27;
          for (int _i28 = 0; _i28 < _list26.size; ++_i28)
          {
            _elem27 = new Unknown();
            _elem27.read(iprot);
            struct.derivatives.add(_elem27);
          }
        }
        struct.setDerivativesIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.initialUnknowns = new java.util.ArrayList<Unknown>(_list29.size);
          Unknown _elem30;
          for (int _i31 = 0; _i31 < _list29.size; ++_i31)
          {
            _elem30 = new Unknown();
            _elem30.read(iprot);
            struct.initialUnknowns.add(_elem30);
          }
        }
        struct.setInitialUnknownsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
