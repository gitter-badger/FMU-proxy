/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef service_TYPES_H
#define service_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/TBase.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/stdcxx.h>
#include "definitions_types.h"

namespace fmuproxy { namespace thrift {

typedef int32_t FmuId;

typedef int32_t ValueReference;

typedef std::vector<int32_t>  ValueReferences;

typedef std::vector<int32_t>  IntArray;

typedef std::vector<double>  RealArray;

typedef std::vector<std::string>  StringArray;

typedef std::vector<bool>  BooleanArray;

}} // namespace

#endif