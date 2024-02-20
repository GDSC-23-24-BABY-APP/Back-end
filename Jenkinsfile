pipeline {
    agent any

    stages {
        stage('Prepare') {
            steps {
                echo '=== Prepare ==='
            }
        }

        stage("Clone repository") {  // 멀티 브랜치파이프라인 작성할 때 세팅해놓은 코드 가져옴. git clone 효과
                    steps {
                        git 'https://github.com/GDSC-23-24-BABY-APP/tobemom-spring-mvc.git'
                       }
                }

        stage('Build Docker Image') {
            steps {
                app = docker.build("arial09/to-be-mom")
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

        stage('Push Docker Image') {
                    steps {
                        script {
                            // Docker 이미지를 Docker Hub로 푸시함
                            docker.withRegistry('https://registry.hub.docker.com', 'arial09') {
                                myapp.push("latest")
                                //myapp.push("${env.BUILD_ID}")
                            }
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