pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = "kayarhabby"
        DOCKER_IMAGE_APP = "vitrinesitepoker-app"
        DOCKER_IMAGE_DB = "vitrinesitepoker-db"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Images (docker-compose)') {
            steps {
                sh 'docker compose build'
            }
        }

        stage('Login DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Tag Images') {
            steps {
                sh """
                docker tag sitevitrine-app $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:${BUILD_NUMBER}
                docker tag sitevitrine-mysql $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:${BUILD_NUMBER}
                """
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh """
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:${BUILD_NUMBER}
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:${BUILD_NUMBER}
                """
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline terminé avec succès"
        }
        failure {
            echo "❌ Pipeline en échec"
        }
    }
}
