#!/bin/bash

usr/bin/redis-server
ENTRYPOINT  ["/usr/bin/redis-server"]
exec "$@"