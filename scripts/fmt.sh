#!/bin/bash

set -eu

[[ -z ${CI:-} ]] && CMD="apply" || CMD="check"
mvn -q spotless:${CMD}
