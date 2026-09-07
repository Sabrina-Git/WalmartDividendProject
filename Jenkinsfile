pipeline {
    agent any

    triggers {
        cron('H/5 * * * *')
    }

    stages {
        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}