pipeline {
    agent any

    environment {
        DOCKERHUB_USERNAME = "kayarhabby"
        DOCKER_IMAGE_APP = "sitevitrine-app"
        DOCKER_IMAGE_DB = "sitevitrine-db"
        DOCKER_TAG = "${BUILD_NUMBER}" // Tag basé sur le numéro de build Jenkins
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Images (docker-compose)') {
            steps {
                sh 'docker compose build'
            }
        }

        stage('Login DockerHub (non-interactive)') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhubcreds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    '''
                }
            }
        }

        stage('Tag Images with Build Number') {
            steps {
                sh """
                docker tag $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:latest $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:$DOCKER_TAG
                docker tag $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:latest $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:$DOCKER_TAG
                """
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh """
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:latest
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_APP:$DOCKER_TAG
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:latest
                docker push $DOCKERHUB_USERNAME/$DOCKER_IMAGE_DB:$DOCKER_TAG
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
