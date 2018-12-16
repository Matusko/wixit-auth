    docker build -t "matusko/redis:latest" .
    
insert correct password $PASSWORD
    
    docker run -e PASSWORD='$PASSWORD' -p 6379:6379 -t matusko/redis
