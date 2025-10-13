pipeline {
    agent any

    tools {
        maven 'Maven-3.9'  // Name of Maven installation in Jenkins
        jdk 'Java-17'       // Name of JDK installation in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-cred-id', url: 'https://github.com/VivekMishra21/AUTOMATION_Website.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            echo 'Build Finished!'
        }
        success {
            echo 'Tests Passed!'
        }
        failure {
            echo 'Build/Tests Failed!'
        }
    }
}
