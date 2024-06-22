#!/bin/bash

set -eu

docker compose up -d

mvn -q clean test
