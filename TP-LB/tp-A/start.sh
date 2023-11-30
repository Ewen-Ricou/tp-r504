#!/bin/bash
docker build -t im-nginx-lb .
mkdir -p shared1
mkdir -p shared2
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html
docker run -d \
	-p 81:80 \
	--mount type=bind,source="$(pwd)"/shared1,target=/usr/share/nginx/html \
	--name nginx1 \
	nginx:latest
docker run -d \
	-p 82:80 \
	--mount type=bind,source="$(pwd)"/shared2,target=/usr/share/nginx/html \
	--name nginx2 \
	nginx:latest
docker run -itd \
	-p 83:80 \
	--mount type=bind,source="$(pwd)",target=/usr/share/nginx/html \
	--name nginx-lb \
	im-nginx-lb