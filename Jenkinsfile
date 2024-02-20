pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                echo '=== Prepare ==='
            }
        }

        stage("Clone repository") {
            steps {
                git 'https://github.com/GDSC-23-24-BABY-APP/tobemom-spring-mvc.git'
            }
        }

        stage('Build and Push Docker Image') {
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

        stage('Clean Up Unused Docker Images') {
            steps {
                script {
                    // 태그가 겹친 이미지 삭제
                    sh 'docker rmi -f $(docker images -f "dangling=true" -q) || true'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo '=== Deploy ==='
            }
        }
    }
}
