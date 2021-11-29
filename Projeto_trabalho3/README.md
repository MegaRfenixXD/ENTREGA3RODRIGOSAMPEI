# Build
mvn clean package && docker build -t Projeto_trabalho3/Projeto_trabalho3 .

# RUN

docker rm -f Projeto_trabalho3 || true && docker run -d -p 8080:8080 -p 4848:4848 --name Projeto_trabalho3 Projeto_trabalho3/Projeto_trabalho3 