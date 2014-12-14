#!/bin/bash
#
# @author David Soler <aensoler@gmail.com>
#
# Generates an runnable JAR.
#
MANIFEST_PATH="META-INF/MANIFEST.MF"
SQLITE_LIB_PATH="lib/sqlite-jdbc-3.8.7.jar"
JAR_PATH="./"
JAR_NAME="gui_shadow_persistence"
DEFAULT_VERSION="lastest"
INPUT_FILES="db -C bin ."

if [[ -z "$1" ]]
then
	JAR_VERSION=$DEFAULT_VERSION
else
	JAR_VERSION=$1
fi

. compile.sh

# Extract SQLite JDBC as native code
cd bin
jar xf ../$SQLITE_LIB_PATH org
find org -name "*.java" -delete
cd ..

jar cvmf $MANIFEST_PATH $JAR_PATH$JAR_NAME-$JAR_VERSION.jar $INPUT_FILES

rm -fR bin/org/sqlite
