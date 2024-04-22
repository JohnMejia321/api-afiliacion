pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Construir el proyecto y generar el artefacto JAR
                bat 'mvn clean package'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                // Buscar el Dockerfile y crear la imagen Docker
                // dir("spring-boot-hello-world") {
                bat 'docker build -t my-docker-image-v2:latest .'
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                // Iniciar sesión en Docker Hub y enviar la imagen
                bat 'docker login -u johnmejia9887654321 -p fredy555.'
                bat 'docker tag my-docker-image-v2:latest johnmejia9887654321/my-docker-image-v2:latest'
                bat 'docker push johnmejia9887654321/my-docker-image-v2:latest'
            }
        }
        
        stage('Deploy with Kubernetes') {
            steps {
                // Descargar el archivo deployment.yaml y aplicar en Kubernetes
                withCredentials([file(credentialsId: 'mycubeconfig', variable: 'KUBECONFIG')]) {
                    bat "kubectl apply -f deployment.yaml  --kubeconfig=${KUBECONFIG}"
                }
            }
        }
    }
}