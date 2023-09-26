FROM ubuntu:latest
LABEL authors="kleyv"

ENTRYPOINT ["top", "-b"]