#!/usr/bin/env bash
message=$(curl -X POST http://localhost:9001/MARION?lastName=OCAMPO)
message=$(curl -X DELETE http://localhost:9001/$uid)
