#!/bin/bash

set -eu

[[ -z ${CI:-} ]] && CMD="apply" || CMD="check"
mvn spotless:${CMD} | egrep -v "^(Download|Progress)"
