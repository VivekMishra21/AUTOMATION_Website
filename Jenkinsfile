pipeline {
    agent any

    environment {
        // Tool names must match exactly what you have configured in Jenkins
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        JAVA_HOME = tool name: 'JDK_17', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from main branch
                git branch: 'main', url: 'https://github.com/VivekMishra21/AUTOMATION_Website.git',  credentialsId: 'github_pat'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project with Maven...'
                bat "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running automated tests...'
                bat "${MAVEN_HOME}/bin/mvn test"
            }
        }
    }

    post {
        success {
            echo 'Build and Tests completed successfully!'
        }
        failure {
            echo 'Build or Tests failed. Check logs!'
        }
    }
}
