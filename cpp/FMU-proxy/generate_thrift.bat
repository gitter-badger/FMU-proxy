
REM - Script not finished.. Consider using the Unix version

if not exist "gen" mkdir gen

thrift -r -out gen --gen cpp ../../rpc-definitions/thrift/service.thrift

move gen/service_types.h include/fmuproxy/thrift/common/
move gen/FmuService.h include/fmuproxy/thrift/common/

move gen/service_types.cpp src/fmuproxy/thrift/common/
move gen/FmuService.cpp src/fmuproxy/thrift/common/

rmdir gen