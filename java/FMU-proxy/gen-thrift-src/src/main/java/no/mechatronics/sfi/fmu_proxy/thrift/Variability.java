/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.mechatronics.sfi.fmu_proxy.thrift;


public enum Variability implements org.apache.thrift.TEnum {
  UNDEFINED_VARIABILITY(0),
  CONSTANT_VARIABILITY(1),
  FIXED_VARIABILITY(2),
  CONTINUOUS_VARIABILITY(3),
  DISCRETE_VARIABILITY(4),
  TUNABLE_VARIABILITY(5);

  private final int value;

  private Variability(int value) {
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
  public static Variability findByValue(int value) { 
    switch (value) {
      case 0:
        return UNDEFINED_VARIABILITY;
      case 1:
        return CONSTANT_VARIABILITY;
      case 2:
        return FIXED_VARIABILITY;
      case 3:
        return CONTINUOUS_VARIABILITY;
      case 4:
        return DISCRETE_VARIABILITY;
      case 5:
        return TUNABLE_VARIABILITY;
      default:
        return null;
    }
  }
}