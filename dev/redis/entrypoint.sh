#!/bin/bash

usr/bin/redis-server --requirepass ${PASSWORD}
ENTRYPOINT  ["/usr/bin/redis-server", "--requirepass", "$PASSWORD"]
exec "$@"