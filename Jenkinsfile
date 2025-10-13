pipeline {
    agent any

    tools {
        maven 'Maven'   // use the exact Maven name from Jenkins
        jdk 'JDK_17'    // use the exact JDK name from Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/VivekMishra21/AUTOMATION_Website.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
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
    }
}

