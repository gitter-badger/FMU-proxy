/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.ntnu.ihb.fmuproxy.thrift;


public enum Initial implements org.apache.thrift.TEnum {
  EXACT_INITIAL(0),
  APPROX_INITIAL(1),
  CALCULATED_INITIAL(2),
  UNKNOWN_INITIAL(3);

  private final int value;

  private Initial(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Initial findByValue(int value) { 
    switch (value) {
      case 0:
        return EXACT_INITIAL;
      case 1:
        return APPROX_INITIAL;
      case 2:
        return CALCULATED_INITIAL;
      case 3:
        return UNKNOWN_INITIAL;
      default:
        return null;
    }
  }
}
