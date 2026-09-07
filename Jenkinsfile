pipeline {
    agent any

    triggers {
    pollSCM('H/5 * * * *')
    }

    stages {
        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}