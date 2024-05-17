pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vrun545/Testing_Project.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
            post {
                success {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/surefire-reports/',
                        reportFiles: 'emailable-report.html',
                        reportName: 'HTML Report',
                        reportTitles: '',
                        useWrapperFileDirectly: true
                    ])
                }
                failure {
                    echo 'Ignoring failed test cases and proceeding with the pipeline'
                }
            }
        }
        stage('Deployment') {
            steps {
                echo 'Deployment is done'
            }
        }
        stage('Clean up') {
            steps {
                echo 'Clean up is done'
            }
        }
    }
}
