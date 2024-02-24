pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                echo '=== Prepare ==='
            }
        }

        stage("Clone repository") {
            when {
                branch 'main'
            }
            steps {
                git 'https://github.com/GDSC-23-24-BABY-APP/tobemom-spring-mvc.git'
            }
        }

        stage('Build and Push Docker Image') {
            when {
                branch 'main'
            }
            steps {
                script {
                    // Docker 이미지 빌드 및 Docker Hub로 푸시
                    docker.withRegistry('https://registry.hub.docker.com', 'arial09') {
                        def app = docker.build("arial09/to-be-mom")
                        app.push("latest")
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo '=== Deploy ==='
            }
        }
    }
}
